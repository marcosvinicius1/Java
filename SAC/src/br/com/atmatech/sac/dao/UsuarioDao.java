/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.sac.dao;

import br.com.atmatech.sac.beans.UsuarioBeans;
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
public class UsuarioDao {
    
    //usado na consulta de usuario na tela de cadastro
    public List<UsuarioBeans> getUsuario(){
        try(Connection conexao=new ConexaoDb().getConnect()){
           String sql="select * from usuario order by nome";           
            PreparedStatement pstm=conexao.prepareStatement(sql);
            ResultSet rs=pstm.executeQuery();
           List<UsuarioBeans>lub=new ArrayList<>();
           while(rs.next()){
               UsuarioBeans ub=new UsuarioBeans();
               ub.setIdusuario(rs.getInt("idusuario"));
               ub.setLogin(rs.getString("login"));
               ub.setNome(rs.getString("nome"));
               ub.setSenha(rs.getString("senha"));
               ub.setTecnico(rs.getBoolean("tecnico"));
               ub.setAtivo(rs.getBoolean("ativo"));
               ub.setVchamados(rs.getBoolean("vchamados"));
               ub.setAlttecnico(rs.getBoolean("alttecnico"));
               ub.setSmtp(rs.getString("smtp"));
               ub.setPorta(rs.getInt("porta"));
               ub.setSsl(rs.getBoolean("ssl"));
               ub.setTls(rs.getBoolean("tls"));
               ub.setEmail(rs.getString("email"));
               ub.setSenhaemail(rs.getString("senhaemail"));
               ub.setAssinatura(rs.getString("assinatura"));
               ub.setBconsulta(rs.getBoolean("bconsulta"));
               
               lub.add(ub);
           }
           rs.close();
           pstm.close();           
           return lub;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Consultar Usuarios\n"+ex);
            return null;
        }
    }
    
    //usado na tela de login
    public UsuarioBeans getUsuario(String login,String senha){
        try(Connection conexao=new ConexaoDb().getConnect()){
           String sql="select * from usuario where login=? and senha=? and ativo='true'";           
            PreparedStatement pstm=conexao.prepareStatement(sql);
            pstm.setString(1, login);
            pstm.setString(2, senha);
            ResultSet rs=pstm.executeQuery();
            UsuarioBeans ub=new UsuarioBeans();
           while(rs.next()){               
               ub.setIdusuario(rs.getInt("idusuario"));
               ub.setLogin(rs.getString("login"));
               ub.setNome(rs.getString("nome"));
               ub.setSenha(rs.getString("senha"));
               ub.setTecnico(rs.getBoolean("tecnico")); 
               ub.setVchamados(rs.getBoolean("vchamados"));
               ub.setAlttecnico(rs.getBoolean("alttecnico"));
               ub.setSmtp(rs.getString("smtp"));
               ub.setPorta(rs.getInt("porta"));
               ub.setSsl(rs.getBoolean("ssl"));
               ub.setTls(rs.getBoolean("tls"));
               ub.setEmail(rs.getString("email"));
               ub.setSenhaemail(rs.getString("senhaemail"));
               ub.setAssinatura(rs.getString("assinatura"));
               ub.setBconsulta(rs.getBoolean("bconsulta"));
               
           }
           rs.close();
           pstm.close();           
           return ub;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Consultar Usuario\n"+ex);
            return null;
        }
    }
    
    //usado na consulta de tecnico no chamado
    public List<UsuarioBeans> getUsuario(String campo,String parametro,String ordenar){
        try(Connection conexao=new ConexaoDb().getConnect()){
           String sql="select * from usuario where "+campo+" like '%"+parametro+"%' and ativo='true' and tecnico='true' order by "+ordenar+"";           
            PreparedStatement pstm=conexao.prepareStatement(sql);
            ResultSet rs=pstm.executeQuery();
            List<UsuarioBeans>lub=new ArrayList<>();
           while(rs.next()){ 
               UsuarioBeans ub=new UsuarioBeans();
               ub.setIdusuario(rs.getInt("idusuario"));
               ub.setLogin(rs.getString("login"));
               ub.setNome(rs.getString("nome"));
               ub.setSenha(rs.getString("senha"));
               ub.setTecnico(rs.getBoolean("tecnico")); 
               ub.setVchamados(rs.getBoolean("vchamados"));
               ub.setAlttecnico(rs.getBoolean("alttecnico"));
               ub.setSmtp(rs.getString("smtp"));
               ub.setPorta(rs.getInt("porta"));
               ub.setSsl(rs.getBoolean("ssl"));
               ub.setTls(rs.getBoolean("tls"));
               ub.setEmail(rs.getString("email"));
               ub.setSenhaemail(rs.getString("senhaemail"));
               ub.setAssinatura(rs.getString("assinatura"));
               ub.setBconsulta(rs.getBoolean("bconsulta"));
               lub.add(ub);
           }
           rs.close();
           pstm.close();           
           return lub;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Consultar Usuario\n"+ex);
            return null;
        }
    }
    //usado na tela de cadastro de usuario
    public void setUsuario(UsuarioBeans ub) throws SQLException {
        try(Connection conexao=new ConexaoDb().getConnect()){
            String sql="insert into usuario(nome,login,tecnico,senha,ativo,vchamados,alttecnico,"
                    + "smtp,porta,ssl,tls,email,senhaemail,assinatura,bconsulta)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstm=conexao.prepareStatement(sql);
            pstm.setString(1, ub.getNome());
            pstm.setString(2, ub.getLogin());
            pstm.setBoolean(3, ub.getTecnico());
            pstm.setString(4,ub.getSenha());
            pstm.setBoolean(5, ub.getAtivo());
            pstm.setBoolean(6, ub.getVchamados());
            pstm.setBoolean(7, ub.getAlttecnico());
            pstm.setString(8,ub.getSmtp());
            pstm.setInt(9,ub.getPorta());
            pstm.setBoolean(10,ub.getSsl());
            pstm.setBoolean(11,ub.getTls());
            pstm.setString(12,ub.getEmail());
            pstm.setString(13,ub.getSenhaemail());
            pstm.setString(14,ub.getAssinatura()); 
            pstm.setBoolean(15, ub.getBconsulta());
            pstm.execute();
            pstm.close();
        }
    }

    //usado na tela de cadastro de usuario
    public void updateUsuario(UsuarioBeans ub) throws SQLException {
        try(Connection conexao=new ConexaoDb().getConnect()){
            String sql="update usuario set nome=?,login=?,tecnico=?,senha=?,ativo=?,vchamados=?,alttecnico=?,"
                    + "smtp=?,porta=?,ssl=?,tls=?,email=?,senhaemail=?,assinatura=?,bconsulta=? where idusuario=?";
            PreparedStatement pstm=conexao.prepareStatement(sql);
            pstm.setString(1, ub.getNome());
            pstm.setString(2, ub.getLogin());
            pstm.setBoolean(3, ub.getTecnico());
            pstm.setString(4,ub.getSenha());
            pstm.setBoolean(5, ub.getAtivo());
            pstm.setBoolean(6, ub.getVchamados());
            pstm.setBoolean(7, ub.getAlttecnico());
            pstm.setString(8,ub.getSmtp());
            pstm.setInt(9,ub.getPorta());
            pstm.setBoolean(10,ub.getSsl());
            pstm.setBoolean(11,ub.getTls());
            pstm.setString(12,ub.getEmail());
            pstm.setString(13,ub.getSenhaemail());
            pstm.setString(14,ub.getAssinatura());
            pstm.setBoolean(15, ub.getBconsulta());
            pstm.setInt(16, ub.getIdusuario());
            
            pstm.execute();
            pstm.close();
        }
    }

    //usado na tela de cadastro de usuario
    public void deleteUsuario(Integer idusuario) throws SQLException {
        try(Connection conexao=new ConexaoDb().getConnect()){
            String sql="delete from usuario where idusuario=?";
            PreparedStatement pstm=conexao.prepareStatement(sql);
            pstm.setInt(1,idusuario);
            pstm.execute();
            pstm.close();
        }
    }
}
