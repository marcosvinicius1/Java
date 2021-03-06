/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.painel.dao;

import br.com.atmatech.painel.beans.Tb_ConfigBeans;
import br.com.atmatech.painel.beans.Tb_ConfigTempBeans;
import br.com.atmatech.painel.connection.ConexaoLocalDBMySql;
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
        try(Connection conexao=new ConexaoLocalDBMySql().getConnect()){
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
                tbc.setLetreirotempo(rs.getInt("letreirotempo"));
                tbc.setLetreirocorfundo(rs.getInt("letreirocorfundo"));
                tbc.setLetreirotexto(rs.getString("letreirotexto"));
                tbc.setLetreirocorfonte(rs.getInt("letreirocorfonte"));
                tbc.setTabela1(rs.getBoolean("tabela01"));
                tbc.setTabela2(rs.getBoolean("tabela02"));
                tbc.setTabela3(rs.getBoolean("tabela03"));
                tbc.setTabela4(rs.getBoolean("tabela04"));                
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
                tbc.setFontetabelatitulo(rs.getInt("fontetabelatitulo"));
                tbc.setFontetipotabelatitulo(rs.getString("fontetipotabelatitulo"));
                tbc.setFonteestilotabelatitulo(rs.getInt("fonteestilotabelatitulo"));
                tbc.setExibirtopo(rs.getBoolean("exibirtopo"));
                tbc.setExibirlateral(rs.getBoolean("exibirlateral"));
                
                tbc.setTabelapromo(rs.getBoolean("tabelapromo"));
                tbc.setFonteestilotabelapromotitulo(rs.getInt("fonteestilotabelapromotitulo"));
                tbc.setFontetipotabelapromotitulo(rs.getString("fontetipotabelapromotitulo"));
                tbc.setCorfontetabelapromo(rs.getInt("corfontetabelapromo"));
                tbc.setCorfundotabelapromo(rs.getInt("corfundotabelapromo"));
                tbc.setFontetabelapromotitulo(rs.getInt("fontetabelapromotitulo"));
                tbc.setEspacamentotabelapromo(rs.getInt("espacamentotabelapromo"));
                tbc.setFontetabelapromo(rs.getInt("fontetabelapromo"));
                tbc.setTranspfundotabelapromo(rs.getInt("transpfundotabelapromo"));
                tbc.setTamanhotabelapromo(rs.getInt("tamanhotabelapromo"));
                tbc.setFonteestilotabelapromo(rs.getInt("fonteestilotabelapromo"));
                tbc.setFontetipotabelapromo(rs.getString("fontetipotabelapromo"));
                tbc.setTabelapromonome(rs.getString("tabelapromonome"));
                tbc.setCtcodigotabelapromo(rs.getBoolean("ctcodigotabelapromo"));
                tbc.setCtprodutotabelapromo(rs.getBoolean("ctprodutotabelapromo"));
                tbc.setCtofertatabelapromo(rs.getBoolean("ctofertatabelapromo"));
                tbc.setCtunidtabelapromo(rs.getBoolean("ctunidtabelapromo"));
                tbc.setCtvalor2tabelapromo(rs.getBoolean("ctvalor2tabelapromo"));
                tbc.setCtvalor1tabelapromo(rs.getBoolean("ctvalor1tabelapromo"));
                tbc.setNomevalor2tabelapromo(rs.getString("nomevalor2tabelapromo"));
                tbc.setNomevalor1tabelapromo(rs.getString("nomevalor1tabelapromo"));                
            }
            rs.close();
            pstm.close();
            conexao.close();
            return tbc;
        }        
    }
    
    public Tb_ConfigTempBeans getTB_ConfigTemp(Integer terminal) throws SQLException{
        try(Connection conexao=new ConexaoLocalDBMySql().getConnect()){
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
                tbc.setLetreirotempo(rs.getInt("letreirotempo"));
                tbc.setLetreirocorfundo(rs.getInt("letreirocorfundo"));
                tbc.setLetreirotexto(rs.getString("letreirotexto"));
                tbc.setLetreirocorfonte(rs.getInt("letreirocorfonte"));
                tbc.setTabela1(rs.getBoolean("tabela01"));
                tbc.setTabela2(rs.getBoolean("tabela02"));
                tbc.setTabela3(rs.getBoolean("tabela03"));
                tbc.setTabela4(rs.getBoolean("tabela04"));               
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
                tbc.setFontetabelatitulo(rs.getInt("fontetabelatitulo"));
                tbc.setFontetipotabelatitulo(rs.getString("fontetipotabelatitulo"));
                tbc.setFonteestilotabelatitulo(rs.getInt("fonteestilotabelatitulo"));
                tbc.setExibirtopo(rs.getBoolean("exibirtopo"));
                tbc.setExibirlateral(rs.getBoolean("exibirlateral"));
                
                tbc.setTabelapromo(rs.getBoolean("tabelapromo"));
                tbc.setFonteestilotabelapromotitulo(rs.getInt("fonteestilotabelapromotitulo"));
                tbc.setFontetipotabelapromotitulo(rs.getString("fontetipotabelapromotitulo"));
                tbc.setCorfontetabelapromo(rs.getInt("corfontetabelapromo"));
                tbc.setCorfundotabelapromo(rs.getInt("corfundotabelapromo"));
                tbc.setFontetabelapromotitulo(rs.getInt("fontetabelapromotitulo"));
                tbc.setEspacamentotabelapromo(rs.getInt("espacamentotabelapromo"));
                tbc.setFontetabelapromo(rs.getInt("fontetabelapromo"));
                tbc.setTranspfundotabelapromo(rs.getInt("transpfundotabelapromo"));
                tbc.setTamanhotabelapromo(rs.getInt("tamanhotabelapromo"));
                tbc.setFonteestilotabelapromo(rs.getInt("fonteestilotabelapromo"));
                tbc.setFontetipotabelapromo(rs.getString("fontetipotabelapromo"));
                tbc.setTabelapromonome(rs.getString("tabelapromonome"));
                tbc.setCtcodigotabelapromo(rs.getBoolean("ctcodigotabelapromo"));
                tbc.setCtprodutotabelapromo(rs.getBoolean("ctprodutotabelapromo"));
                tbc.setCtofertatabelapromo(rs.getBoolean("ctofertatabelapromo"));
                tbc.setCtunidtabelapromo(rs.getBoolean("ctunidtabelapromo"));
                tbc.setCtvalor2tabelapromo(rs.getBoolean("ctvalor2tabelapromo"));
                tbc.setCtvalor1tabelapromo(rs.getBoolean("ctvalor1tabelapromo"));
                tbc.setNomevalor2tabelapromo(rs.getString("nomevalor2tabelapromo"));
                tbc.setNomevalor1tabelapromo(rs.getString("nomevalor1tabelapromo"));
            }
            rs.close();
            pstm.close();
            conexao.close();
            return tbc;
        }        
    }
    
    public int setTb_Config(Tb_ConfigBeans tbc) throws SQLException{
        try(Connection conexao=new ConexaoLocalDBMySql().getConnect()){
            String sql="INSERT INTO tb_config (tamanhox, tamanhoy, letreiro, tipolocalizacao, topoimagem, fundoimagem, lateralimagem, "
                    + "letreirotempo, letreirocorfonte, fontetabela, letreirocorfundo, letreirotexto, tabela01, tabela02, "
                    + "tabela03, tabela04, terminal,ctcodigo,ctproduto,ctoferta,ctvalor1,ctvalor2,nomevalor1,nomevalor2,"
                    + "ctunid,corfontetabela,corfundotabela,fonteestilotabela,fontetipotabela,espacamento,tabela1nome,"
                    + "tabela2nome,tabela3nome,tabela4nome,transpfundotabela,fontetabelatitulo,fontetipotabelatitulo,"
                    + "fonteestilotabelatitulo,exibirtopo,exibirlateral,tabelapromo,fonteestilotabelapromotitulo,fontetipotabelapromotitulo,"
                    + "corfontetabelapromo,corfundotabelapromo,fontetabelapromotitulo,espacamentotabelapromo,fontetabelapromo,"
                    + "transpfundotabelapromo,tamanhotabelapromo,fonteestilotabelapromo,fontetipotabelapromo,tabelapromonome,"
                    + "ctcodigotabelapromo,ctprodutotabelapromo,ctofertatabelapromo,ctunidtabelapromo,ctvalor2tabelapromo,ctvalor1tabelapromo,"
                    + "nomevalor2tabelapromo,nomevalor1tabelapromo) "
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstm=conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            pstm.setInt(1, tbc.getTamanhox());
            pstm.setInt(2, tbc.getTamanhoy());
            pstm.setBoolean(3, tbc.isLetreiro());
            pstm.setString(4, tbc.getTipolocalizacao());
            pstm.setBytes(5, tbc.getTopoimagem());
            pstm.setBytes(6, tbc.getFundoimagem1());
            pstm.setBytes(7, tbc.getLateralimagem());            
            pstm.setInt(8, tbc.getLetreirotempo());
            pstm.setInt(9, tbc.getLetreirocorfonte());
            pstm.setInt(10, tbc.getFonteTabela());
            pstm.setInt(11, tbc.getLetreirocorfundo());
            pstm.setString(12, tbc.getLetreirotexto());
            pstm.setBoolean(13, tbc.isTabela1());
            pstm.setBoolean(14, tbc.isTabela2());
            pstm.setBoolean(15, tbc.isTabela3());
            pstm.setBoolean(16, tbc.isTabela4());            
            pstm.setInt(17, tbc.getTerminal());
            pstm.setBoolean(18, tbc.isCtcodigo());
            pstm.setBoolean(19, tbc.isCtproduto());
            pstm.setBoolean(20, tbc.isCtoferta());
            pstm.setBoolean(21, tbc.isCtvalor1());
            pstm.setBoolean(22, tbc.isCtvalor2());
            pstm.setString(23, tbc.getNomevalor1());
            pstm.setString(24, tbc.getNomevalor2());
            pstm.setBoolean(25, tbc.isCtunid());
            pstm.setInt(26, tbc.getCorfontetabela());
            pstm.setInt(27, tbc.getCorfundotabela());
            pstm.setInt(28, tbc.getFonteestilotabela());
            pstm.setString(29, tbc.getFontetipotabela());
            pstm.setInt(30, tbc.getEspacamento());
            pstm.setString(31, tbc.getTabela1nome());
            pstm.setString(32, tbc.getTabela2nome());
            pstm.setString(33, tbc.getTabela3nome());
            pstm.setString(34, tbc.getTabela4nome());
            pstm.setInt(35, tbc.getTranspfundotabela());
            pstm.setInt(36, tbc.getFontetabelatitulo());
            pstm.setString(37, tbc.getFontetipotabelatitulo());
            pstm.setInt(38, tbc.getFonteestilotabelatitulo());
            pstm.setBoolean(39, tbc.isExibirtopo());
            pstm.setBoolean(40, tbc.isExibirlateral());
            
            pstm.setBoolean(41, tbc.isTabelapromo());
            pstm.setInt(42, tbc.getFonteestilotabelapromotitulo());
            pstm.setString(43, tbc.getFontetipotabelapromotitulo());
            pstm.setInt(44, tbc.getCorfontetabelapromo());
            pstm.setInt(45, tbc.getCorfundotabelapromo());
            pstm.setInt(46, tbc.getFontetabelapromotitulo());
            pstm.setInt(47, tbc.getEspacamentotabelapromo());
            pstm.setInt(48, tbc.getFontetabelapromo());
            pstm.setInt(49, tbc.getTranspfundotabelapromo());
            pstm.setInt(50, tbc.getTamanhotabelapromo());
            pstm.setInt(51, tbc.getFonteestilotabelapromo());
            pstm.setString(52, tbc.getFontetipotabelapromo());
            pstm.setString(53, tbc.getTabelapromonome());
            pstm.setBoolean(54, tbc.isCtcodigotabelapromo());
            pstm.setBoolean(55, tbc.isCtprodutotabelapromo());
            pstm.setBoolean(56, tbc.isCtofertatabelapromo());
            pstm.setBoolean(57, tbc.isCtunidtabelapromo());
            pstm.setBoolean(58, tbc.isCtvalor2tabelapromo());
            pstm.setBoolean(59, tbc.isCtvalor1tabelapromo());
            pstm.setString(60, tbc.getNomevalor2tabelapromo());
            pstm.setString(61, tbc.getNomevalor1tabelapromo());
            
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
        try(Connection conexao=new ConexaoLocalDBMySql().getConnect()){
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

