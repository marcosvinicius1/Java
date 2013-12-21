/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bins;

/**
 *
 * @author MARCOS
 */
public class DadosEmpresaBins {

    public static int id;//variavel global de cadastro empresa
    public static String nome;
    public static String cnpj;
    public static String endereco;
    public static String numero;
    public static String bairro;
    public static String cep;
    public static String cidade;
    public static String telefone;
    public static String senha;
    public static Float desconto;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        DadosEmpresaBins.senha = senha;
    }
    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        DadosEmpresaBins.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        DadosEmpresaBins.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        DadosEmpresaBins.cidade = cidade;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        DadosEmpresaBins.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        DadosEmpresaBins.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        DadosEmpresaBins.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        DadosEmpresaBins.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        DadosEmpresaBins.numero = numero;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        DadosEmpresaBins.telefone = telefone;
    }

    public Float getDesconto() {
        return desconto;
    }

    public void setDesconto(Float desconto) {
        DadosEmpresaBins.desconto = desconto;
    }
    
    
}
