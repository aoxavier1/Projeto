/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.RelatM;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.dao.RelatMDAO;

/**
 *
 * @author Max
 */
public final class TelaRelatorioM extends javax.swing.JInternalFrame {

    String modoRelatM;

    /**
     * Creates new form TelaRelatorio
     */
    public TelaRelatorioM() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) tbl_relat_M.getModel();
        tbl_relat_M.setRowSorter(new TableRowSorter(modelo));

        //Recarregar a lista criada
        readRelatorioM();
        modoRelatM = "Navegar";
        ManipulaInterfaceRelatM();
    }

    public void readRelatorioM() {
        DefaultTableModel modelo = (DefaultTableModel) tbl_relat_M.getModel();
        //Para que não duplique os valores ao inserir
        modelo.setNumRows(0);
        //Criando o objeto DAO para ser passado na nossa Jtabel
        RelatMDAO mdao = new RelatMDAO();

        //Ira pegar os valores que estão na lista e passando para o objeto
        for (RelatM m : mdao.read()) {

            modelo.addRow(new Object[]{
                //Vao pegar os valores que estão no banco
                m.getId(),
                m.getData(),
                m.getKmi(),
                m.getKmf(),
                m.getPerc()
            });
        }
    }

    public void ManipulaInterfaceRelatM() { //Manipulaçao da Tabela
        //Modo de operaçao dos botoes utilizados no projeto
        switch (modoRelatM) {

            case "Navegar":     //Somente o botao novo ira estar disponivel
                btn_relatm_salvar.setEnabled(false);
                btn_relatm_cancelar.setEnabled(false);
                c_relatm_data.setEnabled(false);
                c_relat_kmi.setEnabled(false);
                c_relat_kmf.setEnabled(false);
                btn_relatm_novo.setEnabled(true);
                btn_relatm_editar.setEnabled(false);
                btn_relatm_excluir.setEnabled(false);
                break;

            case "Novo":    //Quando Apertado o botao Novo ira liberar os campos para o cadastro

                btn_relatm_salvar.setEnabled(true);
                btn_relatm_cancelar.setEnabled(true);
                c_relatm_data.setEnabled(true);
                c_relat_kmi.setEnabled(true);
                c_relat_kmf.setEnabled(true);
                btn_relatm_novo.setEnabled(false);
                btn_relatm_editar.setEnabled(false);
                btn_relatm_excluir.setEnabled(false);
                break;

            case "Editar":

                btn_relatm_salvar.setEnabled(true);
                btn_relatm_cancelar.setEnabled(true);
                c_relatm_data.setEnabled(true);
                c_relat_kmi.setEnabled(true);
                c_relat_kmf.setEnabled(true);
                btn_relatm_novo.setEnabled(true);
                btn_relatm_editar.setEnabled(false);
                btn_relatm_excluir.setEnabled(false);
                break;

            case "Excluir":

                btn_relatm_salvar.setEnabled(false);
                btn_relatm_cancelar.setEnabled(false);
                c_relatm_data.setEnabled(true);
                c_relat_kmi.setEnabled(true);
                c_relat_kmf.setEnabled(true);
                btn_relatm_novo.setEnabled(true);
                btn_relatm_editar.setEnabled(false);
                btn_relatm_excluir.setEnabled(false);
                break;

            case "Selecao":
                //Os botões editar e exluir estaram disponiveis para fazer a alterção da tabela
                btn_relatm_salvar.setEnabled(false);
                btn_relatm_cancelar.setEnabled(false);
                c_relatm_data.setEnabled(true);
                c_relat_kmi.setEnabled(true);
                c_relat_kmf.setEnabled(true);
                btn_relatm_novo.setEnabled(false);
                btn_relatm_editar.setEnabled(true);
                btn_relatm_excluir.setEnabled(true);
                break;

            default:
                System.out.println("Modo Invalido");

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_relat_M = new javax.swing.JTable();
        jPanel18 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        c_relatm_data = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        c_relat_kmi = new javax.swing.JTextField();
        btn_relatm_salvar = new javax.swing.JButton();
        btn_relatm_cancelar = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        c_relat_kmf = new javax.swing.JTextField();
        btn_relatm_novo = new javax.swing.JButton();
        btn_relatm_editar = new javax.swing.JButton();
        btn_relatm_excluir = new javax.swing.JButton();
        cmd_print_rm = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jMenu3.setText("jMenu3");

        jMenu4.setText("File");
        jMenuBar1.add(jMenu4);

        jMenu5.setText("Edit");
        jMenuBar1.add(jMenu5);

        jMenuItem1.setText("jMenuItem1");

        setClosable(true);
        setResizable(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        tbl_relat_M.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tbl_relat_M.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Data", "Km Inicial", "Km Final", "Km Pecorrido"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_relat_M.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_relat_MMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbl_relat_M);

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Inserir Dados"));

        jLabel18.setText("Data");

        c_relatm_data.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_relatm_dataActionPerformed(evt);
            }
        });

        jLabel19.setText("Km Inicial :");

        c_relat_kmi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_relat_kmiActionPerformed(evt);
            }
        });

        btn_relatm_salvar.setText("Salvar");
        btn_relatm_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_relatm_salvarActionPerformed(evt);
            }
        });

        btn_relatm_cancelar.setText("Cancelar");
        btn_relatm_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_relatm_cancelarActionPerformed(evt);
            }
        });

        jLabel20.setText("Km Final :");

        c_relat_kmf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_relat_kmfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(c_relatm_data, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(0, 0, 0)
                        .addComponent(c_relat_kmi, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel20))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(btn_relatm_salvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_relatm_cancelar)))
                .addGap(20, 20, 20)
                .addComponent(c_relat_kmf, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(c_relatm_data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(c_relat_kmi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(c_relat_kmf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_relatm_salvar)
                    .addComponent(btn_relatm_cancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_relatm_novo.setText("Novo");
        btn_relatm_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_relatm_novoActionPerformed(evt);
            }
        });

        btn_relatm_editar.setText("Editar");
        btn_relatm_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_relatm_editarActionPerformed(evt);
            }
        });

        btn_relatm_excluir.setText("Excluir");
        btn_relatm_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_relatm_excluirActionPerformed(evt);
            }
        });

        cmd_print_rm.setText("Imprimir");
        cmd_print_rm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_print_rmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btn_relatm_novo)
                .addGap(40, 40, 40)
                .addComponent(btn_relatm_editar)
                .addGap(32, 32, 32)
                .addComponent(btn_relatm_excluir)
                .addGap(18, 18, 18)
                .addComponent(cmd_print_rm)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_relatm_novo)
                    .addComponent(btn_relatm_editar)
                    .addComponent(btn_relatm_excluir)
                    .addComponent(cmd_print_rm))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Relatorio Mensal", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("Relatorio");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmd_print_rmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_print_rmActionPerformed
        //Dara o titulo para seu relatorio
        MessageFormat header = new MessageFormat("Tabela Relatorio Mensal");
        MessageFormat footer = new MessageFormat("Page{0,number,integer }");
        //Chama a tabela seleciona e atribui o titulo
        try {
            tbl_relat_M.print(JTable.PrintMode.NORMAL, header, footer);

        } catch (java.awt.print.PrinterException e) {
            System.err.format("Cannot print %s%n", e.getMessage());
        }
    }//GEN-LAST:event_cmd_print_rmActionPerformed

    private void btn_relatm_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_relatm_excluirActionPerformed
        //Tela de pergunta se realmente quer excluir a linha
        int resp = 0;
        resp = JOptionPane.showConfirmDialog(null, "Deseja Excluir ?");

        // Pega a linha selecionada e se a resposta for SIM exclui da tabela
        if ((tbl_relat_M.getSelectedRow() != -1) && (resp == JOptionPane.YES_OPTION)) {

            RelatM f = new RelatM();
            RelatMDAO dao = new RelatMDAO();

            f.setId((int) tbl_relat_M.getValueAt(tbl_relat_M.getSelectedRow(), 0));
            dao.delete(f);

            readRelatorioM();   //recarrega a tabela após a alteração
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um produto para excluir.");
        }

        modoRelatM = "Excluir";
        ManipulaInterfaceRelatM();
    }//GEN-LAST:event_btn_relatm_excluirActionPerformed

    private void btn_relatm_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_relatm_editarActionPerformed
        modoRelatM = "Editar";
        ManipulaInterfaceRelatM();
    }//GEN-LAST:event_btn_relatm_editarActionPerformed

    private void btn_relatm_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_relatm_novoActionPerformed
        //Limpa os campos de inserção 
        c_relatm_data.setText("");
        c_relat_kmi.setText("");
        c_relat_kmf.setText("");
        modoRelatM = "Novo";
        ManipulaInterfaceRelatM();
    }//GEN-LAST:event_btn_relatm_novoActionPerformed

    private void c_relat_kmfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_relat_kmfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_relat_kmfActionPerformed

    private void btn_relatm_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_relatm_cancelarActionPerformed
        //Limpa os campos de inserção 
        c_relatm_data.setText("");
        c_relat_kmi.setText("");
        c_relat_kmf.setText("");
        modoRelatM = "Navegar";
    }//GEN-LAST:event_btn_relatm_cancelarActionPerformed

    private void btn_relatm_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_relatm_salvarActionPerformed

        RelatM m = new RelatM();
        //Objeto DAO que sera inserido no banco de dados
        RelatMDAO dao = new RelatMDAO();
        /*Se for uma nova operação então ele vai pegar os dados que vão ser inseridos 
            e passar os dados para o objeto determinado */
        String data = (c_relatm_data.getText());
        int Kmi = Integer.parseInt(c_relat_kmi.getText());
        int Kmf = Integer.parseInt(c_relat_kmf.getText());
        int Perc = Kmf - Kmi;
        if (modoRelatM.equals("Novo")) {
            m.setData(data);
            m.setKmi(Kmi);
            m.setKmf(Kmf);
            m.setPerc(Perc);
            dao.create(m);

        } else if (modoRelatM.equals("Editar")) {
            /*Caso a operação selecionada for "Editar" então a linha selecionada
            na tabela ira recarregar os valores para os campos para poderem ser editados*/
            m.setData(data);
            m.setKmi(Kmi);
            m.setKmf(Kmf);
            m.setPerc(Perc);
            m.setId((int) tbl_relat_M.getValueAt(tbl_relat_M.getSelectedRow(), 0));
            dao.update(m);

        }
        readRelatorioM();
        modoRelatM = "Navegar";
        
        //Limpa os campos de inserção 
        c_relatm_data.setText("");
        c_relat_kmi.setText("");
        c_relat_kmf.setText("");
        ManipulaInterfaceRelatM();

    }//GEN-LAST:event_btn_relatm_salvarActionPerformed

    private void c_relat_kmiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_relat_kmiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_relat_kmiActionPerformed

    private void c_relatm_dataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_relatm_dataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_relatm_dataActionPerformed

    private void tbl_relat_MMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_relat_MMouseClicked

        //Se clicar em linha valida valida ele ira abrir o modo selecao
        if (tbl_relat_M.getSelectedRow() != -1) {

            c_relatm_data.setText(tbl_relat_M.getValueAt(tbl_relat_M.getSelectedRow(), 1).toString());
            c_relat_kmi.setText(tbl_relat_M.getValueAt(tbl_relat_M.getSelectedRow(), 2).toString());
            c_relat_kmf.setText(tbl_relat_M.getValueAt(tbl_relat_M.getSelectedRow(), 3).toString());
            modoRelatM = "Selecao";
            ManipulaInterfaceRelatM();
        }
    }//GEN-LAST:event_tbl_relat_MMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_relatm_cancelar;
    private javax.swing.JButton btn_relatm_editar;
    private javax.swing.JButton btn_relatm_excluir;
    private javax.swing.JButton btn_relatm_novo;
    private javax.swing.JButton btn_relatm_salvar;
    private javax.swing.JTextField c_relat_kmf;
    private javax.swing.JTextField c_relat_kmi;
    private javax.swing.JTextField c_relatm_data;
    private javax.swing.JButton cmd_print_rm;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbl_relat_M;
    // End of variables declaration//GEN-END:variables

}
