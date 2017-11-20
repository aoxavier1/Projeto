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
import model.RelatM;

/**
 *
 * @author Max
 */
public class RelatMDAO {
    Connection con;
    
    
    public  RelatMDAO (){
     con = ConnectionFactory.getConnection();
}
     
    public void create(RelatM m) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO relatorio_mensal (Data_Viagem,km_Inicio,km_final,km_total) VALUES (?,?,?,?)");

            stmt.setString(1, m.getData());
            stmt.setInt(2, m.getKmi());
            stmt.setInt(3, m.getKmf());
            stmt.setInt(4, m.getPerc());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<RelatM> read() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<RelatM> relatM = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM relatorio_mensal");
            rs = stmt.executeQuery();

            while (rs.next()) {
                RelatM M = new RelatM();
                M.setId(rs.getInt("idRelatorio_Mensal"));
                M.setData(rs.getString("Data_Viagem"));
                M.setKmi(rs.getInt("Km_inicio"));
                M.setKmf(rs.getInt("Km_Final"));
                M.setPerc(rs.getInt("Km_Total"));
                relatM.add(M);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CustoFDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return relatM;
    }

    public void update(RelatM m) {
        String sql = "UPDATE relatorio_mensal SET Data_Viagem=?,km_Inicio=?,km_final=?,km_total=? WHERE idRelatorio_Mensal =?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, m.getData());
            stmt.setInt(2, m.getKmi());
            stmt.setInt(3, m.getKmf());
            stmt.setInt(4, m.getPerc());
            stmt.setInt(5, m.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void delete(RelatM m) {
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM relatorio_mensal WHERE idRelatorio_Mensal = ?");
            stmt.setInt(1, m.getId());
            stmt.execute();

            JOptionPane.showMessageDialog(null, "Dados excluidos com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
