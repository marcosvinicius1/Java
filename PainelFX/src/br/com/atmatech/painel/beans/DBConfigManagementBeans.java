/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.painel.beans;

/**
 *
 * @author MARCOS
 */
public class DBConfigManagementBeans {

     private String dirdb;
     private String password;
     private String user;
     private Integer terminal;  
     private Integer qtdeterminal;
    
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
   
    public Integer getTerminal() {
        return terminal;
    }

    public void setTerminal(Integer terminal) {
        this.terminal = terminal;
    }

    public Integer getQtdeterminal() {
        return qtdeterminal;
    }

    public void setQtdeterminal(Integer qtdeterminal) {
        this.qtdeterminal = qtdeterminal;
    }
  
}
