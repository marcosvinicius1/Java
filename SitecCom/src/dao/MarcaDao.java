/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bancodados.CriaConexao;
import bins.MarcaBins;
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
public class MarcaDao {
    private Connection conexao;
    public MarcaDao() throws SQLException{
        this.conexao=CriaConexao.getConexao();
    }
    public List<MarcaBins> getLista(String nome) throws SQLException{
       String sql="Select * from marca where nome like ?"; 
       PreparedStatement stmt= this.conexao.prepareStatement(sql);
       stmt.setString(1, nome);
       ResultSet rs= stmt.executeQuery();
       List<MarcaBins> marcalista= new ArrayList<MarcaBins>();
       while(rs.next()){
           MarcaBins mb= new MarcaBins();
           mb.setId(rs.getInt("id"));
           mb.setNome(rs.getString("nome"));
           marcalista.add(mb);
       }
       rs.close();
       stmt.close();
       return marcalista;
    }
     public List<MarcaBins> getmarca(int id) throws SQLException{
       String sql="Select * from marca where id=?"; 
       PreparedStatement stmt= this.conexao.prepareStatement(sql);
       stmt.setInt(1, id);
       ResultSet rs= stmt.executeQuery();
       List<MarcaBins> marcalista= new ArrayList<MarcaBins>();
       while(rs.next()){
           MarcaBins mb= new MarcaBins();
           mb.setId(rs.getInt("id"));
           mb.setNome(rs.getString("nome"));
           marcalista.add(mb);
       }
       rs.close();
       stmt.close();
       return marcalista;
    }
    public void adiciona(MarcaBins mb) throws SQLException{
        String sql="insert into marca (nome)values(?)";
        PreparedStatement stmt= this.conexao.prepareStatement(sql);
        stmt.setString(1, mb.getNome());
        stmt.execute();
        stmt.close();
    }
}
