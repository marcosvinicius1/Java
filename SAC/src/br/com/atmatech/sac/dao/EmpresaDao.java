/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.sac.dao;

import br.com.atmatech.sac.beans.EmpresaBeans;
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
public class EmpresaDao {
//busca todos as empresas
    public List<EmpresaBeans> getEmpresa(){
        try(Connection conexao=new ConexaoDb().getConnect()){
            String sql="select * from empresa left join distrito on(empresa.iddistrito=distrito.iddistrito) order by razao";
            PreparedStatement pstm=conexao.prepareStatement(sql);
            ResultSet rs=pstm.executeQuery();
            List<EmpresaBeans>lpb=new ArrayList<>();
            while(rs.next()){
                EmpresaBeans pb=new EmpresaBeans();
                pb.setIdempresa(rs.getInt("idempresa"));
                pb.setRazao(rs.getString("razao"));
                pb.setFantasia(rs.getString("fantasia"));
                pb.setCnpj(rs.getString("cnpj"));
                pb.setIe(rs.getString("ie"));
                pb.setEndereco(rs.getString("endereco"));
                pb.setIddistrito(rs.getInt("iddistrito"));
                pb.setDistrito(rs.getString("distrito"));
                pb.setNumero(rs.getString("numero"));
                pb.setEmail(rs.getString("email"));
                pb.setTelefone1(rs.getString("telefone1"));
                pb.setTelefone2(rs.getString("telefone2"));
                pb.setTelefone3(rs.getString("telefone3"));
                pb.setIdsituacao(rs.getInt("idsituacao"));
                pb.setObs(rs.getString("obs"));
                pb.setBairro(rs.getString("bairro"));
                pb.setResponsavel(rs.getString("responsavel"));
                lpb.add(pb);
            }
            pstm.close();
            rs.close();
          return lpb;  
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Consultar Empresa\n"+ex);
            return null;
        }
    }
//busca utilizada no filtro empresa
    public List<EmpresaBeans> getEmpresa(String coluna,String parametro,String ordenar){
        try(Connection conexao=new ConexaoDb().getConnect()){
            String sql="select * from empresa left join distrito on(empresa.iddistrito=distrito.iddistrito) where "+coluna+" like '%"+parametro+"%' order by "+ordenar;
            PreparedStatement pstm=conexao.prepareStatement(sql);
            ResultSet rs=pstm.executeQuery();
            List<EmpresaBeans>lpb=new ArrayList<>();
            while(rs.next()){
                EmpresaBeans pb=new EmpresaBeans();
                pb.setIdempresa(rs.getInt("idempresa"));
                pb.setRazao(rs.getString("razao"));
                pb.setFantasia(rs.getString("fantasia"));
                pb.setCnpj(rs.getString("cnpj"));
                pb.setIe(rs.getString("ie"));
                pb.setEndereco(rs.getString("endereco"));
                pb.setIddistrito(rs.getInt("iddistrito"));
                pb.setDistrito(rs.getString("distrito"));
                pb.setNumero(rs.getString("numero"));
                pb.setEmail(rs.getString("email"));
                pb.setTelefone1(rs.getString("telefone1"));
                pb.setTelefone2(rs.getString("telefone2"));
                pb.setTelefone3(rs.getString("telefone3"));
                pb.setIdsituacao(rs.getInt("idsituacao"));
                pb.setObs(rs.getString("obs"));
                pb.setBairro(rs.getString("bairro"));
                pb.setResponsavel(rs.getString("responsavel"));
                lpb.add(pb);
            }
            pstm.close();
            rs.close();
          return lpb;  
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Consultar Empresa\n"+ex);
            return null;
        }                
    }
//salva empresa
    public void setEmpresa(EmpresaBeans pb) throws SQLException{
        try(Connection conexao=new ConexaoDb().getConnect()){
            String sql="insert into empresa (RAZAO,FANTASIA,CNPJ,IE,ENDERECO,IDDISTRITO,NUMERO,EMAIL,TELEFONE1,TELEFONE2,TELEFONE3,IDSITUACAO,OBS,BAIRRO,responsavel) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstm=conexao.prepareStatement(sql);
            pstm.setString(1,pb.getRazao());
            pstm.setString(2, pb.getFantasia());
            pstm.setString(3, pb.getCnpj());
            pstm.setString(4, pb.getIe());
            pstm.setString(5, pb.getEndereco());
            pstm.setInt(6, pb.getIddistrito());
            pstm.setString(7, pb.getNumero());
            pstm.setString(8, pb.getEmail());
            pstm.setString(9, pb.getTelefone1());
            pstm.setString(10, pb.getTelefone2());
            pstm.setString(11, pb.getTelefone3());
            pstm.setInt(12, pb.getIdsituacao());
            pstm.setString(13, pb.getObs());
            pstm.setString(14, pb.getBairro());
            pstm.setString(15, pb.getResponsavel());
            pstm.execute();
            pstm.close();
        }
    }
//utilizado naa empresa
    public void deleteEmpresa(int idempresa) throws SQLException{
        try(Connection conexao=new ConexaoDb().getConnect()){
            String sql="delete from empresa where idempresa=?";
            PreparedStatement pstm=conexao.prepareStatement(sql);
            pstm.setInt(1, idempresa);
            pstm.executeUpdate();
            pstm.close();
        } 
    }
//utilizado na alteracao
    public void updateEmpresa(EmpresaBeans pb) throws SQLException {
        try(Connection conexao=new ConexaoDb().getConnect()){
            String sql="update empresa set RAZAO=?,FANTASIA=?,CNPJ=?,IE=?,ENDERECO=?,IDDISTRITO=?,NUMERO=?,EMAIL=?,"
                    + "TELEFONE1=?,TELEFONE2=?,TELEFONE3=?,IDSITUACAO=?,OBS=?,BAIRRO=?,responsavel=? "                    
                    + "where idempresa=?";
                    
            PreparedStatement pstm=conexao.prepareStatement(sql);
            pstm.setString(1,pb.getRazao());
            pstm.setString(2, pb.getFantasia());
            pstm.setString(3, pb.getCnpj());
            pstm.setString(4, pb.getIe());
            pstm.setString(5, pb.getEndereco());
            pstm.setInt(6, pb.getIddistrito());
            pstm.setString(7, pb.getNumero());
            pstm.setString(8, pb.getEmail());
            pstm.setString(9, pb.getTelefone1());
            pstm.setString(10, pb.getTelefone2());
            pstm.setString(11, pb.getTelefone3());
            pstm.setInt(12, pb.getIdsituacao());
            pstm.setString(13, pb.getObs());
            pstm.setString(14, pb.getBairro());
            pstm.setString(15, pb.getResponsavel());
            pstm.setInt(16, pb.getIdempresa());            
            pstm.executeUpdate();
            pstm.close();
        }
    }
    //usado no login da empresa
    public EmpresaBeans getEmpresaAtivo(Integer idempresa){
        try(Connection conexao=new ConexaoDb().getConnect()){
            String sql="select * from empresa left join distrito on(empresa.iddistrito=distrito.iddistrito) "
                    + " where idempresa=? ";
            PreparedStatement pstm=conexao.prepareStatement(sql);
            pstm.setInt(1, idempresa);
            ResultSet rs=pstm.executeQuery();
            EmpresaBeans pb=new EmpresaBeans();
            while(rs.next()){                
                pb.setIdempresa(rs.getInt("idempresa"));
                pb.setRazao(rs.getString("razao"));
                pb.setFantasia(rs.getString("fantasia"));
                pb.setCnpj(rs.getString("cnpj"));
                pb.setIe(rs.getString("ie"));
                pb.setEndereco(rs.getString("endereco"));
                pb.setIddistrito(rs.getInt("iddistrito"));
                pb.setDistrito(rs.getString("distrito"));
                pb.setNumero(rs.getString("numero"));
                pb.setEmail(rs.getString("email"));
                pb.setTelefone1(rs.getString("telefone1"));
                pb.setTelefone2(rs.getString("telefone2"));
                pb.setTelefone3(rs.getString("telefone3"));
                pb.setIdsituacao(rs.getInt("idsituacao"));
                pb.setObs(rs.getString("obs"));
                pb.setBairro(rs.getString("bairro"));
                pb.setResponsavel(rs.getString("responsavel"));    
            }
            pstm.close();
            rs.close();
          return pb;  
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Consultar Empresa\n"+ex);
            return null;
        }
    }
}
