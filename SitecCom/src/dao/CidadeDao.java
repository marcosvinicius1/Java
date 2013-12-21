/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bancodados.CriaConexao;
import bins.CidadeBins;
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
public class CidadeDao {
    private Connection conexao;
    public CidadeDao() throws SQLException{
        this.conexao=CriaConexao.getConexao();
    }
    public List<CidadeBins> getLista(String nome,String local) throws SQLException{
        String sql = "select cidade.id,cidade.distrito,cidade.nome,estado.nome,pais.nome from cidade,estado,pais where"
                + " cidade.estado=estado.id and estado.pais=pais.id and cidade."+local+" like ? order by cidade."+local+"";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setString(1, nome);
        ResultSet rs = stmt.executeQuery();
        List<CidadeBins> CidadeLista = new ArrayList<CidadeBins>();
        while (rs.next()) {
            CidadeBins cb = new CidadeBins();
            cb.setId(rs.getInt("cidade.id"));
            cb.setDistrito(rs.getString("cidade.distrito"));
            cb.setNome(rs.getString("cidade.nome"));
            cb.setEstado(rs.getString("estado.nome"));
            cb.setPais(rs.getString("pais.nome"));
            
            CidadeLista.add(cb);
        }
        rs.close();
        stmt.close();
        return CidadeLista;
    }

public List<CidadeBins> getcidadepessoa(Integer idcidade) throws SQLException{
        String sql = "select cidade.id,cidade.distrito,cidade.nome,estado.nome,pais.nome from cidade,estado,pais where"
                + " cidade.estado=estado.id and estado.pais=pais.id and cidade.id=?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setInt(1, idcidade);
        ResultSet rs = stmt.executeQuery();
        List<CidadeBins> CidadeLista = new ArrayList<CidadeBins>();
        while (rs.next()) {
            CidadeBins cb = new CidadeBins();
            cb.setId(rs.getInt("cidade.id"));
            cb.setDistrito(rs.getString("cidade.distrito"));
            cb.setNome(rs.getString("cidade.nome"));
            cb.setEstado(rs.getString("estado.nome"));
            cb.setPais(rs.getString("pais.nome"));
            
            CidadeLista.add(cb);
        }
        rs.close();
        stmt.close();
        return CidadeLista;
    }
}