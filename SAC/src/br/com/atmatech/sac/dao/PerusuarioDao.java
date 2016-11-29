/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.sac.dao;

import br.com.atmatech.sac.beans.ListPerUsuarioBeans;
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
 * @author marcos
 */
public class PerusuarioDao {
    public List<ListPerUsuarioBeans> getPerusuario(Integer idusuario){
        try(Connection conexao=new ConexaoDb().getConnect()){
            String sql="select * from perusuario where idusuario=? ";            
            PreparedStatement pstm=conexao.prepareStatement(sql);
            pstm.setInt(1, idusuario);
            ResultSet rs=pstm.executeQuery();
            List<ListPerUsuarioBeans>lpub=new ArrayList<>();
            while(rs.next()){
                ListPerUsuarioBeans pub=new ListPerUsuarioBeans();
                pub.setIdperusuario(rs.getInt("idperusuario"));
                pub.setIdusuario(rs.getInt("idusuario"));
                pub.setView(rs.getString("TELA"));
                pub.setAcao(rs.getString("acao"));
                pub.setAtivo(rs.getString("ativo"));
                lpub.add(pub);
            }
            return lpub;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Consultar Permissões\n"+ex);
            return null;
        }
    }
    
    public void setPerusuario(List<ListPerUsuarioBeans> lpub) throws SQLException{
        try(Connection conexao=new ConexaoDb().getConnect()){
            for(ListPerUsuarioBeans pub:lpub ){
                String sql="INSERT INTO PERUSUARIO (IDUSUARIO, TELA, ACAO, ATIVO) VALUES (?, ?, ?, ?)";
                PreparedStatement pstm=conexao.prepareStatement(sql);
                pstm.setInt(1, pub.getIdusuario());                
                pstm.setString(2, pub.getView());
                pstm.setString(3, pub.getAcao());
                pstm.setString(4, pub.getAtivo());
                pstm.execute();
            }
                        
        }
    }
    public void deletePerusuario(Integer idusuario) throws SQLException{
        try(Connection conexao=new ConexaoDb().getConnect()){
            String sql="delete from perusuario where idusuario="+idusuario+"";
            PreparedStatement pstm=conexao.prepareStatement(sql);
            pstm.execute();
            pstm.close();
        }
    }
}
