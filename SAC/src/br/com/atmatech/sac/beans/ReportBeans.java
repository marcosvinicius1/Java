/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.sac.beans;

/**
 *
 * @author marcos
 */
public class ReportBeans extends CamposReportBeans{
   private Integer idreport;
   private String nomeview;
   private String nomereport;

    public Integer getIdreport() {
        return idreport;
    }

    public void setIdreport(Integer idreport) {
        this.idreport = idreport;
    }

    public String getNomeview() {
        return nomeview;
    }

    public void setNomeview(String nomeview) {
        this.nomeview = nomeview;
    }

    public String getNomereport() {
        return nomereport;
    }

    public void setNomereport(String nomereport) {
        this.nomereport = nomereport;
    }
      
}
