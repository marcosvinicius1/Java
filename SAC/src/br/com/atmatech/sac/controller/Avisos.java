/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.sac.controller;

import br.com.atmatech.sac.beans.AtendimentoBeans;
import br.com.atmatech.sac.dao.AtendimentoDao;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author marcos
 */
public class Avisos {
   
    public int getStatusAtendimento(String status,Integer idtecnico,Boolean supervisor){
        Timestamp dtini=new Timestamp(new Date().getTime());
            Date dtin=new Date();
            Calendar c= Calendar.getInstance();
            c.add(Calendar.DAY_OF_YEAR, -360);
        List<AtendimentoBeans> lab = new AtendimentoDao().getAtendimento(status,idtecnico,supervisor,c.getTime(),new Timestamp(new Date().getTime()),"dtabertura");        
        if(lab!=null){
            return lab.size();        
        }else{
           return 0; 
        }        
    }
    
}
