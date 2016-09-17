/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.sac.dao;

import br.com.atmatech.sac.beans.ReportBeans;
import br.com.atmatech.sac.connection.ConexaoDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author marcos
 */
public class ReportDao {
    
    public List<ReportBeans> getReport(String nomeview){
        List<ReportBeans> lrb=new ArrayList<>();
        try(Connection conexao=new ConexaoDb().getConnect()){
            String sql="select * from report where nomeview=?";
            PreparedStatement pstm=conexao.prepareStatement(sql);
            pstm.setString(1, nomeview);
            ResultSet rs=pstm.executeQuery();
            while(rs.next()){
                ReportBeans rb=new ReportBeans();
                rb.setIdreport(rs.getInt("idreport"));
                rb.setNomereport(rs.getString("nomereport"));
                rb.setNomeview(rs.getString("nomeview"));
                lrb.add(rb);
            }
            return lrb;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Relatório\n"+ex,"Relatório",JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public void setReport(List<ReportBeans> reportbeans,String nomeview,String nomereport) throws SQLException{
        try(Connection conexao=new ConexaoDb().getConnect()){
            String sql="insert into report (nomeview,nomereport) values(?,?) returning idreport";
            PreparedStatement pstm=conexao.prepareStatement(sql);
            pstm.setString(1, nomeview);
            pstm.setString(2, nomereport);                        
            ResultSet rs=pstm.executeQuery();
            int idreport = 0;
            while(rs.next()){
                idreport=rs.getInt("idreport");
            }
            sql="INSERT INTO CAMPOSREPORT (IDREPORT, CAMPOS, AGRUPAR, CONDICAO, VALOR) VALUES (?, ?, ?, ?, ?);";
            pstm=conexao.prepareStatement(sql);
            for (ReportBeans reportbean : reportbeans) {
                pstm.setInt(1, idreport);
                pstm.setString(2, reportbean.getCampos());
                pstm.setBoolean(3, reportbean.getAgrupar());
                pstm.setString(4, reportbean.getCondicao());
                pstm.setString(5, reportbean.getValor());
                pstm.execute();
            }                                  
        } 
    }

    public List<ReportBeans> getCamposReport(String nomeview,String nomereport){
        List<ReportBeans> lrb=new ArrayList<>();
        try(Connection conexao=new ConexaoDb().getConnect()){
            String sql="select * from report left join camposreport on(report.idreport=camposreport.idreport)"
                    + " where nomeview=? and nomereport=?";
            PreparedStatement pstm=conexao.prepareStatement(sql);
            pstm.setString(1, nomeview);
            pstm.setString(2,nomereport);
            ResultSet rs=pstm.executeQuery();
            while(rs.next()){
                ReportBeans rb=new ReportBeans();
                rb.setCampos(rs.getString("campos"));
                rb.setAgrupar(rs.getBoolean("agrupar"));
                rb.setCondicao(rs.getString("condicao"));
                rb.setValor(rs.getString("valor"));
                lrb.add(rb);
            }
            return lrb;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Campos do Relatório\n"+ex,"Relatório",JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public void delReport(String nomeview, String nomereport) throws SQLException {
        try(Connection conexao=new ConexaoDb().getConnect()){
            String sql="delete from report where nomeview=? and nomereport=?";
            PreparedStatement pstm=conexao.prepareStatement(sql);
            pstm.setString(1,nomeview);
            pstm.setString(2, nomereport);
            pstm.execute();
        }
    }
    
}
