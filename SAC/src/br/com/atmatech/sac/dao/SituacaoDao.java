/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.sac.dao;

import br.com.atmatech.sac.beans.SituacaoBeans;
import br.com.atmatech.sac.connection.ConexaoDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MARCOS
 */
public class SituacaoDao {
    
    public List<SituacaoBeans> getSituacao() throws SQLException{
        try(Connection conexao=new ConexaoDb().getConnect()){
            String sql="select * from situacao";
            PreparedStatement pstm=conexao.prepareStatement(sql);
            ResultSet rs=pstm.executeQuery();
            List<SituacaoBeans>lsb=new ArrayList<>();
            while(rs.next()){
                SituacaoBeans sb=new SituacaoBeans();
                sb.setDescricao(rs.getString("descricao"));
                sb.setIdsituacao(rs.getInt("idsituacao"));
                lsb.add(sb);
            }
            rs.close();
            pstm.close();
            return lsb;
        } /*catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Consultar Situação\n"+ex);
            return null;
        }   */    
    }
}
