/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import bins.ConfigxmlBins;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author MARCOS
 */
public class configxml {//le arquivo xml de configuração

    public void conexaoBanco() {// le as teg de configuracao do arquivo XML do banco
        File f = new File("./Configuracao/config.xml");//busca o local do arquivo
        SAXBuilder builder = new SAXBuilder();
        try {
            Document doc = builder.build(f);
            Element root = (Element) doc.getRootElement();
            List pessoas = root.getChildren();
            Iterator i = pessoas.iterator();
            while (i.hasNext()) {//percorre o xml em quanto tiver informaçao
                Element banco = (Element) i.next();
                ConfigxmlBins cxb = new ConfigxmlBins();
                cxb.setLocal(banco.getAttributeValue("local"));//pega o valor da teg local
                cxb.setSenha(banco.getChildText("senha"));//pega o valor da tag senha
                cxb.setUsuario(banco.getChildText("usuario"));//pega o valor da tag usuario
            }
        } catch (JDOMException | IOException ex) {
            JOptionPane.showMessageDialog(null,"Erro no Arquivo\n"+ex);
        }
    }
}
