/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.sac.dao;

import br.com.atmatech.sac.beans.DBConfigBeans;
import br.com.atmatech.sac.beans.ModuloBeans;
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
public class ModuloDao {

    public List<ModuloBeans> getModulo() {
        try (Connection conexao = new ConexaoDb().getConnect()) {
            String sql="select * from modulo where idempresa="+new DBConfigBeans().getCompany()+"";
            PreparedStatement pstm=conexao.prepareStatement(sql);
            ResultSet rs=pstm.executeQuery();
            List<ModuloBeans> lmb=new ArrayList<>();            
            while(rs.next()){
                ModuloBeans mb=new ModuloBeans();
                mb.setIdmodulo(rs.getInt("idmodulo"));
                mb.setDescricao(rs.getString("descricao"));
                mb.setResponsavel(rs.getString("responsavel"));
                mb.setEmail(rs.getString("email"));
                mb.setAtivo(rs.getBoolean("ativo"));
                lmb.add(mb);
            }
            rs.close();
            pstm.close();
            return lmb;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Consultar Modulos\n"+ex);
            return null;
        }        
    }
    
    public List<ModuloBeans> getModulo(String coluna,String parametro) {
        try (Connection conexao = new ConexaoDb().getConnect()) {
            String sql="select * from modulo where "+coluna+" like '%"+parametro+"%' and idempresa="+new DBConfigBeans().getCompany()+" order by "+coluna;
            PreparedStatement pstm=conexao.prepareStatement(sql);
            ResultSet rs=pstm.executeQuery();
            List<ModuloBeans> lmb=new ArrayList<>();            
            while(rs.next()){
                ModuloBeans mb=new ModuloBeans();
                mb.setIdmodulo(rs.getInt("idmodulo"));
                mb.setDescricao(rs.getString("descricao"));
                mb.setResponsavel(rs.getString("responsavel"));
                mb.setEmail(rs.getString("email"));
                mb.setAtivo(rs.getBoolean("ativo"));
                lmb.add(mb);
            }
            rs.close();
            pstm.close();
            return lmb;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Consultar Modulos\n"+ex);
            return null;
        }        
    }
    
    public void setModulo(ModuloBeans mb) throws SQLException{
        try(Connection conexao=new ConexaoDb().getConnect()) {
            String sql="insert into modulo(descricao,responsavel,email,ativo,idempresa)values(?,?,?,?,?)";
            PreparedStatement pstm=conexao.prepareStatement(sql);
            pstm.setString(1, mb.getDescricao());
            pstm.setString(2, mb.getResponsavel());
            pstm.setString(3, mb.getEmail());
            pstm.setString(4, String.valueOf(mb.getAtivo()));
            pstm.setInt(5,new DBConfigBeans().getCompany());
            pstm.execute();
            pstm.close();
        }
    }
    
    public void updateModulo(ModuloBeans mb) throws SQLException{
        try(Connection conexao=new ConexaoDb().getConnect()) {
            String sql="update modulo set descricao=?,responsavel=?,email=?,ativo=? where idmodulo=?";
            PreparedStatement pstm=conexao.prepareStatement(sql);
            pstm.setString(1, mb.getDescricao());
            pstm.setString(2, mb.getResponsavel());
            pstm.setString(3, mb.getEmail());
            pstm.setString(4, String.valueOf(mb.getAtivo()));
            pstm.setInt(5, mb.getIdmodulo());
            pstm.execute();
            pstm.close();            
        }
    }
    
    public void deleteModulo(Integer idmodulo) throws SQLException{
        try(Connection conexao=new ConexaoDb().getConnect()) {
            String sql="delete from modulo where idmodulo=?";
            PreparedStatement pstm=conexao.prepareStatement(sql);
            pstm.setInt(1, idmodulo);
            pstm.execute();
            pstm.close();
        }
    }
}
