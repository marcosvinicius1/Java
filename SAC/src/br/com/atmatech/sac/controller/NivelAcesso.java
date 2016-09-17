/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.sac.controller;

import br.com.atmatech.sac.beans.ListPerUsuarioBeans;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author marcos
 */
public class NivelAcesso {
      List<ListPerUsuarioBeans> lpub = new ListPerUsuarioBeans().getLpub();
   public boolean getAcesso(String view,String acao) {
        for (ListPerUsuarioBeans lpub1 : lpub) {
            if (lpub1.getView().equals(view)) {
                if((lpub1.getAcao().equals(acao)) &&(lpub1.getAtivo().equals("sim"))){
                    return true;
                }               
            }
        }
        JOptionPane.showMessageDialog(null, "Sem Permissão");
         return false;       
    } 
   public boolean getAcesso(String view,String acao,Boolean Menssage) {
        for (ListPerUsuarioBeans lpub1 : lpub) {
            if (lpub1.getView().equals(view)) {
                if((lpub1.getAcao().equals(acao)) &&(lpub1.getAtivo().equals("sim"))){
                    return true;
                }               
            }
        }
        if(Menssage){
            JOptionPane.showMessageDialog(null, "Sem Permissão");
        }        
         return false;       
    }
   
   
   
}
