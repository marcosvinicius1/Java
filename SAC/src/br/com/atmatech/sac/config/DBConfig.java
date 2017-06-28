/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.sac.config;

import br.com.atmatech.sac.beans.DBConfigBeans;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
        cxb.setDirdbhost(prop.getProperty("dirdbhost"));
        cxb.setPassword(prop.getProperty("password"));//pega o valor da tag senha
        cxb.setUser(prop.getProperty("user"));//pega o valor da tag usuario
        cxb.setCompany(Integer.valueOf(prop.getProperty("company"))); //pega o valor da tag compania    
        cxb.setLogin(prop.getProperty("login"));
        cxb.setSenha(prop.getProperty("senha"));
        cxb.setPrimary1r(Integer.valueOf(prop.getProperty("primary1r")));
        cxb.setPrimary1g(Integer.valueOf(prop.getProperty("primary1g")));
        cxb.setPrimary1b(Integer.valueOf(prop.getProperty("primary1b")));
        cxb.setPrimary2r(Integer.valueOf(prop.getProperty("primary2r")));
        cxb.setPrimary2g(Integer.valueOf(prop.getProperty("primary2g")));
        cxb.setPrimary2b(Integer.valueOf(prop.getProperty("primary2b")));
        cxb.setPrimary3r(Integer.valueOf(prop.getProperty("primary3r")));
        cxb.setPrimary3g(Integer.valueOf(prop.getProperty("primary3g")));
        cxb.setPrimary3b(Integer.valueOf(prop.getProperty("primary3b")));
        cxb.setSecondary1r(Integer.valueOf(prop.getProperty("secondary1r")));
        cxb.setSecondary1g(Integer.valueOf(prop.getProperty("secondary1g")));
        cxb.setSecondary1b(Integer.valueOf(prop.getProperty("secondary1b")));
        cxb.setSecondary2r(Integer.valueOf(prop.getProperty("secondary2r")));
        cxb.setSecondary2g(Integer.valueOf(prop.getProperty("secondary2g")));
        cxb.setSecondary2b(Integer.valueOf(prop.getProperty("secondary2b")));
        cxb.setSecondary3r(Integer.valueOf(prop.getProperty("secondary3r")));
        cxb.setSecondary3g(Integer.valueOf(prop.getProperty("secondary3g")));
        cxb.setSecondary3b(Integer.valueOf(prop.getProperty("secondary3b")));
        cxb.setWhiter(Integer.valueOf(prop.getProperty("whiter")));
        cxb.setWhiteg(Integer.valueOf(prop.getProperty("whiteg")));
        cxb.setWhiteb(Integer.valueOf(prop.getProperty("whiteb")));
        cxb.setBlackr(Integer.valueOf(prop.getProperty("blackr")));
        cxb.setBlackg(Integer.valueOf(prop.getProperty("blackg")));
        cxb.setBlackb(Integer.valueOf(prop.getProperty("blackb")));
        cxb.setMenuopacity(Integer.valueOf(prop.getProperty("menuopacity")));
        cxb.setFrameopacity(Integer.valueOf(prop.getProperty("frameopacity")));

        return cxb;
    }
    //retorna os valores do arquivo de configuração    

    public Properties getProp() throws IOException {
        Properties prop = new Properties();
        FileInputStream file = new FileInputStream("./config/config.properties");
        prop.load(file);
        return prop;

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
        prop.put("dirdbhost", cb.getDirdbhost());
        prop.put("user", cb.getUser());
        prop.put("company", String.valueOf(cb.getCompany()));
        prop.put("login", cb.getLogin());
        prop.put("senha", cb.getSenha());
        prop.put("primary1r", String.valueOf(cb.getPrimary1r()));
        prop.put("primary1g", String.valueOf(cb.getPrimary1g()));
        prop.put("primary1b", String.valueOf(cb.getPrimary1b()));
        prop.put("primary2r", String.valueOf(cb.getPrimary2r()));
        prop.put("primary2g", String.valueOf(cb.getPrimary2g()));
        prop.put("primary2b", String.valueOf(cb.getPrimary2b()));
        prop.put("primary3r", String.valueOf(cb.getPrimary3r()));
        prop.put("primary3g", String.valueOf(cb.getPrimary3g()));
        prop.put("primary3b", String.valueOf(cb.getPrimary3b()));
        prop.put("secondary1r", String.valueOf(cb.getSecondary1r()));
        prop.put("secondary1g", String.valueOf(cb.getSecondary1g()));
        prop.put("secondary1b", String.valueOf(cb.getSecondary1b()));
        prop.put("secondary2r", String.valueOf(cb.getSecondary2r()));
        prop.put("secondary2g", String.valueOf(cb.getSecondary2g()));
        prop.put("secondary2b", String.valueOf(cb.getSecondary2b()));
        prop.put("secondary3r", String.valueOf(cb.getSecondary3r()));
        prop.put("secondary3g", String.valueOf(cb.getSecondary3g()));
        prop.put("secondary3b", String.valueOf(cb.getSecondary3b()));
        prop.put("whiter", String.valueOf(cb.getWhiter()));
        prop.put("whiteg", String.valueOf(cb.getWhiteg()));
        prop.put("whiteb", String.valueOf(cb.getWhiteb()));
        prop.put("blackr", String.valueOf(cb.getBlackr()));
        prop.put("blackg", String.valueOf(cb.getBlackg()));
        prop.put("blackb", String.valueOf(cb.getBlackb()));
        prop.put("menuopacity", String.valueOf(cb.getMenuopacity()));
        prop.put("frameopacity", String.valueOf(cb.getFrameopacity()));
        prop.store(new FileOutputStream("./config/config.properties"), null);
    }

    public void createArq(String texto) throws IOException {
        FileWriter arquivo;
        arquivo = new FileWriter(new File("./log.txt"));
        arquivo.write(texto);
        arquivo.close();
    }
}
