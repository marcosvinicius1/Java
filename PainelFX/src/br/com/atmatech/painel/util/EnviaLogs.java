/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.painel.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

/**
 *
 * @author Marcos
 */
public class EnviaLogs {
    public void enviarBD(File file, String enderecoFTP, String login, String senha) throws IOException {
        String nomeArquivo = null;  
        FTPClient ftp = new FTPClient();                                
            ftp.connect( enderecoFTP );              
            //verifica se conectou com sucesso! 
            
            if( FTPReply.isPositiveCompletion( ftp.getReplyCode() ) ) {                  
                ftp.login( login, senha );                  
            } else {  
                //erro ao se conectar  
                ftp.disconnect();                  
            }  
            ftp.changeWorkingDirectory("/atmatech.com.br/ErroLogsPainelFX/");
            //abre um stream com o arquivo a ser enviado              
            InputStream is = new FileInputStream( file );              
            //pega apenas o nome do arquivo             
            int idx = file.getName().lastIndexOf(File.separator);              
            if( idx < 0 ) idx = 0;  
            else idx++;  
            nomeArquivo = file.getName().substring( idx, file.getName().length() );             
            //ajusta o tipo do arquivo a ser enviado  
            ftp.setFileType( FTPClient.BINARY_FILE_TYPE );              
            //faz o envio do arquivo  
            ftp.storeFile( nomeArquivo, is );            
            ftp.disconnect();  
         
    }
}
