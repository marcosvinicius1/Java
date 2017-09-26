/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.painel.connection;


import br.com.atmatech.painel.beans.DBConfigBeans;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author MARCOS
 */
public class ConexaoDBMySql {

    public Connection getConnect() throws SQLException {
        Connection conexao = null;
        DBConfigBeans cb = new DBConfigBeans();
        Statement stmt;
        try {
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Class.forName("com.mysql.jdbc.Driver");            
            conexao = DriverManager.getConnection("jdbc:mysql://"+cb.getLocaldirdb()+":3306/PAINELFX", cb.getLocaluser(), cb.getLocalpassword());            
            stmt = conexao.createStatement();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Registrar Driver de Conexão MySql" + ex, null, JOptionPane.ERROR_MESSAGE);
        }
        return conexao;
    }
    
}
