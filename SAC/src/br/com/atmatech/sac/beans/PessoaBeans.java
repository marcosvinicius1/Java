/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.sac.beans;

import java.sql.Date;






/**
 *
 * @author MARCOS
 */
public class PessoaBeans extends DistritoBeans{
    private Integer idpessoa;
    private String razao;
    private String fantasia;
    private String cnpj;
    private String ie;
    private String endereco;
    private Integer iddistrito;
    private String numero;
    private String email;
    private Integer idmodulo;
    private String telefone1;
    private String telefone2;
    private String telefone3;
    private Integer idsituacao;
    private String obs;
    private String bairro;
    private String responsavel;
    private String modulo;
    private boolean nfe;
    private boolean ecf;
    private Date plugins;
    private boolean nfce;

    public Integer getIdpessoa() {
        return idpessoa;
    }

    public void setIdpessoa(Integer idpessoa) {
        this.idpessoa = idpessoa;
    }

    public String getRazao() {
        return razao;
    }

    public void setRazao(String razao) {
        this.razao = razao;
    }

    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getIddistrito() {
        return iddistrito;
    }

    public void setIddistrito(Integer iddistrito) {
        this.iddistrito = iddistrito;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdmodulo() {
        return idmodulo;
    }

    public void setIdmodulo(Integer idmodulo) {
        this.idmodulo = idmodulo;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getTelefone3() {
        return telefone3;
    }

    public void setTelefone3(String telefone3) {
        this.telefone3 = telefone3;
    }

    public Integer getIdsituacao() {
        return idsituacao;
    }

    public void setIdsituacao(Integer idsituacao) {
        this.idsituacao = idsituacao;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public boolean isNfe() {
        return nfe;
    }

    public void setNfe(boolean nfe) {
        this.nfe = nfe;
    }

    public boolean isEcf() {
        return ecf;
    }

    public void setEcf(boolean ecf) {
        this.ecf = ecf;
    }

    public Date getPlugins() {
        return plugins;
    }

    public void setPlugins(Date plugins) {
        this.plugins = plugins;
    }

    public boolean isNfce() {
        return nfce;
    }

    public void setNfce(boolean nfce) {
        this.nfce = nfce;
    }     
}
