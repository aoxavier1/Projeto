/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import conection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.RelatD;

/**
 *
 * @author Max
 */
public class RelatDDAO {
    Connection con;

    public RelatDDAO() {
        //Abrir a conexão
        con = ConnectionFactory.getConnection();
    }
    public void create (RelatD D){
        //Preparação para trabalhar com os comandos no mysql
        PreparedStatement stmt = null;
        
        try {
            //Setando a tabela onde serão feito as inserções de dados
            stmt = con.prepareStatement("INSERT INTO relatorio_diario (Data_Viagem,Quantidade_De_Viagens,km_do_dia,Quantas_Horas_online,Lucro) VALUES (?,?,?,?,?)");
            //Definindo para onde vai cada valor que vai ser inserido pelo usuario
            stmt.setString(1,D.getData());
            stmt.setInt(2,D.getQtdv());
            stmt.setInt(3,D.getKm());
            stmt.setInt(4,D.getQtdon());
            stmt.setDouble(5, D.getLucro());
            
            //Preparar o sql e em seguida vai executalo
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar"+ ex);
        }finally{
            //Fechando a conexão 
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<RelatD> read() {
        //Preparação do sql
        PreparedStatement stmt = null;
        //Onde serão guardados os resultados do preparedStatement
        ResultSet rs = null;
        
        //Criamos uma lista para armazenar os valores
        List<RelatD> relatD = new ArrayList<>();

        try {
            //Consulta da tabela do banco 
            stmt = con.prepareStatement("SELECT * FROM relatorio_diario");
            //Execução da tabela
            rs = stmt.executeQuery();
            
            //Sempre que existir um resultado ele vai passando para o proximo objeto
            //ate que seja falso
            while (rs.next()) {
                //Chamando o objeto que vai ser criado
                RelatD relatd = new RelatD();
                //Esta passando o valor para as colunas selecionadas
                relatd.setId(rs.getInt("idRelatorio_Diario"));
                relatd.setData(rs.getString("Data_Viagem"));
                relatd.setKm(rs.getInt("Km_do_dia"));
                relatd.setQtdv(rs.getInt("Quantidade_De_Viagens"));
                relatd.setQtdon(rs.getInt("Quantas_Horas_Online"));
                relatd.setLucro(rs.getDouble("Lucro"));
                relatD.add(relatd);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CustoFDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return relatD;
    }

    public void update(RelatD D) {

        String sql = "UPDATE relatorio_diario SET Data_Viagem=?, Quantidade_De_Viagens=?,Km_do_dia=?,Quantas_Horas_Online=?, Lucro =?  WHERE idRelatorio_Diario=?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, D.getData());
            stmt.setInt(2, D.getQtdv());
            stmt.setInt(3, D.getKm());
            stmt.setInt(4, D.getQtdon());
            stmt.setDouble(5, D.getLucro());
            stmt.setInt(6, D.getId());

            stmt.execute();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void delete(RelatD D) {
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM relatorio_diario WHERE idRelatorio_Diario = ?");
            stmt.setInt(1, D.getId());

            stmt.execute();

           JOptionPane.showMessageDialog(null, "Dados excluidos com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
}
