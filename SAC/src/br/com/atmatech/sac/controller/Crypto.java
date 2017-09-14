/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.sac.controller;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 *
 * @author Marcos
 */
public class Crypto {

    public String codifica(String mensagem) throws Exception {
        String chave="atmatechrioverde";
        byte[] bytemensagem = mensagem.getBytes();
        byte[] bytechave = chave.getBytes();
        Key secretKey = new SecretKeySpec(bytechave, "AES");
        Cipher c = Cipher.getInstance("AES");
        c.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] cipher = c.doFinal(bytemensagem);
        String codigo = new BASE64Encoder().encode(cipher);
        return codigo;
    }

    public String decodificar(String decmensagem) throws Exception {
        String chave="atmatechrioverde";
        byte[] bytechave = chave.getBytes();
        Key secretKey = new SecretKeySpec(bytechave, "AES");
        Cipher c = Cipher.getInstance("AES");
        c.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] byteDecmensagem = new BASE64Decoder().decodeBuffer(decmensagem);
        byte[] byteDecodifica = c.doFinal(byteDecmensagem);
        String mensagem = new String(byteDecodifica);
        return mensagem;
    }
}
