/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bins;

/**
 *
 * @author Marcos Vinicius
 */
public class PessoaUsuario {
    static Integer id;
    static String nome;
    static String apelido;
    static String senha;
    static String lembra;
    static int ativo;
    static int empresa;

    public  Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        PessoaUsuario.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        PessoaUsuario.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        PessoaUsuario.apelido = apelido;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        PessoaUsuario.senha = senha;
    }

    public String getLembra() {
        return lembra;
    }

    public void setLembra(String lembra) {
        PessoaUsuario.lembra = lembra;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        PessoaUsuario.ativo = ativo;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        PessoaUsuario.empresa = empresa;
    }
    
    
}
