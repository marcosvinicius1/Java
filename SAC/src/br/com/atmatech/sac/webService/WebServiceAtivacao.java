/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.sac.webService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
public class WebServiceAtivacao {

    private final DefaultHttpClient client = new DefaultHttpClient();

    public String login(String url, String user,String password, String cnpj,String versao,String dias) throws IOException {
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

        HttpResponse response = client.execute(post);
        
        EntityUtils.consume(response.getEntity());
        HttpPost get = new HttpPost("http://atma.serveftp.com/atma/chave.php");
        nameValuePairs.add(new BasicNameValuePair("cnpj", cnpj));
        nameValuePairs.add(new BasicNameValuePair("chave", dias));
        nameValuePairs.add(new BasicNameValuePair("versao", versao));
        get.setEntity(new UrlEncodedFormEntity(nameValuePairs, Consts.UTF_8));
        response = client.execute(get);

        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line;
        
        while ((line = rd.readLine()) != null) {
            chave=chave+line;
        }

        return chave.replace("<script type='text/javascript'>history.go(-1); alert(", "")
                .replace("'); window.close();</script>", "");
    }

}
