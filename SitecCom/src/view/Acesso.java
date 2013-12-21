/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bins.AcessoBins;
import bins.DadosEmpresaBins;
import bins.PermissoesUsuario;
import bins.PessoaBins;
import bins.PessoaUsuario;
import dao.AcessoDao;
import dao.PessoaDao;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marcos Vinicius
 */
public class Acesso extends javax.swing.JFrame {
    List<PessoaBins> lppessoa;
    List<AcessoBins> lpermissao;
    /**
     * Creates new form Acesso
     */
    public Acesso() {
        initComponents();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDusuario = new javax.swing.JDialog();
        jTdusuario = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabledusuario = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JComboBox combobox=new JComboBox();
        combobox.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"NAO","SIM"}) );
        jTableacesso = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTusuario = new javax.swing.JTextField();
        jBsalvar = new javax.swing.JButton();
        jTidusuario = new javax.swing.JTextField();
        jBpesquisa = new javax.swing.JButton();

        jDusuario.setTitle("PESQUISA USUARIO");
        jDusuario.setMinimumSize(new java.awt.Dimension(367, 270));
        jDusuario.setModal(true);
        jDusuario.setResizable(false);

        jTdusuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTdusuarioKeyReleased(evt);
            }
        });

        jTabledusuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "USUARIO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabledusuario.getTableHeader().setResizingAllowed(false);
        jTabledusuario.getTableHeader().setReorderingAllowed(false);
        jTabledusuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabledusuarioMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTabledusuario);

        jLabel3.setText("USUARIO");

        javax.swing.GroupLayout jDusuarioLayout = new javax.swing.GroupLayout(jDusuario.getContentPane());
        jDusuario.getContentPane().setLayout(jDusuarioLayout);
        jDusuarioLayout.setHorizontalGroup(
            jDusuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDusuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDusuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDusuarioLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTdusuario)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDusuarioLayout.setVerticalGroup(
            jDusuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDusuarioLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jDusuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTdusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PERMISSÕES");
        setResizable(false);

        jTableacesso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"CADASTRO PESSOAS", "NAO"},
                {"RECEBER", "NAO"},
                {"CADASTRO PRODUTO", "NAO"},
                {"ORCAMENTO", "NAO"},
                {"CAIXA", "NAO"},
                {"EMPRESA", "NAO"},
                {"BACKUP", "NAO"},
                {"PERMISSAO", "NAO"}
            },
            new String [] {
                "PERMISSÃO", "ATIVO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableacesso.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableacesso);
        jTableacesso.getColumnModel().getColumn(0).setResizable(false);
        jTableacesso.getColumnModel().getColumn(1).setResizable(false);
        jTableacesso.getColumn(jTableacesso.getColumnName(1)).setCellEditor(new DefaultCellEditor(combobox));

        jLabel1.setText("PERMISSÕES DE ACESSO");

        jLabel2.setText("USUARIO:");

        jTusuario.setEditable(false);

        jBsalvar.setText("SALVAR");
        jBsalvar.setEnabled(false);
        jBsalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBsalvarActionPerformed(evt);
            }
        });

        jTidusuario.setEditable(false);

        jBpesquisa.setText("PESQUISA");
        jBpesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBpesquisaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTidusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jTusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jBpesquisa))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jBsalvar))))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addComponent(jTidusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBpesquisa))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBsalvar)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    public void limpatela(){
        jTidusuario.setText("");
        jTusuario.setText("");
        jBsalvar.setEnabled(false);
        for(int i=0;i<jTableacesso.getRowCount();i++){
        jTableacesso.setValueAt("NAO", i, 1);
        }
    }
    private void jBsalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBsalvarActionPerformed

        try {
            AcessoDao ad = new AcessoDao();
            ad.remove(Integer.valueOf(jTidusuario.getText()));
            for (int i = 0; i < jTableacesso.getRowCount(); i++) {
                AcessoBins ab = new AcessoBins();
                ab.setPessoa(Integer.valueOf(jTidusuario.getText()));
                ab.setClasse(String.valueOf(jTableacesso.getValueAt(i, 0)));
                ab.setAcesso(String.valueOf(jTableacesso.getValueAt(i, 1)));
                ad.adiciona(ab);
                
            }
            JOptionPane.showMessageDialog(null, "Permições Dadas");
            jBsalvar.setEnabled(false);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "\n" + ex);
        }
    }//GEN-LAST:event_jBsalvarActionPerformed

    private void jTdusuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTdusuarioKeyReleased
        // TODO add your handling code here:
        try {
            PessoaDao pd = new PessoaDao();
            DadosEmpresaBins de = new DadosEmpresaBins();
            lppessoa = pd.getLogin("%"+jTdusuario.getText()+"%", de.getId());          
            mostrapessoa(lppessoa);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Pesquisar\n"+ex);
        }
    }//GEN-LAST:event_jTdusuarioKeyReleased

    private void jBpesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBpesquisaActionPerformed
        // TODO add your handling code here:
        DefaultTableModel modeloacesso=(DefaultTableModel) jTabledusuario.getModel();
        modeloacesso.setNumRows(0);
        jTdusuario.setText("");
        jDusuario.setLocationRelativeTo(null);
        jDusuario.setVisible(true);
    }//GEN-LAST:event_jBpesquisaActionPerformed

    private void jTabledusuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabledusuarioMouseClicked
        // TODO add your handling code here:     
        limpatela();
        carregausuario();//carrega usuario selecionado para tela de permissao
        jBsalvar.setEnabled(true);
        jDusuario.setVisible(false);
    }//GEN-LAST:event_jTabledusuarioMouseClicked
    public void carregausuario(){
         for(int i=0;i<lppessoa.size();i++){
            if(i==jTabledusuario.getSelectedRow()){
                jTidusuario.setText(String.valueOf(lppessoa.get(i).getId()));
                jTusuario.setText(String.valueOf(lppessoa.get(i).getApelido()));
                carregapermissao(lppessoa.get(i).getId());//carrega permissoes do usuario selecionado para tela permissoes
            }
        }
    }
    public void carregapermissao(int id){//metodo carrega permissoes            
        try {
            AcessoDao ad=new AcessoDao(); 
            lpermissao=ad.getAcesso(id);//perquisa permissoes no banco
            for(int i=0;i<lpermissao.size();i++){//percorre os dados retornado do banco          
                for(int j=0;j<jTableacesso.getRowCount();j++){//percorre a tabela
                    if(lpermissao.get(i).getClasse().equals(jTableacesso.getValueAt(j, 0))){//compara que o retorno e igual ao que esta no banco
                        jTableacesso.setValueAt(lpermissao.get(i).getAcesso(), j, 1);//preenche os valores na tabela
                    }
                }
            }
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar permissoes\n"+ex);
        }
    }
    public void mostrapessoa(List<PessoaBins> lp){
        DefaultTableModel modelopessoa=(DefaultTableModel) jTabledusuario.getModel();
        modelopessoa.setNumRows(0);
        for(int i=0;i<lp.size();i++){
            
            modelopessoa.addRow(new Object[]{lp.get(i).getApelido()});
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Acesso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Acesso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Acesso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Acesso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Acesso().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBpesquisa;
    private javax.swing.JButton jBsalvar;
    private javax.swing.JDialog jDusuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableacesso;
    private javax.swing.JTable jTabledusuario;
    private javax.swing.JTextField jTdusuario;
    private javax.swing.JTextField jTidusuario;
    private javax.swing.JTextField jTusuario;
    // End of variables declaration//GEN-END:variables
}
