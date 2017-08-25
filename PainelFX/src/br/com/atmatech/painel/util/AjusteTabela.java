/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.painel.util;

import javax.swing.JTable;

/**
 *
 * @author Marcos
 */
public class AjusteTabela {

    public void movimentaTabelaUP(JTable tabela) {
        if (tabela.getSelectedRow() > 0) {
            Integer selecao = tabela.getSelectedRow();
            Object codigo = tabela.getValueAt(selecao - 1, 0);
            tabela.setValueAt(tabela.getValueAt(selecao, 0), selecao - 1, 0);
            tabela.setValueAt(codigo, selecao, 0);

            Object produto = tabela.getValueAt(selecao - 1, 1);
            tabela.setValueAt(tabela.getValueAt(selecao, 1), selecao - 1, 1);
            tabela.setValueAt(produto, selecao, 1);

            Object unidade = tabela.getValueAt(selecao - 1, 2);
            tabela.setValueAt(tabela.getValueAt(selecao, 2), selecao - 1, 2);
            tabela.setValueAt(unidade, selecao, 2);

            Boolean oferta = (Boolean) tabela.getValueAt(selecao - 1, 3);
            tabela.setValueAt(tabela.getValueAt(selecao, 3), selecao - 1, 3);
            tabela.setValueAt(oferta, selecao, 3);

            Object valor1 = tabela.getValueAt(selecao - 1, 4);
            tabela.setValueAt(tabela.getValueAt(selecao, 4), selecao - 1, 4);
            tabela.setValueAt(valor1, selecao, 4);

            Object valor2 = tabela.getValueAt(selecao - 1, 5);
            tabela.setValueAt(tabela.getValueAt(selecao, 5), selecao - 1, 5);
            tabela.setValueAt(valor2, selecao, 5);

        }
    }

    public void movimentaTabelaDown(JTable tabela) {
        if ((tabela.getSelectedRow() > -1) && (tabela.getSelectedRow() < tabela.getRowCount() - 1)) {
            Integer selecao = tabela.getSelectedRow();
            Object codigo = tabela.getValueAt(selecao + 1, 0);
            tabela.setValueAt(tabela.getValueAt(selecao, 0), selecao + 1, 0);
            tabela.setValueAt(codigo, selecao, 0);

            Object produto = tabela.getValueAt(selecao + 1, 1);
            tabela.setValueAt(tabela.getValueAt(selecao, 1), selecao + 1, 1);
            tabela.setValueAt(produto, selecao, 1);

            Object unidade = tabela.getValueAt(selecao + 1, 2);
            tabela.setValueAt(tabela.getValueAt(selecao, 2), selecao + 1, 2);
            tabela.setValueAt(unidade, selecao, 2);

            Boolean oferta = (Boolean) tabela.getValueAt(selecao + 1, 3);
            tabela.setValueAt(tabela.getValueAt(selecao, 3), selecao + 1, 3);
            tabela.setValueAt(oferta, selecao, 3);

            Object valor1 = tabela.getValueAt(selecao + 1, 4);
            tabela.setValueAt(tabela.getValueAt(selecao, 4), selecao + 1, 4);
            tabela.setValueAt(valor1, selecao, 4);

            Object valor2 = tabela.getValueAt(selecao + 1, 5);
            tabela.setValueAt(tabela.getValueAt(selecao, 5), selecao + 1, 5);
            tabela.setValueAt(valor2, selecao, 5);

        }
    }
}
