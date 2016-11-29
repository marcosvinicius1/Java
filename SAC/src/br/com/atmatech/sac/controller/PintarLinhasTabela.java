/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.sac.controller;

/**
 *
 * @author MarcosVinicius
 */
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class PintarLinhasTabela extends DefaultTableCellRenderer {
    Boolean trocar;
    public PintarLinhasTabela(Boolean trocar){
        this.trocar=trocar;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        Component result = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if ((String.valueOf(table.getValueAt(row, 5)).equals("ABERTO")) && ((String.valueOf(table.getValueAt(row, 3)).equals("")))) {
            if(trocar){
            result.setFont(new Font("arial", Font.BOLD, 12));
            result.setForeground(Color.RED);
            result.setBackground(Color.green);
            }else{
            result.setFont(new Font("arial", Font.BOLD, 10));
            result.setForeground(Color.BLACK);
            result.setBackground(Color.GREEN);
            }
        } else if ((String.valueOf(table.getValueAt(row, 5)).equals("ABERTO")) && ((!String.valueOf(table.getValueAt(row, 3)).equals("")))) {
            result.setFont(new Font("arial", Font.BOLD, 12));
            result.setForeground(Color.BLACK);
            result.setBackground(Color.GREEN);       
        } else if (String.valueOf(table.getValueAt(row, 5)).equals("PENDENTE")) {
            result.setFont(new Font("arial", Font.BOLD, 12));
            result.setForeground(Color.white);
            result.setBackground(Color.red);
        } else if (String.valueOf(table.getValueAt(row, 5)).equals("FECHADO")) {
            result.setFont(new Font("arial", Font.BOLD, 12));
            result.setForeground(Color.black);
            result.setBackground(Color.BLUE);
        } else {
            result.setFont(new Font("arial", Font.PLAIN, 12));
            result.setForeground(Color.black);
            result.setBackground(Color.white);
        }
        return result;
    }

}
