/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.auditor.config;


import br.com.atmatech.auditor.beans.DBConfigBeans;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author MARCOS
 */
public class DBConfig {

    public DBConfigBeans getConfig() throws IOException {
        Properties prop = getProp();
        DBConfigBeans cxb = new DBConfigBeans();
        cxb.setDirdb(prop.getProperty("dirdb"));//pega o valor da teg local
        cxb.setPassword(prop.getProperty("password"));//pega o valor da tag senha
        cxb.setUser(prop.getProperty("user"));//pega o valor da tag usuario        
        return cxb;
    }
    //retorna os valores do arquivo de configuração    

    public Properties getProp() throws IOException {
        Properties prop = new Properties();
        FileInputStream file = new FileInputStream("./config/config.properties");
        prop.load(file);
        return prop;

    }

    public void createArq(String texto) throws IOException {
        FileWriter arquivo;
        arquivo = new FileWriter(new File("./log.txt"));
        arquivo.write(texto);
        arquivo.close();
    }
}
