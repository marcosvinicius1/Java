/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.painel.config;

import br.com.atmatech.painel.beans.DBConfigManagementBeans;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author MARCOS
 */
public class DBConfigManagement {

    public List<DBConfigManagementBeans> getConfig() throws IOException {
        Properties prop = getProp();
        List<DBConfigManagementBeans> dbmb = new ArrayList<>();
        if (prop.getProperty("qtdeterminal") != null) {
            for (int i = 1; i <= Integer.valueOf(prop.getProperty("qtdeterminal")); i++) {
                DBConfigManagementBeans cxb = new DBConfigManagementBeans();
                cxb.setDirdb(prop.getProperty("dirdb" + i));//pega o valor da teg local
                cxb.setPassword(prop.getProperty("password" + i));//pega o valor da tag senha
                cxb.setUser(prop.getProperty("user" + i));//pega o valor da tag usuario         
                cxb.setTerminal(Integer.valueOf(prop.getProperty("terminal" + i)));
                cxb.setQtdeterminal(Integer.valueOf(prop.getProperty("qtdeterminal")));
                dbmb.add(cxb);
            }
        }
        return dbmb;
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
            File file = new File("./logs/" + new Date().getYear() + new Date().getMonth() + new Date().getDay() + "log.txt");
            if (file.exists()) {
                OutputStream bytes = new FileOutputStream(file, true); // passado "true" para gravar no mesmo arquivo
                OutputStreamWriter chars = new OutputStreamWriter(bytes);
                BufferedWriter strings = new BufferedWriter(chars);
                strings.write("\r\n" + texto);
                strings.close();
            } else {
                arquivo = new FileWriter(new File("./logs/" + new Date().getYear() + new Date().getMonth() + new Date().getDay() + "log.txt"));
                arquivo.write(texto);
                arquivo.close();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Gerar Log" + ex);
        }

    }

    //cria arquivo de configuração
    public void createConfigManagementInicial() throws IOException {
        File file = new File("./config");
        file.mkdir();
        file = new File("./config/config.properties");
        file.createNewFile();
        FileInputStream finput = new FileInputStream("./config/config.properties");
        Properties prop = new Properties();
        //  prop.load(finput);
        prop.put("tipo", "Management");
        prop.store(new FileOutputStream("./config/config.properties"), null);
    }

    public void createConfigManagement(List<DBConfigManagementBeans> ldbcm) throws IOException {
        File file = new File("./config");
        file.mkdir();
        file = new File("./config/config.properties");
        file.createNewFile();
        FileInputStream finput = new FileInputStream("./config/config.properties");
        Properties prop = new Properties();
        //  prop.load(finput);
        int i = 1;
        Map<String, String> map = new HashMap<String, String>();
        // prop.put("tipo", "Management");           
        prop.put("tipo", "Management");        
        for (DBConfigManagementBeans dbcm : ldbcm) {    
            if (i > 1) {
                prop = getProp();                
            }
            prop.put("terminal" + i, dbcm.getTerminal().toString());
            prop.put("dirdb" + i, dbcm.getDirdb());
            prop.put("user" + i, dbcm.getUser());
            prop.put("password" + i, dbcm.getPassword());
            prop.put("qtdeterminal", dbcm.getQtdeterminal().toString());                        
            prop.store(new FileOutputStream("./config/config.properties"), null);
            i++;
        }
                
    }

}
