/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.sac.controller;

import br.com.atmatech.sac.beans.PessoaBeans;
import java.net.MalformedURLException;
import java.util.List;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

/**
 *
 * @author marcos
 */
public class Email {

    public void emailAtendimento(String smtp, String user, String password, Integer porta, Boolean ssl, Boolean tls,
            String emailto, String emailfrom, 
            String solicitante,String nchamado,String razao,String data,
            String solicitacao,String realizacao, String tecnico,String imagem) throws EmailException, MalformedURLException {
        
        HtmlEmail email = new HtmlEmail();
        email.setHostName(smtp); // o servidor SMTP para envio do e-mail
        email.addTo(emailto); //destinatário
        email.setFrom(emailfrom); // remetente        
        email.setSubject("Aviso de Atendimento - Suporte");
        // configura a mensagem para o formato HTML        
        email.setHtmlMsg("<html><meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\">Prezado(a)Senhor(a).<br>"
                + "<b>"+solicitante+"</b><p>"
                + "Informamos que o protocolo número&#013<b> "+nchamado+"</b> foi finalizado por nossa Central de Suporte.<p>"
                + "Cliente<br>"
                + ""+razao+"<p>"
                + "Data<br>"
                + ""+data+"<p>"
                + "Descrição do Problema<br>"
                + ""+solicitacao+"<p>"
                + "Solução<br>"
                + ""+realizacao+"<p>"
                + "Atendente<br>"
                + ""+tecnico+"<p>"
                + "<b>Atenciosamente</b> Suporte Atmatech<p><p>"+imagem+" </html>");
        email.setAuthentication(user, password);
        email.setSmtpPort(porta);
        email.setSSL(ssl);
        email.setTLS(tls);
        email.send();
    }
    
    public void emaiMassa(String smtp, String user, String password, Integer porta, Boolean ssl, Boolean tls,
            List<PessoaBeans> emailto, String emailfrom, 
            String conteudo,String assunto) throws EmailException, MalformedURLException {
        HtmlEmail email = new HtmlEmail();
        email.setHostName(smtp); // o servidor SMTP para envio do e-mail
        Integer indice2=0;
        Integer j=0;
        for(int i=0;(i<emailto.size()) && (i<45);i++){               
           email.addTo(emailto.get(i).getEmail());//destinatario            
           indice2=i;           
        }        
        while(j<=indice2){           
            emailto.remove(0);
            j++;
        }
        conteudo=conteudo.replaceAll("\n", "<p>");
        email.setFrom(emailfrom); // remetente        
        //email.addCc(emailfrom);
        email.setSubject(assunto);
        // configura a mensagem para o formato HTML        
        email.setHtmlMsg("<html><meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\">"+conteudo+"</html>");
        email.setAuthentication(user, password);
        email.setSmtpPort(porta);
        email.setSSL(ssl);
        email.setTLS(tls);        
        email.send();               
        if(emailto!=null){
           if(emailto.size()>1){          
          emaiMassa(smtp, user, password, porta, ssl, tls, emailto, emailfrom, conteudo, assunto);            
        }  
        }
               
    }
    public void emai(String smtp, String user, String password, Integer porta, Boolean ssl, Boolean tls,
           String emailto, String emailfrom, 
            String conteudo,String assunto) throws EmailException, MalformedURLException {
        HtmlEmail email = new HtmlEmail();
        email.setHostName(smtp); // o servidor SMTP para envio do e-mail                  
        email.addTo(emailto);//destinatario            
        conteudo=conteudo.replaceAll("\n", "<p>");
        email.setFrom(emailfrom); // remetente        
        //email.addCc(emailfrom);
        email.setSubject(assunto);
        // configura a mensagem para o formato HTML        
        email.setHtmlMsg("<html><meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\">"+conteudo+"</html>");
        email.setAuthentication(user, password);
        email.setSmtpPort(porta);
        email.setSSL(ssl);
        email.setTLS(tls);        
        email.send();                                                                     
    }

}
