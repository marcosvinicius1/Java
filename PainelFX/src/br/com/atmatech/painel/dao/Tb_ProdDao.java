/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.painel.dao;

import br.com.atmatech.painel.beans.Tb_ProdBeans;
import br.com.atmatech.painel.connection.ConexaoDBMySql;
import br.com.atmatech.painel.connection.ConexaoDBSqlServer;
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
public class Tb_ProdDao {

    public List<Tb_ProdBeans> getProdBalanca() throws SQLException {
        try (Connection conexao = new ConexaoDBSqlServer().getConnect()) {
            String sql = "select * from vw_prod_painel";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            List<Tb_ProdBeans> lpb = new ArrayList<>();
            while (rs.next()) {
                Tb_ProdBeans pb = new Tb_ProdBeans();
                pb.setCodigo(rs.getString("codigo"));
                pb.setDescricao(rs.getString("descricao"));
                pb.setUnid(rs.getString("unid"));
                pb.setValor1(rs.getFloat("valor1"));
                pb.setValor2(rs.getFloat("valor2"));
                pb.setOferta(rs.getBoolean("oferta"));
                lpb.add(pb);
            }
            rs.close();
            pstm.close();
            conexao.close();
            return lpb;
        }
    }

    public List<Tb_ProdBeans> getProdLocal() throws SQLException {
        try (Connection conexao = new ConexaoDBMySql().getConnect()) {
            String sql = "select * from tb_prod";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            List<Tb_ProdBeans> lpb = new ArrayList<>();
            while (rs.next()) {
                Tb_ProdBeans pb = new Tb_ProdBeans();
                pb.setCodigo(rs.getString("codigo"));
                pb.setDescricao(rs.getString("descricao"));
                pb.setUnid(rs.getString("unid"));
                pb.setValor1(rs.getFloat("valor1"));
                pb.setValor2(rs.getFloat("valor2"));
                pb.setOferta(rs.getBoolean("oferta"));
                lpb.add(pb);
            }
            rs.close();
            pstm.close();
            conexao.close();
            return lpb;
        }
    }
    
    public List<Tb_ProdBeans> getFiltroProdLocal(String filtro) throws SQLException {
        try (Connection conexao = new ConexaoDBMySql().getConnect()) {
            String sql = "select * from tb_prod where descricao like ? OR codigo like ? ";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            pstm.setString(1, "%"+filtro+"%");
            pstm.setString(2, "%"+filtro+"%");
            ResultSet rs = pstm.executeQuery();
            List<Tb_ProdBeans> lpb = new ArrayList<>();
            while (rs.next()) {
                Tb_ProdBeans pb = new Tb_ProdBeans();
                pb.setCodigo(rs.getString("codigo"));
                pb.setDescricao(rs.getString("descricao"));
                pb.setUnid(rs.getString("unid"));
                pb.setValor1(rs.getFloat("valor1"));
                pb.setValor2(rs.getFloat("valor2"));
                pb.setOferta(rs.getBoolean("oferta"));
                lpb.add(pb);
            }
            rs.close();
            pstm.close();
            conexao.close();
            return lpb;
        }
    }

    public void setProdLocal(List<Tb_ProdBeans> lpb) throws SQLException {
        try (Connection conexao = new ConexaoDBMySql().getConnect()) {
            String sql = "insert into tb_prod(codigo,descricao,unid,valor1,valor2)values(?,?,?,?,?)";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            for (Tb_ProdBeans pb : lpb) {                
                pstm.setString(1, pb.getCodigo());
                pstm.setString(2, pb.getDescricao());
                pstm.setString(3, pb.getUnid());
                pstm.setFloat(4, pb.getValor1());
                pstm.setFloat(5, pb.getValor2());
                pstm.addBatch();
            }
            pstm.executeBatch();
            pstm.close();
            conexao.close();
        }
    }    
    
    public Boolean delProdLocal() throws SQLException {
        Boolean retorno = false;
        try (Connection conexao = new ConexaoDBMySql().getConnect()) {
            String sql = "delete from tb_prod";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            pstm.execute();
            retorno = true;
        } 
        return retorno;
    }
}
