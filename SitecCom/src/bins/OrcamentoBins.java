/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bins;

/**
 *
 * @author MARCOS
 */
public class OrcamentoBins {
    int id;
    int produto;
    String descproduto;
    String codproduto;
    int pessoa;
    float qtde;
    float precovenda;
    float desconto;
    float precotproduto;
    float precotorcamento;
    String formapg;
    String tipo;
    String data;

    public String getCodproduto() {
        return codproduto;
    }

    public void setCodproduto(String codproduto) {
        this.codproduto = codproduto;
    }

    public String getDescproduto() {
        return descproduto;
    }

    public void setDescproduto(String descproduto) {
        this.descproduto = descproduto;
    }
    

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    public String getFormapg() {
        return formapg;
    }

    public void setFormapg(String formapg) {
        this.formapg = formapg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPessoa() {
        return pessoa;
    }

    public void setPessoa(int pessoa) {
        this.pessoa = pessoa;
    }

    public float getPrecotorcamento() {
        return precotorcamento;
    }

    public void setPrecotorcamento(float precotorcamento) {
        this.precotorcamento = precotorcamento;
    }

    public float getPrecotproduto() {
        return precotproduto;
    }

    public void setPrecotproduto(float precotproduto) {
        this.precotproduto = precotproduto;
    }

    public float getPrecovenda() {
        return precovenda;
    }

    public void setPrecovenda(float precovenda) {
        this.precovenda = precovenda;
    }

    public int getProduto() {
        return produto;
    }

    public void setProduto(int produto) {
        this.produto = produto;
    }

    public float getQtde() {
        return qtde;
    }

    public void setQtde(float qtde) {
        this.qtde = qtde;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
}
