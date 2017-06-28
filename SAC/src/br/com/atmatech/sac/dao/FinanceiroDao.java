/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.sac.dao;

import br.com.atmatech.sac.beans.FinanceiroBeans;
import br.com.atmatech.sac.connection.ConexaoDb;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcos
 */
public class FinanceiroDao {

    public List<FinanceiroBeans> getFinanceiro() throws SQLException {
        try (Connection conexao = new ConexaoDb().getConnect()) {
            String sql = "select * from financeiro where idpessoa is not null order by vencimento,cliente";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            List<FinanceiroBeans> lfb = new ArrayList<>();
            while (rs.next()) {
                FinanceiroBeans fb = new FinanceiroBeans();
                fb.setIdfinanceiro(rs.getInt("idfinanceiro"));
                fb.setDoc(rs.getString("doc"));
                fb.setCliente(rs.getString("cliente"));
                fb.setValor(rs.getFloat("valor"));
                fb.setVencimento(rs.getDate("vencimento"));
                fb.setContato(rs.getString("contato"));
                fb.setTelcel(rs.getString("telcel"));
                fb.setAtualizacao(rs.getDate("atualizacao"));
                fb.setIdpessoa(rs.getInt("idpessoa"));
                lfb.add(fb);
            }
            rs.close();
            pstm.close();
            return lfb;
        }
    }

    public Date getFinanceiroDate() throws SQLException {
        try (Connection conexao = new ConexaoDb().getConnect()) {
            String sql = "select atualizacao from financeiro  group by atualizacao";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            Date atualizacao = new Date(0, 0, 0);
            while (rs.next()) {
                atualizacao = rs.getDate("atualizacao");
            }
            rs.close();
            pstm.close();
            return atualizacao;
        }
    }

    public List<FinanceiroBeans> getFinanceiroVencidos() throws SQLException {
        try (Connection conexao = new ConexaoDb().getConnect()) {
            String sql = "select * from financeiro  where idpessoa is not NULL "
                    + " AND vencimento<now() order by vencimento,cliente";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            List<FinanceiroBeans> lfb = new ArrayList<>();
            while (rs.next()) {
                FinanceiroBeans fb = new FinanceiroBeans();
                fb.setIdfinanceiro(rs.getInt("idfinanceiro"));
                fb.setDoc(rs.getString("doc"));
                fb.setCliente(rs.getString("cliente"));
                fb.setValor(rs.getFloat("valor"));
                fb.setVencimento(rs.getDate("vencimento"));
                fb.setContato(rs.getString("contato"));
                fb.setTelcel(rs.getString("telcel"));
                fb.setAtualizacao(rs.getDate("atualizacao"));
                fb.setIdpessoa(rs.getInt("idpessoa"));
                lfb.add(fb);
            }
            rs.close();
            pstm.close();
            return lfb;
        }
    }

    public List<FinanceiroBeans> getFinanceiroAbertoMes() throws SQLException {
        try (Connection conexao = new ConexaoDb().getConnect()) {
            String sql = "select * from financeiro  where idpessoa is not NULL "
                    + " AND MONTH(vencimento)=MONTH(now())  AND Year(vencimento)=Year(now()) order by vencimento,cliente";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            List<FinanceiroBeans> lfb = new ArrayList<>();
            while (rs.next()) {
                FinanceiroBeans fb = new FinanceiroBeans();
                fb.setIdfinanceiro(rs.getInt("idfinanceiro"));
                fb.setDoc(rs.getString("doc"));
                fb.setCliente(rs.getString("cliente"));
                fb.setValor(rs.getFloat("valor"));
                fb.setVencimento(rs.getDate("vencimento"));
                fb.setContato(rs.getString("contato"));
                fb.setTelcel(rs.getString("telcel"));
                fb.setAtualizacao(rs.getDate("atualizacao"));
                fb.setIdpessoa(rs.getInt("idpessoa"));
                lfb.add(fb);
            }
            rs.close();
            pstm.close();
            return lfb;
        }
    }

    public void setFinanceiro(FinanceiroBeans fb) throws SQLException {
        try (Connection conexao = new ConexaoDb().getConnect()) {
            String sql = "INSERT INTO financeiro (doc, cliente, valor, vencimento, contato, telcel, atualizacao, idpessoa) "
                    + "VALUES(?,?,?,?,?,?,cast(now() as date),(select idpessoa from pessoa where pessoa.cnpj=?));";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            pstm.setString(1, fb.getDoc());
            pstm.setString(2, fb.getCliente());
            pstm.setFloat(3, fb.getValor());
            pstm.setDate(4, fb.getVencimento());
            pstm.setString(5, fb.getContato());
            pstm.setString(6, fb.getTelcel());
            pstm.setString(7, fb.getCliente().substring(fb.getCliente().length()-14, fb.getCliente().length()));
            pstm.execute();
            pstm.close();
        }
    }

    public void dropFinanceiro() throws SQLException {
        try (Connection conexao = new ConexaoDb().getConnect()) {
            String sql = "delete from financeiro where idfinanceiro>0";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            pstm.execute();
            pstm.close();
        }
    }

    public List<FinanceiroBeans> getFinanceiroVencidosMes() throws SQLException {
        try (Connection conexao = new ConexaoDb().getConnect()) {
            String sql = "select * from financeiro  where idpessoa is not NULL "
                    + " AND MONTH(vencimento)=MONTH(now())  AND Day(vencimento)<Day(now()) order by vencimento,cliente";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            List<FinanceiroBeans> lfb = new ArrayList<>();
            while (rs.next()) {
                FinanceiroBeans fb = new FinanceiroBeans();
                fb.setIdfinanceiro(rs.getInt("idfinanceiro"));
                fb.setDoc(rs.getString("doc"));
                fb.setCliente(rs.getString("cliente"));
                fb.setValor(rs.getFloat("valor"));
                fb.setVencimento(rs.getDate("vencimento"));
                fb.setContato(rs.getString("contato"));
                fb.setTelcel(rs.getString("telcel"));
                fb.setAtualizacao(rs.getDate("atualizacao"));
                fb.setIdpessoa(rs.getInt("idpessoa"));
                lfb.add(fb);
            }
            rs.close();
            pstm.close();
            return lfb;
        }
    }

}
