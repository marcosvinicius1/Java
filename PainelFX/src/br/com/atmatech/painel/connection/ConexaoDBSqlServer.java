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
 * @author Marcos
 */
public class ConexaoDBSqlServer {
    public Connection getConnect() throws SQLException {
        Connection conexao = null;
        DBConfigBeans cb = new DBConfigBeans();
        Statement stmt;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");              
            conexao = DriverManager.getConnection("jdbc:sqlserver://"+cb.getDirdb()+":"+cb.getPortabanco()+";database="+cb.getBanco(), cb.getUser(), cb.getPassword());            
            stmt = conexao.createStatement();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Registrar Driver de Conexão SqlServer" + ex, null, JOptionPane.ERROR_MESSAGE);
        }
        return conexao;
    }
}
