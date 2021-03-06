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
import java.util.List;
import org.apache.http.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author MARCOS
 */
public class WebServiceAtivacao {

    private final DefaultHttpClient client = new DefaultHttpClient();

    public Boolean login(String url, String user, String password, String cnpj) throws IOException {
        Boolean chave = false;
        HttpPost post = new HttpPost(url);
        boolean result = false;
        /* Configura os parâmetros do POST */
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add(new BasicNameValuePair("login", user));
        nameValuePairs.add(new BasicNameValuePair("senha", password));
        post.setEntity(new UrlEncodedFormEntity(nameValuePairs, Consts.UTF_8));

        HttpResponse response = client.execute(post);

        EntityUtils.consume(response.getEntity());
        HttpGet get = new HttpGet("http://atma.serveftp.com/atma/view/nav/header_chave.php?cnpj=" + cnpj);
        response = client.execute(get);

        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line;
        FileWriter out = new FileWriter("./ativacao.html");
        PrintWriter gravarArq = new PrintWriter(out);
        while ((line = rd.readLine()) != null) {
            gravarArq.print(line + "\n");
            chave=true;
        }
        out.close();
        return chave;
    }

}
