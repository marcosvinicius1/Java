/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.auditor.beans;

import java.sql.Date;


/**
 *
 * @author Marcos
 */
public class NfceBeans {
    private String id_cupom;
    private String nro_dcto;
    private String chave;
    private Date dt_venda;
    private Integer id_pdv;
    private String chave_sefaz;
    private String chave_xml;
    private String status_nfc;

    public String getId_cupom() {
        return id_cupom;
    }

    public void setId_cupom(String id_cupom) {
        this.id_cupom = id_cupom;
    }

    public String getNro_dcto() {
        return nro_dcto;
    }

    public void setNro_dcto(String nro_dcto) {
        this.nro_dcto = nro_dcto;
    }

    
    
    public Date getDt_venda() {
        return dt_venda;
    }

    public void setDt_venda(Date dt_venda) {
        this.dt_venda = dt_venda;
    }

    public Integer getId_pdv() {
        return id_pdv;
    }

    public void setId_pdv(Integer id_pdv) {
        this.id_pdv = id_pdv;
    }

    public String getChave_sefaz() {
        return chave_sefaz;
    }

    public void setChave_sefaz(String chave_sefaz) {
        this.chave_sefaz = chave_sefaz;
    }            

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getChave_xml() {
        return chave_xml;
    }

    public void setChave_xml(String chave_xml) {
        this.chave_xml = chave_xml;
    }

    public String getStatus_nfc() {
        return status_nfc;
    }

    public void setStatus_nfc(String status_nfc) {
        this.status_nfc = status_nfc;
    }
    
    
}
