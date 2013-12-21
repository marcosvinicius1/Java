/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bancodados.CriaConexao;
import bins.ReceberBins;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author MARCOS
 */
public class ReceberDao {
    private Connection conexao;
    public ReceberDao() throws SQLException{
        this.conexao= CriaConexao.getConexao();
    }
    //ADICIONA CONTA
    public void adiciona(ReceberBins rb) throws SQLException{
        String sql="insert into receber(vendedor,cliente,norcamento,ndocumento,emissao,tipo,pg,"
                + "datavenda,datavencimento,valor,datapg,empresa,obs)values(?,?,"+rb.getNorcamento()+",?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stmt=conexao.prepareStatement(sql);
        stmt.setInt(1,rb.getVendedor());
        stmt.setInt(2,rb.getCliente());
        stmt.setString(3,rb.getNdocumento());
        stmt.setString(4,rb.getEmissao());
        stmt.setString(5,rb.getTipo());
        stmt.setString(6,rb.getPg());
        stmt.setString(7,rb.getDatavenda());
        stmt.setString(8,rb.getDatavencimento());
        stmt.setFloat(9,rb.getValor());
        stmt.setString(10,rb.getDatapg());
        stmt.setInt(11,rb.getEmpresa());
        stmt.setString(12, rb.getObs());
        stmt.execute();
        stmt.close();
    
    }
    public void altera(ReceberBins rb) throws SQLException{
        
        String sql="update receber set vendedor=?,cliente=?,norcamento="+rb.getNorcamento()+",ndocumento=?,emissao=?,tipo=?,pg=?,"
                + "datavenda=?,datavencimento=?,valor=?,datapg=?,empresa=?,obs=? where id=?";
        PreparedStatement stmt=conexao.prepareStatement(sql);
        stmt.setInt(1,rb.getVendedor());
        stmt.setInt(2,rb.getCliente());
        stmt.setString(3,rb.getNdocumento());
        stmt.setString(4,rb.getEmissao());
        stmt.setString(5,rb.getTipo());
        stmt.setString(6,rb.getPg());
        stmt.setString(7,rb.getDatavenda());
        stmt.setString(8,rb.getDatavencimento());
        stmt.setFloat(9,rb.getValor());
        stmt.setString(10,rb.getDatapg());
        stmt.setInt(11,rb.getEmpresa());
        stmt.setString(12, rb.getObs());
        stmt.setInt(13, rb.getId());
        stmt.execute();
        stmt.close();
    
    }
    public List<ReceberBins> getlista(String campo,int empresa,String pago) throws SQLException{
        String sql="select receber.*,DATE_FORMAT(datavencimento, '%d.%m.%Y') AS dvencimento,DATE_FORMAT(datapg, '%d.%m.%Y') AS dpagamento,DATE_FORMAT(datavenda, '%d.%m.%Y') AS dvenda,pessoa.nome as nomecliente,pessoa.cpf_cnpj as cnpjcliente,p.nome as nomevendedor from receber\n" +
                       "LEFT JOIN pessoa on receber.cliente=pessoa.id\n" +
                        "LEFT JOIN pessoa p on receber.vendedor=p.id where "+campo+" and receber.empresa="+empresa+" and receber.pg <>? ";
        PreparedStatement stmt= conexao.prepareStatement(sql);
        stmt.setString(1, pago);
        ResultSet rs=stmt.executeQuery();
        List<ReceberBins> receberLista= new ArrayList<ReceberBins>();
        while (rs.next()) {
            ReceberBins rb = new ReceberBins();
            rb.setId(rs.getInt("id"));
            rb.setVendedor(rs.getInt("vendedor"));
            rb.setCliente(rs.getInt("cliente"));
            rb.setNorcamento(rs.getInt("norcamento"));
            rb.setNdocumento(rs.getString("ndocumento"));
            rb.setEmissao(rs.getString("emissao"));
            rb.setTipo(rs.getString("tipo"));
            rb.setPg(rs.getString("pg"));
            rb.setDatavenda(rs.getString("dvenda"));
            rb.setDatavencimento(rs.getString("dvencimento"));
            rb.setValor(rs.getFloat("valor"));
            rb.setDatapg(rs.getString("dpagamento"));
            rb.setEmpresa(rs.getInt("empresa"));
            rb.setNomecliente(rs.getString("nomecliente"));
            rb.setCnpjcliente(rs.getString("cnpjcliente"));
            rb.setNomevendedor(rs.getString("nomevendedor"));
            rb.setObs(rs.getString("obs"));
            receberLista.add(rb);
        }
        rs.close();
        stmt.close();
        return receberLista;
    }
    //METODO UTILIZADO PARA LISTAS AS DUPLICATAS NAO PAGAS NA VIEW CAIXA AGRUPADA POR TIPO
    public List<ReceberBins> getFormaPagamentoNaoPagos(int empresa,String datainicial,String datafinal) throws SQLException{
        String sql="select tipo,sum(valor) as soma from receber where empresa=? and pg='N' and datavenda between ? and ? group by tipo";
        PreparedStatement stmt= conexao.prepareStatement(sql);
        stmt.setInt(1, empresa);
        stmt.setString(2, datainicial);
        stmt.setString(3, datafinal);
        ResultSet rs=stmt.executeQuery();
        List<ReceberBins> receberLista= new ArrayList<ReceberBins>();
        while (rs.next()) {
            ReceberBins rb = new ReceberBins();            
            rb.setTipo(rs.getString("tipo"));            
            rb.setValor(rs.getFloat("soma"));          
            receberLista.add(rb);
        }
        rs.close();
        stmt.close();
        return receberLista;
    }
    //METODO UTILIZADO PARA LISTAS AS DUPLICATAS NAO PAGAS NA VIEW CAIXA DETALHADA
    public List<ReceberBins> getPagamentoNaoPagosDetalhado(int empresa,String datainicial,String datafinal,String tipo) throws SQLException{
        String sql="select receber.id,receber.norcamento,receber.valor,DATE_FORMAT(datavenda, '%d.%m.%Y') AS dtvenda,pessoa.nome "
                + "from receber left join pessoa on receber.cliente=pessoa.id where receber.empresa=? and receber.pg='N' and receber.tipo=? and datavenda between ? and ?";
        PreparedStatement stmt= conexao.prepareStatement(sql);
        stmt.setInt(1, empresa);
        stmt.setString(2, tipo);
        stmt.setString(3, datainicial);
        stmt.setString(4, datafinal);
        ResultSet rs=stmt.executeQuery();
        List<ReceberBins> receberLista= new ArrayList<ReceberBins>();
        while (rs.next()) {
            ReceberBins rb = new ReceberBins(); 
            rb.setDatavenda(rs.getString("dtvenda"));
            rb.setNorcamento(rs.getInt("norcamento"));
            rb.setId(rs.getInt("id"));
            rb.setNomecliente(rs.getString("nome"));
            rb.setValor(rs.getFloat("valor"));  
            receberLista.add(rb);
        }
        rs.close();
        stmt.close();
        return receberLista;
    }
    
    public void remove(ReceberBins rb) throws SQLException{
        String sql="delete from receber where id=?";
        PreparedStatement stmt=conexao.prepareStatement(sql);
        stmt.setInt(1, rb.getId());
        stmt.execute();
        stmt.close();
    }
     public void removeNorcamento(ReceberBins rb) throws SQLException{
        String sql="delete from receber where norcamento=?";
        PreparedStatement stmt=conexao.prepareStatement(sql);
        stmt.setInt(1, rb.getNorcamento());
        stmt.execute();
        stmt.close();
    }
}
