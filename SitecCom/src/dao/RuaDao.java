/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bancodados.CriaConexao;
import bins.RuaBins;
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
public class RuaDao {
   
    private Connection conexao;
    public RuaDao() throws SQLException{
        this.conexao=CriaConexao.getConexao();
    }

    public void adiciona(RuaBins rb) throws SQLException{
        //PREPARA A CONEXAO
        String sql="insert into rua (nome,cidade,bairro,cep)values(?,?,?,?)";
        PreparedStatement stmt =conexao.prepareStatement(sql);
        //SETA OS VALORES
        stmt.setString(1,rb.getNome());
        stmt.setInt(2,rb.getCidade());
        stmt.setString(3,rb.getBairro());
        stmt.setString(4, rb.getCep());
        //EXECULTA O CODIGO SQL
        stmt.execute();
        stmt.close();
    }
    public List<RuaBins> getLista(int nome) throws SQLException{
        String sql = "select * from rua where cidade = ?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setInt(1, nome);
        ResultSet rs = stmt.executeQuery();
        List<RuaBins> RuaLista = new ArrayList<RuaBins>();
        while (rs.next()) {
            RuaBins rb = new RuaBins();
            rb.setId(rs.getInt("id"));
            rb.setNome(rs.getString("nome"));
            rb.setBairro(rs.getString("bairro"));
            rb.setCidade(rs.getInt("cidade"));
            rb.setCep(rs.getString("cep"));
            RuaLista.add(rb);
        }
        rs.close();
        stmt.close();
        return RuaLista;
    }
    public List<RuaBins> getruapessoa(int nome) throws SQLException{
        String sql = "select * from rua where id = ?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setInt(1, nome);
        ResultSet rs = stmt.executeQuery();
        List<RuaBins> RuaLista = new ArrayList<RuaBins>();
        while (rs.next()) {
            RuaBins rb = new RuaBins();
            rb.setId(rs.getInt("id"));
            rb.setNome(rs.getString("nome"));
            rb.setBairro(rs.getString("bairro"));
            rb.setCidade(rs.getInt("cidade"));
            rb.setCep(rs.getString("cep"));
            RuaLista.add(rb);
        }
        rs.close();
        stmt.close();
        return RuaLista;
    }
    public List<RuaBins> getPesquisa(String nome,String local,int idcidade) throws SQLException{
        String sql = "select * from rua where cidade="+idcidade+" and "+local+" like ? ";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setString(1, nome);
        ResultSet rs = stmt.executeQuery();
        List<RuaBins> RuaLista = new ArrayList<RuaBins>();
        while (rs.next()) {
            RuaBins rb = new RuaBins();
            rb.setId(rs.getInt("id"));
            rb.setNome(rs.getString("nome"));
            rb.setBairro(rs.getString("bairro"));
            rb.setCidade(rs.getInt("cidade"));
            rb.setCep(rs.getString("cep"));
            RuaLista.add(rb);
        }
        rs.close();
        stmt.close();
        return RuaLista;
    }
    public void altera(RuaBins rb) throws SQLException{
        //PREPARA A CONEXAO
        String sql="update rua set nome=?, bairro=?, cep=? where id=?";
        PreparedStatement stmt =conexao.prepareStatement(sql);
        //SETA OS VALORES
        stmt.setString(1,rb.getNome());
        stmt.setString(2,rb.getBairro());
        stmt.setString(3, rb.getCep());
        stmt.setInt(4, rb.getId());
        //EXECULTA O CODIGO SQL
        stmt.execute();
        stmt.close();
    }
}
