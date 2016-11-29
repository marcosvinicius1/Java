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
public class VeiculoBeans {
    private Integer idveiculo;
    private String modelo;
    private Integer periodo;
    private String marca;
    private double trocaini;
    private String placa;
    private double trocafin;
    private double km;
    private boolean monitor;
    private boolean ativo;
    private Integer idempresa;

    public Integer getIdveiculo() {
        return idveiculo;
    }

    public void setIdveiculo(Integer idveiculo) {
        this.idveiculo = idveiculo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getTrocaini() {
        return trocaini;
    }

    public void setTrocaini(double trocaini) {
        this.trocaini = trocaini;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public double getTrocafin() {
        return trocafin;
    }

    public void setTrocafin(double trocafin) {
        this.trocafin = trocafin;
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    public boolean isMonitor() {
        return monitor;
    }

    public void setMonitor(boolean monitor) {
        this.monitor = monitor;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Integer getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(Integer idempresa) {
        this.idempresa = idempresa;
    }
        
}
