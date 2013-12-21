/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
import bancodados.CriaConexao;
import bins.PessoaBins;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author MARCOS
 */
public class PessoaDao {
    private Connection conexao;
    public PessoaDao() throws SQLException{
        this.conexao=CriaConexao.getConexao();
    }

    public void adiciona(PessoaBins p1) throws SQLException{
        //PREPARA A CONEXAO
        String sql="insert into pessoa (nome,apelido,cpf_cnpj,inscricao,rua,numero,senha,lembra,telefone,tipo,modalidade,ativo,empresa,fantasia)"
                + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stmt =conexao.prepareStatement(sql);
        //SETA OS VALORES
        stmt.setString(1,p1.getNome());
        stmt.setString(2,p1.getApelido());
        stmt.setString(3,p1.getCpf_cnpj());
        stmt.setString(4,p1.getInscricao());
        stmt.setInt(5,p1.getRua());
        stmt.setString(6,p1.getNumero());
        stmt.setString(7,p1.getSenha());
        stmt.setString(8,p1.getLembra());
        stmt.setString(9,p1.getTelefone());
        stmt.setInt(10,p1.getTipo());
        stmt.setInt(11,p1.getModalidade());
        stmt.setInt(12, p1.getAtivo());
        stmt.setInt(13,p1.getEmpresa());
        stmt.setString(14, p1.getFantasia());
        //EXECULTA O CODIGO SQL
        stmt.execute();
        stmt.close();
    }
    public List<PessoaBins> getLista(String nome,String local,int empresa) throws SQLException{
        String sql = "select * from pessoa where "+local+" like ? and empresa="+empresa+" order by "+local+"";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setString(1, nome);
        ResultSet rs = stmt.executeQuery();
        List<PessoaBins> PessoaLista = new ArrayList<PessoaBins>();
        while (rs.next()) {
            PessoaBins b1 = new PessoaBins();
            b1.setId(rs.getInt("id"));
            b1.setNome(rs.getString("nome"));
            b1.setApelido(rs.getString("apelido"));
            b1.setCpf_cnpj(rs.getString("cpf_cnpj"));
            b1.setInscricao(rs.getString("inscricao"));
            b1.setRua(rs.getInt("rua"));           
            b1.setNumero((rs.getString("numero")));
            b1.setSenha(rs.getString("senha"));
            b1.setLembra(rs.getString("lembra"));
            b1.setTelefone(rs.getString("telefone"));
            b1.setTipo(rs.getInt("tipo"));
            b1.setModalidade(rs.getInt("modalidade"));
            b1.setAtivo(rs.getInt("ativo"));
            b1.setFantasia(rs.getString("fantasia"));
            PessoaLista.add(b1);
        }
        rs.close();
        stmt.close();
        return PessoaLista;
    }
   public List<PessoaBins> getListafornecedor(String nome,String local,int empresa) throws SQLException{
        String sql = "select * from pessoa where "+local+" like ? and ativo='0' and modalidade in(2,3) and empresa="+empresa+" order by "+local+"";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setString(1, nome);
        ResultSet rs = stmt.executeQuery();
        List<PessoaBins> PessoaLista = new ArrayList<PessoaBins>();
        while (rs.next()) {
            PessoaBins b1 = new PessoaBins();
            b1.setId(rs.getInt("id"));
            b1.setNome(rs.getString("nome"));
            b1.setApelido(rs.getString("apelido"));
            b1.setCpf_cnpj(rs.getString("cpf_cnpj"));
            b1.setInscricao(rs.getString("inscricao"));
            b1.setRua(rs.getInt("rua"));           
            b1.setNumero((rs.getString("numero")));
            b1.setSenha(rs.getString("senha"));
            b1.setLembra(rs.getString("lembra"));
            b1.setTelefone(rs.getString("telefone"));
            b1.setTipo(rs.getInt("tipo"));
            b1.setModalidade(rs.getInt("modalidade"));
            b1.setAtivo(rs.getInt("ativo"));
            b1.setEmpresa(rs.getInt("empresa"));
            b1.setFantasia(rs.getString("fantasia"));
            PessoaLista.add(b1);
        }
        rs.close();
        stmt.close();
        return PessoaLista;
    }
   public List<PessoaBins> getListacliente(String nome,String local,int empresa) throws SQLException{
        String sql = "select * from pessoa where "+local+" like ? and ativo='0' and modalidade in(1,3,5) and empresa="+empresa+" order by "+local+"";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setString(1, nome);
        ResultSet rs = stmt.executeQuery();
        List<PessoaBins> PessoaLista = new ArrayList<PessoaBins>();
        while (rs.next()) {
            PessoaBins b1 = new PessoaBins();
            b1.setId(rs.getInt("id"));
            b1.setNome(rs.getString("nome"));
            b1.setApelido(rs.getString("apelido"));
            b1.setCpf_cnpj(rs.getString("cpf_cnpj"));
            b1.setInscricao(rs.getString("inscricao"));
            b1.setRua(rs.getInt("rua"));           
            b1.setNumero((rs.getString("numero")));
            b1.setSenha(rs.getString("senha"));
            b1.setLembra(rs.getString("lembra"));
            b1.setTelefone(rs.getString("telefone"));
            b1.setTipo(rs.getInt("tipo"));
            b1.setModalidade(rs.getInt("modalidade"));
            b1.setAtivo(rs.getInt("ativo"));
            b1.setEmpresa(rs.getInt("empresa"));
            b1.setFantasia(rs.getString("fantasia"));
            PessoaLista.add(b1);
        }
        rs.close();
        stmt.close();
        return PessoaLista;
    }
   public List<PessoaBins> getListavendedor(String nome,int empresa) throws SQLException{
        String sql = "select * from pessoa where nome like ? and ativo='0' and modalidade in(4,5) and empresa="+empresa+" order by nome";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setString(1, nome);
        ResultSet rs = stmt.executeQuery();
        List<PessoaBins> PessoaLista = new ArrayList<PessoaBins>();
        while (rs.next()) {
            PessoaBins b1 = new PessoaBins();
            b1.setId(rs.getInt("id"));
            b1.setNome(rs.getString("nome"));
            b1.setApelido(rs.getString("apelido"));
            b1.setCpf_cnpj(rs.getString("cpf_cnpj"));
            b1.setInscricao(rs.getString("inscricao"));
            b1.setRua(rs.getInt("rua"));           
            b1.setNumero((rs.getString("numero")));
            b1.setSenha(rs.getString("senha"));
            b1.setLembra(rs.getString("lembra"));
            b1.setTelefone(rs.getString("telefone"));
            b1.setTipo(rs.getInt("tipo"));
            b1.setModalidade(rs.getInt("modalidade"));
            b1.setAtivo(rs.getInt("ativo"));
            b1.setEmpresa(rs.getInt("empresa"));
            b1.setFantasia(rs.getString("fantasia"));
            PessoaLista.add(b1);
        }
        rs.close();
        stmt.close();
        return PessoaLista;
    }
   public List<PessoaBins> getLogin(String nome,int empresa) throws SQLException{
        String sql = "select * from pessoa where apelido like ? and ativo='0' and modalidade in(4,5) and empresa="+empresa+" order by nome";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setString(1, nome);
        ResultSet rs = stmt.executeQuery();
        List<PessoaBins> PessoaLista = new ArrayList<PessoaBins>();
        while (rs.next()) {
            PessoaBins b1 = new PessoaBins();
            b1.setId(rs.getInt("id"));
            b1.setNome(rs.getString("nome"));
            b1.setApelido(rs.getString("apelido"));
            b1.setCpf_cnpj(rs.getString("cpf_cnpj"));
            b1.setInscricao(rs.getString("inscricao"));
            b1.setRua(rs.getInt("rua"));           
            b1.setNumero((rs.getString("numero")));
            b1.setSenha(rs.getString("senha"));
            b1.setLembra(rs.getString("lembra"));
            b1.setTelefone(rs.getString("telefone"));
            b1.setTipo(rs.getInt("tipo"));
            b1.setModalidade(rs.getInt("modalidade"));
            b1.setAtivo(rs.getInt("ativo"));
            b1.setEmpresa(rs.getInt("empresa"));
            b1.setFantasia(rs.getString("fantasia"));
            PessoaLista.add(b1);
        }
        rs.close();
        stmt.close();
        return PessoaLista;
    }
    public List<PessoaBins> getpessoa(int id) throws SQLException{
        String sql = "select * from pessoa where id=?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        List<PessoaBins> PessoaLista = new ArrayList<PessoaBins>();
        while (rs.next()) {
            PessoaBins b1 = new PessoaBins();
            b1.setId(rs.getInt("id"));
            b1.setNome(rs.getString("nome"));
            b1.setApelido(rs.getString("apelido"));
            b1.setCpf_cnpj(rs.getString("cpf_cnpj"));
            b1.setInscricao(rs.getString("inscricao"));
            b1.setRua(rs.getInt("rua"));           
            b1.setNumero((rs.getString("numero")));
            b1.setSenha(rs.getString("senha"));
            b1.setLembra(rs.getString("lembra"));
            b1.setTelefone(rs.getString("telefone"));
            b1.setTipo(rs.getInt("tipo"));
            b1.setModalidade(rs.getInt("modalidade"));
            b1.setAtivo(rs.getInt("ativo"));
            b1.setFantasia(rs.getString("fantasia"));
            PessoaLista.add(b1);
        }
        rs.close();
        stmt.close();
        return PessoaLista;
    }
    public void altera(PessoaBins p1) throws SQLException{
        String sql="update pessoa set nome=?,apelido=?,cpf_cnpj=?,inscricao=?,rua=?,numero=?"
                + ",senha=?,lembra=?,telefone=?,tipo=?,modalidade=?,ativo=?,fantasia=? where id=?";
        PreparedStatement stmt= conexao.prepareStatement(sql);
        
        //SETA OS VALORES
        stmt.setString(1,p1.getNome());
        stmt.setString(2,p1.getApelido());
        stmt.setString(3,p1.getCpf_cnpj());
        stmt.setString(4,p1.getInscricao());
        stmt.setInt(5,p1.getRua());
        stmt.setString(6,p1.getNumero());
        stmt.setString(7,p1.getSenha());
        stmt.setString(8,p1.getLembra());
        stmt.setString(9,p1.getTelefone());
        stmt.setInt(10,p1.getTipo());
        stmt.setInt(11,p1.getModalidade());
        stmt.setInt(12, p1.getAtivo());
        stmt.setString(13, p1.getFantasia());
        stmt.setInt(14, p1.getId());
        //EXECULTA O CODIGO SQL
        stmt.execute();
        stmt.close();
        
    }
    public void remove(PessoaBins p1) throws SQLException{
        String sql="delete from pessoa where id=?";
        PreparedStatement stmt= conexao.prepareStatement(sql);
        stmt.setLong(1, p1.getId());
        stmt.execute();
        stmt.close();
        
    }
}
