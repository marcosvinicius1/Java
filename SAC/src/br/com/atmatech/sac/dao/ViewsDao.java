/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.sac.dao;

import br.com.atmatech.sac.beans.ViewsBeans;
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
public class ViewsDao {
    public List<ViewsBeans> getViews(){
        try(Connection conexao=new ConexaoDb().getConnect()){
            String sql="SELECT RDB$DESCRIPTION DESCRICAO,RDB$RELATION_NAME NOME FROM RDB$RELATIONS WHERE NOT RDB$VIEW_BLR IS NULL";
            PreparedStatement pstm=conexao.prepareStatement(sql);
            ResultSet rs=pstm.executeQuery();
            List<ViewsBeans>lvb=new ArrayList<>();
            while(rs.next()){
                ViewsBeans vb=new ViewsBeans();
                vb.setNome(rs.getString("nome"));
                vb.setDescricao(rs.getString("descricao"));
                lvb.add(vb);
            }
            return lvb;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Consultar Relatorios\n" + ex);
            return null;
        }           
    }
    public List<ViewsBeans> getViewsCampos(String view){
        try(Connection conexao=new ConexaoDb().getConnect()){
            String sql="select  r.RDB$RELATION_NAME nome,RDB$FIELD_NAME campos,RDB$FIELD_SOURCE tamanho\n" +
" from rdb$relation_fields f\n" +
"join rdb$relations r on f.rdb$relation_name = r.rdb$relation_name AND f.rdb$relation_name LIKE'VIEW%'\n" +
" AND r.RDB$DESCRIPTION=?";
            PreparedStatement pstm=conexao.prepareStatement(sql);
            pstm.setString(1,view);
            ResultSet rs=pstm.executeQuery();
            List<ViewsBeans>lvb=new ArrayList<>();
            while(rs.next()){
                ViewsBeans vb=new ViewsBeans();
                vb.setNome(rs.getString("nome"));
                vb.setCampos(rs.getString("campos"));                
                lvb.add(vb);
            }
            return lvb;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Consultar Relatorios\n" + ex);
            return null;
        }           
    }
}
