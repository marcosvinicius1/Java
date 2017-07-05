/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.painel.config;

import br.com.atmatech.painel.beans.DBConfigBeans;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JOptionPane;

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
        cxb.setLinhatabela(Integer.valueOf(prop.getProperty("linhatabela")));
        cxb.setTabela1(Boolean.valueOf(prop.getProperty("tabela01")));
        cxb.setTabela2(Boolean.valueOf(prop.getProperty("tabela02")));
        cxb.setTabela3(Boolean.valueOf(prop.getProperty("tabela03")));
        cxb.setTabela4(Boolean.valueOf(prop.getProperty("tabela04")));
        cxb.setSequencial(Boolean.valueOf(prop.getProperty("sequencial")));
        cxb.setLetreiro(Boolean.valueOf(prop.getProperty("letreiro")));
        cxb.setLetreirotexto(prop.getProperty("letreirotexto"));
        cxb.setLetreirotempo(Integer.valueOf(prop.getProperty("letreirotempo")));
        cxb.setTabelacheia(Boolean.valueOf(prop.getProperty("tabelacheia")));
        cxb.setTipolocalizacao(prop.getProperty("tipolocalizacao"));        
        cxb.setFundoimagem1(prop.getProperty("fundoimagem1"));
        cxb.setTamanhox(Integer.valueOf(prop.getProperty("tamanhox")));
        cxb.setTamanhoy(Integer.valueOf(prop.getProperty("tamanhoy")));
        cxb.setLetreirocorfundo(prop.getProperty("letreirocorfundo"));
        cxb.setLetreirocorfonte(prop.getProperty("letreirocorfonte"));
        
        return cxb;
    }
    //retorna os valores do arquivo de configuração    

    public Properties getProp() throws IOException {
        Properties prop = new Properties();
        FileInputStream file = new FileInputStream("./config/config.properties");
        prop.load(file);
        return prop;

    }

    public void createArq(String texto) {
        FileWriter arquivo;
        try {
            arquivo = new FileWriter(new File("./log.txt"));
            arquivo.write(texto);
            arquivo.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Gerar Log"+ex);
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
        prop.put("tabela01", String.valueOf(cb.isTabela1()));
        prop.put("tabela02", String.valueOf(cb.isTabela2()));
        prop.put("tabela03", String.valueOf(cb.isTabela3()));
        prop.put("tabela04", String.valueOf(cb.isTabela4()));
        prop.put("sequencial", String.valueOf(cb.isSequencial()));
        prop.put("linhatabela", String.valueOf(cb.getLinhatabela()));
        prop.put("letreiro", String.valueOf(cb.isLetreiro()));
        prop.put("letreirotexto", cb.getLetreirotexto());
        prop.put("letreirotempo", String.valueOf(cb.getLetreirotempo()));
        prop.put("tabelacheia", String.valueOf(cb.isTabelacheia()));
        prop.put("tipolocalizacao", cb.getTipolocalizacao());        
        prop.put("fundoimagem1", cb.getFundoimagem1());        
        prop.put("tamanhox",String.valueOf(cb.getTamanhox()));
        prop.put("tamanhoy",String.valueOf(cb.getTamanhoy()));
        prop.put("letreirocorfundo",String.valueOf(cb.getLetreirocorfundo()));
        prop.put("letreirocorfonte",String.valueOf(cb.getLetreirocorfonte()));
        prop.store(new FileOutputStream("./config/config.properties"), null);
    }

}
