/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bancodados.CriaConexao;
import bins.GrupoBins;
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
public class GrupoDao {
     private Connection conexao;
    public GrupoDao() throws SQLException{
        this.conexao=CriaConexao.getConexao();
    }
    public List<GrupoBins> getLista(String nome) throws SQLException{
       String sql="Select * from grupo where nome like ?"; 
       PreparedStatement stmt= this.conexao.prepareStatement(sql);
       stmt.setString(1, nome);
       ResultSet rs= stmt.executeQuery();
       List<GrupoBins> grupolista= new ArrayList<GrupoBins>();
       while(rs.next()){
           GrupoBins gb= new GrupoBins();
           gb.setId(rs.getInt("id"));
           gb.setNome(rs.getString("nome"));
           grupolista.add(gb);
       }
       rs.close();
       stmt.close();
       return grupolista;
    }
    public List<GrupoBins> getgrupo(int id) throws SQLException{
       String sql="Select * from grupo where id=?"; 
       PreparedStatement stmt= this.conexao.prepareStatement(sql);
       stmt.setInt(1, id);
       ResultSet rs= stmt.executeQuery();
       List<GrupoBins> grupolista= new ArrayList<GrupoBins>();
       while(rs.next()){
           GrupoBins gb= new GrupoBins();
           gb.setId(rs.getInt("id"));
           gb.setNome(rs.getString("nome"));
           grupolista.add(gb);
       }
       rs.close();
       stmt.close();
       return grupolista;
    }
    public void adiciona(GrupoBins gb) throws SQLException{
        String sql="insert into grupo (nome)values(?)";
        PreparedStatement stmt= this.conexao.prepareStatement(sql);
        stmt.setString(1, gb.getNome());
        stmt.execute();
        stmt.close();
    }
}
