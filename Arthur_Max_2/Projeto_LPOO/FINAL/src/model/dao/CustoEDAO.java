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
import model.CustoE;

/**
 *
 * @author Max
 */
public class CustoEDAO {

    Connection con;

    public CustoEDAO() {

        con = ConnectionFactory.getConnection();
    }

    public void create(CustoE e) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO custos_extras (Descrição,Valor,Data_Compra,Quantidade) VALUES (?,?,?,?)");
            stmt.setString(1, e.getNome());
            stmt.setDouble(2, e.getPreco());
            stmt.setString(3, e.getData());
            stmt.setInt(4, e.getQtd());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<CustoE> read() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<CustoE> custE = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM custos_extras");
            rs = stmt.executeQuery();

            while (rs.next()) {
                CustoE prod = new CustoE();
                prod.setId(rs.getInt("idCustos_Extras"));
                prod.setData(rs.getString("Data_Compra"));
                prod.setNome(rs.getString("Descrição"));
                prod.setQtd(rs.getInt("Quantidade"));
                prod.setPreco(rs.getDouble("Valor"));
                custE.add(prod);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CustoFDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return custE;
    }

    public void update(CustoE E) {

        String sql = "UPDATE custos_extras SET Data_Compra=?, Descrição=?,Quantidade=?, Valor =?  WHERE idCustos_Extras=?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, E.getData());
            stmt.setString(2, E.getNome());
            stmt.setInt(3, E.getQtd());
            stmt.setDouble(4, E.getPreco());
            stmt.setInt(5, E.getId());

            stmt.execute();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void delete(CustoE E) {
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM custos_extras WHERE idCustos_Extras = ?");
            stmt.setInt(1, E.getId());

            stmt.execute();

            JOptionPane.showMessageDialog(null, "Dados excluidos com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
}
