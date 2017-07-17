/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.painel.controller;

import br.com.atmatech.painel.beans.DBConfigBeans;
import br.com.atmatech.painel.beans.Tb_ProdBeans;
import br.com.atmatech.painel.beans.Tb_Prod_PainelBeans;
import br.com.atmatech.painel.config.DBConfig;
import br.com.atmatech.painel.dao.Tb_ProdDao;
import br.com.atmatech.painel.dao.Tb_Prod_PainelDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcos
 */
public class CargaController {

    public void cargaProd() {
        List<Tb_ProdBeans> lpbs = new ArrayList<>();
        List<Tb_ProdBeans> lpbm = new ArrayList<>();
        try {
            lpbs = new Tb_ProdDao().getProdBalanca();
            lpbm = new Tb_ProdDao().getProdLocal();
            if (comparaArrayListCarga(lpbs, lpbm)) {
                if (new Tb_ProdDao().delProdLocal()) {
                    new Tb_ProdDao().setProdLocal(lpbs);
                }
            }
        } catch (SQLException ex) {
            new DBConfig().createArqLog("\nCargaController:Erro ao Atualizar Produtos No Banco Local:\n" + ex + "\n");
            //JOptionPane.showMessageDialog(null, "Erro ao Atualizar Produtos No Banco Local\n" + ex);
        }
    }
//nao esta sendo utilizado, era utilizado na atualização do tb_prod com tb_prod_local
    public void cargaProdLocal() {
        List<Tb_ProdBeans> lpb = new ArrayList<>();
        List<Tb_Prod_PainelBeans> lppb = new ArrayList<>();
        try {
            lpb = new Tb_ProdDao().getProdLocal();
            lppb = new Tb_Prod_PainelDao().getProdPainel(new DBConfigBeans().getTerminal());
            comparaArrayListCargaProdLocal(lpb, lppb);
        } catch (SQLException ex) {
            new DBConfig().createArqLog("\nCargaController:Erro ao Atualizar Produtos No Banco Local Tabela tb_prod com tb_prod_painel:\n" + ex + "\n");
            //JOptionPane.showMessageDialog(null, "Erro ao Atualizar Produtos No Banco Local\n" + ex);
        }
    }

    private boolean comparaArrayListCarga(List<Tb_ProdBeans> lpbs, List<Tb_ProdBeans> lpbm) {
        if (lpbs != null) {
            if (lpbs.size() != lpbm.size()) {
                return true;
            } else {
                for (int i = 0; i < lpbs.size(); i++) {
                    if (!lpbs.get(i).getCodigo().equals(lpbm.get(i).getCodigo())) {
                        return true;
                    }
                    if (!lpbs.get(i).getDescricao().equals(lpbm.get(i).getDescricao())) {
                        return true;
                    }
                    if (!lpbs.get(i).getUnid().equals(lpbm.get(i).getUnid())) {
                        return true;
                    }
                    if (!lpbs.get(i).getValor1().equals(lpbm.get(i).getValor1())) {
                        return true;
                    }
                    if (!lpbs.get(i).getValor2().equals(lpbm.get(i).getValor2())) {
                        return true;
                    }
                    if (!lpbs.get(i).getOferta().equals(lpbm.get(i).getOferta())) {
                        return true;
                    }
                }
                return false;
            }
        }
        return true;
    }
//nao utilizado mais, era utiizado na analise de comparativo de 2 array list de consulta da tb_prod e tb_prod_local
    private boolean comparaArrayListCargaProdLocal(List<Tb_ProdBeans> lpb, List<Tb_Prod_PainelBeans> lppb) throws SQLException {
        for (int i = 0; i < lppb.size(); i++) {
            for (Tb_ProdBeans pb : lpb) {
                if (lppb.get(i).getCodigo().equals(pb.getCodigo())) {     
                    System.err.println(lppb.get(i).getValor1()+":"+pb.getValor1());
                    if (lppb.get(i).getValor1()!=pb.getValor1()) {                        
                        new Tb_Prod_PainelDao().updateProdPainel(lppb.get(i).getCodigo(), new DBConfigBeans().getTerminal(), pb.getValor1());
                    }
                }
            }
        }
        return true;
    }
}
