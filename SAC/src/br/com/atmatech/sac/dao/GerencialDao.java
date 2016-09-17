/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.sac.dao;

import br.com.atmatech.sac.connection.ConexaoDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author marcos
 */
public class GerencialDao {

    public List<String[]> getView(String[] campos, String nameview) {
        try (Connection conexao = new ConexaoDb().getConnect()) {
            String sql = "select " + Arrays.toString(campos).replace("[", "").replace("]", "") + " from " + nameview + "";
            PreparedStatement pstm =conexao.prepareStatement(sql);
            ResultSet rs=pstm.executeQuery();
             List<String []> lrview=new ArrayList<>();  
             List valores=new ArrayList<>();
            while(rs.next()){
                valores.clear();
                for(int i=0;i<campos.length;i++){                    
                    valores.add(rs.getString(campos[i]));
                } 
                String [] campos1=(String []) valores.toArray(new String[valores.size()]);
                lrview.add(campos1);
            }
            return lrview;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Consulta\n"+ex);
            return null;
        }       
    }
    
    
    public List<String[]> getView(String[] campos, String nameview,String group) {
        try (Connection conexao = new ConexaoDb().getConnect()) {
            String sql = "select " + Arrays.toString(campos).replace("[", "").replace("]", "") + " "
                    + "from " + nameview +" order by "+group+"";
            System.out.println(sql);
            PreparedStatement pstm =conexao.prepareStatement(sql);
            ResultSet rs=pstm.executeQuery();
             List<String []> lrview=new ArrayList<>();  
             List valores=new ArrayList<>();
            while(rs.next()){
                valores.clear();
                for(int i=0;i<campos.length;i++){                    
                    valores.add(rs.getString(campos[i]));
                } 
                String [] campos1=(String []) valores.toArray(new String[valores.size()]);
                lrview.add(campos1);
            }
            return lrview;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Consulta\n"+ex);
            return null;
        }       
    }

    public List<String[]> getView(String[] campos, String nameview,String group,String [] condicao) {
        try (Connection conexao = new ConexaoDb().getConnect()) {
            String sql = "select " + Arrays.toString(campos).replace("[", "").replace("]", "") + " "
                    + "from " + nameview +" where "+Arrays.toString(condicao).replace("[", "").replace("]", "").replace(",","")+" "
                    + "order by "+group+"";
            System.out.println(sql);
            PreparedStatement pstm =conexao.prepareStatement(sql);
            ResultSet rs=pstm.executeQuery();
             List<String []> lrview=new ArrayList<>();  
             List valores=new ArrayList<>();
            while(rs.next()){
                valores.clear();
                for(int i=0;i<campos.length;i++){                    
                    valores.add(rs.getString(campos[i]));
                } 
                String [] campos1=(String []) valores.toArray(new String[valores.size()]);
                lrview.add(campos1);
            }
            return lrview;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Consulta\n"+ex);
            return null;
        }       
    }
    
    public List<String[]> getView(String[] campos, String nameview,String [] condicao) {
        try (Connection conexao = new ConexaoDb().getConnect()) {
            String sql = "select " + Arrays.toString(campos).replace("[", "").replace("]", "") + " "
                    + "from " + nameview +" where "+Arrays.toString(condicao).replace("[", "").replace("]", "").replace(",","")+" ";

            System.out.println(sql);
            PreparedStatement pstm =conexao.prepareStatement(sql);
            ResultSet rs=pstm.executeQuery();
             List<String []> lrview=new ArrayList<>();  
             List valores=new ArrayList<>();
            while(rs.next()){
                valores.clear();
                for(int i=0;i<campos.length;i++){                    
                    valores.add(rs.getString(campos[i]));
                } 
                String [] campos1=(String []) valores.toArray(new String[valores.size()]);
                lrview.add(campos1);
            }
            return lrview;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Consulta\n"+ex);
            return null;
        }       
    }
}
