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
abstract class CamposReportBeans {
    private Integer idcamposreport;
    private Integer idreport;
    private String campos;
    private Boolean agrupar;
    private String condicao;
    private String valor;

    public Integer getIdcamposreport() {
        return idcamposreport;
    }

    public void setIdcamposreport(Integer idcamposreport) {
        this.idcamposreport = idcamposreport;
    }

    public Integer getIdreport() {
        return idreport;
    }

    public void setIdreport(Integer idreport) {
        this.idreport = idreport;
    }

    public String getCampos() {
        return campos;
    }

    public void setCampos(String campos) {
        this.campos = campos;
    }

    public Boolean getAgrupar() {
        return agrupar;
    }

    public void setAgrupar(Boolean agrupar) {
        this.agrupar = agrupar;
    }

    public String getCondicao() {
        return condicao;
    }

    public void setCondicao(String condicao) {
        this.condicao = condicao;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
        
}
