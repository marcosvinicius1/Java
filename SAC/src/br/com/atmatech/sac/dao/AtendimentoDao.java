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

    public Integer setAtendimento(AtendimentoBeans ab) throws SQLException {
        try (Connection conexao = new ConexaoDb().getConnect()) {
            String sql = "INSERT INTO ATENDIMENTO (IDPESSOA, IDTECNICO, IDABERTURA, DTABERTURA, DTINICIAL, DTFINAL, STATUS, ATIVO, "
                    + "SOLICITANTE, TIPO, SOLICITACAO, REALIZADO, PENDENTE,idveiculo,kminicial,kmfinal,anotacao,idempresa) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?) returning idatendimento";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, ab.getIDPESSOA());

            pstm.setInt(2, ab.getIDTECNICO());

            pstm.setInt(3, ab.getIDABERTURA());
            pstm.setTimestamp(4, ab.getDTABERTURA());
            pstm.setTimestamp(5, ab.getDTINICIAL());
            pstm.setTimestamp(6, ab.getDTFINAL());
            pstm.setString(7, ab.getSTATUS());
            pstm.setBoolean(8, ab.getATIVO());
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
            ResultSet rs = pstm.executeQuery();
            Integer idatendimento = 0;
            while (rs.next()) {
                idatendimento = rs.getInt("idatendimento");
            }
            pstm.close();
            conexao.close();
            return idatendimento;

        }
    }

    //usado na abertura da tela de listaatendimento
    public List<AtendimentoBeans> getAtendimento(String status, Integer idtecnico, Boolean supervisor, Date ini, Date fin, String tpdata) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

        try (Connection conexao = new ConexaoDb().getConnect()) {
            String dtini = sdf.format(ini);
            String dtfin = sdf.format(fin);
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
                        + " where atendimento.ativo='true' and status in( " + status + ") and cast(atendimento." + tpdata + " as date) between '" + dtini + "' and '" + dtfin + "' and atendimento.idempresa="+new DBConfigBeans().getCompany()+" order by atendimento.idatendimento";
            } else {
                sql = "select atendimento.*,tecnico.nome tecnico,abertura.nome tecnicoabertura,tecnicoante.nome tecnicoanterior,pessoa.*,distrito.distrito,modulo.descricao modulo,placa from atendimento\n"
                        + " left join pessoa on(atendimento.idpessoa=pessoa.idpessoa)\n"
                        + " left join usuario tecnico on(atendimento.idtecnico=tecnico.idusuario)\n"
                        + " left join usuario abertura on(atendimento.idabertura=abertura.idusuario)\n"
                        + " left join  usuario tecnicoante on(atendimento.idtecnicoanterior=tecnicoante.idusuario)\n"
                        + " left join veiculo on(atendimento.idveiculo=veiculo.idveiculo)"
                        + " inner join  distrito on(pessoa.iddistrito=distrito.iddistrito)\n"
                        + " inner join modulo on(pessoa.idmodulo=modulo.idmodulo)\n"
                        + " where atendimento.ativo='true' and status in( " + status + ") and ((idtecnico=?) or (idtecnico=1)) and cast(atendimento." + tpdata + " as date) between '" + dtini + "' and '" + dtfin + "' and atendimento.idempresa="+new DBConfigBeans().getCompany()+" order by atendimento.idatendimento";
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
            JOptionPane.showMessageDialog(null, "Erro no Formato da Data\n" + ex, "Atendimento", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    //usado na filtragem de chamao na tela listaatendimento
    public List<AtendimentoBeans> getAtendimento(String status, String campo, String parametro, Integer idtecnico, Boolean supervisor, Date ini, Date fin, String tpdata) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

        try (Connection conexao = new ConexaoDb().getConnect()) {
            String dtini = sdf.format(ini);
            String dtfin = sdf.format(fin);
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
                        + " where atendimento.ativo='true' and status in( " + status + ") and " + campo + " " + parametro + " and cast(atendimento." + tpdata + " as date) between '" + dtini + "' and '" + dtfin + "' and atendimento.idempresa="+new DBConfigBeans().getCompany()+"";

            } else {

                sql = "select atendimento.*,tecnico.nome tecnico,abertura.nome tecnicoabertura,tecnicoante.nome tecnicoanterior,pessoa.*,distrito.distrito,modulo.descricao modulo,placa from atendimento\n"
                        + " left join pessoa on(atendimento.idpessoa=pessoa.idpessoa)\n"
                        + " left join usuario tecnico on(atendimento.idtecnico=tecnico.idusuario)\n"
                        + " left join usuario abertura on(atendimento.idabertura=abertura.idusuario)\n"
                        + " left join  usuario tecnicoante on(atendimento.idtecnicoanterior=tecnicoante.idusuario)\n"
                        + " left join veiculo on(atendimento.idveiculo=veiculo.idveiculo)"
                        + " inner join  distrito on(pessoa.iddistrito=distrito.iddistrito)\n"
                        + " inner join modulo on(pessoa.idmodulo=modulo.idmodulo)\n"
                        + " where atendimento.ativo='true' and status in( " + status + ") and " + campo + " " + parametro + " and ((idtecnico=?) or (idtecnico=1)) and cast(atendimento." + tpdata + " as date) between '" + dtini + "' and '" + dtfin + "' and atendimento.idempresa="+new DBConfigBeans().getCompany()+"";

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
            JOptionPane.showMessageDialog(null, "Erro no Formato da Data\n" + ex, "Atendimento", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
//utilizado na tela de atendimento do atendimento selecionado
    public AtendimentoBeans getAtendimento(Integer idatendimento) {        
        try (Connection conexao = new ConexaoDb().getConnect()) {
            String sql;
            sql = "select atendimento.*,tecnico.nome tecnico,abertura.nome tecnicoabertura,tecnicoante.nome tecnicoanterior,pessoa.*,distrito.distrito,modulo.descricao modulo,placa from atendimento\n"
                    + " left join pessoa on(atendimento.idpessoa=pessoa.idpessoa)\n"
                    + " left join usuario tecnico on(atendimento.idtecnico=tecnico.idusuario)\n"
                    + " left join usuario abertura on(atendimento.idabertura=abertura.idusuario)\n"
                    + " left join  usuario tecnicoante on(atendimento.idtecnicoanterior=tecnicoante.idusuario)\n"
                    + " left join veiculo on(atendimento.idveiculo=veiculo.idveiculo)"
                    + " inner join  distrito on(pessoa.iddistrito=distrito.iddistrito)\n"
                    + " inner join modulo on(pessoa.idmodulo=modulo.idmodulo)\n"
                    + " where atendimento.idatendimento=? and atendimento.idempresa="+new DBConfigBeans().getCompany()+"";

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
            }
            pstm.close();
            rs.close();
            conexao.close();
            return ab;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar Atendimento\n" + ex, "Atendimento", JOptionPane.ERROR_MESSAGE);
            return null;
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Erro no Formato da Data\n" + ex, "Atendimento", JOptionPane.ERROR_MESSAGE);
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
                    + "    ANOTACAO= ?"
                    + " WHERE (IDATENDIMENTO = ?)";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, ab.getIDPESSOA());
            pstm.setInt(2, ab.getIDTECNICO());
            pstm.setInt(3, ab.getIDABERTURA());
            pstm.setTimestamp(4, ab.getDTABERTURA());
            pstm.setTimestamp(5, ab.getDTINICIAL());
            pstm.setTimestamp(6, ab.getDTFINAL());
            pstm.setString(7, ab.getSTATUS());
            pstm.setBoolean(8, ab.getATIVO());
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
            pstm.setInt(19, ab.getIDATENDIMENTO());
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
}
