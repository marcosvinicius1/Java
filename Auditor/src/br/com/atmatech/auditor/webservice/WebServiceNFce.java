/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.auditor.webservice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 *
 * @author MARCOS
 */
public class WebServiceNFce {

    private final DefaultHttpClient client = new DefaultHttpClient();

    public String Searche(String chave) throws Exception {
        String line2;        
         HttpGet get = new HttpGet("http://nfe.sefaz.go.gov.br/nfeweb/jsp/CConsultaCompletaNFEJSF.jsf?parametroChaveAcesso=" + chave);
//         List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
//         nameValuePairs.add(new BasicNameValuePair("rTipoDoc", "2"));
         
      //  HttpGet get = new HttpGet("http://homolog.sefaz.go.gov.br/nfeweb/jsp/CConsultaCompletaNFEJSF.jsf?parametroChaveAcesso=" + chave);
        HttpResponse response = client.execute(get);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line;
        File file = new File("./nfce" + new Date().getDay() + new Date().getMonth() + new Date().getYear());
        file.mkdir();
        FileWriter out = new FileWriter("./" + file + "/" + chave + ".xml");
        PrintWriter gravarArq = new PrintWriter(out);      
        line2 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"; 
        while ((line = rd.readLine()) != null) {
            line = line.replace("&gt;", ">").replaceAll("&lt;", "<").replace("&quot;", "\"").replace("&amp;", "&").replace("&Atilde;","Ã");
            if (line.contains("<nfeProc xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"3.10\">")) {
                int index = line.indexOf("</nfeProc>");
                line2 = line2 + line.substring(0, index + 10);
                gravarArq.print(line2 + "\n");                
            }
        }
        out.close();
        return line2;
    }

    public Map<String, String> SearcheStatus(String chave) throws Exception {
        String line2;
        Map<String,String> status=new HashMap<String, String>();
        HttpGet get = new HttpGet("http://nfe.sefaz.go.gov.br/nfeweb/jsp/CConsultaCompletaNFEJSF.jsf?parametroChaveAcesso=" + chave);
       //HttpGet get = new HttpGet("http://homolog.sefaz.go.gov.br/nfeweb/jsp/CConsultaCompletaNFEJSF.jsf?parametroChaveAcesso=" + chave);
        HttpResponse response = client.execute(get);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line;
        //String status = "ERRO";
        line2 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
        while ((line = rd.readLine()) != null) {
            line = line.replace("&gt;", ">").replaceAll("&lt;", "<").replace("&quot;", "\"").replace("&amp;", "&");
            if (line.contains("<nfeProc xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"3.10\">")) {
                int index = line.indexOf("</nfeProc>");
                line2 = line2 + line.substring(0, index + 10);                
            }
        }
        if (line2.contains("<xMotivo>Evento registrado e vinculado a NF-e</xMotivo>")) {
            if (line2.contains("<xEvento>Cancelamento</xEvento>")) {
                status.put("chave", "CANCELADO");
            } else {
                status.put("chave", "EVENTO NAO IDENTIFICADO");                
            }
        } else if (line2.contains("<xMotivo>Autorizado o uso da NF-e</xMotivo>")) {
            status.put("chave", "ENVIADO");            
        }else{
            status.put("chave", "NAO EXISTE");            
        }
        String valor="0";
        if(line2.indexOf("</vNF>")>0){
            valor=line2.substring(line2.indexOf("<vNF>")+5, line2.indexOf("</vNF>"));        
        }
        status.put("valor", valor);
        return status;
    }

    public void deleteTree(File inFile) {
        if (inFile.isFile()) {
            inFile.delete();
        } else {
            File files[] = inFile.listFiles();
            for (int i = 0; i < files.length; i++) {
                deleteTree(files[i]);
            }
        }
    }
}
