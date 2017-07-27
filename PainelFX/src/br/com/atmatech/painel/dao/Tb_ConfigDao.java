/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.painel.dao;

import br.com.atmatech.painel.beans.Tb_ConfigBeans;
import br.com.atmatech.painel.beans.Tb_ConfigTempBeans;
import br.com.atmatech.painel.connection.ConexaoDBMySql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Marcos
 */
public class Tb_ConfigDao {
    public Tb_ConfigBeans getTB_Config(Integer terminal) throws SQLException{
        try(Connection conexao=new ConexaoDBMySql().getConnect()){
            String sql="select * from tb_config where terminal=?";
            PreparedStatement pstm=conexao.prepareStatement(sql);
            pstm.setInt(1, terminal);
            ResultSet rs=pstm.executeQuery();
            Tb_ConfigBeans tbc=new Tb_ConfigBeans();
            while(rs.next()){
                tbc.setIdtb_config(rs.getInt("idtb_config"));
                tbc.setTamanhox(rs.getInt("tamanhox"));
                tbc.setTamanhoy(rs.getInt("tamanhoy"));
                tbc.setLetreiro(rs.getBoolean("letreiro"));
                tbc.setTipolocalizacao(rs.getString("tipolocalizacao"));
                tbc.setTopoimagem(rs.getBytes("topoimagem"));
                tbc.setFundoimagem1(rs.getBytes("fundoimagem"));
                tbc.setLateralimagem(rs.getBytes("lateralimagem"));
                tbc.setTransparencia(rs.getBoolean("transparencia"));
                tbc.setLetreirotempo(rs.getInt("letreirotempo"));
                tbc.setLetreirocorfundo(rs.getInt("letreirocorfundo"));
                tbc.setLetreirotexto(rs.getString("letreirotexto"));
                tbc.setLetreirocorfonte(rs.getInt("letreirocorfonte"));
                tbc.setTabela1(rs.getBoolean("tabela01"));
                tbc.setTabela2(rs.getBoolean("tabela02"));
                tbc.setTabela3(rs.getBoolean("tabela03"));
                tbc.setTabela4(rs.getBoolean("tabela04"));
                tbc.setTabelacheia(rs.getBoolean("tabelacheia"));
                tbc.setTerminal(rs.getInt("terminal"));                                
                tbc.setCtcodigo(rs.getBoolean("ctcodigo"));
                tbc.setCtproduto(rs.getBoolean("ctproduto"));
                tbc.setCtunid(rs.getBoolean("ctunid"));
                tbc.setCtoferta(rs.getBoolean("ctoferta"));
                tbc.setCtvalor1(rs.getBoolean("ctvalor1"));
                tbc.setCtvalor2(rs.getBoolean("ctvalor2"));
                tbc.setNomevalor1(rs.getString("nomevalor1"));
                tbc.setNomevalor2(rs.getString("nomevalor2"));                
                tbc.setFonteTabela(rs.getInt("fontetabela"));
                tbc.setCorfontetabela(rs.getInt("corfontetabela"));
                tbc.setCorfundotabela(rs.getInt("corfundotabela"));
                tbc.setFonteestilotabela(rs.getInt("fonteestilotabela"));
                tbc.setFontetipotabela(rs.getString("fontetipotabela"));
                tbc.setEspacamento(rs.getInt("espacamento"));
                tbc.setTabela1nome(rs.getString("tabela1nome"));
                tbc.setTabela2nome(rs.getString("tabela2nome"));
                tbc.setTabela3nome(rs.getString("tabela3nome"));
                tbc.setTabela4nome(rs.getString("tabela4nome"));
                tbc.setTranspfundotabela(rs.getInt("transpfundotabela"));
            }
            rs.close();
            pstm.close();
            conexao.close();
            return tbc;
        }        
    }
    
    public Tb_ConfigTempBeans getTB_ConfigTemp(Integer terminal) throws SQLException{
        try(Connection conexao=new ConexaoDBMySql().getConnect()){
            String sql="select * from tb_config where terminal=?";
            PreparedStatement pstm=conexao.prepareStatement(sql);
            pstm.setInt(1, terminal);
            ResultSet rs=pstm.executeQuery();
            Tb_ConfigTempBeans tbc=new Tb_ConfigTempBeans();
            while(rs.next()){
                tbc.setIdtb_config(rs.getInt("idtb_config"));
                tbc.setTamanhox(rs.getInt("tamanhox"));
                tbc.setTamanhoy(rs.getInt("tamanhoy"));
                tbc.setLetreiro(rs.getBoolean("letreiro"));
                tbc.setTipolocalizacao(rs.getString("tipolocalizacao"));
                tbc.setTopoimagem(rs.getBytes("topoimagem"));
                tbc.setFundoimagem1(rs.getBytes("fundoimagem"));
                tbc.setLateralimagem(rs.getBytes("lateralimagem"));
                tbc.setTransparencia(rs.getBoolean("transparencia"));
                tbc.setLetreirotempo(rs.getInt("letreirotempo"));
                tbc.setLetreirocorfundo(rs.getInt("letreirocorfundo"));
                tbc.setLetreirotexto(rs.getString("letreirotexto"));
                tbc.setLetreirocorfonte(rs.getInt("letreirocorfonte"));
                tbc.setTabela1(rs.getBoolean("tabela01"));
                tbc.setTabela2(rs.getBoolean("tabela02"));
                tbc.setTabela3(rs.getBoolean("tabela03"));
                tbc.setTabela4(rs.getBoolean("tabela04"));
                tbc.setTabelacheia(rs.getBoolean("tabelacheia"));
                tbc.setTerminal(rs.getInt("terminal"));                                
                tbc.setCtcodigo(rs.getBoolean("ctcodigo"));
                tbc.setCtproduto(rs.getBoolean("ctproduto"));
                tbc.setCtunid(rs.getBoolean("ctunid"));
                tbc.setCtoferta(rs.getBoolean("ctoferta"));
                tbc.setCtvalor1(rs.getBoolean("ctvalor1"));
                tbc.setCtvalor2(rs.getBoolean("ctvalor2"));
                tbc.setNomevalor1(rs.getString("nomevalor1"));
                tbc.setNomevalor2(rs.getString("nomevalor2"));                
                tbc.setFonteTabela(rs.getInt("fontetabela"));
                tbc.setCorfontetabela(rs.getInt("corfontetabela"));
                tbc.setCorfundotabela(rs.getInt("corfundotabela"));
                tbc.setFonteestilotabela(rs.getInt("fonteestilotabela"));
                tbc.setFontetipotabela(rs.getString("fontetipotabela"));
                tbc.setEspacamento(rs.getInt("espacamento"));
                tbc.setTabela1nome(rs.getString("tabela1nome"));
                tbc.setTabela2nome(rs.getString("tabela2nome"));
                tbc.setTabela3nome(rs.getString("tabela3nome"));
                tbc.setTabela4nome(rs.getString("tabela4nome"));
                tbc.setTranspfundotabela(rs.getInt("transpfundotabela"));
            }
            rs.close();
            pstm.close();
            conexao.close();
            return tbc;
        }        
    }
    
    public int setTb_Config(Tb_ConfigBeans tbc) throws SQLException{
        try(Connection conexao=new ConexaoDBMySql().getConnect()){
            String sql="INSERT INTO tb_config (tamanhox, tamanhoy, letreiro, tipolocalizacao, topoimagem, fundoimagem, lateralimagem, "
                    + "transparencia, letreirotempo, letreirocorfonte, fontetabela, letreirocorfundo, letreirotexto, tabela01, tabela02, "
                    + "tabela03, tabela04, tabelacheia, terminal,ctcodigo,ctproduto,ctoferta,ctvalor1,ctvalor2,nomevalor1,nomevalor2,"
                    + "ctunid,corfontetabela,corfundotabela,fonteestilotabela,fontetipotabela,espacamento,tabela1nome,tabela2nome,tabela3nome,tabela4nome,transpfundotabela) "
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstm=conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            pstm.setInt(1, tbc.getTamanhox());
            pstm.setInt(2, tbc.getTamanhoy());
            pstm.setBoolean(3, tbc.isLetreiro());
            pstm.setString(4, tbc.getTipolocalizacao());
            pstm.setBytes(5, tbc.getTopoimagem());
            pstm.setBytes(6, tbc.getFundoimagem1());
            pstm.setBytes(7, tbc.getLateralimagem());
            pstm.setBoolean(8, tbc.isTransparencia());
            pstm.setInt(9, tbc.getLetreirotempo());
            pstm.setInt(10, tbc.getLetreirocorfonte());
            pstm.setInt(11, tbc.getFonteTabela());
            pstm.setInt(12, tbc.getLetreirocorfundo());
            pstm.setString(13, tbc.getLetreirotexto());
            pstm.setBoolean(14, tbc.isTabela1());
            pstm.setBoolean(15, tbc.isTabela2());
            pstm.setBoolean(16, tbc.isTabela3());
            pstm.setBoolean(17, tbc.isTabela4());
            pstm.setBoolean(18, tbc.isTabelacheia());
            pstm.setInt(19, tbc.getTerminal());
            pstm.setBoolean(20, tbc.isCtcodigo());
            pstm.setBoolean(21, tbc.isCtproduto());
            pstm.setBoolean(22, tbc.isCtoferta());
            pstm.setBoolean(23, tbc.isCtvalor1());
            pstm.setBoolean(24, tbc.isCtvalor2());
            pstm.setString(25, tbc.getNomevalor1());
            pstm.setString(26, tbc.getNomevalor2());
            pstm.setBoolean(27, tbc.isCtunid());
            pstm.setInt(28, tbc.getCorfontetabela());
            pstm.setInt(29, tbc.getCorfundotabela());
            pstm.setInt(30, tbc.getFonteestilotabela());
            pstm.setString(31, tbc.getFontetipotabela());
            pstm.setInt(32, tbc.getEspacamento());
            pstm.setString(33, tbc.getTabela1nome());
            pstm.setString(34, tbc.getTabela2nome());
            pstm.setString(35, tbc.getTabela3nome());
            pstm.setString(36, tbc.getTabela4nome());
            pstm.setInt(37, tbc.getTranspfundotabela());
            pstm.execute();
            ResultSet rs=pstm.getGeneratedKeys();
            int key=0;
            while(rs.next()){
                key=rs.getInt(1);
            }
            pstm.close();
            conexao.close();     
            return key;
        }
    }
    public void delTb_Config(Integer idterminal,int key) throws SQLException{
        try(Connection conexao=new ConexaoDBMySql().getConnect()){
            String sql="delete from tb_config where terminal=? and idtb_config<?";
            PreparedStatement pstm=conexao.prepareStatement(sql);
            pstm.setInt(1, idterminal);
            pstm.setInt(2, key);
            pstm.execute();
            pstm.close();
            conexao.close();
        }
    }
}
