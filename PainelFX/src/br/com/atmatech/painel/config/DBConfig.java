/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.painel.config;

import br.com.atmatech.painel.beans.DBConfigBeans;
import br.com.atmatech.painel.beans.Tb_ConfigBeans;
import br.com.atmatech.painel.dao.Tb_ConfigDao;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        cxb.setLocaldirdb(prop.getProperty("localdirdb"));//pega o valor da teg local
        cxb.setLocalpassword(prop.getProperty("localpassword"));//pega o valor da tag senha
        cxb.setLocaluser(prop.getProperty("localuser"));//pega o valor da tag usuario         
        cxb.setTerminal(Integer.valueOf(prop.getProperty("terminal", "0")));
        cxb.setTipo(prop.getProperty("tipo"));
        cxb.setBanco(prop.getProperty("banco"));
        if (prop.getProperty("terminal")!=null) {
            try {
                Tb_ConfigBeans tbc = new Tb_ConfigDao().getTB_Config(Integer.valueOf(prop.getProperty("terminal")));
            } catch (SQLException ex) {
                new DBConfig().createArqLog("\nDBConfig:Erro ao Ler TB_CONFIG\n" + ex + "\n");
            }
        }

        return cxb;
    }
    //retorna os valores do arquivo de configuração    

    public Properties getProp() throws IOException {
        Properties prop = new Properties();
        FileInputStream file = new FileInputStream("./config/config.properties");
        prop.load(file);
        return prop;

    }

    public void createArqLog(String texto) {
        FileWriter arquivo;
        try {
            String nomecomputador=InetAddress.getLocalHost().getHostName();
            nomecomputador=nomecomputador.replace(" ", "");   
            Date data = new Date();
            SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat formatadorhora = new SimpleDateFormat("HH:mm:ss");
            String dataf=formatador.format(data);
            texto=formatadorhora.format(data)+texto;
            dataf=dataf.replace("/", "");
            File file = new File("./logs/"+nomecomputador+dataf + "log.txt");
            if (file.exists()) {
                OutputStream bytes = new FileOutputStream(file, true); // passado "true" para gravar no mesmo arquivo
                OutputStreamWriter chars = new OutputStreamWriter(bytes);
                BufferedWriter strings = new BufferedWriter(chars);
                strings.write("\r\n" + texto);
                strings.close();
            } else {
                arquivo = new FileWriter(file);
                arquivo.write(texto);
                arquivo.close();
            }            
        } catch (Exception ex) {
            
        }

    }

    //cria arquivo de configuração
    public void createConfig(DBConfigBeans cb) throws IOException {
        File file = new File("./config");
        file.mkdir();
        file = new File("./config/config.properties");
        file.createNewFile();
        FileInputStream finput = new FileInputStream("./config/config.properties");
        Properties prop = new Properties();
        //  prop.load(finput);
        prop.put("password", cb.getPassword());
        prop.put("dirdb", cb.getDirdb());
        prop.put("user", cb.getUser());
        prop.put("localpassword", cb.getLocalpassword());
        prop.put("localdirdb", cb.getLocaldirdb());
        prop.put("localuser", cb.getLocaluser());
        prop.put("terminal", String.valueOf(cb.getTerminal()));
        prop.put("tipo", cb.getTipo());
        prop.put("banco", cb.getBanco());
        prop.store(new FileOutputStream("./config/config.properties"), null);
    }

}
