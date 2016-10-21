/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.sac.beans;

import java.sql.Timestamp;

/**
 *
 * @author marcos
 */
public class AtendimentoBeans extends PessoaBeans{
    private Integer IDATENDIMENTO;
    private Integer IDPESSOA;
    private Integer IDTECNICO;
    private Integer IDABERTURA;
    private Timestamp DTABERTURA;
    private Timestamp DTINICIAL;
    private Timestamp DTFINAL;
    private String STATUS;
    private Boolean ATIVO;
    private String SOLICITANTE;
    private String TIPO;
    private String SOLICITACAO;
    private String REALIZADO;
    private String PENDENTE;
    private Integer IDTECNICOANTERIOR; 
    private String tecniconome;
    private String aberturanome;
    private String tecanteriornome; 
    private Integer idveiculo;
    private double kminicial;
    private double kmfinal;
    private String placa;
    private String anotacao;

    public Integer getIDATENDIMENTO() {
        return IDATENDIMENTO;
    }

    public void setIDATENDIMENTO(Integer IDATENDIMENTO) {
        this.IDATENDIMENTO = IDATENDIMENTO;
    }

    public Integer getIDPESSOA() {
        return IDPESSOA;
    }

    public void setIDPESSOA(Integer IDPESSOA) {
        this.IDPESSOA = IDPESSOA;
    }

    public Integer getIDTECNICO() {
        return IDTECNICO;
    }

    public void setIDTECNICO(Integer IDTECNICO) {
        this.IDTECNICO = IDTECNICO;
    }

    public Integer getIDABERTURA() {
        return IDABERTURA;
    }

    public void setIDABERTURA(Integer IDABERTURA) {
        this.IDABERTURA = IDABERTURA;
    }

    public Timestamp getDTABERTURA() {
        return DTABERTURA;
    }

    public void setDTABERTURA(Timestamp DTABERTURA) {
        this.DTABERTURA = DTABERTURA;
    }

    public Timestamp getDTINICIAL() {
        return DTINICIAL;
    }

    public void setDTINICIAL(Timestamp DTINICIAL) {
        this.DTINICIAL = DTINICIAL;
    }

    public Timestamp getDTFINAL() {
        return DTFINAL;
    }

    public void setDTFINAL(Timestamp DTFINAL) {
        this.DTFINAL = DTFINAL;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public Boolean getATIVO() {
        return ATIVO;
    }

    public void setATIVO(Boolean ATIVO) {
        this.ATIVO = ATIVO;
    }

    public String getSOLICITANTE() {
        return SOLICITANTE;
    }

    public void setSOLICITANTE(String SOLICITANTE) {
        this.SOLICITANTE = SOLICITANTE;
    }

    public String getTIPO() {
        return TIPO;
    }

    public void setTIPO(String TIPO) {
        this.TIPO = TIPO;
    }

    public String getSOLICITACAO() {
        return SOLICITACAO;
    }

    public void setSOLICITACAO(String SOLICITACAO) {
        this.SOLICITACAO = SOLICITACAO;
    }

    public String getREALIZADO() {
        return REALIZADO;
    }

    public void setREALIZADO(String REALIZADO) {
        this.REALIZADO = REALIZADO;
    }

    public String getPENDENTE() {
        return PENDENTE;
    }

    public void setPENDENTE(String PENDENTE) {
        this.PENDENTE = PENDENTE;
    }

    public Integer getIDTECNICOANTERIOR() {
        return IDTECNICOANTERIOR;
    }

    public void setIDTECNICOANTERIOR(Integer IDTECNICOANTERIOR) {
        this.IDTECNICOANTERIOR = IDTECNICOANTERIOR;
    }

    public String getTecniconome() {
        return tecniconome;
    }

    public void setTecniconome(String tecniconome) {
        this.tecniconome = tecniconome;
    }

    public String getAberturanome() {
        return aberturanome;
    }

    public void setAberturanome(String aberturanome) {
        this.aberturanome = aberturanome;
    }

    public String getTecanteriornome() {
        return tecanteriornome;
    }

    public void setTecanteriornome(String tecanteriornome) {
        this.tecanteriornome = tecanteriornome;
    }

    public Integer getIdveiculo() {
        return idveiculo;
    }

    public void setIdveiculo(Integer idveiculo) {
        this.idveiculo = idveiculo;
    }

    public double getKminicial() {
        return kminicial;
    }

    public void setKminicial(double kminicial) {
        this.kminicial = kminicial;
    }

    public double getKmfinal() {
        return kmfinal;
    }

    public void setKmfinal(double kmfinal) {
        this.kmfinal = kmfinal;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getAnotacao() {
        return anotacao;
    }

    public void setAnotacao(String anotacao) {
        this.anotacao = anotacao;
    }
    
    
    
}
