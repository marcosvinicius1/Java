/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.painel.dao;

import br.com.atmatech.painel.beans.Tb_Prod_PainelBeans;
import br.com.atmatech.painel.connection.ConexaoLocalDBMySql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcos
 */
public class Tb_Prod_PainelDao {

    public List<Tb_Prod_PainelBeans> getProdPainel(Integer terminal, Integer painel) throws SQLException {
        try (Connection conexao = new ConexaoLocalDBMySql().getConnect()) {
            String sql = "SELECT tb_prod_painel.* FROM tb_prod_painel "
                    + " INNER JOIN tb_prod ON(tb_prod_painel.codigo=tb_prod.codigo) where terminal=? and painel=? order by tb_prod_painel.idtb_painel";            
            PreparedStatement pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, terminal);
            pstm.setInt(2, painel);
            ResultSet rs = pstm.executeQuery();
            List<Tb_Prod_PainelBeans> lpb = new ArrayList<>();
            while (rs.next()) {
                Tb_Prod_PainelBeans pb = new Tb_Prod_PainelBeans();
                pb.setCodigo(rs.getString("codigo"));
                pb.setDescricao(rs.getString("descricao"));
                pb.setUnid(rs.getString("unid"));
                pb.setValor1(rs.getFloat("valor1"));
                pb.setValor2(rs.getFloat("valor2"));
                pb.setOferta(rs.getBoolean("oferta"));
                pb.setReceita(rs.getString("receita"));                
                pb.setTerminal(rs.getInt("terminal"));
                pb.setPainel(rs.getInt("painel"));
                lpb.add(pb);
            }
            rs.close();
            pstm.close();
            conexao.close();
            return lpb;
        }
    }
    
    public List<Tb_Prod_PainelBeans> getProdPainelConfig(Integer terminal, Integer painel) throws SQLException {
        try (Connection conexao = new ConexaoLocalDBMySql().getConnect()) {
            String sql = "SELECT tb_prod_painel.* FROM tb_prod_painel "
                    + "where terminal=? and painel=? order by tb_prod_painel.idtb_painel";            
            PreparedStatement pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, terminal);
            pstm.setInt(2, painel);
            ResultSet rs = pstm.executeQuery();
            List<Tb_Prod_PainelBeans> lpb = new ArrayList<>();
            while (rs.next()) {
                Tb_Prod_PainelBeans pb = new Tb_Prod_PainelBeans();
                pb.setCodigo(rs.getString("codigo"));
                pb.setDescricao(rs.getString("descricao"));
                pb.setUnid(rs.getString("unid"));
                pb.setValor1(rs.getFloat("valor1"));
                pb.setValor2(rs.getFloat("valor2"));
                pb.setOferta(rs.getBoolean("oferta"));
                pb.setReceita(rs.getString("receita"));                
                pb.setTerminal(rs.getInt("terminal"));
                pb.setPainel(rs.getInt("painel"));
                lpb.add(pb);
            }
            rs.close();
            pstm.close();
            conexao.close();
            return lpb;
        }
    }
    
    public List<Tb_Prod_PainelBeans> getProdPainelTabelas(Integer terminal, String painel) throws SQLException {
        try (Connection conexao = new ConexaoLocalDBMySql().getConnect()) {
            String sql = "SELECT tb_prod_painel.* FROM tb_prod_painel "
                    + " INNER JOIN tb_prod ON(tb_prod_painel.codigo=tb_prod.codigo) where terminal=? and painel in(" + painel + ") order by tb_prod_painel.idtb_painel";            
            PreparedStatement pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, terminal);            
            ResultSet rs = pstm.executeQuery();
            List<Tb_Prod_PainelBeans> lpb = new ArrayList<>();            
            while (rs.next()) {
                Tb_Prod_PainelBeans pb = new Tb_Prod_PainelBeans();
                pb.setCodigo(rs.getString("codigo"));
                pb.setDescricao(rs.getString("descricao"));
                pb.setUnid(rs.getString("unid"));
                pb.setValor1(rs.getFloat("valor1"));
                pb.setValor2(rs.getFloat("valor2"));
                pb.setOferta(rs.getBoolean("oferta"));
                pb.setReceita(rs.getString("receita"));                
                pb.setTerminal(rs.getInt("terminal"));
                pb.setPainel(rs.getInt("painel"));
                lpb.add(pb);
            }
            rs.close();
            pstm.close();
            conexao.close();
            return lpb;
        }
    }
    
    public void setProdPainel(List<Tb_Prod_PainelBeans> lpb) throws SQLException {
        try (Connection conexao = new ConexaoLocalDBMySql().getConnect()) {
            String sql = "insert into tb_prod_painel(codigo,descricao,unid,valor1,valor2,oferta,terminal,painel) values ";            
            String sql2 = null;
            for (Tb_Prod_PainelBeans pb : lpb) {                
                String sql3 = "('" +pb.getCodigo()+ "','" +pb.getDescricao() + "','" + pb.getUnid() + "','" + pb.getValor1() + "','" + pb.getValor2() + "',"
                        + "" + pb.getOferta() + "," + pb.getTerminal() + "," + pb.getPainel() + ") ";                
                if (sql2==null) {                    
                    sql2=sql+sql3;
                }else{                    
                    sql2=sql2+","+sql3;
                }
            }            
            PreparedStatement pstm = conexao.prepareStatement(sql2);
            pstm.execute();
            pstm.close();
            conexao.close();
        }
    }    
    
    public void setProdPainelbackup(List<Tb_Prod_PainelBeans> lpb) throws SQLException {
        try (Connection conexao = new ConexaoLocalDBMySql().getConnect()) {
            String sql = "insert into tb_prod_painel(codigo,descricao,unid,valor1,valor2,oferta,terminal,painel)values(?,?,?,?,?,?,?,?)";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            for (Tb_Prod_PainelBeans pb : lpb) {                
                pstm.setString(1, pb.getCodigo());
                pstm.setString(2, pb.getDescricao());
                pstm.setString(3, pb.getUnid());
                pstm.setFloat(4, pb.getValor1());
                pstm.setFloat(5, pb.getValor2());
                pstm.setBoolean(6, pb.getOferta());
                pstm.setInt(7, pb.getTerminal());
                pstm.setInt(8, pb.getPainel());
                pstm.addBatch();
            }
            pstm.executeBatch();
            pstm.close();
            conexao.close();
        }
    }    
    
    public void updateProdPainel(String codigo, Integer terminal, Float valor1) throws SQLException {
        try (Connection conexao = new ConexaoLocalDBMySql().getConnect()) {
            String sql = "UPDATE tb_prod_painel SET valor1 = ? WHERE codigo = ? AND terminal=?";            
            PreparedStatement pstm = conexao.prepareStatement(sql);            
            pstm.setFloat(0, valor1);
            pstm.setString(1, codigo);
            pstm.setInt(2, terminal);
            System.err.println(pstm.toString());
            pstm.execute();
            pstm.close();
            conexao.close();
        }
    }    
    
    public Boolean delProdPainel(Integer terminal, Integer painel) throws SQLException {
        Boolean retorno = false;
        try (Connection conexao = new ConexaoLocalDBMySql().getConnect()) {
            String sql = "delete from tb_prod_painel where terminal=? and painel=?";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, terminal);
            pstm.setInt(2, painel);
            pstm.execute();
            retorno = true;
        }        
        return retorno;
    }
}
