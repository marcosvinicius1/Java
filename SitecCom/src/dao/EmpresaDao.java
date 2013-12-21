/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bancodados.CriaConexao;
import bins.EmpresaBins;
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
public class EmpresaDao {
    private Connection conexao;
    public EmpresaDao() throws SQLException{
        this.conexao=CriaConexao.getConexao();
    }
    public List<EmpresaBins> getLista() throws SQLException{
        String sql = "select * from empresa";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        List<EmpresaBins> EmpresaLista = new ArrayList<EmpresaBins>();
        while (rs.next()) {
            EmpresaBins eb= new EmpresaBins();
            eb.setId(rs.getInt("id"));
            eb.setNome(rs.getString("nome"));
            eb.setCnpj(rs.getString("cnpj"));
            eb.setEndereco(rs.getString("endereco"));
            eb.setNumero(rs.getString("numero"));
            eb.setBairro(rs.getString("bairro"));
            eb.setCidade(rs.getString("cidade"));
            eb.setTelefone(rs.getString("telefone"));
            eb.setCep(rs.getString("cep")); 
            eb.setSenha(rs.getString("senha"));
            eb.setDesconto(rs.getFloat("desconto"));
            EmpresaLista.add(eb);
        }
        rs.close();
        stmt.close();
        return EmpresaLista;
    }
    public void altera(EmpresaBins eb) throws SQLException{
        String sql="update empresa set nome=?,cnpj=?,endereco=?,numero=?,bairro=?,cidade=?,telefone=?,"
                + "cep=?,senha=?,desconto=? where id=?";
        PreparedStatement stmt=conexao.prepareStatement(sql);
        
        stmt.setString(1, eb.getNome());
        stmt.setString(2, eb.getCnpj());
        stmt.setString(3, eb.getEndereco());
        stmt.setString(4, eb.getNumero());
        stmt.setString(5, eb.getBairro());
        stmt.setString(6, eb.getCidade());
        stmt.setString(7, eb.getTelefone());
        stmt.setString(8, eb.getCep());
        stmt.setString(9, eb.getSenha());
        stmt.setFloat(10, eb.getDesconto());
        stmt.setInt(11, eb.getId());
        
        stmt.execute();
        stmt.close();
    }
    
}
