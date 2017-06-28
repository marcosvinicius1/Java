/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.sac.dao;

import br.com.atmatech.sac.beans.LembreteBeans;
import br.com.atmatech.sac.connection.ConexaoDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Marcos
 */
public class LembreteDao {

    public LembreteBeans getLembrete(Integer idlembrete) throws SQLException {
        try (Connection conexao = new ConexaoDb().getConnect()) {
            String sql = "select lembrete.*,usuario.nome from lembrete "
                    + "left join usuario on(lembrete.idusuarioremt=usuario.idusuario) where idlembrete=?";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, idlembrete);
            ResultSet rs = pstm.executeQuery();
            LembreteBeans lb = new LembreteBeans();
            while (rs.next()) {
                lb.setIdlembrete(rs.getInt("idlembrete"));
                lb.setMensagem(rs.getString("mensagem"));
                lb.setIdusuario(rs.getInt("idusuario"));
                lb.setStatus(rs.getBoolean("status"));
                lb.setTitulo(rs.getString("titulo"));
                lb.setIdusuarioremt(rs.getInt("idusuarioremt"));
                lb.setNome(rs.getString("nome"));
            }
            pstm.close();
            rs.close();
            return lb;
        }
    }

    public List<String> getLembreteTitulo(Integer idusuario) throws SQLException {
        try (Connection conexao = new ConexaoDb().getConnect()) {
            String sql = "select * from lembrete where idusuario=? and status='true'";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, idusuario);
            ResultSet rs = pstm.executeQuery();
            List<String> llb = new ArrayList<>();
            while (rs.next()) {
                String lb = new String();
                lb = rs.getInt("idlembrete") + " | " + rs.getString("titulo");
                llb.add(lb);
            }
            pstm.close();
            rs.close();
            return llb;
        }
    }

    public void setLembrete(Integer idusuario, String titulo, String mensagem, Integer idusuarioremt,Date data) throws SQLException {
        try (Connection conexao = new ConexaoDb().getConnect()) {
            SimpleDateFormat sdfah = new SimpleDateFormat("yyyy.MM.dd  HH:mm:ss");
            String sql = "insert into lembrete(mensagem,idusuario,status,titulo,idusuarioremt,data) values(?,?,?,?,?,?)";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            pstm.setString(1, mensagem);
            pstm.setInt(2, idusuario);
            pstm.setString(3, "true");
            pstm.setString(4, titulo);
            pstm.setInt(5, idusuarioremt);
            pstm.setString(6, sdfah.format(data));
            pstm.execute();
            pstm.close();
        }
    }

    public void delLembrete(Integer idlembrete) throws SQLException {
        try (Connection conexao = new ConexaoDb().getConnect()) {
            String sql = "update lembrete set status='false' where idlembrete=?";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, idlembrete);
            pstm.execute();
            pstm.close();
        }
    }
}
