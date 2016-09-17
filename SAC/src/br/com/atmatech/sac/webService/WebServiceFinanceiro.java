/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.sac.webService;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
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

    public String login(String url, String user,String password, String cnpj,String tipo) throws IOException {
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
        HttpPost get = new HttpPost("http://atma.serveftp.com/atma/"+tipo);
        nameValuePairs.add(new BasicNameValuePair("data_ini", ""));
        nameValuePairs.add(new BasicNameValuePair("data_fin", ""));
        nameValuePairs.add(new BasicNameValuePair("text_pesquisa", ""));
        nameValuePairs.add(new BasicNameValuePair("filtro", "cnpj"));
        nameValuePairs.add(new BasicNameValuePair("text_pesquisa_cnpj", cnpj));
        nameValuePairs.add(new BasicNameValuePair("text_pesquisa_fantasia", ""));
        nameValuePairs.add(new BasicNameValuePair("text_pesquisa_doc", ""));
        nameValuePairs.add(new BasicNameValuePair("button", ""));
        get.setEntity(new UrlEncodedFormEntity(nameValuePairs, Consts.UTF_8));
        response = client.execute(get);

        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line;
        System.out.println(Arrays.toString(response.getAllHeaders()));
        //new HyperLinkTest().br(response.toString());
        //escre a pagina no console
        
//        while ((line = rd.readLine()) != null) {
//            chave=chave+line;
//            System.out.println(line+"\n");
//        }
//        // Grava pagina no arquivo
        FileWriter out = new FileWriter("./pagina.html");
        PrintWriter gravarArq = new PrintWriter(out);
        while ((line = rd.readLine()) != null) {
            gravarArq.print(line+"\n");           
        }
        out.close();
        return chave;
    }

}
