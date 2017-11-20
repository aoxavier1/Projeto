/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import conection.ConnectionFactory;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.CustoF;

/**
 *
 * @author Max
 */
public class CustoFDAO {
        Connection con;
    
        public CustoFDAO() {
        con = ConnectionFactory.getConnection();
    }
    public void create (CustoF f){
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO custos_fixos (Data_Compra,Descricao,Periodo,Preco) VALUES (?,?,?,?)");
            stmt.setString(1,f.getData());
            stmt.setString(2,f.getNome());
            stmt.setString(3,f.getPrd());
            stmt.setDouble(4,f.getPreco());
            stmt.execute();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar"+ ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
    
    
    public List<CustoF> read (){
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<CustoF> produtos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM custos_fixos");
            rs = stmt.executeQuery();
             
            while (rs.next()){
                CustoF prod = new CustoF();
                prod.setId(rs.getInt("idCusto_Fixos"));
                prod.setData(rs.getString("Data_Compra"));
                prod.setNome(rs.getString("Descricao"));
                prod.setPrd(rs.getString("periodo"));
                prod.setPreco(rs.getDouble("preco"));
                produtos.add(prod);
            }
            
                    } catch (SQLException ex) {
            Logger.getLogger(CustoFDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
            
        return produtos;
    }
    
    public void update (CustoF f){
        
        String sql = "UPDATE custos_fixos SET Data_Compra=?, Descricao=?, Periodo =? , Preco=? WHERE idCusto_Fixos=?";
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1,f.getData());
            stmt.setString(2,f.getNome());
            stmt.setString(3,f.getPrd());
            stmt.setDouble(4,f.getPreco());
            stmt.setInt(5,f.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar"+ ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
}
    public void delete(CustoF f) {
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM custos_fixos WHERE idCusto_Fixos = ?");
            stmt.setInt(1, f.getId());

            stmt.execute();

            JOptionPane.showMessageDialog(null, "Dados excluidos com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    
}