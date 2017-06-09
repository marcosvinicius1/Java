/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.sac.dao;

import br.com.atmatech.sac.beans.DBConfigBeans;
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

    public List<ViewsBeans> getViews() {
        try (Connection conexao = new ConexaoDb().getConnect()) {
            DBConfigBeans dbcb = new DBConfigBeans();
            String sql = "SELECT * FROM information_schema.views where table_schema='" + new DBConfigBeans().getDirdb().replace("jdbc:mysql://192.168.25.195:3306/", "") + "'";            
            PreparedStatement pstm = conexao.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            List<ViewsBeans> lvb = new ArrayList<>();
            while (rs.next()) {
                ViewsBeans vb = new ViewsBeans();
                vb.setNome(rs.getString("TABLE_NAME"));
                vb.setDescricao(rs.getString("TABLE_NAME"));
                lvb.add(vb);
            }
            return lvb;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Consultar Relatorios\n" + ex);
            return null;
        }
    }

    public List<ViewsBeans> getViewsCampos(String view) {
        try (Connection conexao = new ConexaoDb().getConnect()) {
            String sql = "SELECT * FROM information_schema.COLUMNS where table_schema='" + new DBConfigBeans().getDirdb().replace("jdbc:mysql://192.168.25.195:3306/", "") + "' "
                    + " and table_name=?";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            pstm.setString(1, view);
            ResultSet rs = pstm.executeQuery();
            List<ViewsBeans> lvb = new ArrayList<>();
            while (rs.next()) {
                ViewsBeans vb = new ViewsBeans();
                vb.setNome(rs.getString("TABLE_NAME"));
                vb.setCampos(rs.getString("COLUMN_NAME"));
                lvb.add(vb);
            }
            return lvb;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Consultar Relatorios\n" + ex);
            return null;
        }
    }
}
