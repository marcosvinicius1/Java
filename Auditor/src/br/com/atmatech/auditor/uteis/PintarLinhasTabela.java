/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.auditor.uteis;

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

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        Component result = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (String.valueOf(table.getValueAt(row, 9)).equals("PENDENTE")) {
            result.setFont(new Font("arial", Font.BOLD, 12));
            result.setForeground(Color.BLACK);
            result.setBackground(Color.RED);
        } else if (String.valueOf(table.getValueAt(row, 9)).equals("ENVIADO")) {
            result.setFont(new Font("arial", Font.BOLD, 12));
            result.setForeground(Color.BLACK);
            result.setBackground(Color.GREEN);
        } else {
            result.setForeground(Color.BLACK);
            result.setBackground(Color.ORANGE);
        }
        return result;
    }

}
