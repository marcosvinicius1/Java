/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.sac.beans;

/**
 *
 * @author Marcos
 */
public class LembreteBeans extends UsuarioBeans{
    private Integer idlembrete;
    private String mensagem;
    private Integer idusuario;
    private Boolean status;
    private String titulo;
    private Integer idusuarioremt;

    public Integer getIdlembrete() {
        return idlembrete;
    }

    public void setIdlembrete(Integer idlembrete) {
        this.idlembrete = idlembrete;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getIdusuarioremt() {
        return idusuarioremt;
    }

    public void setIdusuarioremt(Integer idusuarioremt) {
        this.idusuarioremt = idusuarioremt;
    }            
}
