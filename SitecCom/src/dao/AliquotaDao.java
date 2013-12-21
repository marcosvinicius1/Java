/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bancodados.CriaConexao;
import bins.AliquotaBins;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MARCOS
 */
public class AliquotaDao {
    private Connection conexao;
    public AliquotaDao() throws SQLException{
        this.conexao=CriaConexao.getConexao();
    }
    public List<AliquotaBins> getLista(String nome) throws SQLException{
       String sql="Select * from aliquota where nome like ?"; 
       PreparedStatement stmt= this.conexao.prepareStatement(sql);
       stmt.setString(1, nome);
       ResultSet rs= stmt.executeQuery();
       List<AliquotaBins> aliquotalista= new ArrayList<AliquotaBins>();
       while(rs.next()){
           AliquotaBins ab= new AliquotaBins();
           ab.setId(rs.getInt("id"));
           ab.setNome(rs.getString("nome"));
           ab.setAliq(rs.getFloat("aliq"));
           aliquotalista.add(ab);
       }
       rs.close();
       stmt.close();
       return aliquotalista;
    }
    public List<AliquotaBins> getaliquota(int id) throws SQLException{
       String sql="Select * from aliquota where id=?"; 
       PreparedStatement stmt= this.conexao.prepareStatement(sql);
       stmt.setInt(1, id);
       ResultSet rs= stmt.executeQuery();
       List<AliquotaBins> aliquotalista= new ArrayList<AliquotaBins>();
       while(rs.next()){
           AliquotaBins ab= new AliquotaBins();
           ab.setId(rs.getInt("id"));
           ab.setNome(rs.getString("nome"));
           ab.setAliq(rs.getFloat("aliq"));
           aliquotalista.add(ab);
       }
       rs.close();
       stmt.close();
       return aliquotalista;
    }
    public void adiciona(AliquotaBins ab) throws SQLException{
        String sql="insert into aliquota (nome,aliq)values(?,?)";
        PreparedStatement stmt= this.conexao.prepareStatement(sql);
        stmt.setString(1, ab.getNome());
        stmt.setFloat(2, ab.getAliq());
        stmt.execute();
        stmt.close();
    }
}
