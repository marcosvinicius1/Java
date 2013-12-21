/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Backup;

import bins.ConfigxmlBins;
import bins.DataBins;
import config.configxml;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author MARCOS
 */
public class Backup {
   public boolean backupSistema(){
       Runtime rotina= Runtime.getRuntime();
       File file=new File("c:/BackupSitec");
       if(!file.isDirectory()){
           new File("c:/BackupSitec").mkdir();
       }
       try {
           DataBins db=new DataBins();
           ConfigxmlBins confB=new ConfigxmlBins();
           rotina.exec("./Configuracao/mysqldump -hlocalhost -u"+confB.getUsuario()+" -p"+confB.getSenha()+" servidor "
                   + "--result-file=c:\\BackupSitec\\servidor"+db.getMes()+db.getDia()+db.getHora()+db.getMinuto()+db.getSegundo()+".sql");
           return true;
       } catch (IOException ex) {
           JOptionPane.showMessageDialog(null,"Erro no Backup"+ex);
           return false;
       }
       
   }
}
