/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.sac.webService;

import br.com.atmatech.sac.beans.EmpresaBeans;
import br.com.atmatech.sac.beans.PessoaBeans;
import java.io.BufferedReader;
import java.io.FileReader;
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
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author MARCOS
 */
public class WebServiceCadastro {

    private final DefaultHttpClient client = new DefaultHttpClient();

    

    
public PessoaBeans postWebService(String cnpj) throws IOException {
        PessoaBeans pb = new PessoaBeans();
        HttpPost post = new HttpPost("http://appasp.sefaz.go.gov.br/Sintegra/Consulta/consultar.asp");
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add(new BasicNameValuePair("rTipoDoc", "2"));
        nameValuePairs.add(new BasicNameValuePair("tDoc", cnpj));
        nameValuePairs.add(new BasicNameValuePair("tCCE", ""));
        nameValuePairs.add(new BasicNameValuePair("tCNPJ", cnpj));
        nameValuePairs.add(new BasicNameValuePair("tCPF", ""));
        nameValuePairs.add(new BasicNameValuePair("btCGC", "Consultar"));
        nameValuePairs.add(new BasicNameValuePair("zion.SystemAction", "consultarSintegra()"));
        nameValuePairs.add(new BasicNameValuePair("zion.OnSubmited", ""));
        nameValuePairs.add(new BasicNameValuePair("zion.FormElementPosted", "zionFormID_1"));
        nameValuePairs.add(new BasicNameValuePair("zionPostMethod", ""));
        nameValuePairs.add(new BasicNameValuePair("zionRichValidator", "true"));
        post.setEntity(new UrlEncodedFormEntity(nameValuePairs, Consts.UTF_8));
        HttpResponse response;

        response = client.execute(post);

        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String inputLine;
        // Grava pagina no arquivo
       // BufferedWriter out = new BufferedWriter(new FileWriter("./pagina.txt"));
//        while ((inputLine = rd.readLine()) != null) {
//            out.write(inputLine);
//            out.newLine();
//        }
                // Grava pagina no arquivo
        FileWriter out = new FileWriter("./pagina.txt");
        PrintWriter gravarArq = new PrintWriter(out);
        while ((inputLine = rd.readLine()) != null) {
            gravarArq.print(inputLine+"\n");           
        }
        out.close();
        
        String insc = searchTableWeb("Estadual - CCE :", new BufferedReader(new FileReader("./pagina.txt")));
        if (insc != null) {
            pb.setIe(insc.replaceAll("[.-]", ""));
        }
        pb.setRazao(searchTableWeb("Nome Empresarial:", new BufferedReader(new FileReader("./pagina.txt"))));
        pb.setEndereco(searchTableWeb("Logradouro:", new BufferedReader(new FileReader("./pagina.txt"))));
        pb.setNumero(searchTableWeb("mero:", new BufferedReader(new FileReader("./pagina.txt"))));
        pb.setBairro(searchTableWeb("Bairro:", new BufferedReader(new FileReader("./pagina.txt"))));
        pb.setDistrito(searchTableWeb("pio:", new BufferedReader(new FileReader("./pagina.txt"))));
        String tel = searchTableWeb("Telefone:", new BufferedReader(new FileReader("./pagina.txt")));
        if (tel != null) {
            pb.setTelefone1(tel.replaceAll("[()]", "").replaceAll(" ", ""));
        }
        return pb;
    }
public EmpresaBeans postWebServiceEmp(String cnpj) throws IOException {
        EmpresaBeans pb = new EmpresaBeans();
        HttpPost post = new HttpPost("http://appasp.sefaz.go.gov.br/Sintegra/Consulta/consultar.asp");
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add(new BasicNameValuePair("rTipoDoc", "2"));
        nameValuePairs.add(new BasicNameValuePair("tDoc", cnpj));
        nameValuePairs.add(new BasicNameValuePair("tCCE", ""));
        nameValuePairs.add(new BasicNameValuePair("tCNPJ", cnpj));
        nameValuePairs.add(new BasicNameValuePair("tCPF", ""));
        nameValuePairs.add(new BasicNameValuePair("btCGC", "Consultar"));
        nameValuePairs.add(new BasicNameValuePair("zion.SystemAction", "consultarSintegra()"));
        nameValuePairs.add(new BasicNameValuePair("zion.OnSubmited", ""));
        nameValuePairs.add(new BasicNameValuePair("zion.FormElementPosted", "zionFormID_1"));
        nameValuePairs.add(new BasicNameValuePair("zionPostMethod", ""));
        nameValuePairs.add(new BasicNameValuePair("zionRichValidator", "true"));
        post.setEntity(new UrlEncodedFormEntity(nameValuePairs, Consts.UTF_8));
        HttpResponse response;

        response = client.execute(post);

        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String inputLine;
        // Grava pagina no arquivo
       // BufferedWriter out = new BufferedWriter(new FileWriter("./pagina.txt"));
//        while ((inputLine = rd.readLine()) != null) {
//            out.write(inputLine);
//            out.newLine();
//        }
                // Grava pagina no arquivo
        FileWriter out = new FileWriter("./pagina.txt");
        PrintWriter gravarArq = new PrintWriter(out);
        while ((inputLine = rd.readLine()) != null) {
            gravarArq.print(inputLine+"\n");           
        }
        out.close();
        
        String insc = searchTableWeb("Estadual - CCE :", new BufferedReader(new FileReader("./pagina.txt")));
        if (insc != null) {
            pb.setIe(insc.replaceAll("[.-]", ""));
        }
        pb.setRazao(searchTableWeb("Nome Empresarial:", new BufferedReader(new FileReader("./pagina.txt"))));
        pb.setEndereco(searchTableWeb("Logradouro:", new BufferedReader(new FileReader("./pagina.txt"))));
        pb.setNumero(searchTableWeb("mero:", new BufferedReader(new FileReader("./pagina.txt"))));
        pb.setBairro(searchTableWeb("Bairro:", new BufferedReader(new FileReader("./pagina.txt"))));
        pb.setDistrito(searchTableWeb("pio:", new BufferedReader(new FileReader("./pagina.txt"))));
        String tel = searchTableWeb("Telefone:", new BufferedReader(new FileReader("./pagina.txt")));
        if (tel != null) {
            pb.setTelefone1(tel.replaceAll("[()]", "").replaceAll(" ", ""));
        }
        return pb;
    }

    public String searchTableWeb(String label_title, BufferedReader rd) throws IOException {
        String line;
        String tex = "";
        while ((line = rd.readLine()) != null) {
            if (line.contains(label_title)) {
                while (!line.contains("<span class=\"label_text\">")) {
                    line = rd.readLine();
                    if (line.contains("<span class=\"label_text\">")) {
                        String texto = line.replace("<span class=\"label_text\">", "").replaceAll("</span>", "").replaceAll("</td>", "").replaceAll("&nbsp;", "").trim();
                        if (texto.equals("")) {
                            String linet = line;
                            line = rd.readLine();
                            return line.trim();
                            // line=linet;
                        } else {
                            return texto;
                        }

                    }
                }
            }
        }
        return null;
    }
}
