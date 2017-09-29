/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.painel.connection;

import br.com.atmatech.painel.beans.DBConfigBeans;
import br.com.atmatech.painel.config.DBConfig;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Marcos
 */
//Esta Classe esta Benzida em Nome de Jesus
public class ConexaoDBAccess {
    public Connection getConnect(){
        DBConfigBeans cb = new DBConfigBeans();
        Connection conexao = null;
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");            
            conexao=DriverManager.getConnection("jdbc:ucanaccess://"+cb.getDirdb(), "", "");                       
        } catch (Exception ex) {
            new DBConfig().createArqLog("ConexaoDBAccess - getConnect :"+ex);
        }
        return conexao;
    }
}
