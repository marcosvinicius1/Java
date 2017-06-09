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
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class PintarLinhasTabelaFin extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        Component result = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date data = null;
        Date datadia = null;

        try {
            String sdata = table.getValueAt(row, 4).toString();
            int ind1 = sdata.indexOf(".");
            int ind2 = sdata.indexOf(".", ind1 + 1);
            String dd = sdata.substring(0, ind1);
            String mm = sdata.substring(ind1 + 1, ind2);
            String yyyy = sdata.substring(ind2 + 1);
            data = new java.sql.Date(Integer.parseInt(yyyy) - 1900, Integer.parseInt(mm) - 1, Integer.parseInt(dd));           
            datadia = new java.sql.Date(sdf.parse(sdf.format(new Date())).getTime());            

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(result, "Erro ao Converter Data\n" + ex);
        }
        if (data.getTime() < datadia.getTime()) {
            result.setFont(new Font("arial", Font.BOLD, 12));
            result.setForeground(Color.WHITE);
            result.setBackground(Color.RED);

        } else {
            result.setFont(new Font("arial", Font.BOLD, 12));
            result.setForeground(Color.black);
            result.setBackground(Color.WHITE);
        }
        return result;
    }

}
