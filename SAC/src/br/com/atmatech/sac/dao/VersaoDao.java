/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.sac.dao;

import br.com.atmatech.sac.beans.VersaoBeans;
import br.com.atmatech.sac.connection.ConexaoDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author marcos
 */
public class VersaoDao {
    public VersaoBeans getVersao() throws SQLException{
        VersaoBeans vb=new VersaoBeans();
        try(Connection conexao=new ConexaoDb().getConnect()){
            String sql=" select * from versao where idversao=(select max(idversao) from versao)";
            PreparedStatement pstm=conexao.prepareStatement(sql);
            ResultSet rs=pstm.executeQuery();  
            while(rs.next()){
            vb.setIdversao(rs.getInt("idversao"));
            vb.setVersao(rs.getInt("versao"));
            vb.setEdicao(rs.getInt("edicao"));
            vb.setSeguranca(rs.getInt("seguranca"));
            }
            rs.close();
            pstm.close();
            conexao.close();
        }        
        return vb;        
    }
    
    public void setVersao(Integer versao,Integer edicao,Integer seguranca) throws SQLException{
        try(Connection conexao=new ConexaoDb().getConnect()){
            String sql=" update versao set versao="+versao+",edicao="+edicao+",seguranca="+seguranca+" where idversao=(select max(idversao) from versao)";
            PreparedStatement pstm=conexao.prepareStatement(sql);
            pstm.execute();
            pstm.close();
            conexao.close();
        }
    }
}
