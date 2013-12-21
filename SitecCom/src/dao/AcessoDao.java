/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bancodados.CriaConexao;
import bins.AcessoBins;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcos Vinicius
 */
public class AcessoDao {
    private Connection conexao;
    public AcessoDao() throws SQLException{
        this.conexao=CriaConexao.getConexao();
    }
    public void adiciona(AcessoBins ac) throws SQLException{
        String sql="insert into acesso (pessoa,classe,acesso) value(?,?,?)";
        PreparedStatement stmt=this.conexao.prepareStatement(sql);
        stmt.setInt(1, ac.getPessoa());
        stmt.setString(2, ac.getClasse());
        stmt.setString(3, ac.getAcesso());
        stmt.execute();
        stmt.close();
    }
    public void remove(int ac) throws SQLException{
        String sql="delete from acesso where pessoa="+ac+"";
        PreparedStatement stmt=this.conexao.prepareStatement(sql);
        stmt.execute(sql);
        stmt.close();
    }
    public List<AcessoBins> getAcesso(int id) throws SQLException{
        String sql="Select * from acesso where pessoa="+id+"";
        PreparedStatement stmt=this.conexao.prepareStatement(sql);
        ResultSet rs=stmt.executeQuery(sql);
        List<AcessoBins> acessolista=new ArrayList<AcessoBins>();
        while(rs.next()){
            AcessoBins ab=new AcessoBins();
            ab.setAcesso(rs.getString("acesso"));
            ab.setClasse(rs.getString("classe"));
            ab.setPessoa(rs.getInt("pessoa"));
            acessolista.add(ab);
        }
        rs.close();
        stmt.close();
        return acessolista;
    }
}
