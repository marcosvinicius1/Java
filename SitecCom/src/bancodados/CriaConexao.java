/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bancodados;

/**
 *
 * @author MARCOS
 */
import bins.ConfigxmlBins;
import config.configxml;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcos
 */
public class CriaConexao {
    public static Connection getConexao() throws SQLException {
      //  try {
            configxml cx=new configxml();//cria objeto da classe configxml
            cx.conexaoBanco();//execulta metodo de ler as teg de configuração do banco
            ConfigxmlBins cxb=new ConfigxmlBins();//cria objeto dos bins da configuracao do banco
           // Class.forName("com.mysql.jdbc.Driver");
            //return DriverManager.getConnection("jdbc:mysql://localhost/servidor","root","4695828");
            return DriverManager.getConnection(cxb.getLocal(),cxb.getUsuario(),cxb.getSenha());//seta o retorno do bins
        /*} catch (ClassNotFoundException e) {
            throw new SQLException(e.getMessage());
        }*/
    }
}
