/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author MARCOS
 */
import java.sql.*;
import bancodados.CriaConexao;
import bins.ProdutoBins;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDao {
    private Connection conexao;
    public ProdutoDao() throws SQLException{
        this.conexao=CriaConexao.getConexao();
    }

    public void adiciona(ProdutoBins pb) throws SQLException{
        //PREPARA A CONEXAO
        String sql="insert into produto (aliquota,grupo,marca,pessoa,codbarra,descricao,qtde,qtdemin,localizacao,margemlucro,"
                + "precocusto,precovenda,frete,acessorio,ativo,valoraliq,custoreal,empresa)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stmt =conexao.prepareStatement(sql);
        //SETA OS VALORES
        stmt.setInt(1,pb.getAliquota());
        stmt.setInt(2,pb.getGrupo());
        stmt.setInt(3,pb.getMarca());
        stmt.setInt(4,pb.getPessoa());
        stmt.setString(5,pb.getCodbarra());
        stmt.setString(6,pb.getDescricao());
        stmt.setFloat(7,pb.getQtde());
        stmt.setFloat(8,pb.getQtdemin());
        stmt.setString(9,pb.getLocalizacao());
        stmt.setFloat(10,pb.getMargemlucro());
        stmt.setFloat(11,pb.getPrecocusto());
        stmt.setFloat(12, pb.getPrecovenda());
        stmt.setFloat(13, pb.getFrete());
        stmt.setFloat(14, pb.getAcessorio());
        stmt.setInt(15, pb.getAtivo());
        stmt.setFloat(16, pb.getValoraliq());
        stmt.setFloat(17, pb.getCustoreal());
        stmt.setInt(18, pb.getEmpresa());
        //EXECULTA O CODIGO SQL
        stmt.execute();
        stmt.close();
    }
    public void altera(ProdutoBins pb) throws SQLException{
        //PREPARA A CONEXAO
        String sql="update produto set aliquota=?,grupo=?,marca=?,pessoa=?,codbarra=?,descricao=?,qtde=?,qtdemin=?,localizacao=?,margemlucro=?,"
                + "precocusto=?,precovenda=?,frete=?,acessorio=?,ativo=?,valoraliq=?,custoreal=? where id=?";
        PreparedStatement stmt =conexao.prepareStatement(sql);
        //SETA OS VALORES
        stmt.setInt(1,pb.getAliquota());
        stmt.setInt(2,pb.getGrupo());
        stmt.setInt(3,pb.getMarca());
        stmt.setInt(4,pb.getPessoa());
        stmt.setString(5,pb.getCodbarra());
        stmt.setString(6,pb.getDescricao());
        stmt.setFloat(7,pb.getQtde());
        stmt.setFloat(8,pb.getQtdemin());
        stmt.setString(9,pb.getLocalizacao());
        stmt.setFloat(10,pb.getMargemlucro());
        stmt.setFloat(11,pb.getPrecocusto());
        stmt.setFloat(12, pb.getPrecovenda());
        stmt.setFloat(13, pb.getFrete());
        stmt.setFloat(14, pb.getAcessorio());
        stmt.setInt(15, pb.getAtivo());
        stmt.setFloat(16, pb.getValoraliq());
        stmt.setFloat(17, pb.getCustoreal());
        stmt.setInt(18,pb.getId());
              
        //EXECULTA O CODIGO SQL
        stmt.execute();
        stmt.close();
    }
     public List<ProdutoBins> getListaproduto(String nome,String local,int empresa) throws SQLException{
        String sql = "select * from produto where "+local+" like ? and empresa="+empresa+" order by "+local+"";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setString(1, nome);
        ResultSet rs = stmt.executeQuery();
        List<ProdutoBins> ProdutoLista = new ArrayList<ProdutoBins>();
         while (rs.next()) {
             ProdutoBins pb = new ProdutoBins();
             pb.setId(rs.getInt("id"));
             pb.setAliquota(rs.getInt("aliquota"));
             pb.setGrupo(rs.getInt("grupo"));
             pb.setMarca(rs.getInt("marca"));
             pb.setPessoa(rs.getInt("pessoa"));
             pb.setCodbarra(rs.getString("codbarra"));
             pb.setDescricao(rs.getString("descricao"));
             pb.setQtde(rs.getFloat("qtde"));
             pb.setQtdemin(rs.getFloat("qtdemin"));
             pb.setLocalizacao(rs.getString("localizacao"));
             pb.setMargemlucro(rs.getFloat("margemlucro"));
             pb.setPrecocusto(rs.getFloat("precocusto"));
             pb.setPrecovenda(rs.getFloat("precovenda"));
             pb.setFrete(rs.getFloat("frete"));
             pb.setAcessorio(rs.getFloat("acessorio"));
             pb.setAtivo(rs.getInt("ativo"));
             pb.setValoraliq(rs.getFloat("valoraliq"));
             pb.setCustoreal(rs.getFloat("custoreal"));
             pb.setEmpresa(rs.getInt("empresa"));
             ProdutoLista.add(pb);
        }
        rs.close();
        stmt.close();
        return ProdutoLista;
    }
     public List<ProdutoBins> getprodutoativo(String nome,String local,int empresa) throws SQLException{
        String sql = "select * from produto where "+local+" like ? and empresa="+empresa+" and ativo=0 order by "+local+"";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setString(1, nome);
        ResultSet rs = stmt.executeQuery();
        List<ProdutoBins> ProdutoLista = new ArrayList<ProdutoBins>();
         while (rs.next()) {
             ProdutoBins pb = new ProdutoBins();
             pb.setId(rs.getInt("id"));
             pb.setAliquota(rs.getInt("aliquota"));
             pb.setGrupo(rs.getInt("grupo"));
             pb.setMarca(rs.getInt("marca"));
             pb.setPessoa(rs.getInt("pessoa"));
             pb.setCodbarra(rs.getString("codbarra"));
             pb.setDescricao(rs.getString("descricao"));
             pb.setQtde(rs.getFloat("qtde"));
             pb.setQtdemin(rs.getFloat("qtdemin"));
             pb.setLocalizacao(rs.getString("localizacao"));
             pb.setMargemlucro(rs.getFloat("margemlucro"));
             pb.setPrecocusto(rs.getFloat("precocusto"));
             pb.setPrecovenda(rs.getFloat("precovenda"));
             pb.setFrete(rs.getFloat("frete"));
             pb.setAcessorio(rs.getFloat("acessorio"));
             pb.setAtivo(rs.getInt("ativo"));
             pb.setValoraliq(rs.getFloat("valoraliq"));
             pb.setCustoreal(rs.getFloat("custoreal"));
             pb.setEmpresa(rs.getInt("empresa"));
             ProdutoLista.add(pb);
        }
        rs.close();
        stmt.close();
        return ProdutoLista;
    }
     public void remove(ProdutoBins pb) throws SQLException{
        String sql="delete from produto where id=?";
        PreparedStatement stmt= conexao.prepareStatement(sql);
        stmt.setInt(1, pb.getId());
        stmt.execute();
        stmt.close();
        
    }
     public void baixaestoque(ProdutoBins pb,Float qtde) throws SQLException{
         String sql="update produto set qtde=qtde-"+qtde+"where id=?";
         PreparedStatement stmt=conexao.prepareStatement(sql);
         stmt.setFloat(1, pb.getId());
         stmt.execute();
         stmt.close();
     }
     public void retornaestoque(ProdutoBins pb,Float qtde) throws SQLException{
         String sql="update produto set qtde=qtde+"+qtde+" where id=?";
         PreparedStatement stmt=conexao.prepareStatement(sql);
         stmt.setFloat(1, pb.getId());
         stmt.execute();
         stmt.close();
     }
}
