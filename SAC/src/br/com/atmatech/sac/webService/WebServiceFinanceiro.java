/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.sac.webService;

import br.com.atmatech.sac.beans.FinanceiroBeans;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author MARCOS
 */
public class WebServiceFinanceiro {

    private final DefaultHttpClient client = new DefaultHttpClient();

    public List<FinanceiroBeans> getFinanceiro(String url, String user, String password) throws IOException {
        String chave = "";
        HttpPost post = new HttpPost(url);
        boolean result = false;
        /* Configura os parâmetros do POST */
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add(new BasicNameValuePair("login", user));
        nameValuePairs.add(new BasicNameValuePair("senha", password));
        nameValuePairs.add(new BasicNameValuePair("x", "26"));
        nameValuePairs.add(new BasicNameValuePair("y", "26"));
        post.setEntity(new UrlEncodedFormEntity(nameValuePairs, Consts.UTF_8));
        // post.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 5.1; rv:18.0) Gecko/20100101 Firefox/18.0");
        HttpResponse response = client.execute(post);
        // System.out.println("Login form get: " + response.getStatusLine());
        EntityUtils.consume(response.getEntity());
        HttpPost get = new HttpPost("http://atma.serveftp.com/atma/view/index.php?page=BAIXAR&mostrar=1");
        get.setEntity(new UrlEncodedFormEntity(nameValuePairs, Consts.UTF_8));
        response = client.execute(get);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line;
//        // Grava pagina no arquivo
        FileWriter out = new FileWriter("./logfin.txt");
        PrintWriter gravarArq = new PrintWriter(out);
        int indexant = 11;
        boolean doc = true;
        boolean cliente = true;
        boolean valor = true;
        boolean vencimento = true;
        boolean contato = true;
        boolean tel = true;
        String tdoc = "";
        String tcliente = "";
        float tvalor = 0;
        Date tvencimento = null;
        String tcontato = "";
        String ttel = "";
        List<FinanceiroBeans> lfb = new ArrayList<>();
        while ((line = rd.readLine()) != null) {
            if (line.contains("<tr><td>")) {
                //gravarArq.print(line+"\n");
                line = line.replace("<tr><td>", "\n").replace("</td></tr>", "\n");
                line = line.replace("</td><td>", ";").replace("</td><td align='center'><a class='btn default' target='_blank'", ";").replace("</i></a>", ":");
                gravarArq.print(line + "\n");
                for (int i = 0; i < line.length(); i++) {
                    if (doc && (indexant != i)) {
                        if (line.charAt(i) == ';') {
                            tdoc = line.substring(indexant+1, i);
                            indexant = i;
                            doc = false;
                        }
                    } else {
                        if ((!doc) && (cliente) && (indexant != i)) {
                            if (line.charAt(i) == ';') {
                                tcliente = line.substring(indexant + 1, i);
                                indexant = i;
                                cliente = false;
                            }
                        } else {
                            if ((!doc) && (!cliente) && (valor) && (indexant != i)) {
                                if (line.charAt(i) == ';') {
                                    tvalor = Float.valueOf(line.substring(indexant + 1, i));
                                    indexant = i;
                                    valor = false;
                                }
                            } else {
                                if ((!doc) && (!cliente) && (!valor) && (vencimento) && (indexant != i)) {
                                    if (line.charAt(i) == ';') {                                        
                                        String data = line.substring(indexant + 1, i).replace("/", ".");
                                        int ind1 = data.indexOf(".");
                                        int ind2 = data.indexOf(".", ind1 + 1);
                                        String dd = data.substring(0, ind1);
                                        String mm = data.substring(ind1 + 1, ind2);
                                        String yyyy = data.substring(ind2 + 1);                                        
                                        tvencimento=new Date(Integer.parseInt(yyyy)-1900, Integer.parseInt(mm)-1, Integer.parseInt(dd));
                                        indexant = i;
                                        vencimento = false;
                                    }
                                } else {
                                    if ((!doc) && (!cliente) && (!valor) && (!vencimento) && (contato) && (indexant != i)) {
                                        if (line.charAt(i) == ';') {
                                            tcontato = line.substring(indexant + 1, i);
                                            indexant = i;
                                            contato = false;
                                        }
                                    } else {
                                        if ((!doc) && (!cliente) && (!valor) && (!vencimento) && (!contato) && (tel) && (indexant != i)) {
                                            if (line.charAt(i) == ';') {
                                                ttel = line.substring(indexant + 1, i);
                                                indexant = i;
                                                tel = false;
                                            }
                                        } else {
                                            if ((!doc) && (!cliente) && (!valor) && (!vencimento) && (!contato) && (!tel) && (line.charAt(i) == ':')) {
                                                indexant = i + 2;
                                                FinanceiroBeans fb = new FinanceiroBeans();
                                                fb.setCliente(tcliente);
                                                fb.setContato(tcontato);
                                                fb.setDoc(tdoc);
                                                fb.setTelcel(ttel);
                                                fb.setValor(tvalor);
                                                fb.setVencimento(tvencimento);
                                                lfb.add(fb);
                                                doc = true;
                                                cliente = true;
                                                valor = true;
                                                vencimento = true;
                                                contato = true;
                                                tel = true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }
        out.close();
        return lfb;
    }    

}
