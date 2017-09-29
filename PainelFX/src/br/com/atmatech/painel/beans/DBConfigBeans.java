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
    static private Integer terminal;
    static private String tipo;
    static private String banco;
    static private String locallog;
    static private Integer portabanco;
    static private String tipobanco;
    static private Integer sleep;
    
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

    public Integer getTerminal() {
        return terminal;
    }

    public void setTerminal(Integer terminal) {
        this.terminal = terminal;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getLocallog() {
        return locallog;
    }

    public void setLocallog(String locallog) {
        this.locallog = locallog;
    }

    public Integer getPortabanco() {
        return portabanco;
    }

    public void setPortabanco(Integer portabanco) {
        this.portabanco = portabanco;
    }

    public String getTipobanco() {
        return tipobanco;
    }

    public void setTipobanco(String tipobanco) {
        this.tipobanco = tipobanco;
    }

    public Integer getSleep() {
        return sleep;
    }

    public void setSleep(Integer sleep) {
        this.sleep = sleep;
    }
    
}
