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
public class DBConfigBeans {

    static private String dirdb;
    static private String password;
    static private String user;
    static private String localdirdb;
    static private String localpassword;
    static private String localuser;
    static private boolean tabela1;
    static private boolean tabela2;
    static private boolean tabela3;
    static private boolean tabela4;
    static private Integer linhatabela=1;
    static private boolean sequencial;
    static private boolean letreiro;
    
   

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

    public boolean isTabela1() {
        return tabela1;
    }

    public void setTabela1(boolean tabela1) {
        this.tabela1 = tabela1;
    }

    public boolean isTabela2() {
        return tabela2;
    }

    public void setTabela2(boolean tabela2) {
        this.tabela2 = tabela2;
    }

    public boolean isTabela3() {
        return tabela3;
    }

    public void setTabela3(boolean tabela3) {
        this.tabela3 = tabela3;
    }

    public boolean isTabela4() {
        return tabela4;
    }

    public void setTabela4(boolean tabela4) {
        this.tabela4 = tabela4;
    }

    public Integer getLinhatabela() {
        return linhatabela;
    }

    public void setLinhatabela(Integer linhatabela) {
        this.linhatabela = linhatabela;
    }

    public boolean isSequencial() {
        return sequencial;
    }

    public void setSequencial(boolean sequencial) {
        this.sequencial = sequencial;
    }

    public String getLocaldirdb() {
        return localdirdb;
    }

    public void setLocaldirdb(String localdirdb) {
        this.localdirdb = localdirdb;
    }

    public String getLocalpassword() {
        return localpassword;
    }

    public void setLocalpassword(String localpassword) {
        this.localpassword = localpassword;
    }

    public String getLocaluser() {
        return localuser;
    }

    public void setLocaluser(String localuser) {
        this.localuser = localuser;
    }

    public boolean isLetreiro() {
        return letreiro;
    }

    public void setLetreiro(boolean letreiro) {
        this.letreiro = letreiro;
    }
            
}
