/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.painelteste.beans;

/**
 *
 * @author MARCOS
 */
public class DBConfigBeans {

    static private String dirdb;
    static private String password;
    static private String user;
    
   

    public String getDirdb() {
        return dirdb;
    }

    
    
    public void setDirdb(String dirdb) {
        this.dirdb = dirdb;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
}
