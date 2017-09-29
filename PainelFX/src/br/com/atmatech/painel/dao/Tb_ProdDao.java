/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.painel.dao;

import br.com.atmatech.painel.beans.DBConfigBeans;
import br.com.atmatech.painel.beans.Tb_ProdBeans;
import br.com.atmatech.painel.config.DBConfig;
import br.com.atmatech.painel.connection.ConexaoDB;
import br.com.atmatech.painel.connection.ConexaoLocalDBMySql;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcos
 */
public class Tb_ProdDao {

    Connection conexao1 = null;
    Statement pstm1 = null;
    Boolean encerrar = true;

    public List<Tb_ProdBeans> getProdBalanca() throws SQLException {
        DBConfigBeans db = new DBConfigBeans();
        if (db.getTipobanco().equals("Access")) {
            List<Tb_ProdBeans> lpb = new ArrayList<>();
            conexao1 = new ConexaoDB().getConnect();
            String sql = "select * from vw_prod_painel";
            encerrar = true;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException ex) {
                        new DBConfig().createArqLog("Erro ao Pausar Thread");
                    }
                    closeConexao();
                }
            }).start();
            pstm1 = conexao1.createStatement();
            encerrar = false;
            ResultSet rs = pstm1.executeQuery(sql);
            while (rs.next()) {
                Tb_ProdBeans pb = new Tb_ProdBeans();
                pb.setCodigo(rs.getString("codigo"));
                pb.setDescricao(rs.getString("descricao"));
                pb.setUnid(rs.getString("unid"));
                pb.setValor1(rs.getFloat("valor1"));
                pb.setValor2(rs.getFloat("valor2"));
                pb.setOferta(rs.getBoolean("oferta"));
                lpb.add(pb);
            }
            conexao1.commit();
            rs.close();
            pstm1.close();
            conexao1.close();
            return lpb;
        } else if (db.getTipobanco().equals("Filizola bkp")) {
            List<Tb_ProdBeans> lpb = new ArrayList<>();
            File file1 = new File(db.getDirdb() + db.getBanco());            
            if (file1.exists()) {
                try {
                    FileReader arq = new FileReader(file1);
                    BufferedReader lerArq = new BufferedReader(arq);
                    String linha = lerArq.readLine();
                    while (linha != null) {
                        Tb_ProdBeans pb=new Tb_ProdBeans();                        
                        pb.setCodigo(String.valueOf(Integer.valueOf(linha.substring(0, 6))));
                        pb.setDescricao(linha.substring(7, 29));
                        pb.setUnid("KG");
                        pb.setValor1(new Float(linha.substring(30, 34)+"."+linha.substring(34, 36)));
                        pb.setValor2(new Float(0));
                        pb.setOferta(false);
                        lpb.add(pb);
                        linha = lerArq.readLine(); // lê da segunda até a última linha
                    }
                    arq.close();                    
                    return lpb;                    
                } catch (Exception ex) {                    
                    new DBConfig().createArqLog("Tb_ProdDao - getProdBalanca:" + ex);
                    return null;
                }
            }else{
                System.err.println("nao encontrou");
            return null;
            }
        }  else {
            try (Connection conexao = new ConexaoDB().getConnect()) {
                String sql = "select * from vw_prod_painel";
                PreparedStatement pstm = conexao.prepareStatement(sql);
                ResultSet rs = pstm.executeQuery();
                List<Tb_ProdBeans> lpb = new ArrayList<>();
                while (rs.next()) {
                    Tb_ProdBeans pb = new Tb_ProdBeans();
                    pb.setCodigo(rs.getString("codigo"));
                    pb.setDescricao(rs.getString("descricao"));
                    pb.setUnid(rs.getString("unid"));
                    pb.setValor1(rs.getFloat("valor1"));
                    pb.setValor2(rs.getFloat("valor2"));
                    pb.setOferta(rs.getBoolean("oferta"));
                    lpb.add(pb);
                }
                rs.close();
                pstm.close();
                conexao.close();
                return lpb;
            }
        }        
    }

    public List<Tb_ProdBeans> getProdLocal() throws SQLException {
        try (Connection conexao = new ConexaoLocalDBMySql().getConnect()) {
            String sql = "select * from tb_prod";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            List<Tb_ProdBeans> lpb = new ArrayList<>();
            while (rs.next()) {
                Tb_ProdBeans pb = new Tb_ProdBeans();
                pb.setCodigo(rs.getString("codigo"));
                pb.setDescricao(rs.getString("descricao"));
                pb.setUnid(rs.getString("unid"));
                pb.setValor1(rs.getFloat("valor1"));
                pb.setValor2(rs.getFloat("valor2"));
                pb.setOferta(rs.getBoolean("oferta"));
                lpb.add(pb);
            }
            rs.close();
            pstm.close();
            conexao.close();
            return lpb;
        }
    }

    public List<Tb_ProdBeans> getFiltroProdLocal(String filtro) throws SQLException {
        try (Connection conexao = new ConexaoLocalDBMySql().getConnect()) {
            String sql = "select * from tb_prod where descricao like ? OR codigo like ? ";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            pstm.setString(1, "%" + filtro + "%");
            pstm.setString(2, "%" + filtro + "%");
            ResultSet rs = pstm.executeQuery();
            List<Tb_ProdBeans> lpb = new ArrayList<>();
            while (rs.next()) {
                Tb_ProdBeans pb = new Tb_ProdBeans();
                pb.setCodigo(rs.getString("codigo"));
                pb.setDescricao(rs.getString("descricao"));
                pb.setUnid(rs.getString("unid"));
                pb.setValor1(rs.getFloat("valor1"));
                pb.setValor2(rs.getFloat("valor2"));
                pb.setOferta(rs.getBoolean("oferta"));
                lpb.add(pb);
            }
            rs.close();
            pstm.close();
            conexao.close();
            return lpb;
        }
    }

    public void setProdLocal(List<Tb_ProdBeans> lpb) throws SQLException {
        try (Connection conexao = new ConexaoLocalDBMySql().getConnect()) {
            String sql = "insert into tb_prod(codigo,descricao,unid,valor1,valor2)values(?,?,?,?,?)";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            for (Tb_ProdBeans pb : lpb) {
                pstm.setString(1, pb.getCodigo());
                pstm.setString(2, pb.getDescricao());
                pstm.setString(3, pb.getUnid());
                pstm.setFloat(4, pb.getValor1());
                pstm.setFloat(5, pb.getValor2());
                pstm.addBatch();
            }
            pstm.executeBatch();
            pstm.close();
            conexao.close();
        }
    }

    public Boolean delProdLocal() throws SQLException {
        Boolean retorno = false;
        try (Connection conexao = new ConexaoLocalDBMySql().getConnect()) {
            String sql = "delete from tb_prod";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            pstm.execute();
            retorno = true;
        }
        return retorno;
    }

    public void closeConexao() {
        try {
            if (encerrar) {
                conexao1.close();
                pstm1.close();
                new DBConfig().createArqLog("Conexao Encerrada Forcadamente");
            }
        } catch (Exception ex) {
            new DBConfig().createArqLog("Erro ao Forcar Fechamento da Conexao");
        }
    }
}
