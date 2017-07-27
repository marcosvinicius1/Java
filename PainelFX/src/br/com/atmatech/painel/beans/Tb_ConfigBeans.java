/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.painel.beans;

import java.io.File;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author MARCOS
 */
public class Tb_ConfigBeans {

    static private Integer idtb_config;
    static private boolean tabela1;
    static private boolean tabela2;
    static private boolean tabela3;
    static private boolean tabela4;
    static private String tabela1nome;
    static private String tabela2nome;
    static private String tabela3nome;
    static private String tabela4nome;
    static private Integer FonteTabela;
    static private boolean transparencia;
    static private boolean letreiro;
    static private String letreirotexto;
    static private Integer letreirotempo;
    static private boolean tabelacheia;
    static private String tipolocalizacao;
    static private Integer tempotransicao;
    static private byte[] fundoimagem1;
    static private Integer tamanhox;
    static private Integer tamanhoy;
    static private Integer letreirocorfundo;
    static private Integer letreirocorfonte;
    static private byte[] lateralimagem;
    static private byte[] topoimagem;
    static private Integer terminal;
    static private boolean ctcodigo;
    static private boolean ctproduto;
    static private boolean ctoferta;
    static private boolean ctvalor1;
    static private boolean ctvalor2;
    static private String nomevalor1;
    static private String nomevalor2;
    static private boolean ctunid;
    static private Integer corfontetabela;
    static private Integer corfundotabela;
    static private Integer fonteestilotabela;
    static private String fontetipotabela;
    static private Integer espacamento;
    static private Integer transpfundotabela;
    
    public boolean isTabela1() {
        return tabela1;
    }

    public void setTabela1(boolean tabela1) {
        this.tabela1 = tabela1;
    }

    public boolean isTabela2() {
        return tabela2;
    }

    public void setTabela2(boolean tabela2) {
        this.tabela2 = tabela2;
    }

    public boolean isTabela3() {
        return tabela3;
    }

    public void setTabela3(boolean tabela3) {
        this.tabela3 = tabela3;
    }

    public boolean isTabela4() {
        return tabela4;
    }

    public void setTabela4(boolean tabela4) {
        this.tabela4 = tabela4;
    }

    public Integer getFonteTabela() {
        return FonteTabela;
    }

    public void setFonteTabela(Integer FonteTabela) {
        this.FonteTabela = FonteTabela;
    }

    public boolean isTransparencia() {
        return transparencia;
    }

    public void setTransparencia(boolean transparencia) {
        this.transparencia = transparencia;
    }

    public boolean isLetreiro() {
        return letreiro;
    }

    public void setLetreiro(boolean letreiro) {
        this.letreiro = letreiro;
    }

    public String getLetreirotexto() {
        return letreirotexto;
    }

    public void setLetreirotexto(String letreirotexto) {
        this.letreirotexto = letreirotexto;
    }

    public Integer getLetreirotempo() {
        return letreirotempo;
    }

    public void setLetreirotempo(Integer letreirotempo) {
        this.letreirotempo = letreirotempo;
    }

    public boolean isTabelacheia() {
        return tabelacheia;
    }

    public void setTabelacheia(boolean tabelacheia) {
        this.tabelacheia = tabelacheia;
    }

    public String getTipolocalizacao() {
        return tipolocalizacao;
    }

    public void setTipolocalizacao(String tipolocalizacao) {
        this.tipolocalizacao = tipolocalizacao;
    }

    public Integer getTempotransicao() {
        return tempotransicao;
    }

    public void setTempotransicao(Integer tempotransicao) {
        this.tempotransicao = tempotransicao;
    }

    public byte[] getFundoimagem1() {
        return fundoimagem1;
    }

    public void setFundoimagem1(byte[] fundoimagem1) {
        this.fundoimagem1 = fundoimagem1;
    }

    public Integer getTamanhox() {
        return tamanhox;
    }

    public void setTamanhox(Integer tamanhox) {
        this.tamanhox = tamanhox;
    }

    public Integer getTamanhoy() {
        return tamanhoy;
    }

    public void setTamanhoy(Integer tamanhoy) {
        this.tamanhoy = tamanhoy;
    }

    public Integer getLetreirocorfundo() {
        return letreirocorfundo;
    }

    public void setLetreirocorfundo(Integer letreirocorfundo) {
        this.letreirocorfundo = letreirocorfundo;
    }

    public Integer getLetreirocorfonte() {
        return letreirocorfonte;
    }

    public void setLetreirocorfonte(Integer letreirocorfonte) {
        this.letreirocorfonte = letreirocorfonte;
    }

    public byte[] getLateralimagem() {
        return lateralimagem;
    }

    public void setLateralimagem(byte[] lateralimagem) {
        this.lateralimagem = lateralimagem;
    }

    public byte[] getTopoimagem() {
        return topoimagem;
    }

    public void setTopoimagem(byte[] topoimagem) {
        this.topoimagem = topoimagem;
    }

    public Integer getTerminal() {
        return terminal;
    }

    public void setTerminal(Integer terminal) {
        this.terminal = terminal;
    }

    public String getArquivoFundoImagem1() {
        File f = new File("./imagem/fundoimagem1.jpg");
        FileOutputStream fos;
        try {
            if (getFundoimagem1() != null) {
                fos = new FileOutputStream(f);
                fos.write(getFundoimagem1());
                fos.flush();
                fos.close();
            } else {
                return "./imagem/PadraoFundo.jpg";
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Converte Imagem Fundo" + ex);
        }

        return "./imagem/fundoimagem1.jpg";
    }

    public String getArquivoLateralImagem() {
        File f = new File("./imagem/lateralimagem.jpg");
        FileOutputStream fos;
        try {
            if (getLateralimagem() != null) {
                fos = new FileOutputStream(f);
                fos.write(getLateralimagem());
                fos.flush();
                fos.close();                
            }else{
                return "./imagem/PadraoLateral.jpg";            
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Converte Imagem Lateral" + ex);
        }
        return "./imagem/lateralimagem.jpg";
    }

    public String getArquivoTopoImagem() {
        File f = new File("./imagem/topoimagem.jpg");
        try {
            if (getTopoimagem() != null) {
                FileOutputStream fos = new FileOutputStream(f);
                fos.write(getTopoimagem());
                fos.flush();
                fos.close();
            } else {
                return "./imagem/PadraoTopo.jpg";
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Converte Imagem Topo" + ex);
        }

        return "./imagem/topoimagem.jpg";
    }

    public boolean isCtcodigo() {
        return ctcodigo;
    }

    public void setCtcodigo(boolean ctcodigo) {
        this.ctcodigo = ctcodigo;
    }

    public boolean isCtproduto() {
        return ctproduto;
    }

    public void setCtproduto(boolean ctproduto) {
        this.ctproduto = ctproduto;
    }

    public boolean isCtvalor1() {
        return ctvalor1;
    }

    public void setCtvalor1(boolean ctvalor1) {
        this.ctvalor1 = ctvalor1;
    }

    public boolean isCtvalor2() {
        return ctvalor2;
    }

    public void setCtvalor2(boolean ctvalor2) {
        this.ctvalor2 = ctvalor2;
    }

    public String getNomevalor1() {
        return nomevalor1;
    }

    public void setNomevalor1(String nomevalor1) {
        this.nomevalor1 = nomevalor1;
    }

    public String getNomevalor2() {
        return nomevalor2;
    }

    public void setNomevalor2(String nomevalor2) {
        this.nomevalor2 = nomevalor2;
    }

    public boolean isCtoferta() {
        return ctoferta;
    }

    public void setCtoferta(boolean ctoferta) {
        this.ctoferta = ctoferta;
    }

    public boolean isCtunid() {
        return ctunid;
    }

    public void setCtunid(boolean ctunid) {
        this.ctunid = ctunid;
    }

    public Integer getCorfontetabela() {
        return corfontetabela;
    }

    public void setCorfontetabela(Integer corfontetabela) {
        this.corfontetabela = corfontetabela;
    }

    public Integer getCorfundotabela() {
        return corfundotabela;
    }

    public void setCorfundotabela(Integer corfundotabela) {
        this.corfundotabela = corfundotabela;
    }

    public Integer getFonteestilotabela() {
        return fonteestilotabela;
    }

    public void setFonteestilotabela(Integer fonteestilotabela) {
        this.fonteestilotabela = fonteestilotabela;
    }

    public String getFontetipotabela() {
        return fontetipotabela;
    }

    public void setFontetipotabela(String fontetipotabela) {
        this.fontetipotabela = fontetipotabela;
    }

    public Integer getEspacamento() {
        return espacamento;
    }

    public void setEspacamento(Integer espacamento) {
        this.espacamento = espacamento;
    }

    public String getTabela1nome() {
        return tabela1nome;
    }

    public void setTabela1nome(String tabela1nome) {
        this.tabela1nome = tabela1nome;
    }

    public String getTabela2nome() {
        return tabela2nome;
    }

    public void setTabela2nome(String tabela2nome) {
        this.tabela2nome = tabela2nome;
    }

    public String getTabela3nome() {
        return tabela3nome;
    }

    public void setTabela3nome(String tabela3nome) {
        this.tabela3nome = tabela3nome;
    }

    public String getTabela4nome() {
        return tabela4nome;
    }

    public void setTabela4nome(String tabela4nome) {
        this.tabela4nome = tabela4nome;
    }

    public Integer getIdtb_config() {
        return idtb_config;
    }

    public void setIdtb_config(Integer idtb_config) {
        this.idtb_config = idtb_config;
    }

    public Integer getTranspfundotabela() {
        return transpfundotabela;
    }

    public void setTranspfundotabela(Integer transpfundotabela) {
        this.transpfundotabela = transpfundotabela;
    }
}
