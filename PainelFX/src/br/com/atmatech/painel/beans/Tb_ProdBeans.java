/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.painel.beans;

/**
 *
 * @author Marcos
 */
public class Tb_ProdBeans {
    private Integer idtb_prod;
    private String codigo;
    private String descricao;
    private String unid;
    private Float valor1;
    private Float valor2;
    private Boolean oferta;
    private String receita;
    

    public Integer getIdtb_prod() {
        return idtb_prod;
    }

    public void setIdtb_prod(Integer idtb_prod) {
        this.idtb_prod = idtb_prod;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUnid() {
        return unid;
    }

    public void setUnid(String unid) {
        this.unid = unid;
    }

    public Float getValor1() {
        return valor1;
    }

    public void setValor1(Float valor1) {
        this.valor1 = valor1;
    }

    public Float getValor2() {
        return valor2;
    }

    public void setValor2(Float valor2) {
        this.valor2 = valor2;
    }

    public Boolean getOferta() {
        return oferta;
    }

    public void setOferta(Boolean oferta) {
        this.oferta = oferta;
    }

    public String getReceita() {
        return receita;
    }

    public void setReceita(String receita) {
        this.receita = receita;
    }
    
    
}