/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.sac.connection;

import br.com.atmatech.sac.beans.DBConfigBeans;
import java.awt.Color;
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
    static Color cor=Color.RED;

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
            Class.forName("org.firebirdsql.jdbc.FBDriver");
            conexao = DriverManager.getConnection(cb.getDirdb(), cb.getUser(), cb.getPassword());
            stmt = conexao.createStatement();
            cor=Color.green;
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Registrar Driver de Conexão" + ex, null, JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {          
            if (ex.getErrorCode() == 335544721) {
                cor=Color.red;
            } else {
                throw new SQLException(ex);
            }

        }
        System.err.println("retornou");
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
            cor=Color.green;
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Registrar Driver de Conexão" + ex, null, JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            if (ex.getErrorCode() == 335544721) {
                cor=Color.red;
            } else {
                throw new SQLException(ex);
            }

        }
        return conexao;
    }
    
    public Color getStatusServer(){
        return cor;
    }
}
