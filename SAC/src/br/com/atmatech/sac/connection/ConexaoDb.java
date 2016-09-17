/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.sac.connection;

import br.com.atmatech.sac.beans.DBConfigBeans;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


/**
 *
 * @author MARCOS
 */
public class ConexaoDb {
    public Connection getConnect() throws SQLException{
         Connection conexao=null;
        DBConfigBeans cb=new DBConfigBeans();
        Statement stmt;
        try {            
            //cb= new br.com.atmatech.sac.config.Config().getConfig();
            Class.forName("org.firebirdsql.jdbc.FBDriver");
            conexao=DriverManager.getConnection(cb.getDirdb(),cb.getUser(),cb.getPassword());
            stmt=conexao.createStatement();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Registrar Driver de Conexão"+ex, null, JOptionPane.ERROR_MESSAGE);
        } 
        return conexao;        
    }
}
