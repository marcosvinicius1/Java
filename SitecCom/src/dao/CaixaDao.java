/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bancodados.CriaConexao;
import bins.CaixaBins;
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
public class CaixaDao {
    private Connection conexao;
    public CaixaDao() throws SQLException{
        this.conexao=CriaConexao.getConexao();
    }
    public List<CaixaBins> getFormaPagamento(int empresa,String datainicial,String datafinal) throws SQLException{
        String sql="select formapg,sum(valor) as soma from caixa where empresa=? and datapagamento between ? and ? group by formapg";
        PreparedStatement stmt= this.conexao.prepareStatement(sql);
        stmt.setInt(1, empresa);
        stmt.setString(2, datainicial);
        stmt.setString(3, datafinal);
        ResultSet rs= stmt.executeQuery();
        List caixalista=new ArrayList<CaixaBins>();
        while(rs.next()){
            CaixaBins cb= new CaixaBins();
            cb.setFormapg(rs.getString("formapg"));
            cb.setValor(rs.getFloat("soma"));
            caixalista.add(cb);
        }
        rs.close();
        stmt.close();
        return caixalista;
    }
    public List<CaixaBins> getPagamentoDetalhado(String forma,int empresa,String datainicial,String datafinal) throws SQLException{
        String sql="select caixa.*,DATE_FORMAT(DATAPAGAMENTO, '%d.%m.%Y') AS dpagamento,pessoa.nome as nome from caixa \n" +
            "left join pessoa ON CAIXA.PESSOA=pessoa.id\n" +
         "where CAIXA.formapg=? AND CAIXA.EMPRESA=? AND DATAPAGAMENTO BETWEEN ? AND ?";
        PreparedStatement stmt= this.conexao.prepareStatement(sql);
        stmt.setString(1, forma);
        stmt.setInt(2, empresa);
        stmt.setString(3, datainicial);
        stmt.setString(4, datafinal);
        ResultSet rs= stmt.executeQuery();
        List caixalista=new ArrayList<CaixaBins>();
        while(rs.next()){
            CaixaBins cb= new CaixaBins();
            cb.setId(rs.getInt("id"));
            cb.setReceber(rs.getInt("receber"));
            cb.setPesoaorcamento(rs.getInt("pesoaorcamento"));
            cb.setPessoa(rs.getString("nome"));
            cb.setFormapg(rs.getString("formapg"));
            cb.setValor(rs.getFloat("valor"));
            cb.setDatapagamento(rs.getString("dpagamento"));
            cb.setEmpresa(rs.getInt("empresa"));          
            caixalista.add(cb);
        }
        rs.close();
        stmt.close();
        return caixalista;
    }
}
