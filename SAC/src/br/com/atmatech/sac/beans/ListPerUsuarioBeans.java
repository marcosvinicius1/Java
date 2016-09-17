/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.sac.beans;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marcos
 */
public class ListPerUsuarioBeans extends PerusuarioBeans{

    static List<ListPerUsuarioBeans> lpub=new ArrayList<>();
    
    public List<ListPerUsuarioBeans> getLpub(){
        return lpub;
    }
    public void setLupb(List<ListPerUsuarioBeans> lpub){
        this.lpub=lpub;
    }
}
