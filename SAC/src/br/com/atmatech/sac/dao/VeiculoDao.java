/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.sac.dao;

import br.com.atmatech.sac.beans.VeiculoBeans;
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
 * @author marcos
 */
public class VeiculoDao {

    public void setVeiculo(VeiculoBeans vb) throws SQLException {
        try(Connection conexao=new ConexaoDb().getConnect()){
            String sql="INSERT INTO VEICULO (MODELO, PERIODO, MARCA, TROCAINI, PLACA, TROCAFIN, KM, MONITOR,ativo) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)";
            PreparedStatement pstm=conexao.prepareStatement(sql);
            pstm.setString(1, vb.getModelo());
            pstm.setInt(2, vb.getPeriodo());
            pstm.setString(3, vb.getMarca());
            pstm.setDouble(4, vb.getTrocaini());
            pstm.setString(5, vb.getPlaca());
            pstm.setDouble(6, vb.getTrocafin());
            pstm.setDouble(7, vb.getKm());
            pstm.setBoolean(8, vb.isMonitor());
            pstm.setBoolean(9, vb.isAtivo());
            pstm.execute();
            pstm.close();
            conexao.close();
        }
    }

    public List<VeiculoBeans> getVeiculo() {
        try(Connection conexao=new ConexaoDb().getConnect()){
            String sql="select * from veiculo";
            PreparedStatement pstm=conexao.prepareStatement(sql);
            ResultSet rs=pstm.executeQuery();
            List<VeiculoBeans> lvb=new ArrayList<>();
            while(rs.next()){
                VeiculoBeans vb=new VeiculoBeans();
                vb.setIdveiculo(rs.getInt("idveiculo"));
                vb.setModelo(rs.getString("modelo"));
                vb.setPeriodo(rs.getInt("periodo"));
                vb.setMarca(rs.getString("marca"));
                vb.setTrocaini(rs.getDouble("trocaini"));
                vb.setTrocafin(rs.getDouble("trocafin"));
                vb.setPlaca(rs.getString("placa"));
                vb.setKm(rs.getDouble("km"));
                vb.setMonitor(rs.getBoolean("monitor"));
                vb.setAtivo(rs.getBoolean("ativo"));
                lvb.add(vb);
            }
            rs.close();
            pstm.close();
            conexao.close();
            return lvb;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Consultar Veiculos\n" + ex);
            return null;
        }        
    }
    
    public List<VeiculoBeans> getVeiculoAtivo() {
        try(Connection conexao=new ConexaoDb().getConnect()){
            String sql="select * from veiculo where ativo='true'";
            PreparedStatement pstm=conexao.prepareStatement(sql);
            ResultSet rs=pstm.executeQuery();
            List<VeiculoBeans> lvb=new ArrayList<>();
            while(rs.next()){
                VeiculoBeans vb=new VeiculoBeans();
                vb.setIdveiculo(rs.getInt("idveiculo"));
                vb.setModelo(rs.getString("modelo"));
                vb.setPeriodo(rs.getInt("periodo"));
                vb.setMarca(rs.getString("marca"));
                vb.setTrocaini(rs.getDouble("trocaini"));
                vb.setTrocafin(rs.getDouble("trocafin"));
                vb.setPlaca(rs.getString("placa"));
                vb.setKm(rs.getDouble("km"));
                vb.setMonitor(rs.getBoolean("monitor"));
                vb.setAtivo(rs.getBoolean("ativo"));
                lvb.add(vb);
            }
            rs.close();
            pstm.close();
            conexao.close();
            return lvb;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Consultar Veiculos\n" + ex);
            return null;
        }        
    }

    public void updateVeiculo(VeiculoBeans vb) throws SQLException {
        try(Connection conexao=new ConexaoDb().getConnect()){
            String sql="UPDATE VEICULO SET MODELO = ?,PERIODO = ?,MARCA = ?,TROCAINI = ?,PLACA = ?,TROCAFIN = ?,KM = ?,MONITOR = ?,ATIVO = ? WHERE IDVEICULO = ?";
            PreparedStatement pstm=conexao.prepareStatement(sql);
            pstm.setString(1, vb.getModelo());
            pstm.setInt(2, vb.getPeriodo());
            pstm.setString(3, vb.getMarca());
            pstm.setDouble(4, vb.getTrocaini());
            pstm.setString(5, vb.getPlaca());
            pstm.setDouble(6, vb.getTrocafin());
            pstm.setDouble(7, vb.getKm());
            pstm.setBoolean(8, vb.isMonitor());
            pstm.setBoolean(9, vb.isAtivo());
            pstm.setInt(10, vb.getIdveiculo());
            pstm.execute();
            pstm.close();
            conexao.close();
        }
    }

    public void deleteVeiculo(Integer idveiculo) throws SQLException {
        try(Connection conexao=new ConexaoDb().getConnect()){
            String sql="delete from veiculo where idveiculo=?";
            PreparedStatement pstm=conexao.prepareStatement(sql);
            pstm.setInt(1, idveiculo);
            pstm.execute();
            pstm.close();
            conexao.close();
        }
    }
    
}
