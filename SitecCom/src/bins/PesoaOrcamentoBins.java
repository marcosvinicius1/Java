/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bins;

/**
 *
 * @author MARCOS
 */
public class PesoaOrcamentoBins {
    int id;
    int pessoacliente;
    int pessoavendedor;
    int empresa;
    String data;
    float vorcamento;
    String tipo;
    String npessoacliente;
    String formapg;
    
    public String getNpessoacliente() {
        return npessoacliente;
    }

    public void setNpessoacliente(String npessoacliente) {
        this.npessoacliente = npessoacliente;
    }

    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public float getVorcamento() {
        return vorcamento;
    }

    public void setVorcamento(float vorcamento) {
        this.vorcamento = vorcamento;
    }
    
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPessoacliente() {
        return pessoacliente;
    }

    public void setPessoacliente(int pessoacliente) {
        this.pessoacliente = pessoacliente;
    }

    public int getPessoavendedor() {
        return pessoavendedor;
    }

    public void setPessoavendedor(int pessoavendedor) {
        this.pessoavendedor = pessoavendedor;
    }

    public String getFormapg() {
        return formapg;
    }

    public void setFormapg(String formapg) {
        this.formapg = formapg;
    }
    
    
}
