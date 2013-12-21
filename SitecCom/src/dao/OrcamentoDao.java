/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bancodados.CriaConexao;
import bins.OrcamentoBins;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MARCOS
 */
public class OrcamentoDao {
   private Connection conexao;
    public OrcamentoDao() throws SQLException{
        this.conexao=CriaConexao.getConexao();
    }

    public void adiciona(OrcamentoBins ob) throws SQLException{
        //PREPARA A CONEXAO
        String sql="insert into orcamento (produto,pessoa,qtde,precovenda,desconto,precotproduto,precotorcamento,formapg,data)"
                + "values(?,?,?,?,?,?,?,?,?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);       
        //SETA OS VALORES
        stmt.setInt(1,ob.getProduto());
        stmt.setInt(2, ob.getPessoa());
        stmt.setFloat(3,ob.getQtde());
        stmt.setFloat(4,ob.getPrecovenda());
        stmt.setFloat(5,ob.getDesconto());
        stmt.setFloat(6,ob.getPrecotproduto());
        stmt.setFloat(7,ob.getPrecotorcamento());
        stmt.setString(8,ob.getFormapg());
      //  stmt.setString(9, ob.getTipo());
        stmt.setString(9, ob.getData());
        //EXECULTA O CODIGO SQL
        stmt.execute();
        stmt.close();
        
    } 
      
    public List<OrcamentoBins> getLista(int id) throws SQLException{
        String sql = "select orcamento.*,produto.codbarra,produto.descricao from orcamento inner join produto"
                + " on orcamento.produto=produto.id where orcamento.pessoa=?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        List<OrcamentoBins> ProdutoLista = new ArrayList<OrcamentoBins>();
        while(rs.next()){
            OrcamentoBins ob= new OrcamentoBins();
               ob.setProduto(rs.getInt("produto"));
               ob.setPessoa(rs.getInt("pessoa"));
               ob.setQtde(rs.getFloat("qtde"));
               ob.setPrecovenda(rs.getFloat("precovenda"));
               ob.setDesconto(rs.getFloat("desconto"));
               ob.setPrecotproduto(rs.getFloat("precotproduto"));
               ob.setFormapg(rs.getString("formapg"));
               ob.setCodproduto(rs.getString("codbarra"));
               ob.setDescproduto(rs.getString("descricao"));
               ProdutoLista.add(ob);
        }
        rs.close();
        stmt.close();
        return ProdutoLista;
    }
    public void remove(OrcamentoBins ob) throws SQLException{
        String sql="delete from orcamento where pessoa=?";
        PreparedStatement stmt= conexao.prepareStatement(sql);
        stmt.setLong(1, ob.getPessoa());
        stmt.execute();
        stmt.close();
        
    }
}
