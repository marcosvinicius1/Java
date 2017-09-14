/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.sac.dao;

import br.com.atmatech.sac.beans.AtendimentoBeans;
import br.com.atmatech.sac.beans.DBConfigBeans;
import br.com.atmatech.sac.connection.ConexaoDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author marcos
 */
public class AtendimentoDao {
    SimpleDateFormat sdfb = new SimpleDateFormat("dd.MM.yyyy");
    SimpleDateFormat sdfbH = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
    SimpleDateFormat sdfa = new SimpleDateFormat("yyyy.MM.dd");
    SimpleDateFormat sdfah = new SimpleDateFormat("yyyy.MM.dd  HH:mm:ss");

    public Integer setAtendimento(AtendimentoBeans ab) throws SQLException {
        try (Connection conexao = new ConexaoDb().getConnect()) {
            String sql = "INSERT INTO ATENDIMENTO (IDPESSOA, IDTECNICO, IDABERTURA, DTABERTURA, DTINICIAL, DTFINAL, STATUS, ATIVO, "
                    + "SOLICITANTE, TIPO, SOLICITACAO, REALIZADO, PENDENTE,idveiculo,kminicial,kmfinal,anotacao,idempresa) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?)";
            PreparedStatement pstm = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            pstm.setInt(1, ab.getIDPESSOA());
            pstm.setInt(2, ab.getIDTECNICO());
            pstm.setInt(3, ab.getIDABERTURA());
            if(ab.getDTABERTURA()!=null){
            pstm.setString(4, sdfah.format(ab.getDTABERTURA()));    
            }else{
                pstm.setString(4, null);
            }
            if(ab.getDTINICIAL()!=null){
            pstm.setString(5, sdfah.format(ab.getDTINICIAL()));    
            }else{
                pstm.setString(5, null);
            }
            if(ab.getDTFINAL()!=null){
                pstm.setString(6, sdfah.format(ab.getDTFINAL()));
            }else{
                pstm.setString(6, null);
            }            
            pstm.setString(7, ab.getSTATUS());
            pstm.setString(8, Boolean.toString(ab.getATIVO()));
            pstm.setString(9, ab.getSOLICITANTE());
            pstm.setString(10, ab.getTIPO());
            pstm.setString(11, ab.getSOLICITACAO());
            pstm.setString(12, ab.getREALIZADO());
            pstm.setString(13, ab.getPENDENTE());
            if (ab.getIdveiculo() == null) {
                pstm.setNull(14, java.sql.Types.INTEGER);
            } else {
                pstm.setInt(14, ab.getIdveiculo());
            }
            pstm.setDouble(15, ab.getKminicial());
            pstm.setDouble(16, ab.getKmfinal());
            pstm.setString(17, ab.getAnotacao());
            pstm.setInt(18, new DBConfigBeans().getCompany());
            pstm.execute();            
            ResultSet rs =pstm.getGeneratedKeys();
            Integer idatendimento = 0;
            while (rs.next()) {
                idatendimento = rs.getInt(1);
            }
            pstm.close();
            conexao.close();
            return idatendimento;

        }
    }

    //usado na abertura da tela de listaatendimento
    public List<AtendimentoBeans> getAtendimento(String tipo,String status, Integer idtecnico, Boolean supervisor, Date ini, Date fin, String tpdata) throws SQLException {
       
        try (Connection conexao = new ConexaoDb().getConnect()) {
            String dtini = sdfa.format(ini);
            String dtfin = sdfa.format(fin);
            String sql;             
            if (supervisor) {
                sql = "select atendimento.*,tecnico.nome tecnico,abertura.nome tecnicoabertura,tecnicoante.nome tecnicoanterior,pessoa.*,distrito.distrito,modulo.descricao modulo,placa from atendimento\n"
                        + " left join pessoa on(atendimento.idpessoa=pessoa.idpessoa)\n"
                        + " left join usuario tecnico on(atendimento.idtecnico=tecnico.idusuario)\n"
                        + " left join usuario abertura on(atendimento.idabertura=abertura.idusuario)\n"
                        + " left join  usuario tecnicoante on(atendimento.idtecnicoanterior=tecnicoante.idusuario)\n"
                        + " left join veiculo on(atendimento.idveiculo=veiculo.idveiculo)"
                        + " inner join  distrito on(pessoa.iddistrito=distrito.iddistrito)\n"
                        + " inner join modulo on(pessoa.idmodulo=modulo.idmodulo)\n"
                        + " where atendimento.ativo='true' and tipo in("+tipo+") and status in( " + status + ") and cast(atendimento." + tpdata + " as date) between '" + dtini + "' and '" + dtfin + "' and atendimento.idempresa=" + new DBConfigBeans().getCompany() + " order by atendimento.idatendimento";
            } else {
                sql = "select atendimento.*,tecnico.nome tecnico,abertura.nome tecnicoabertura,tecnicoante.nome tecnicoanterior,pessoa.*,distrito.distrito,modulo.descricao modulo,placa from atendimento\n"
                        + " left join pessoa on(atendimento.idpessoa=pessoa.idpessoa)\n"
                        + " left join usuario tecnico on(atendimento.idtecnico=tecnico.idusuario)\n"
                        + " left join usuario abertura on(atendimento.idabertura=abertura.idusuario)\n"
                        + " left join  usuario tecnicoante on(atendimento.idtecnicoanterior=tecnicoante.idusuario)\n"
                        + " left join veiculo on(atendimento.idveiculo=veiculo.idveiculo)"
                        + " inner join  distrito on(pessoa.iddistrito=distrito.iddistrito)\n"
                        + " inner join modulo on(pessoa.idmodulo=modulo.idmodulo)\n"
                        + " where atendimento.ativo='true' and tipo in("+tipo+") and status in( " + status + ") and ((idtecnico=?) or (idtecnico=1)) and cast(atendimento." + tpdata + " as date) between '" + dtini + "' and '" + dtfin + "' and atendimento.idempresa=" + new DBConfigBeans().getCompany() + " order by atendimento.idatendimento";
            }
            PreparedStatement pstm = conexao.prepareStatement(sql);            
            if (!supervisor) {
                pstm.setInt(1, idtecnico);
            }
            ResultSet rs = pstm.executeQuery();
            List<AtendimentoBeans> lab = new ArrayList<>();
            while (rs.next()) {
                AtendimentoBeans ab = new AtendimentoBeans();
                ab.setIDATENDIMENTO(rs.getInt("idatendimento"));
                ab.setIDPESSOA(rs.getInt("idpessoa"));
                ab.setIDTECNICO(rs.getInt("idtecnico"));
                ab.setIDABERTURA(rs.getInt("idabertura"));
                ab.setDTABERTURA(rs.getTimestamp("dtabertura"));
                ab.setDTINICIAL(rs.getTimestamp("dtinicial"));
                ab.setDTFINAL(rs.getTimestamp("dtfinal"));
                ab.setSTATUS(rs.getString("status"));
                ab.setATIVO(rs.getBoolean("ativo"));
                ab.setSOLICITANTE(rs.getString("solicitante"));
                ab.setTIPO(rs.getString("tipo"));
                ab.setSOLICITACAO(rs.getString("solicitacao"));
                ab.setREALIZADO(rs.getString("realizado"));
                ab.setPENDENTE(rs.getString("pendente"));
                ab.setIDTECNICOANTERIOR(rs.getInt("idtecnicoanterior"));
                ab.setTecniconome(rs.getString("tecnico"));
                ab.setAberturanome(rs.getString("tecnicoabertura"));
                ab.setTecanteriornome(rs.getString("tecnicoanterior"));
                ab.setRazao(rs.getString("razao"));
                ab.setObsatend(rs.getString("obsatend"));
                ab.setFantasia(rs.getString("fantasia"));
                ab.setResponsavel(rs.getString("responsavel"));
                ab.setModulo(rs.getString("modulo"));
                ab.setTelefone1(rs.getString("telefone1"));
                ab.setSOLICITANTE(rs.getString("solicitante"));
                ab.setDistrito(rs.getString("distrito"));
                ab.setNumero(rs.getString("numero"));
                ab.setEndereco(rs.getString("endereco"));
                ab.setBairro(rs.getString("bairro"));
                ab.setEmail(rs.getString("email"));
                ab.setIdveiculo(rs.getInt("idveiculo"));
                ab.setKminicial(rs.getDouble("kminicial"));
                ab.setKmfinal(rs.getDouble("kmfinal"));
                ab.setPlaca(rs.getString("placa"));
                ab.setAnotacao(rs.getString("anotacao"));
                ab.setEcf(rs.getBoolean("ecf"));
                ab.setNfe(rs.getBoolean("nfe"));
                ab.setPlugins(rs.getDate("dtplugin"));
                ab.setNfce(rs.getBoolean("nfce"));
                lab.add(ab);
            }
            pstm.close();
            rs.close();
            conexao.close();
            return lab;
        }
    }

    //usado na filtragem de chamao na tela listaatendimento
    public List<AtendimentoBeans> getAtendimento(String status, String campo, String parametro, Integer idtecnico, Boolean supervisor, Date ini, Date fin, String tpdata) {
        

        try (Connection conexao = new ConexaoDb().getConnect()) {
            String dtini = sdfa.format(ini);
            String dtfin = sdfa.format(fin);
            String sql;
            if (supervisor) {

                sql = "select atendimento.*,tecnico.nome tecnico,abertura.nome tecnicoabertura,tecnicoante.nome tecnicoanterior,pessoa.*,distrito.distrito,modulo.descricao modulo,placa from atendimento\n"
                        + " left join pessoa on(atendimento.idpessoa=pessoa.idpessoa)\n"
                        + " left join usuario tecnico on(atendimento.idtecnico=tecnico.idusuario)\n"
                        + " left join usuario abertura on(atendimento.idabertura=abertura.idusuario)\n"
                        + " left join  usuario tecnicoante on(atendimento.idtecnicoanterior=tecnicoante.idusuario)\n"
                        + " left join veiculo on(atendimento.idveiculo=veiculo.idveiculo)"
                        + " inner join  distrito on(pessoa.iddistrito=distrito.iddistrito)\n"
                        + " inner join modulo on(pessoa.idmodulo=modulo.idmodulo)\n"
                        + " where atendimento.ativo='true' and status in( " + status + ") and " + campo + " " + parametro + " and cast(atendimento." + tpdata + " as date) between '" + dtini + "' and '" + dtfin + "' and atendimento.idempresa=" + new DBConfigBeans().getCompany() + "";

            } else {

                sql = "select atendimento.*,tecnico.nome tecnico,abertura.nome tecnicoabertura,tecnicoante.nome tecnicoanterior,pessoa.*,distrito.distrito,modulo.descricao modulo,placa from atendimento\n"
                        + " left join pessoa on(atendimento.idpessoa=pessoa.idpessoa)\n"
                        + " left join usuario tecnico on(atendimento.idtecnico=tecnico.idusuario)\n"
                        + " left join usuario abertura on(atendimento.idabertura=abertura.idusuario)\n"
                        + " left join  usuario tecnicoante on(atendimento.idtecnicoanterior=tecnicoante.idusuario)\n"
                        + " left join veiculo on(atendimento.idveiculo=veiculo.idveiculo)"
                        + " inner join  distrito on(pessoa.iddistrito=distrito.iddistrito)\n"
                        + " inner join modulo on(pessoa.idmodulo=modulo.idmodulo)\n"
                        + " where atendimento.ativo='true' and status in( " + status + ") and " + campo + " " + parametro + " and ((idtecnico=?) or (idtecnico=1)) and cast(atendimento." + tpdata + " as date) between '" + dtini + "' and '" + dtfin + "' and atendimento.idempresa=" + new DBConfigBeans().getCompany() + "";

            }

            PreparedStatement pstm = conexao.prepareStatement(sql);
            if (!supervisor) {
                pstm.setInt(1, idtecnico);
            }

            ResultSet rs = pstm.executeQuery();
            List<AtendimentoBeans> lab = new ArrayList<>();
            while (rs.next()) {
                AtendimentoBeans ab = new AtendimentoBeans();
                ab.setIDATENDIMENTO(rs.getInt("idatendimento"));
                ab.setIDPESSOA(rs.getInt("idpessoa"));
                ab.setIDTECNICO(rs.getInt("idtecnico"));
                ab.setIDABERTURA(rs.getInt("idabertura"));
                ab.setDTABERTURA(rs.getTimestamp("dtabertura"));
                ab.setDTINICIAL(rs.getTimestamp("dtinicial"));
                ab.setDTFINAL(rs.getTimestamp("dtfinal"));
                ab.setSTATUS(rs.getString("status"));
                ab.setATIVO(rs.getBoolean("ativo"));
                ab.setSOLICITANTE(rs.getString("solicitante"));
                ab.setTIPO(rs.getString("tipo"));
                ab.setSOLICITACAO(rs.getString("solicitacao"));
                ab.setREALIZADO(rs.getString("realizado"));
                ab.setPENDENTE(rs.getString("pendente"));
                ab.setIDTECNICOANTERIOR(rs.getInt("idtecnicoanterior"));
                ab.setTecniconome(rs.getString("tecnico"));
                ab.setAberturanome(rs.getString("tecnicoabertura"));
                ab.setTecanteriornome(rs.getString("tecnicoanterior"));
                ab.setRazao(rs.getString("razao"));
                ab.setFantasia(rs.getString("fantasia"));
                ab.setResponsavel(rs.getString("responsavel"));
                ab.setModulo(rs.getString("modulo"));
                ab.setTelefone1(rs.getString("telefone1"));
                ab.setSOLICITANTE(rs.getString("solicitante"));
                ab.setDistrito(rs.getString("distrito"));
                ab.setNumero(rs.getString("numero"));
                ab.setEndereco(rs.getString("endereco"));
                ab.setBairro(rs.getString("bairro"));
                ab.setEmail(rs.getString("email"));
                ab.setIdveiculo(rs.getInt("idveiculo"));
                ab.setKminicial(rs.getDouble("kminicial"));
                ab.setKmfinal(rs.getDouble("kmfinal"));
                ab.setPlaca(rs.getString("placa"));
                ab.setAnotacao(rs.getString("anotacao"));
                ab.setEcf(rs.getBoolean("ecf"));
                ab.setNfe(rs.getBoolean("nfe"));
                ab.setPlugins(rs.getDate("dtplugin"));
                ab.setNfce(rs.getBoolean("nfce"));
                ab.setObsatend(rs.getString("obsatend"));
                lab.add(ab);
            }
            pstm.close();
            rs.close();
            conexao.close();
            return lab;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar Atendimento\n" + ex, "Atendimento", JOptionPane.ERROR_MESSAGE);
            return null;
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Converter Dados\n" + ex, "Atendimento", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
//utilizado na tela de atendimento do atendimento selecionado

    public AtendimentoBeans getAtendimento(Integer idatendimento) {
        try (Connection conexao = new ConexaoDb().getConnect()) {
            String sql;
            sql = "select atendimento.*,tecnico.nome tecnico,abertura.nome tecnicoabertura,tecnicoante.nome tecnicoanterior,pessoa.*,distrito.distrito,modulo.descricao modulo,placa,tecnicoedit.nome nometecnicoedit from atendimento\n"
                    + " left join pessoa on(atendimento.idpessoa=pessoa.idpessoa)\n"
                    + " left join usuario tecnico on(atendimento.idtecnico=tecnico.idusuario)\n"
                    + " left join usuario abertura on(atendimento.idabertura=abertura.idusuario)\n"
                    + " left join  usuario tecnicoante on(atendimento.idtecnicoanterior=tecnicoante.idusuario)\n"
                    + " left join veiculo on(atendimento.idveiculo=veiculo.idveiculo)"
                    + " inner join  distrito on(pessoa.iddistrito=distrito.iddistrito)\n"
                    + " inner join modulo on(pessoa.idmodulo=modulo.idmodulo)\n"
                    + "left join usuario tecnicoedit on(tecnicoedit.idusuario=atendimento.idtecnicoedit)"
                    + " where atendimento.idatendimento=? and atendimento.idempresa=" + new DBConfigBeans().getCompany() + "";

            PreparedStatement pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, idatendimento);
            ResultSet rs = pstm.executeQuery();
            AtendimentoBeans ab = new AtendimentoBeans();
            while (rs.next()) {
                ab.setIDATENDIMENTO(rs.getInt("idatendimento"));
                ab.setIDPESSOA(rs.getInt("idpessoa"));
                ab.setIDTECNICO(rs.getInt("idtecnico"));
                ab.setIDABERTURA(rs.getInt("idabertura"));
                ab.setDTABERTURA(rs.getTimestamp("dtabertura"));
                ab.setDTINICIAL(rs.getTimestamp("dtinicial"));
                ab.setDTFINAL(rs.getTimestamp("dtfinal"));
                ab.setSTATUS(rs.getString("status"));
                ab.setATIVO(rs.getBoolean("ativo"));
                ab.setSOLICITANTE(rs.getString("solicitante"));
                ab.setTIPO(rs.getString("tipo"));
                ab.setSOLICITACAO(rs.getString("solicitacao"));
                ab.setREALIZADO(rs.getString("realizado"));
                ab.setPENDENTE(rs.getString("pendente"));
                ab.setIDTECNICOANTERIOR(rs.getInt("idtecnicoanterior"));
                ab.setTecniconome(rs.getString("tecnico"));
                ab.setAberturanome(rs.getString("tecnicoabertura"));
                ab.setTecanteriornome(rs.getString("tecnicoanterior"));
                ab.setRazao(rs.getString("razao"));
                ab.setFantasia(rs.getString("fantasia"));
                ab.setResponsavel(rs.getString("responsavel"));
                ab.setModulo(rs.getString("modulo"));
                ab.setTelefone1(rs.getString("telefone1"));
                ab.setSOLICITANTE(rs.getString("solicitante"));
                ab.setDistrito(rs.getString("distrito"));
                ab.setNumero(rs.getString("numero"));
                ab.setEndereco(rs.getString("endereco"));
                ab.setBairro(rs.getString("bairro"));
                ab.setEmail(rs.getString("email"));
                ab.setIdveiculo(rs.getInt("idveiculo"));
                ab.setKminicial(rs.getDouble("kminicial"));
                ab.setKmfinal(rs.getDouble("kmfinal"));
                ab.setPlaca(rs.getString("placa"));
                ab.setAnotacao(rs.getString("anotacao"));
                ab.setEcf(rs.getBoolean("ecf"));
                ab.setNfe(rs.getBoolean("nfe"));
                ab.setPlugins(rs.getDate("dtplugin"));
                ab.setNfce(rs.getBoolean("nfce"));
                ab.setObsatend(rs.getString("obsatend"));
                ab.setIdtecnicoedit(rs.getInt("idtecnicoedit"));
                ab.setNometecnicoedit(rs.getString("nometecnicoedit"));
            }
            pstm.close();
            rs.close();
            conexao.close();
            return ab;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar Atendimento\n" + ex, "Atendimento", JOptionPane.ERROR_MESSAGE);
            return null;
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Converter Dados\n" + ex, "Atendimento", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public void updateAtendimento(AtendimentoBeans ab) throws SQLException {
        try (Connection conexao = new ConexaoDb().getConnect()) {
            String sql = "UPDATE ATENDIMENTO"
                    + " SET IDPESSOA = ?,"
                    + "    IDTECNICO = ?,"
                    + "    IDABERTURA = ?,"
                    + "    DTABERTURA = ?,"
                    + "    DTINICIAL = ?,"
                    + "    DTFINAL = ?,"
                    + "    STATUS = ?,"
                    + "    ATIVO = ?,"
                    + "    SOLICITANTE = ?,"
                    + "    TIPO = ?,"
                    + "    SOLICITACAO = ?,"
                    + "    REALIZADO = ?,"
                    + "    PENDENTE = ?,"
                    + "    IDTECNICOANTERIOR = ?,"
                    + "    IDVEICULO= ?,"
                    + "    KMINICIAL= ?,"
                    + "    KMFINAL= ?,"
                    + "    ANOTACAO= ?,"
                    + "    idtecnicoedit=?"
                    
                    + " WHERE (IDATENDIMENTO = ?)";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, ab.getIDPESSOA());
            pstm.setInt(2, ab.getIDTECNICO());
            pstm.setInt(3, ab.getIDABERTURA());
            if(ab.getDTABERTURA()!=null){
            pstm.setString(4, sdfah.format(ab.getDTABERTURA()));    
            }else{
                pstm.setString(4, null);
            }
            if(ab.getDTINICIAL()!=null){
            pstm.setString(5, sdfah.format(ab.getDTINICIAL()));    
            }else{
                pstm.setString(5, null);
            }
            if(ab.getDTFINAL()!=null){
                pstm.setString(6, sdfah.format(ab.getDTFINAL()));
            }else{
                pstm.setString(6, null);
            }
            pstm.setString(7, ab.getSTATUS());
            pstm.setString(8, Boolean.toString(ab.getATIVO()));
            pstm.setString(9, ab.getSOLICITANTE());
            pstm.setString(10, ab.getTIPO());
            pstm.setString(11, ab.getSOLICITACAO());
            pstm.setString(12, ab.getREALIZADO());
            pstm.setString(13, ab.getPENDENTE());
            String idtecnicoanterior;
            if (ab.getIDTECNICOANTERIOR() == 0) {
                idtecnicoanterior = null;
            } else {
                idtecnicoanterior = ab.getIDTECNICOANTERIOR().toString();
            }
            pstm.setString(14, idtecnicoanterior);
            if (ab.getIdveiculo() == null) {
                pstm.setNull(15, java.sql.Types.INTEGER);
            } else {
                pstm.setInt(15, ab.getIdveiculo());
            }
            pstm.setDouble(16, ab.getKminicial());
            pstm.setDouble(17, ab.getKmfinal());
            pstm.setString(18, ab.getAnotacao());
            pstm.setInt(19, ab.getIdtecnicoedit());
            pstm.setInt(20, ab.getIDATENDIMENTO());
            pstm.execute();
            pstm.close();
            conexao.close();
        }
    }

    public void deleteAtendimento(Integer idatendimento) throws SQLException {
        try (Connection conexao = new ConexaoDb().getConnect()) {
            String sql = "update atendimento set ativo='false' where idatendimento=?";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, idatendimento);
            pstm.execute();
            pstm.close();
            conexao.close();
        }
    }

    public List<AtendimentoBeans> getAjuda(String sql2) {
        try (Connection conexao = new ConexaoDb().getConnect()) {
            String sql;
            sql = "select solicitacao,realizado from atendimento where atendimento.idempresa=" + new DBConfigBeans().getCompany() + " " + sql2;
            PreparedStatement pstm = conexao.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            List<AtendimentoBeans> lab = new ArrayList<>();
            while (rs.next()) {
                AtendimentoBeans ab = new AtendimentoBeans();
                ab.setSOLICITACAO(rs.getString("solicitacao").replaceAll("\n", " "));
                ab.setREALIZADO(rs.getString("realizado").replaceAll("\n", " "));
                lab.add(ab);
            }
            pstm.close();
            rs.close();
            conexao.close();
            return lab;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar Atendimento\n" + ex, "Atendimento", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
