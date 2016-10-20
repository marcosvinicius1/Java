/**
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2016 Ricardo Mariaca http://www.dynamicreports.org
 *
 * This file is part of DynamicReports.
 *
 * DynamicReports is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 *
 * DynamicReports is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with DynamicReports. If not, see <http://www.gnu.org/licenses/>.
 */
package br.com.atmatech.sac.report;

import br.com.atmatech.sac.tamplatreport.ReportModel;
import static net.sf.dynamicreports.report.builder.DynamicReports.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

//import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class ReportGerencial {

    public ReportGerencial(String[] campos, List<String[]> valor, String view, String groupby) {

        if (campos.length == 1) {
            build1Column(campos, valor, view, groupby);
        }
        if (campos.length == 2) {
            build2Column(campos, valor, view, groupby);
        }
        if (campos.length == 3) {
            build3Column(campos, valor, view, groupby);
        }
        if (campos.length == 4) {
            build4Column(campos, valor, view, groupby);
        }
        if (campos.length == 5) {
            build5Column(campos, valor, view, groupby);
        }

    }

    private void build1Column(String[] column, List<String[]> values, String Title, String groupby) {

        DRDataSource dataSource = new DRDataSource(column);
        for (String[] value : values) {
            dataSource.add((Object[]) value);

        }
        try {
            if (!groupby.equals("")) {
                report()
                        .setTemplate(ReportModel.reportTemplate)
                        .columns(col.column(column[0], column[0], type.stringType()))
                        .title(ReportModel.createTitleComponent(Title))
                        .pageFooter(ReportModel.footerComponent)
                        .setDataSource(dataSource).groupBy(grp.group(col.column(groupby, groupby, type.stringType())))
                        .show(false);
            } else {
                report()
                        .setTemplate(ReportModel.reportTemplate)
                        .columns(col.column(column[0], column[0], type.stringType()))
                        .title(ReportModel.createTitleComponent(Title))
                        .pageFooter(ReportModel.footerComponent)
                        .setDataSource(dataSource)
                        .show(false);
            }

        } catch (DRException e) {            
            JOptionPane.showMessageDialog(null, "Erro ao Gerar Relatorio"+e);
        }
    }

    private void build2Column(String[] column, List<String[]> values, String Title, String groupby) {

        DRDataSource dataSource = new DRDataSource(column);
        for (String[] value : values) {
            dataSource.add((Object[]) value);

        }
        try {
            if (!groupby.equals("")) {
                report()
                        .setTemplate(ReportModel.reportTemplate)
                        .columns(col.column(column[0], column[0], type.stringType()),
                                col.column(column[1], column[1], type.stringType()))
                        .title(ReportModel.createTitleComponent(Title))
                        .pageFooter(ReportModel.footerComponent)
                        .setDataSource(dataSource).groupBy(grp.group(col.column(groupby, groupby, type.stringType())))
                        .show(false);
            } else {
                report()
                        .setTemplate(ReportModel.reportTemplate)
                        .columns(col.column(column[0], column[0], type.stringType()),
                                col.column(column[1], column[1], type.stringType()))
                        .title(ReportModel.createTitleComponent(Title))
                        .pageFooter(ReportModel.footerComponent)
                        .setDataSource(dataSource)
                        .show(false);
            }

        } catch (DRException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Gerar Relatorio"+e);
        }
    }

    private void build3Column(String[] column, List<String[]> values, String Title, String groupby) {

        DRDataSource dataSource = new DRDataSource(column);
        for (String[] value : values) {
            dataSource.add((Object[]) value);
        }
        try {
            if (!groupby.equals("")) {
                report()
                        .setTemplate(ReportModel.reportTemplate)
                        .columns(col.column(column[0], column[0], type.stringType()),
                                col.column(column[1], column[1], type.stringType()),
                                col.column(column[2], column[2], type.stringType()))
                        .title(ReportModel.createTitleComponent(Title))
                        .pageFooter(ReportModel.footerComponent)
                        .setDataSource(dataSource).groupBy(grp.group(col.column(groupby, groupby, type.stringType())))
                        .show(false);
            } else {
                report()
                        .setTemplate(ReportModel.reportTemplate)
                        .columns(col.column(column[0], column[0], type.stringType()),
                                col.column(column[1], column[1], type.stringType()),
                                col.column(column[2], column[2], type.stringType()))
                        .title(ReportModel.createTitleComponent(Title))
                        .pageFooter(ReportModel.footerComponent)
                        .setDataSource(dataSource)
                        .show(false);
            }

        } catch (DRException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Gerar Relatorio"+e);
        }
    }

    private Date toDate(int year, int month, int day) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month - 1);
        c.set(Calendar.DAY_OF_MONTH, day);
        return c.getTime();
    }

    private void build4Column(String[] column, List<String[]> values, String Title, String groupby) {

        DRDataSource dataSource = new DRDataSource(column);
        for (String[] value : values) {
            dataSource.add((Object[]) value);
        }
        try {
            if (!groupby.equals("")) {
                report()
                        .setTemplate(ReportModel.reportTemplate)
                        .columns(col.column(column[0], column[0], type.stringType()),
                                col.column(column[1], column[1], type.stringType()),
                                col.column(column[2], column[2], type.stringType()),
                                col.column(column[3], column[3], type.stringType()))                        
                        .title(ReportModel.createTitleComponent(Title))
                        .pageFooter(ReportModel.footerComponent)
                        .setDataSource(dataSource).groupBy(grp.group(col.column(groupby, groupby, type.stringType())))
                        .show(false);
            } else {
                report()
                        .setTemplate(ReportModel.reportTemplate)
                        .columns(col.column(column[0], column[0], type.stringType()),
                                col.column(column[1], column[1], type.stringType()),
                                col.column(column[2], column[2], type.stringType()),
                                col.column(column[3], column[3], type.stringType()))
                        .title(ReportModel.createTitleComponent(Title))
                        .pageFooter(ReportModel.footerComponent)
                        .setDataSource(dataSource)
                        .show(false);
            }

        } catch (DRException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Gerar Relatorio"+e);
        }
    }
    
    private void build5Column(String[] column, List<String[]> values, String Title, String groupby) {

        DRDataSource dataSource = new DRDataSource(column);
        for (String[] value : values) {
            dataSource.add((Object[]) value);
        }
        try {
            if (!groupby.equals("")) {
                report()
                        .setTemplate(ReportModel.reportTemplate)
                        .columns(col.column(column[0], column[0], type.stringType()),
                                col.column(column[1], column[1], type.stringType()),
                                col.column(column[2], column[2], type.stringType()),
                                col.column(column[3], column[3], type.stringType()),
                                col.column(column[4], column[4], type.stringType()))                        
                        .title(ReportModel.createTitleComponent(Title))
                        .pageFooter(ReportModel.footerComponent)
                        .setDataSource(dataSource).groupBy(grp.group(col.column(groupby, groupby, type.stringType())))
                        .show(false);
            } else {
                report()
                        .setTemplate(ReportModel.reportTemplate)
                        .columns(col.column(column[0], column[0], type.stringType()),
                                col.column(column[1], column[1], type.stringType()),
                                col.column(column[2], column[2], type.stringType()),
                                col.column(column[3], column[3], type.stringType()),
                                col.column(column[4], column[4], type.stringType())) 
                        .title(ReportModel.createTitleComponent(Title))
                        .pageFooter(ReportModel.footerComponent)
                        .setDataSource(dataSource)
                        .show(false);
            }

        } catch (DRException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Gerar Relatorio"+e);
        }
    }
}
