/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.sac.dao;

import br.com.atmatech.sac.beans.DistritoBeans;
import br.com.atmatech.sac.connection.ConexaoDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author MARCOS
 */
public class DistritoDao {
    public List<DistritoBeans> getDistrito(){
        try(Connection conexao=new ConexaoDb().getConnect()){
          String sql="select * from distrito order by distrito" ;
            PreparedStatement pstm=conexao.prepareStatement(sql);
            ResultSet rs=pstm.executeQuery();
            List<DistritoBeans> ldb=new ArrayList<>();
            while (rs.next()) {
                DistritoBeans db=new DistritoBeans();
                db.setIddistrito(rs.getInt("iddistrito"));
                db.setDistrito(rs.getString("distrito"));
                db.setMunicipio(rs.getString("municipio"));
                db.setPais(rs.getString("pais"));
                db.setUf(rs.getString("uf"));
                ldb.add(db);
            }
            pstm.close();
            rs.close();
            return ldb;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Consultar Distritos\n"+ex);
            return null;
        }
    }

    public List<DistritoBeans> getDistrito(String filtro, String campo) {
        try(Connection conexao=new ConexaoDb().getConnect()){
          String sql="select * from distrito where "+campo+" like '%"+filtro+"%' ORDER BY "+campo ;
            PreparedStatement pstm=conexao.prepareStatement(sql);            
            ResultSet rs=pstm.executeQuery();
            List<DistritoBeans> ldb=new ArrayList<>();
            while (rs.next()) {
                DistritoBeans db=new DistritoBeans();
                db.setIddistrito(rs.getInt("iddistrito"));
                db.setDistrito(rs.getString("distrito"));
                db.setMunicipio(rs.getString("municipio"));
                db.setPais(rs.getString("pais"));
                db.setUf(rs.getString("uf"));
                ldb.add(db);
            }
            pstm.close();
            rs.close();
            return ldb;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Consultar Distritos\n"+ex);
            return null;
        }
    }
}
