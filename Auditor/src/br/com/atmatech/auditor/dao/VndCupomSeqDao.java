/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.auditor.dao;

import br.com.atmatech.auditor.beans.VndCupomSeqBeans;
import br.com.atmatech.auditor.connection.ConexaoDb;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcos
 */
public class VndCupomSeqDao {

    public List<VndCupomSeqBeans> getVndCupomSeqMax() throws SQLException, IOException {
        try (Connection conexao = new ConexaoDb().getConnect()) {
            String sql = "SELECT NRO_ECF,MAX(NRO_DCTO) MAX_DCTO FROM VND_CUPOM "
                    + "WHERE NRO_DCTO IS NOT NULL AND STATUS_NFC IS NOT NULL "
                    + "GROUP BY NRO_ECF";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            ArrayList<VndCupomSeqBeans> lvcs = new ArrayList<>();
            while (rs.next()) {
                VndCupomSeqBeans vcs = new VndCupomSeqBeans();
                vcs.setNro_nfce(rs.getInt("NRO_ECF"));
                vcs.setMax_dcto(rs.getInt("max_dcto"));
                lvcs.add(vcs);
            }
            return lvcs;
        }

    }

    public List<Integer> getVndCupomSeq(int nro_ecf) throws SQLException, IOException {
        try (Connection conexao = new ConexaoDb().getConnect()) {
            String sql = "SELECT NRO_ECF,NRO_DCTO FROM VND_CUPOM WHERE NRO_DCTO IS NOT NULL AND STATUS_NFC IN('ENVIADO','CANCELADO','INUTILIZADO') AND NRO_ECF="+nro_ecf+" "
                    + "GROUP BY NRO_ECF,NRO_DCTO ORDER BY NRO_ECF,NRO_DCTO";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            ArrayList<Integer> lvcs = new ArrayList<>();
            while (rs.next()) {
                Integer vcs;                
                vcs=rs.getInt("NRO_DCTO");
                lvcs.add(vcs);
            }
            return lvcs;
        }

    }
}
