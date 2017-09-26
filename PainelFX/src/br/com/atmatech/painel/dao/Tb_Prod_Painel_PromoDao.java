/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.painel.dao;

import br.com.atmatech.painel.beans.Tb_Prod_Painel_PromoBeans;
import br.com.atmatech.painel.connection.ConexaoDBMySql;
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
public class Tb_Prod_Painel_PromoDao {
    
//usado na consulta assim que abre a tela de promocao
    public List<Tb_Prod_Painel_PromoBeans> getProdPainel(Integer terminal, Integer painel) throws SQLException {
        try (Connection conexao = new ConexaoDBMySql().getConnect()) {
            String sql = "SELECT tb_prod_painel_promo.* FROM tb_prod_painel_promo "
                    + " INNER JOIN tb_prod ON(tb_prod_painel_promo.codigo=tb_prod.codigo) where terminal=? and painel=? order by tb_prod_painel_promo.idtb_painel_promo";            
            PreparedStatement pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, terminal);
            pstm.setInt(2, painel);
            ResultSet rs = pstm.executeQuery();
            List<Tb_Prod_Painel_PromoBeans> lpb = new ArrayList<>();
            while (rs.next()) {
                Tb_Prod_Painel_PromoBeans pb = new Tb_Prod_Painel_PromoBeans();
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
    //consulta produtos da tabela promocao
    public List<Tb_Prod_Painel_PromoBeans> getProdPainelConfig(Integer terminal, Integer painel) throws SQLException {
        try (Connection conexao = new ConexaoDBMySql().getConnect()) {
            String sql = "SELECT tb_prod_painel_promo.* FROM tb_prod_painel_promo "
                    + "where terminal=? and painel=? order by tb_prod_painel_promo.idtb_painel_promo";            
            PreparedStatement pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, terminal);
            pstm.setInt(2, painel);
            ResultSet rs = pstm.executeQuery();
            List<Tb_Prod_Painel_PromoBeans> lpb = new ArrayList<>();
            while (rs.next()) {
                Tb_Prod_Painel_PromoBeans pb = new Tb_Prod_Painel_PromoBeans();
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
    //usado para verificar se produto foi alterado na atualizacao automatica
    public List<Tb_Prod_Painel_PromoBeans> getProdPainelTabelas(Integer terminal, String painel) throws SQLException {
        try (Connection conexao = new ConexaoDBMySql().getConnect()) {
            String sql = "SELECT tb_prod_painel_promo.* FROM tb_prod_painel_promo "
                    + " INNER JOIN tb_prod ON(tb_prod_painel_promo.codigo=tb_prod.codigo) where terminal=? and painel in(" + painel + ") order by tb_prod_painel_promo.idtb_painel_promo";            
            PreparedStatement pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, terminal);            
            ResultSet rs = pstm.executeQuery();
            List<Tb_Prod_Painel_PromoBeans> lpb = new ArrayList<>();            
            while (rs.next()) {
                Tb_Prod_Painel_PromoBeans pb = new Tb_Prod_Painel_PromoBeans();
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
    //utilizado para salvar produtos na promocao
    public void setProdPainel(List<Tb_Prod_Painel_PromoBeans> lpb) throws SQLException {
        try (Connection conexao = new ConexaoDBMySql().getConnect()) {
            String sql = "insert into tb_prod_painel_promo(codigo,descricao,unid,valor1,valor2,oferta,terminal,painel) values ";            
            String sql2 = null;
            for (Tb_Prod_Painel_PromoBeans pb : lpb) {                
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
    //utilizado para limpar produtos na promocao
    public Boolean delProdPainel(Integer terminal, Integer painel) throws SQLException {
        Boolean retorno = false;
        try (Connection conexao = new ConexaoDBMySql().getConnect()) {
            String sql = "delete from tb_prod_painel_promo where terminal=? and painel=?";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, terminal);
            pstm.setInt(2, painel);
            pstm.execute();
            retorno = true;
        }        
        return retorno;
    }
}
