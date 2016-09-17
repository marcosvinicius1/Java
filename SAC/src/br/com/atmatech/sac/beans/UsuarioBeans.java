/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.sac.beans;

/**
 *
 * @author MARCOS
 */
public class UsuarioBeans {
    private Integer idusuario;
    private String nome;
    private String login;
    private Boolean tecnico;
    private String senha;
    private Boolean ativo;
    private Boolean vchamados;
    private Boolean alttecnico;
    private String smtp;
    private Integer porta;
    private Boolean ssl;
    private Boolean tls;
    private String email;
    private String senhaemail;
    private String assinatura;
    private Boolean bconsulta;

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Boolean getTecnico() {
        return tecnico;
    }

    public void setTecnico(Boolean tecnico) {
        this.tecnico = tecnico;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Boolean getVchamados() {
        return vchamados;
    }

    public void setVchamados(Boolean vchamados) {
        this.vchamados = vchamados;
    }

    public Boolean getAlttecnico() {
        return alttecnico;
    }

    public void setAlttecnico(Boolean alttecnico) {
        this.alttecnico = alttecnico;
    }

    public String getSmtp() {
        return smtp;
    }

    public void setSmtp(String smtp) {
        this.smtp = smtp;
    }

    public Integer getPorta() {
        return porta;
    }

    public void setPorta(Integer porta) {
        this.porta = porta;
    }

    public Boolean getSsl() {
        return ssl;
    }

    public void setSsl(Boolean ssl) {
        this.ssl = ssl;
    }

    public Boolean getTls() {
        return tls;
    }

    public void setTls(Boolean tls) {
        this.tls = tls;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenhaemail() {
        return senhaemail;
    }

    public void setSenhaemail(String senhaemail) {
        this.senhaemail = senhaemail;
    }

    public String getAssinatura() {
        return assinatura;
    }

    public void setAssinatura(String assinatura) {
        this.assinatura = assinatura;
    }

    public Boolean getBconsulta() {
        return bconsulta;
    }

    public void setBconsulta(Boolean bconsulta) {
        this.bconsulta = bconsulta;
    }
    
    
}
