/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.sac.dao;

import br.com.atmatech.sac.beans.AnexoBeans;
import br.com.atmatech.sac.connection.ConexaoDb;
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
public class AnexoDao {
    public void setAnexo(AnexoBeans ab) throws SQLException{
        try(Connection conexao=new ConexaoDb().getConnect()){
            String sql="insert into anexo(descricao,extensao,arquivo,idpessoa,data)values(?,?,?,?,NOW())";
            PreparedStatement pstm=conexao.prepareStatement(sql);
            pstm.setString(1, ab.getDescricao());
            pstm.setString(2, ab.getExtensao());
            pstm.setBytes(3, ab.getArquivo());
            pstm.setInt(4, ab.getIdpessoa());
            pstm.execute();
            pstm.close();
            conexao.close();
        }       
    }
    
    public List<AnexoBeans> getAnexo(Integer idpessoa){
        try(Connection conexao=new ConexaoDb().getConnect()){
            String sql="select * from anexo where idpessoa=?";
            PreparedStatement pstm=conexao.prepareStatement(sql);
            pstm.setInt(1, idpessoa);
            ResultSet rs=pstm.executeQuery();
            List<AnexoBeans> lab=new ArrayList<>();
            while(rs.next()){
                AnexoBeans ab=new AnexoBeans();
                ab.setIdanexo(rs.getInt("idanexo"));
                ab.setDescricao(rs.getString("descricao"));
                ab.setExtensao(rs.getString("extensao"));
                ab.setArquivo(rs.getBytes("arquivo"));
                ab.setIdpessoa(rs.getInt("idpessoa"));
                ab.setData(rs.getDate("data"));
                lab.add(ab);
            }
            rs.close();
            pstm.close();
            conexao.close();
            return lab;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro Ao Pesquisar Arquivos\n"+ex);
            return null;
        }
    }
}
