/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.sac.report;

import br.com.atmatech.sac.connection.ConexaoDb;
import br.com.atmatech.sac.view.ViewListaAtendimento;
import br.com.atmatech.sac.view.ViewPrincipal;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Marcos
 */
public class Report {
    //*metodo utilizado na viewprincipal
    public void getReport(String nomeReport, String parametro,ViewPrincipal frame) {
        try (Connection conexao = new ConexaoDb().getConnect()) {
            Map parametros = new HashMap();
            parametros.put("parametro", parametro);
            JasperPrint jasperPrint = JasperFillManager.fillReport("./report/" + nomeReport + ".jasper", parametros, conexao);
            frame.closeAguarde();
            JasperViewer view = new JasperViewer(jasperPrint, false);                
            view.setVisible(true);
            view.toFront();
        } catch (JRException ex) {            
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Report\n" + ex);
        } catch (SQLException ex) {            
            JOptionPane.showMessageDialog(null, "Erro ao Fazer Consulta\n" + ex);
        }
    }
    //metodo utilizado na imprenssao do chamado
    public void getReportChamado(Integer idatendimento,ViewListaAtendimento frame) {
        try (Connection conexao = new ConexaoDb().getConnect()) {
            Map parametros = new HashMap();            
            InputStream image = this.getClass().getResourceAsStream("./image/logo.png");
            parametros.put("idatendimento", idatendimento);
            parametros.put("imagem", "./image/logo.png");
            JasperPrint jasperPrint = JasperFillManager.fillReport("./report/ReportChamado.jasper", parametros, conexao);
            frame.closeAguarde();
            JasperViewer view = new JasperViewer(jasperPrint, false);            
            view.setVisible(true);
            view.toFront();

        } catch (JRException ex) {            
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Report\n" + ex);
        } catch (SQLException ex) {            
            JOptionPane.showMessageDialog(null, "Erro ao Fazer Consulta\n" + ex);
        }
    }
    
    //*metodo utilizado na viewprincipal para inicializa
    public void inicializaReport(String nomeReport, String parametro) {
        try (Connection conexao = new ConexaoDb().getConnect()) {
            Map parametros = new HashMap();
            parametros.put("parametro", parametro);
            JasperPrint jasperPrint = JasperFillManager.fillReport("./report/" + nomeReport + ".jasper", parametros, conexao);
          //  JasperViewer view = new JasperViewer(jasperPrint, false);    
        } catch (JRException ex) {            
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Report\n" + ex);
        } catch (SQLException ex) {            
            JOptionPane.showMessageDialog(null, "Erro ao Fazer Consulta\n" + ex);
        }
    }
    //*metodo utilizado na viewprincipal para inicializa
    public void inicializaReportChamado() {
        try (Connection conexao = new ConexaoDb().getConnect()) {
            Map parametros = new HashMap();            
            InputStream image = this.getClass().getResourceAsStream("./image/logo.png");
            parametros.put("idatendimento", 0);
            parametros.put("imagem", "./image/logo.png");
            JasperPrint jasperPrint = JasperFillManager.fillReport("./report/ReportChamado.jasper", parametros, conexao);

        } catch (JRException ex) {            
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Report\n" + ex);
        } catch (SQLException ex) {            
            JOptionPane.showMessageDialog(null, "Erro ao Fazer Consulta\n" + ex);
        }
    }
}
