/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.auditor.dao;

import br.com.atmatech.auditor.beans.NfceBeans;
import br.com.atmatech.auditor.connection.ConexaoDb;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Marcos
 */
public class NfceDao {

    public ArrayList<NfceBeans> getNfceXmlIncorreto(Date dtini, Date dtfin) throws SQLException, IOException {
        java.sql.Date dtinisql = new java.sql.Date(dtini.getTime());
        java.sql.Date dtfinsql = new java.sql.Date(dtfin.getTime());
        try (Connection conexao = new ConexaoDb().getConnect()) {
            String sql = "select VND_CUPOM_NFC_XML.ID_CUPOM,VND_CUPOM.NRO_DCTO,VND_CUPOM_NFC_XML.CHAVE,vnd_cupom.DT_VENDA,VND_CUPOM_NFC_XML.ID_PDV,SUBSTRING(XML_NFE,116,44) CHAVE_XML,VND_CUPOM.STATUS_NFC  from ansg.dbo.VND_CUPOM_NFC_XML "
                    + " left join ansg.dbo.vnd_cupom on(VND_CUPOM_NFC_XML.ID_CUPOM=vnd_cupom.ID_CUPOM and VND_CUPOM_NFC_XML.ID_PDV=vnd_cupom.ID_PDV)"
                    + " where cast (vnd_cupom.DT_VENDA as date) between ? and ? and xml_nfe NOT LIKE '%<nfeProc%'  and vnd_cupom.NRO_DCTO IS NOT null AND VND_CUPOM.STATUS_NFC<>'INUTILIZADO' AND VND_CUPOM.STATUS_NFC<>'ABORTADO' AND VND_CUPOM.STATUS_NFC<>'CANCELADO' ORDER BY VND_CUPOM_NFC_XML.ID_PDV,VND_CUPOM.NRO_DCTO";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            pstm.setDate(1, dtinisql);
            pstm.setDate(2, dtfinsql);
            ResultSet rs = pstm.executeQuery();
            ArrayList<NfceBeans> lnfce = new ArrayList<>();
            while (rs.next()) {
                NfceBeans nfce = new NfceBeans();
                nfce.setId_cupom(rs.getString("id_cupom"));
                nfce.setNro_dcto(rs.getString("nro_dcto"));
                nfce.setChave(rs.getString("chave"));
                nfce.setDt_venda(rs.getDate("dt_venda"));
                nfce.setId_pdv(rs.getInt("id_pdv"));
                nfce.setChave_xml(rs.getString("chave_xml"));
                nfce.setStatus_nfc(rs.getString("STATUS_NFC"));
                lnfce.add(nfce);
            }
            pstm.close();
            rs.close();
            conexao.close();
            return lnfce;
        }
    }
    
    public void updateNfce(String idnfce,String xml_nfce,String chave_nfce) throws SQLException, IOException{
        try(Connection conexao=new ConexaoDb().getConnect()){
            String sql="UPDATE ansg.dbo.VND_CUPOM_NFC_XML SET CHAVE=?,xml_nfe=? WHERE id_cupom=?";
            PreparedStatement pstm=conexao.prepareStatement(sql);
            pstm.setString(1, chave_nfce);
            pstm.setString(2, xml_nfce);
            pstm.setString(3, idnfce);
            pstm.execute();
            pstm.close();
            conexao.close();
        }        
    }
    
    public void updateNfceStatus(String idnfce,String status,String cnc,Integer idsitnfce) throws SQLException, IOException{
        try(Connection conexao=new ConexaoDb().getConnect()){
            String sql="UPDATE ansg.dbo.VND_CUPOM SET STATUS_NFC=?,ID_SIT_DCTO=?,CNC=? WHERE id_cupom=?";
            PreparedStatement pstm=conexao.prepareStatement(sql);
            pstm.setString(1, status);
            pstm.setInt(2, idsitnfce);
            pstm.setString(3, cnc);
            pstm.setString(4, idnfce);
            pstm.execute();
            pstm.close();
            conexao.close();
        }        
    }
    
    public ArrayList<NfceBeans> getNfceXmlCancelado(Date dtini, Date dtfin) throws SQLException, IOException {
        java.sql.Date dtinisql = new java.sql.Date(dtini.getTime());
        java.sql.Date dtfinsql = new java.sql.Date(dtfin.getTime());
        try (Connection conexao = new ConexaoDb().getConnect()) {
            String sql = "select VND_CUPOM_NFC_XML.ID_CUPOM,VND_CUPOM.NRO_DCTO,VND_CUPOM_NFC_XML.CHAVE,vnd_cupom.DT_VENDA,VND_CUPOM_NFC_XML.ID_PDV,VND_CUPOM.STATUS_NFC,((VND_CUPOM.VR_TOTAL-VND_CUPOM.VR_DESCONTO)+VND_CUPOM.VR_ACRESCIMO) VR_TOTAL from ansg.dbo.VND_CUPOM_NFC_XML "
                    + " left join ansg.dbo.vnd_cupom on(VND_CUPOM_NFC_XML.ID_CUPOM=vnd_cupom.ID_CUPOM and VND_CUPOM_NFC_XML.ID_PDV=vnd_cupom.ID_PDV)"
                    + " where cast (vnd_cupom.DT_VENDA as date) between ? and ? and xml_nfe LIKE '%<nfeProc%' and vnd_cupom.NRO_DCTO IS NOT null AND VND_CUPOM.STATUS_NFC<>'ABORTADO' ORDER BY VND_CUPOM_NFC_XML.ID_PDV,VND_CUPOM.NRO_DCTO";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            pstm.setDate(1, dtinisql);
            pstm.setDate(2, dtfinsql);
            ResultSet rs = pstm.executeQuery();
            ArrayList<NfceBeans> lnfce = new ArrayList<>();
            while (rs.next()) {
                NfceBeans nfce = new NfceBeans();
                nfce.setId_cupom(rs.getString("id_cupom"));
                nfce.setNro_dcto(rs.getString("nro_dcto"));
                nfce.setChave(rs.getString("chave"));
                nfce.setDt_venda(rs.getDate("dt_venda"));
                nfce.setId_pdv(rs.getInt("id_pdv"));
                nfce.setStatus_nfc(rs.getString("STATUS_NFC"));
                nfce.setValor(rs.getFloat("VR_TOTAL"));
                lnfce.add(nfce);
            }
            pstm.close();
            rs.close();
            conexao.close();
            return lnfce;
        }
    }
    
}
