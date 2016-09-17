/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.sac.controller;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author MarcosVinicius
 */
public class LimitaCaracterUpper extends PlainDocument {

    private int iMaxLength;
    private boolean str;

    public LimitaCaracterUpper(int maxlen,boolean str) {
        super();
        iMaxLength = maxlen;
        this.str=str;
    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr)
            throws BadLocationException {

        if (iMaxLength <= 0) // aceitara qualquer no. de caracteres  
        {
            super.insertString(offset, str.toUpperCase(), attr);
            return;
        }

        int ilen = (getLength() + str.length());
        boolean ver=true;
        if ((ilen <= iMaxLength) && !(this.str)) // se o comprimento final for menor aceita string...  
        {
                //valida se o campo tem letra so aceita numero
            for (int i = 0; i < str.length(); i++) {
                if (Character.isDigit(str.charAt(i)) == false) {
                    ver=false;                                       
                }  
            } 
            if(ver){
               super.insertString(offset, str, attr);   // ...aceita str 
            }            
        }
        if ((ilen <= iMaxLength) && (this.str)) // se o comprimento final for menor aceita string...  
        {
                //aceita numero e letra
            super.insertString(offset, str.toUpperCase(), attr);   // ...aceita str 
        }

    }

}
