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
    static String status="OFF-Line";

    public Connection getConnect() throws SQLException {
        DBConfigBeans dbcb = new DBConfigBeans();
        if (dbcb.getUsehost().equals("remoto")) {
            return getConnectHostHemoto();
        } else {
            return getConnectHostLocal();
        }
    }

    public Connection getConnectHostLocal() throws SQLException {
        Connection conexao = null;
        DBConfigBeans cb = new DBConfigBeans();
        Statement stmt;
        try {
            //cb= new br.com.atmatech.sac.config.Config().getConfig();
           // Class.forName("org.firebirdsql.jdbc.FBDriver");
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection(cb.getDirdb(), cb.getUser(), cb.getPassword());
            stmt = conexao.createStatement();
            status="ON-Line";
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Registrar Driver de Conexão" + ex, null, JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {          
                throw new SQLException(ex);
        }
        return conexao;
    }

    public Connection getConnectHostHemoto() throws SQLException {
        Connection conexao = null;
        DBConfigBeans cb = new DBConfigBeans();
        Statement stmt;
        try {
            //cb= new br.com.atmatech.sac.config.Config().getConfig();
            Class.forName("org.firebirdsql.jdbc.FBDriver");
            conexao = DriverManager.getConnection(cb.getDirdbhost(), cb.getUser(), cb.getPassword());
            stmt = conexao.createStatement();
            status="ON-Line";
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Registrar Driver de Conexão" + ex, null, JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
                throw new SQLException(ex);            
        }
        return conexao;
    }
    
    public String getStatusServer(){
        return status;
    }
}
