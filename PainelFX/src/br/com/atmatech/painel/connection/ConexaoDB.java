/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.painel.connection;

import br.com.atmatech.painel.beans.DBConfigBeans;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Marcos
 */
public class ConexaoDB {
    public Connection getConnect() throws SQLException {
        DBConfigBeans db=new DBConfigBeans();        
        if(db.getTipobanco().equals("SqlServer")){
            return new ConexaoDBSqlServer().getConnect();
        }
        if(db.getTipobanco().equals("Access")){
            return new ConexaoDBAccess().getConnect();
        }
        if(db.getTipobanco().equals("MySql")){
            return new ConexaoDBMySql1().getConnect();
        }        
        return null;
    }
}
