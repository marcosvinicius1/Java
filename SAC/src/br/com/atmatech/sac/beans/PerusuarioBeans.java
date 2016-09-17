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
abstract class PerusuarioBeans {
    private  Integer idperusuario;
    private  Integer idusuario;
    private  String view;
    private  String acao;
    private  String ativo;

    public Integer getIdperusuario() {
        return idperusuario;
    }

    public void setIdperusuario(Integer idperusuario) {
        this.idperusuario = idperusuario;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    
    
    
}
