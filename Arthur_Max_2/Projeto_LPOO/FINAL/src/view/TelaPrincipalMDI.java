/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Max
 */
public class TelaPrincipalMDI extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipalMDI() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        r_mensal = new javax.swing.JMenuItem();
        r_diario = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        c_extras = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jDesktopPane1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/application_view_columns.png"))); // NOI18N
        jMenu1.setText("Relatorio");

        r_mensal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/overlays.png"))); // NOI18N
        r_mensal.setText("Mensal");
        r_mensal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_mensalActionPerformed(evt);
            }
        });
        jMenu1.add(r_mensal);

        r_diario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/page_attach.png"))); // NOI18N
        r_diario.setText("Diario");
        r_diario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_diarioActionPerformed(evt);
            }
        });
        jMenu1.add(r_diario);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/money.png"))); // NOI18N
        jMenu2.setText("Custo");

        c_extras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/money_delete.png"))); // NOI18N
        c_extras.setText("Extras");
        c_extras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_extrasActionPerformed(evt);
            }
        });
        jMenu2.add(c_extras);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/money_delete.png"))); // NOI18N
        jMenuItem4.setText("Fixos");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void r_diarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_diarioActionPerformed
       TelaRelatorioD telaR = new TelaRelatorioD();
        jDesktopPane1.add(telaR);
        telaR.setVisible(true);
    }//GEN-LAST:event_r_diarioActionPerformed

    private void r_mensalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_mensalActionPerformed
                
        TelaRelatorioM telaM = new TelaRelatorioM();
        jDesktopPane1.add(telaM);
        telaM.setVisible(true);
        
    }//GEN-LAST:event_r_mensalActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        CustosFixos telaCusf = new CustosFixos();
        jDesktopPane1.add(telaCusf);
        telaCusf.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void c_extrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_extrasActionPerformed
        CustosExtras custoE = new CustosExtras();
        jDesktopPane1.add(custoE);
        custoE.setVisible(true);
    }//GEN-LAST:event_c_extrasActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipalMDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalMDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalMDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalMDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new TelaPrincipalMDI().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem c_extras;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem r_diario;
    private javax.swing.JMenuItem r_mensal;
    // End of variables declaration//GEN-END:variables
}
