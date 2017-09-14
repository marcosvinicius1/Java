/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srv;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import javax.swing.JOptionPane;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

/**
 *
 * @author Marcos
 */
public class update {

    public void getVersao(View view) {
        String server = "ftp.atmatech.com.br";
        int port = 21;
        String user = "atmatech";
        String pass = "ftpp2015";
        FTPClient ftpClient = new FTPClient();
        try {

            ftpClient.connect(server, port);
            ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            ftpClient.changeWorkingDirectory("/atmatech.com.br/atualizacaosac/");

            // APPROACH #1: using retrieveFile(String, OutputStream)
            String[] arq = ftpClient.listNames();
            for (String f : arq) {
                if (!f.equals(".")) {
                    if (!f.equals("..")) {
                        if (f.contains(".")) {
                            view.jLprogresso.setText(f);                            
                            String remoteFile1 = "/atmatech.com.br/atualizacaosac/" + f;
                            String destino = ".\\" + f;
                            File downloadFile1 = new File(destino);
                            OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1));
                            boolean success = ftpClient.retrieveFile(remoteFile1, outputStream1);
                            outputStream1.close();
                            if (!success) {
                                JOptionPane.showMessageDialog(null, "Erro Em Baixar Versão");
                                System.exit(0);
                            }
                        } else {                            
                            ftpClient.changeWorkingDirectory("/atmatech.com.br/atualizacaosac/" + f);
                            String[] arq2 = ftpClient.listNames();
                            for (String f2 : arq2) {
                                if (!f2.equals(".")) {
                                    if (!f2.equals("..")) {
                                        view.jLprogresso.setText(f2);
                                        File diretorio = new File(".\\" + f);
                                        if (!diretorio.exists()) {
                                            diretorio.mkdirs(); //mkdir() cria somente um diretório, mkdirs() cria diretórios e subdiretórios.
                                        }
                                        String remoteFile1 = "/atmatech.com.br/atualizacaosac/" + f + "/" + f2;
                                        String destino = ".\\" + f + "\\" + f2;
                                        File downloadFile1 = new File(destino);
                                        OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1));
                                        boolean success = ftpClient.retrieveFile(remoteFile1, outputStream1);
                                        outputStream1.close();
                                        if (!success) {
                                            JOptionPane.showMessageDialog(null, "Erro Em Baixar Versão");
                                            System.exit(0);
                                        }
                                    }
                                }
                            }

                        }

                    }
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro \n" + ex);
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro \n" + ex);
            }
        }
    }
}
