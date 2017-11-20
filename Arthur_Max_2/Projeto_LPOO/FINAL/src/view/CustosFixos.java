/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.text.MessageFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.CustoF;
import model.dao.CustoFDAO;

/**
 *
 * @author Max
 */
public final class CustosFixos extends javax.swing.JInternalFrame {

    String modoCustoF;
    
    /**
     * Creates new form CustosFixos
     */
    public CustosFixos() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) tbl_cf_fix.getModel();
        tbl_cf_fix.setRowSorter(new TableRowSorter(modelo));
        
        //Recarregar a lista criada
        readCustosFixos();

        modoCustoF = "Navegar";
        ManipulaInterfaceCustoF();
    }

    public void readCustosFixos() {
        DefaultTableModel modelo = (DefaultTableModel) tbl_cf_fix.getModel();
        //Para que não duplique os valores ao inserir
        modelo.setNumRows(0);
        //Criando o objeto DAO para ser passado na nossa Jtabel
        CustoFDAO fdao = new CustoFDAO();

        //Ira pegar os valores que estão na lista e passando para o objeto
        for (CustoF f : fdao.read()) {
            modelo.addRow(new Object[]{
                //Vao pegar os valores que estão no banco
                f.getId(),
                f.getData(),
                f.getNome(),
                f.getPrd(),
                f.getPreco()
            });
        }
    }

    public void ManipulaInterfaceCustoF() { //Manipulaçao da Tabela
        //Modo de operaçao dos botoes utilizados no projeto
        switch (modoCustoF) {

            case "Navegar":
                //Somente o botao novo ira estar disponivel
                btn_cf_salvar.setEnabled(false);
                btn_cf_cancelar.setEnabled(false);
                c_cf_preco.setEnabled(false);
                c_cf_prd.setEnabled(false);
                c_cf_data.setEnabled(false);
                c_cf_desc.setEnabled(false);
                btn_cf_novo.setEnabled(true);
                btn_cf_editar.setEnabled(false);
                btn_cf_excluir.setEnabled(false);
                break;

            case "Novo":
                //Quando Apertado o botao Novo ira liberar os campos para o cadastro
                btn_cf_salvar.setEnabled(true);
                btn_cf_cancelar.setEnabled(true);
                c_cf_preco.setEnabled(true);
                c_cf_prd.setEnabled(true);
                c_cf_data.setEnabled(true);
                c_cf_desc.setEnabled(true);
                btn_cf_novo.setEnabled(false);
                btn_cf_editar.setEnabled(false);
                btn_cf_excluir.setEnabled(false);
                break;

            case "Editar":
                btn_cf_salvar.setEnabled(true);
                btn_cf_cancelar.setEnabled(true);
                c_cf_preco.setEnabled(true);
                c_cf_prd.setEnabled(true);
                c_cf_data.setEnabled(true);
                c_cf_desc.setEnabled(true);
                btn_cf_novo.setEnabled(true);
                btn_cf_editar.setEnabled(false);
                btn_cf_excluir.setEnabled(false);
                break;

            case "Excluir":
                // Somente Botao Novo estara liberado
                btn_cf_salvar.setEnabled(false);
                btn_cf_cancelar.setEnabled(false);
                c_cf_preco.setEnabled(false);
                c_cf_prd.setEnabled(false);
                c_cf_data.setEnabled(false);
                c_cf_desc.setEnabled(false);
                btn_cf_novo.setEnabled(true);
                btn_cf_editar.setEnabled(false);
                btn_cf_excluir.setEnabled(false);
                break;

            case "Selecao":
                //Os botões editar e exluir estaram disponiveis para fazer a alterção da tabela
                btn_cf_salvar.setEnabled(false);
                btn_cf_cancelar.setEnabled(false);
                c_cf_data.setEnabled(false);
                c_cf_desc.setEnabled(false);
                btn_cf_novo.setEnabled(false);
                btn_cf_editar.setEnabled(true);
                btn_cf_excluir.setEnabled(true);
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

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_cf_fix = new javax.swing.JTable();
        btn_cf_novo = new javax.swing.JButton();
        btn_cf_editar = new javax.swing.JButton();
        btn_cf_excluir = new javax.swing.JButton();
        cmdf_print = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        c_cf_data = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        c_cf_desc = new javax.swing.JTextField();
        btn_cf_salvar = new javax.swing.JButton();
        btn_cf_cancelar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        c_cf_prd = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        c_cf_preco = new javax.swing.JTextField();

        setClosable(true);

        tbl_cf_fix.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tbl_cf_fix.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Data", "Descrição", "Periodo ", "Preço $"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
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
        tbl_cf_fix.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_cf_fixMouseClicked(evt);
            }
        });
        tbl_cf_fix.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbl_cf_fixKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_cf_fix);

        btn_cf_novo.setText("Novo");
        btn_cf_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cf_novoActionPerformed(evt);
            }
        });

        btn_cf_editar.setText("Editar");
        btn_cf_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cf_editarActionPerformed(evt);
            }
        });

        btn_cf_excluir.setText("Excluir");
        btn_cf_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cf_excluirActionPerformed(evt);
            }
        });

        cmdf_print.setText("Imprimir");
        cmdf_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdf_printActionPerformed(evt);
            }
        });

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Cadastro Produto"));

        jLabel3.setText("Data :");

        c_cf_data.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_cf_dataActionPerformed(evt);
            }
        });

        jLabel4.setText("Descrição: ");

        c_cf_desc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_cf_descActionPerformed(evt);
            }
        });

        btn_cf_salvar.setText("Salvar");
        btn_cf_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cf_salvarActionPerformed(evt);
            }
        });

        btn_cf_cancelar.setText("Cancelar");
        btn_cf_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cf_cancelarActionPerformed(evt);
            }
        });

        jLabel8.setText("Periodo :");

        c_cf_prd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_cf_prdActionPerformed(evt);
            }
        });

        jLabel9.setText("Preço :");

        c_cf_preco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_cf_precoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(c_cf_data, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(c_cf_desc, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(c_cf_prd, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(c_cf_preco, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(btn_cf_salvar)
                        .addGap(26, 26, 26)
                        .addComponent(btn_cf_cancelar)))
                .addGap(0, 161, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(c_cf_data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(c_cf_desc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(c_cf_prd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9))
                    .addComponent(c_cf_preco))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cf_cancelar)
                    .addComponent(btn_cf_salvar))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_cf_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_cf_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_cf_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmdf_print)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cf_novo)
                    .addComponent(btn_cf_excluir)
                    .addComponent(btn_cf_editar)
                    .addComponent(cmdf_print))
                .addGap(28, 28, 28)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Custos Fixo", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void c_cf_precoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_cf_precoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_cf_precoActionPerformed

    private void c_cf_prdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_cf_prdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_cf_prdActionPerformed

    private void btn_cf_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cf_cancelarActionPerformed
        //Limpa os campos de inserção 
        c_cf_data.setText("");
        c_cf_desc.setText("");
        modoCustoF = "Navegar";
        ManipulaInterfaceCustoF();
    }//GEN-LAST:event_btn_cf_cancelarActionPerformed

    private void btn_cf_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cf_salvarActionPerformed
        //Apos clicar em salvar ele atribui os valores digitados e adicionado na variavel D

        CustoF f = new CustoF();
         //Objeto DAO que sera inserido no banco de dados
        CustoFDAO dao = new CustoFDAO();
        
        if (modoCustoF.equals("Novo")) {
            /*Se for uma nova operação então ele vai pegar os dados que vão ser inseridos 
            e passar os dados para o objeto determinado */
            f.setData(c_cf_data.getText());
            f.setNome(c_cf_desc.getText());
            f.setPrd(c_cf_prd.getText());
            f.setPreco(Double.parseDouble(c_cf_preco.getText()));
            dao.create(f);
        } else if (modoCustoF.equals("Editar")) {
             /*Caso a operação selecionada for "Editar" então a linha selecionada
            na tabela ira recarregar os valores para os campos para poderem ser editados*/
            f.setData(c_cf_data.getText());
            f.setNome(c_cf_desc.getText());
            f.setPrd(c_cf_prd.getText());
            f.setPreco(Double.parseDouble(c_cf_preco.getText()));
            f.setId((int) tbl_cf_fix.getValueAt(tbl_cf_fix.getSelectedRow(), 0));
            dao.update(f);
        }

        readCustosFixos();
        modoCustoF = "Navegar";
        //Limpa os campos de inserção 
        c_cf_data.setText("");
        c_cf_desc.setText("");
        c_cf_prd.setText("");
        c_cf_preco.setText("");
        ManipulaInterfaceCustoF();
    }//GEN-LAST:event_btn_cf_salvarActionPerformed

    private void c_cf_descActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_cf_descActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_cf_descActionPerformed

    private void c_cf_dataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_cf_dataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_cf_dataActionPerformed

    private void cmdf_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdf_printActionPerformed
         //Dara o titulo para seu relatorio
        MessageFormat header = new MessageFormat("Tabela Custo Fixo");
        MessageFormat footer = new MessageFormat("Page{0,number,integer }");
        //Chama a tabela seleciona e atribui o titulo
        try {
            tbl_cf_fix.print(JTable.PrintMode.NORMAL, header, footer);

        } catch (java.awt.print.PrinterException e) {
            System.err.format("Cannot print %s%n", e.getMessage());
        }
    }//GEN-LAST:event_cmdf_printActionPerformed

    private void btn_cf_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cf_excluirActionPerformed
        //Tela de pergunta se realmente quer excluir a linha
        int resp =0;
        resp = JOptionPane.showConfirmDialog(null, "Deseja Excluir ?");
        
        
        // Pega a linha selecionada e se a resposta for SIM exclui da tabela
        if ((tbl_cf_fix.getSelectedRow() != -1) && (resp == JOptionPane.YES_OPTION )){

            CustoF f = new CustoF();
            CustoFDAO dao = new CustoFDAO();

            f.setId((int) tbl_cf_fix.getValueAt(tbl_cf_fix.getSelectedRow(), 0));
            dao.delete(f);
            readCustosFixos();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um produto para excluir.");
        }
        modoCustoF = "Excluir";
        ManipulaInterfaceCustoF();
    }//GEN-LAST:event_btn_cf_excluirActionPerformed

    private void btn_cf_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cf_editarActionPerformed
        modoCustoF = "Editar";
        ManipulaInterfaceCustoF();
    }//GEN-LAST:event_btn_cf_editarActionPerformed

    private void btn_cf_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cf_novoActionPerformed
        //Limpa os campos de inserção 
        c_cf_data.setText("");
        c_cf_desc.setText("");
        c_cf_prd.setText("");
        c_cf_preco.setText("");
        modoCustoF = "Novo";
        ManipulaInterfaceCustoF();
    }//GEN-LAST:event_btn_cf_novoActionPerformed

    private void tbl_cf_fixMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_cf_fixMouseClicked
        //Se clicar em linha valida valida ele ira abrir o modo selecao
        if (tbl_cf_fix.getSelectedRow() != -1) {

            c_cf_data.setText(tbl_cf_fix.getValueAt(tbl_cf_fix.getSelectedRow(), 1).toString());
            c_cf_desc.setText(tbl_cf_fix.getValueAt(tbl_cf_fix.getSelectedRow(), 2).toString());
            c_cf_prd.setText(tbl_cf_fix.getValueAt(tbl_cf_fix.getSelectedRow(), 3).toString());
            c_cf_preco.setText(tbl_cf_fix.getValueAt(tbl_cf_fix.getSelectedRow(), 4).toString());
            modoCustoF = "Selecao";
            ManipulaInterfaceCustoF();

        }
    }//GEN-LAST:event_tbl_cf_fixMouseClicked

    private void tbl_cf_fixKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_cf_fixKeyReleased
    }//GEN-LAST:event_tbl_cf_fixKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cf_cancelar;
    private javax.swing.JButton btn_cf_editar;
    private javax.swing.JButton btn_cf_excluir;
    private javax.swing.JButton btn_cf_novo;
    private javax.swing.JButton btn_cf_salvar;
    private javax.swing.JTextField c_cf_data;
    private javax.swing.JTextField c_cf_desc;
    private javax.swing.JTextField c_cf_prd;
    private javax.swing.JTextField c_cf_preco;
    private javax.swing.JButton cmdf_print;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable tbl_cf_fix;
    // End of variables declaration//GEN-END:variables
}
