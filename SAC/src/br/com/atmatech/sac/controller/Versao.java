/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.sac.controller;

import br.com.atmatech.sac.beans.VersaoBeans;
import br.com.atmatech.sac.dao.VersaoDao;
import java.sql.SQLException;

/**
 *
 * @author marcos
 */
public class Versao {
    public Boolean verificaVersao(Integer versao,Integer edicao,Integer seguranca) throws SQLException{
        
        
            VersaoBeans vb=new VersaoBeans();
            vb= new VersaoDao().getVersao();
            if(versao.equals(vb.getVersao())){
                if(edicao.equals(vb.getEdicao())){
                    if(seguranca.equals(vb.getSeguranca())){
                        return true;
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
            }else{
                return false;
            }
              
    }
}
