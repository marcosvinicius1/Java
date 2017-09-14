/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.sac.controller;

import br.com.atmatech.sac.beans.AtendimentoBeans;
import br.com.atmatech.sac.beans.FinanceiroBeans;
import br.com.atmatech.sac.dao.AtendimentoDao;
import br.com.atmatech.sac.dao.FinanceiroDao;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author marcos
 */
public class Avisos {

    public int getStatusAtendimento(String tipo,String status, Integer idtecnico, Boolean supervisor) {
        Timestamp dtini = new Timestamp(new Date().getTime());
        Date dtin = new Date();
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_YEAR, -360);
        List<AtendimentoBeans> lab = null;
        try {
            lab = new AtendimentoDao().getAtendimento(tipo,status, idtecnico, supervisor, c.getTime(), new Timestamp(new Date().getTime()), "dtabertura");
        } catch (SQLException ex) {
            //Logger.getLogger(Avisos.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (lab != null) {
            return lab.size();
        } else {
            return 0;
        }
    }

    public int getStatusFinanceiro(String tipo) throws SQLException {
        if (tipo.equals("VencidosMes")) {
            List<FinanceiroBeans> lfb = new FinanceiroDao().getFinanceiroVencidosMes();
            if (lfb != null) {
                return lfb.size();
            } else {
                return 0;
            }
        } else if (tipo.equals("Vencidos")) {
            List<FinanceiroBeans> lfb = new FinanceiroDao().getFinanceiroVencidos();
            if (lfb != null) {
                return lfb.size();
            } else {
                return 0;
            }
        } else if (tipo.equals("AbertoMes")) {
            List<FinanceiroBeans> lfb = new FinanceiroDao().getFinanceiroAbertoMes();
            if (lfb != null) {
                return lfb.size();
            } else {
                return 0;
            }
        }
        return 0;
    }

}
