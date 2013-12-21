/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bancodados.CriaConexao;
import bins.PesoaOrcamentoBins;
import bins.PessoaBins;
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
public class PessoaOrcamentoDao {
       private Connection conexao;
    public PessoaOrcamentoDao() throws SQLException{
        this.conexao=CriaConexao.getConexao();
    }

    public void adiciona(PesoaOrcamentoBins po) throws SQLException{
        //PREPARA A CONEXAO
        String sql="insert into pesoaorcamento(pessoacliente,pessoavendedor,empresa,data,vorcamento,tipo,formapg)"
                + "values(?,?,?,?,?,?,?)";
        PreparedStatement stmt =conexao.prepareStatement(sql);
        //SETA OS VALORES
        stmt.setInt(1, po.getPessoacliente());
        stmt.setInt(2, po.getPessoavendedor());
        stmt.setInt(3, po.getEmpresa());
        stmt.setString(4, po.getData());
        stmt.setFloat(5, po.getVorcamento());
        stmt.setString(6, po.getTipo());
        stmt.setString(7, po.getFormapg());
        //EXECULTA O CODIGO SQL
        stmt.execute();
        stmt.close();
    }
    public void altera(PesoaOrcamentoBins po) throws SQLException{
        //PREPARA A CONEXAO
        String sql="update pesoaorcamento set pessoacliente=?, pessoavendedor=?,empresa=?,data=?,vorcamento=?,tipo=?,formapg=? where id=?";
        PreparedStatement stmt =conexao.prepareStatement(sql);
        //SETA OS VALORES
        stmt.setInt(1, po.getPessoacliente());
        stmt.setInt(2, po.getPessoavendedor());
        stmt.setInt(3, po.getEmpresa());
        stmt.setString(4, po.getData());
        stmt.setFloat(5, po.getVorcamento());
        stmt.setString(6, po.getTipo());
        stmt.setString(7, po.getFormapg());
        stmt.setInt(8, po.getId());
        //EXECULTA O CODIGO SQL
        stmt.execute();
        stmt.close();
    }
    public int liberaorcamento(int numero) throws SQLException{
        String sql="update pesoaorcamento set tipo='O' where id=?";
        PreparedStatement stmt= conexao.prepareStatement(sql);
        stmt.setInt(1, numero);
        stmt.execute();
        int resultado=stmt.getUpdateCount();
        stmt.close();
        return resultado;
    }
    public int ultimoadiciona() throws SQLException {
        String sql = "select max(id) as id from pesoaorcamento";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        int id=0;
        while (rs.next()) {
        id = rs.getInt("id");
        }
        rs.close();
        stmt.close();
        return id;
    }
    public List<PesoaOrcamentoBins> getLista(String nome,String local,int empresa) throws SQLException{
        String sql = "select pesoaorcamento.*,DATE_FORMAT(data, '%d.%m.%Y') AS dorc,pessoa.nome as npessoacliente from pesoaorcamento inner join pessoa on "
                + "pesoaorcamento.pessoacliente=pessoa.id where "+local+" like ? and pesoaorcamento.empresa="+empresa+"";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setString(1, nome);
        ResultSet rs = stmt.executeQuery();
        List<PesoaOrcamentoBins> PessoaLista = new ArrayList<PesoaOrcamentoBins>();
        while(rs.next()){
            PesoaOrcamentoBins pob= new PesoaOrcamentoBins();
            pob.setId(rs.getInt("id"));
            pob.setPessoacliente(rs.getInt("pessoacliente"));
            pob.setPessoavendedor(rs.getInt("pessoavendedor"));
            pob.setEmpresa(rs.getInt("empresa"));
            pob.setData(rs.getString("dorc"));
            pob.setVorcamento(rs.getFloat("vorcamento"));
            pob.setTipo(rs.getString("tipo"));
            pob.setNpessoacliente(rs.getString("npessoacliente"));
            
            PessoaLista.add(pob);
        }
        rs.close();
        stmt.close();
        return PessoaLista;
    }
    public void remove(PesoaOrcamentoBins pob) throws SQLException{
        String sql="delete from pesoaorcamento where id=?";
        PreparedStatement stmt= conexao.prepareStatement(sql);
        stmt.setLong(1, pob.getId());
        stmt.execute();
        stmt.close();
        
    }
}
