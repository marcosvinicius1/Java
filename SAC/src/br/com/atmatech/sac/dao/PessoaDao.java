/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.sac.dao;

import br.com.atmatech.sac.beans.DBConfigBeans;
import br.com.atmatech.sac.beans.PessoaBeans;
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
 * @author MARCOS
 */
public class PessoaDao {

    //utilizado na abertura da ViewPessoa
    public List<PessoaBeans> getPessoa() {
        try (Connection conexao = new ConexaoDb().getConnect()) {
            String sql = "select * from pessoa left join "
                    + "distrito on(pessoa.iddistrito=distrito.iddistrito) where idempresa=" + new DBConfigBeans().getCompany() + " order by razao";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            List<PessoaBeans> lpb = new ArrayList<>();
            while (rs.next()) {
                PessoaBeans pb = new PessoaBeans();
                pb.setIdpessoa(rs.getInt("idpessoa"));
                pb.setRazao(rs.getString("razao"));
                pb.setFantasia(rs.getString("fantasia"));
                pb.setCnpj(rs.getString("cnpj"));
                pb.setIe(rs.getString("ie"));
                pb.setEndereco(rs.getString("endereco"));
                pb.setIddistrito(rs.getInt("iddistrito"));
                pb.setDistrito(rs.getString("distrito"));
                pb.setNumero(rs.getString("numero"));
                pb.setEmail(rs.getString("email"));
                pb.setIdmodulo(rs.getInt("idmodulo"));
                pb.setTelefone1(rs.getString("telefone1"));
                pb.setTelefone2(rs.getString("telefone2"));
                pb.setTelefone3(rs.getString("telefone3"));
                pb.setIdsituacao(rs.getInt("idsituacao"));
                pb.setObs(rs.getString("obs"));
                pb.setBairro(rs.getString("bairro"));
                pb.setResponsavel(rs.getString("responsavel"));
                pb.setEcf(rs.getBoolean("ecf"));
                pb.setNfe(rs.getBoolean("nfe"));
                pb.setPlugins(rs.getDate("dtplugin"));
                pb.setNfce(rs.getBoolean("nfce"));
                lpb.add(pb);
            }
            pstm.close();
            rs.close();
            return lpb;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Consultar Clientes\n" + ex);
            return null;
        }
    }

    //utilizado na consulta da grid da ViewPessoa
    public List<PessoaBeans> getPessoa(String coluna, String parametro, String ordenar) {
        try (Connection conexao = new ConexaoDb().getConnect()) {
            String sql = "select * from pessoa left join "
                    + "distrito on(pessoa.iddistrito=distrito.iddistrito) where " + coluna + " like '%" + parametro + "%' and idempresa=" + new DBConfigBeans().getCompany() + " order by " + ordenar;
            PreparedStatement pstm = conexao.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            List<PessoaBeans> lpb = new ArrayList<>();
            while (rs.next()) {
                PessoaBeans pb = new PessoaBeans();
                pb.setIdpessoa(rs.getInt("idpessoa"));
                pb.setRazao(rs.getString("razao"));
                pb.setFantasia(rs.getString("fantasia"));
                pb.setCnpj(rs.getString("cnpj"));
                pb.setIe(rs.getString("ie"));
                pb.setEndereco(rs.getString("endereco"));
                pb.setIddistrito(rs.getInt("iddistrito"));
                pb.setDistrito(rs.getString("distrito"));
                pb.setNumero(rs.getString("numero"));
                pb.setEmail(rs.getString("email"));
                pb.setIdmodulo(rs.getInt("idmodulo"));
                pb.setTelefone1(rs.getString("telefone1"));
                pb.setTelefone2(rs.getString("telefone2"));
                pb.setTelefone3(rs.getString("telefone3"));
                pb.setIdsituacao(rs.getInt("idsituacao"));
                pb.setObs(rs.getString("obs"));
                pb.setBairro(rs.getString("bairro"));
                pb.setResponsavel(rs.getString("responsavel"));
                pb.setEcf(rs.getBoolean("ecf"));
                pb.setNfe(rs.getBoolean("nfe"));
                pb.setPlugins(rs.getDate("dtplugin"));
                pb.setNfce(rs.getBoolean("nfce"));
                lpb.add(pb);
            }
            pstm.close();
            rs.close();
            return lpb;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Consultar Clientes\n" + ex);
            return null;
        }
    }

    //utiliza na consulta de clientes na abertura de chamados
    public List<PessoaBeans> getPessoaAtivo(String parametro, String ordenar) {
        try (Connection conexao = new ConexaoDb().getConnect()) {
            String sql = "select * from pessoa left join distrito on(pessoa.iddistrito=distrito.iddistrito) "
                    + "LEFT JOIN MODULO ON (PESSOA.idmodulo=MODULO.idmodulo) "
                    + "where ((razao like '%" + parametro + "%') or (fantasia like '%" + parametro + "%') or (cnpj like '%" + parametro + "%')) and idsituacao=1 and pessoa.idempresa=" + new DBConfigBeans().getCompany() + " order by " + ordenar;
            PreparedStatement pstm = conexao.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            List<PessoaBeans> lpb = new ArrayList<>();
            while (rs.next()) {
                PessoaBeans pb = new PessoaBeans();
                pb.setIdpessoa(rs.getInt("idpessoa"));
                pb.setRazao(rs.getString("razao"));
                pb.setFantasia(rs.getString("fantasia"));
                pb.setCnpj(rs.getString("cnpj"));
                pb.setIe(rs.getString("ie"));
                pb.setEndereco(rs.getString("endereco"));
                pb.setIddistrito(rs.getInt("iddistrito"));
                pb.setDistrito(rs.getString("distrito"));
                pb.setNumero(rs.getString("numero"));
                pb.setEmail(rs.getString("email"));
                pb.setIdmodulo(rs.getInt("idmodulo"));
                pb.setTelefone1(rs.getString("telefone1"));
                pb.setTelefone2(rs.getString("telefone2"));
                pb.setTelefone3(rs.getString("telefone3"));
                pb.setIdsituacao(rs.getInt("idsituacao"));
                pb.setObs(rs.getString("obs"));
                pb.setBairro(rs.getString("bairro"));
                pb.setResponsavel(rs.getString("responsavel"));
                pb.setModulo(rs.getString("descricao"));
                pb.setEcf(rs.getBoolean("ecf"));
                pb.setNfe(rs.getBoolean("nfe"));
                pb.setPlugins(rs.getDate("dtplugin"));
                pb.setNfce(rs.getBoolean("nfce"));
                lpb.add(pb);
            }
            pstm.close();
            rs.close();
            return lpb;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Consultar Clientes\n" + ex);
            return null;
        }
    }

    public void setPessoa(PessoaBeans pb) throws SQLException {
        try (Connection conexao = new ConexaoDb().getConnect()) {
            String sql = "insert into pessoa (RAZAO,FANTASIA,CNPJ,IE,ENDERECO,IDDISTRITO,NUMERO,EMAIL,IDMODULO,TELEFONE1,TELEFONE2,TELEFONE3,IDSITUACAO,OBS,BAIRRO,responsavel,nfe,ecf,dtplugin,idempresa,nfce) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            pstm.setString(1, pb.getRazao());
            pstm.setString(2, pb.getFantasia());
            pstm.setString(3, pb.getCnpj());
            pstm.setString(4, pb.getIe());
            pstm.setString(5, pb.getEndereco());
            pstm.setInt(6, pb.getIddistrito());
            pstm.setString(7, pb.getNumero());
            pstm.setString(8, pb.getEmail());
            pstm.setInt(9, pb.getIdmodulo());
            pstm.setString(10, pb.getTelefone1());
            pstm.setString(11, pb.getTelefone2());
            pstm.setString(12, pb.getTelefone3());
            pstm.setInt(13, pb.getIdsituacao());
            pstm.setString(14, pb.getObs());
            pstm.setString(15, pb.getBairro());
            pstm.setString(16, pb.getResponsavel());
            pstm.setBoolean(17, pb.isNfe());
            pstm.setBoolean(18, pb.isEcf());
            pstm.setDate(19, pb.getPlugins());
            pstm.setInt(20, new DBConfigBeans().getCompany());
            pstm.setBoolean(21, pb.isNfce());
            pstm.execute();
            pstm.close();
        }
    }

    public void deletePessoa(int idpessoa) throws SQLException {
        try (Connection conexao = new ConexaoDb().getConnect()) {
            String sql = "delete from pessoa where idpessoa=?";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, idpessoa);
            pstm.executeUpdate();
            pstm.close();
        }
    }

    public void updatePessoa(PessoaBeans pb) throws SQLException {
        try (Connection conexao = new ConexaoDb().getConnect()) {
            String sql = "update pessoa set RAZAO=?,FANTASIA=?,CNPJ=?,IE=?,ENDERECO=?,IDDISTRITO=?,NUMERO=?,EMAIL=?,"
                    + "IDMODULO=?,TELEFONE1=?,TELEFONE2=?,TELEFONE3=?,IDSITUACAO=?,OBS=?,BAIRRO=?,responsavel=?,"
                    + "NFE=?,ECF=?,DTPLUGIN=?,NFCE=? "
                    + "where idpessoa=?";

            PreparedStatement pstm = conexao.prepareStatement(sql);
            pstm.setString(1, pb.getRazao());
            pstm.setString(2, pb.getFantasia());
            pstm.setString(3, pb.getCnpj());
            pstm.setString(4, pb.getIe());
            pstm.setString(5, pb.getEndereco());
            pstm.setInt(6, pb.getIddistrito());
            pstm.setString(7, pb.getNumero());
            pstm.setString(8, pb.getEmail());
            pstm.setInt(9, pb.getIdmodulo());
            pstm.setString(10, pb.getTelefone1());
            pstm.setString(11, pb.getTelefone2());
            pstm.setString(12, pb.getTelefone3());
            pstm.setInt(13, pb.getIdsituacao());
            pstm.setString(14, pb.getObs());
            pstm.setString(15, pb.getBairro());
            pstm.setString(16, pb.getResponsavel());
            pstm.setBoolean(17, pb.isNfe());
            pstm.setBoolean(18, pb.isEcf());
            pstm.setDate(19, pb.getPlugins());
            pstm.setBoolean(20, pb.isNfce());
            pstm.setInt(21, pb.getIdpessoa());

            pstm.executeUpdate();
            pstm.close();
        }
    }

    //utilizado na busca inicial da abertura do atendimento
    public List<PessoaBeans> getPessoaAgrupada() {
        try (Connection conexao = new ConexaoDb().getConnect()) {
            String sql = "select p3.razao||' | '||p3.endereco||' | '||p3.idpessoa as razao from (select p1.razao,p1.idpessoa,p1.endereco from pessoa p1 where p1.idsituacao=1 \n"
                    + "union all \n"
                    + "select p2.fantasia,p2.idpessoa,p2.endereco from pessoa p2 where p2.idsituacao=1) p3 order by p3.idpessoa";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            List<PessoaBeans> lpb = new ArrayList<>();
            while (rs.next()) {
                PessoaBeans pb = new PessoaBeans();
                pb.setRazao(rs.getString("razao"));
                lpb.add(pb);
            }
            pstm.close();
            rs.close();
            return lpb;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Consultar Clientes\n" + ex);
            return null;
        }
    }

    public PessoaBeans getPessoaAtivo(Integer idpessoa) {
        try (Connection conexao = new ConexaoDb().getConnect()) {
            String sql = "select * from pessoa left join "
                    + "distrito on(pessoa.iddistrito=distrito.iddistrito) "
                    + "LEFT JOIN MODULO ON (PESSOA.idmodulo=MODULO.idmodulo) where pessoa.idpessoa=? and pessoa.idempresa=" + new DBConfigBeans().getCompany() + "";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, idpessoa);
            ResultSet rs = pstm.executeQuery();
            PessoaBeans pb = new PessoaBeans();
            while (rs.next()) {
                pb.setIdpessoa(rs.getInt("idpessoa"));
                pb.setRazao(rs.getString("razao"));
                pb.setFantasia(rs.getString("fantasia"));
                pb.setCnpj(rs.getString("cnpj"));
                pb.setIe(rs.getString("ie"));
                pb.setEndereco(rs.getString("endereco"));
                pb.setIddistrito(rs.getInt("iddistrito"));
                pb.setDistrito(rs.getString("distrito"));
                pb.setNumero(rs.getString("numero"));
                pb.setEmail(rs.getString("email"));
                pb.setIdmodulo(rs.getInt("idmodulo"));
                pb.setTelefone1(rs.getString("telefone1"));
                pb.setTelefone2(rs.getString("telefone2"));
                pb.setTelefone3(rs.getString("telefone3"));
                pb.setIdsituacao(rs.getInt("idsituacao"));
                pb.setObs(rs.getString("obs"));
                pb.setBairro(rs.getString("bairro"));
                pb.setResponsavel(rs.getString("responsavel"));
                pb.setModulo(rs.getString("descricao"));
                pb.setNfce(rs.getBoolean("nfce"));
            }
            pstm.close();
            rs.close();
            return pb;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Consultar Clientes\n" + ex);
            return null;
        }
    }
}
