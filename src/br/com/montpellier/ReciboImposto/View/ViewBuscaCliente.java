/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.montpellier.ReciboImposto.View;

import br.com.montpellier.ReciboImposto.Controller.ControllerCliente;
import br.com.montpellier.ReciboImposto.Controller.ControllerComanda;
import br.com.montpellier.ReciboImposto.Model.ModelCliente;
import br.com.montpellier.ReciboImposto.Singleton.GerenciadorDeTelas;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author santos
 */
public class ViewBuscaCliente extends javax.swing.JFrame {

    /**
     * Creates new form ViewBuscaCliente
     */
    public ViewBuscaCliente() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) jtBuscaClientePorNome.getModel();
        jtBuscaClientePorNome.setRowSorter(new TableRowSorter(modelo));
        readJTable();
    }
    
     public void readJTable() {

        DefaultTableModel modelo = (DefaultTableModel) jtBuscaClientePorNome.getModel();
        modelo.setNumRows(0);
        jtBuscaClientePorNome.getColumnModel().getColumn(0).setPreferredWidth(9);
        jtBuscaClientePorNome.getColumnModel().getColumn(1).setPreferredWidth(90);
        jtBuscaClientePorNome.getColumnModel().getColumn(2).setPreferredWidth(80);
        jtBuscaClientePorNome.getColumnModel().getColumn(3).setPreferredWidth(78);
       
        ControllerCliente clientContr = new ControllerCliente();

        DefaultTableCellRenderer tabela = new DefaultTableCellRenderer();
        tabela.setHorizontalAlignment(SwingConstants.LEFT);
        jtBuscaClientePorNome.getColumnModel().getColumn(0).setCellRenderer(tabela);

        for (ModelCliente client : clientContr.read()) {

            modelo.addRow(new Object[]{
                client.getCodigo(),
                client.getNome(),
                client.getEmail(),
                client.getTelefone(),
            });

        }
    }

    public void readJTableBusca(String nome) {

        DefaultTableModel modelo = (DefaultTableModel) jtBuscaClientePorNome.getModel();
        modelo.setNumRows(0);
        jtBuscaClientePorNome.getColumnModel().getColumn(0).setPreferredWidth(9);
        jtBuscaClientePorNome.getColumnModel().getColumn(1).setPreferredWidth(90);
        jtBuscaClientePorNome.getColumnModel().getColumn(2).setPreferredWidth(80);
        jtBuscaClientePorNome.getColumnModel().getColumn(3).setPreferredWidth(78);
        
        ControllerCliente clientContr = new ControllerCliente();

        DefaultTableCellRenderer tabela = new DefaultTableCellRenderer();
        tabela.setHorizontalAlignment(SwingConstants.LEFT);
        jtBuscaClientePorNome.getColumnModel().getColumn(0).setCellRenderer(tabela);

        for (ModelCliente client : clientContr.readForNome(nome)) {

            modelo.addRow(new Object[]{
                client.getCodigo(),
                client.getNome(),
                client.getEmail(),
                client.getTelefone(),
            });
                

        }
    }

    public void readJTableQuery(String cliente) {

        DefaultTableModel modelo = (DefaultTableModel) jtBuscaClientePorNome.getModel();
        modelo.setNumRows(0);
        ControllerCliente clientContr = new ControllerCliente();

        DefaultTableCellRenderer tabela = new DefaultTableCellRenderer();
        tabela.setHorizontalAlignment(SwingConstants.LEFT);
        jtBuscaClientePorNome.getColumnModel().getColumn(0).setCellRenderer(tabela);

        for (ModelCliente client : clientContr.readQuery(cliente)) {

            modelo.addRow(new Object[]{
                client.getCodigo(),
                client.getNome(),
                client.getEmail(),
                client.getTelefone(),
            });

        }

    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblBuscaCliente = new javax.swing.JLabel();
        lblFiltro = new javax.swing.JLabel();
        tfBuscaClientePorNome = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtBuscaClientePorNome = new javax.swing.JTable();
        btnConfirmar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblBuscaCliente.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lblBuscaCliente.setText("BUSCA DE CLIENTE");

        lblFiltro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblFiltro.setText("Filtro");

        tfBuscaClientePorNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfBuscaClientePorNomeActionPerformed(evt);
            }
        });
        tfBuscaClientePorNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfBuscaClientePorNomeKeyReleased(evt);
            }
        });

        jtBuscaClientePorNome.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Cod", "Nome", "E-mail", "Telefone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtBuscaClientePorNome.getTableHeader().setReorderingAllowed(false);
        jtBuscaClientePorNome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtBuscaClientePorNomeMouseClicked(evt);
            }
        });
        jtBuscaClientePorNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtBuscaClientePorNomeKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jtBuscaClientePorNome);
        if (jtBuscaClientePorNome.getColumnModel().getColumnCount() > 0) {
            jtBuscaClientePorNome.getColumnModel().getColumn(0).setResizable(false);
            jtBuscaClientePorNome.getColumnModel().getColumn(1).setResizable(false);
            jtBuscaClientePorNome.getColumnModel().getColumn(2).setResizable(false);
            jtBuscaClientePorNome.getColumnModel().getColumn(3).setResizable(false);
        }

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addComponent(lblBuscaCliente)
                .addGap(65, 65, 65))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblFiltro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfBuscaClientePorNome, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnConfirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(23, 23, 23))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBuscaCliente)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFiltro)
                    .addComponent(tfBuscaClientePorNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmar)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tfBuscaClientePorNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfBuscaClientePorNomeActionPerformed

        JOptionPane.showMessageDialog(rootPane, "Null!", "Aviso do Sistema.", JOptionPane.WARNING_MESSAGE);
//       ControllerComanda testarCliente = new ControllerComanda();
//        if (testarCliente.testaClientePorCodigo(tfBuscaClientePorNome.getText().toString()) != true) {
//            lblFiltro.setForeground(Color.red);
//            JOptionPane.showMessageDialog(rootPane, "Cliente não encontrado!.", "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
//
//        } else {
//            
//            TableRowSorter rs = (TableRowSorter) jtBuscaClientePorNome.getRowSorter();
//            rs.setRowFilter(RowFilter.regexFilter("(?i)" + tfBuscaClientePorNome.getText(), 0, 1));
//           //readJTableBusca(tfBuscaClientePorNome.getText());
//            
////            tfNomeCliente.setText(clienteControl.queryClientePorCodigo(tfCodigoCliente.getText()).getNome());
////            tfTelefone.setText(clienteControl.queryClientePorCodigo(tfCodigoCliente.getText()).getTelefone());
////            tfEmail.setText(clienteControl.queryClientePorCodigo(tfCodigoCliente.getText()).getEmail());
////            this.dispose();
////            GerenciadorDeTelas.getInstanse().getViewNovaComanda().setVisible(true);
//
//            //lblLogin.setForeground(Color.BLACK);
//        };
    }//GEN-LAST:event_tfBuscaClientePorNomeActionPerformed

    private void tfBuscaClientePorNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfBuscaClientePorNomeKeyReleased
        TableRowSorter rs = (TableRowSorter) jtBuscaClientePorNome.getRowSorter();
        rs.setRowFilter(RowFilter.regexFilter("(?i)" + tfBuscaClientePorNome.getText(), 0, 1));
    }//GEN-LAST:event_tfBuscaClientePorNomeKeyReleased
    ModelCliente clientModel = new ModelCliente();
    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        if (jtBuscaClientePorNome.getSelectedRow() != -1) {
            this.dispose();
            GerenciadorDeTelas.getInstanse().getViewNovaComanda().setVisible(true);
            GerenciadorDeTelas.getInstanse().getViewNovaComanda().preencheCliente(clientModel);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione um Cliente", "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void jtBuscaClientePorNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtBuscaClientePorNomeKeyReleased
       clientModel.setCodigo(0);
        clientModel.setNome("");
        clientModel.setCpf("");
        clientModel.setCnpj("");
        clientModel.setCidade("");
        clientModel.setEstado("");

        if (jtBuscaClientePorNome.getSelectedRow() != -1) {

//            //DefaultTableModel modelo = (DefaultTableModel) jtClientes.getModel();
//            // DefaultTableModel modelo = (DefaultTableModel) jtClientes.getModel();
//            clientModel.setCodigo(Integer.parseInt(jtClientes.getValueAt(jtClientes.getSelectedRow(), 0).toString()));
//            //System.out.println(jtClientes.getValueAt(jtClientes.getSelectedRow(), 0).toString());
//            clientModel.setNome(jtClientes.getValueAt(jtClientes.getSelectedRow(), 1).toString());
//            //System.out.println(jtClientes.getValueAt(jtClientes.getSelectedRow(), 0).toString());
//            clientModel.setCpf(jtClientes.getValueAt(jtClientes.getSelectedRow(), 2).toString());
//            // System.out.println(jtClientes.getValueAt(jtClientes.getSelectedRow(), 1).toString());
//            clientModel.setCnpj(jtClientes.getValueAt(jtClientes.getSelectedRow(), 3).toString());
//            // System.out.println(jtClientes.getValueAt(jtClientes.getSelectedRow(), 2).toString());
//            clientModel.setCidade(jtClientes.getValueAt(jtClientes.getSelectedRow(), 4).toString());
//            clientModel.setEstado(jtClientes.getValueAt(jtClientes.getSelectedRow(), 5).toString());
              
              ControllerCliente clientControl = new ControllerCliente();
             String indice = jtBuscaClientePorNome.getValueAt(jtBuscaClientePorNome.getSelectedRow(), 0).toString();
             clientModel.setCodigo(clientControl.queryClientePorCodigo(indice).getCodigo());
             clientModel.setNome(clientControl.queryClientePorCodigo(indice).getNome());
//             clientModel.setCpf(clientControl.queryClientePorCodigo(indice).getCpf());
//             clientModel.setCnpj(clientControl.queryClientePorCodigo(indice).getCnpj());
//             clientModel.setCidade(clientControl.queryClientePorCodigo(indice).getCidade());
//             clientModel.setEstado(clientControl.queryClientePorCodigo(indice).getEstado());
//             clientModel.setRua(clientControl.queryClientePorCodigo(indice).getRua());
//             clientModel.setBairro(clientControl.queryClientePorCodigo(indice).getBairro());
             clientModel.setTelefone(clientControl.queryClientePorCodigo(indice).getTelefone());
             clientModel.setEmail(clientControl.queryClientePorCodigo(indice).getEmail());
        }
    }//GEN-LAST:event_jtBuscaClientePorNomeKeyReleased

    private void jtBuscaClientePorNomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtBuscaClientePorNomeMouseClicked
        clientModel.setCodigo(0);
        clientModel.setNome("");
        clientModel.setCpf("");
        clientModel.setCnpj("");
        clientModel.setCidade("");
        clientModel.setEstado("");

        if (jtBuscaClientePorNome.getSelectedRow() != -1) {

//            //DefaultTableModel modelo = (DefaultTableModel) jtClientes.getModel();
//            // DefaultTableModel modelo = (DefaultTableModel) jtClientes.getModel();
//            clientModel.setCodigo(Integer.parseInt(jtClientes.getValueAt(jtClientes.getSelectedRow(), 0).toString()));
//            //System.out.println(jtClientes.getValueAt(jtClientes.getSelectedRow(), 0).toString());
//            clientModel.setNome(jtClientes.getValueAt(jtClientes.getSelectedRow(), 1).toString());
//            //System.out.println(jtClientes.getValueAt(jtClientes.getSelectedRow(), 0).toString());
//            clientModel.setCpf(jtClientes.getValueAt(jtClientes.getSelectedRow(), 2).toString());
//            // System.out.println(jtClientes.getValueAt(jtClientes.getSelectedRow(), 1).toString());
//            clientModel.setCnpj(jtClientes.getValueAt(jtClientes.getSelectedRow(), 3).toString());
//            // System.out.println(jtClientes.getValueAt(jtClientes.getSelectedRow(), 2).toString());
//            clientModel.setCidade(jtClientes.getValueAt(jtClientes.getSelectedRow(), 4).toString());
//            clientModel.setEstado(jtClientes.getValueAt(jtClientes.getSelectedRow(), 5).toString());
              
              ControllerCliente clientControl = new ControllerCliente();
             String indice = jtBuscaClientePorNome.getValueAt(jtBuscaClientePorNome.getSelectedRow(), 0).toString();
             clientModel.setCodigo(clientControl.queryClientePorCodigo(indice).getCodigo());
             clientModel.setNome(clientControl.queryClientePorCodigo(indice).getNome());
//             clientModel.setCpf(clientControl.queryClientePorCodigo(indice).getCpf());
//             clientModel.setCnpj(clientControl.queryClientePorCodigo(indice).getCnpj());
//             clientModel.setCidade(clientControl.queryClientePorCodigo(indice).getCidade());
//             clientModel.setEstado(clientControl.queryClientePorCodigo(indice).getEstado());
//             clientModel.setRua(clientControl.queryClientePorCodigo(indice).getRua());
//             clientModel.setBairro(clientControl.queryClientePorCodigo(indice).getBairro());
             clientModel.setTelefone(clientControl.queryClientePorCodigo(indice).getTelefone());
             clientModel.setEmail(clientControl.queryClientePorCodigo(indice).getEmail());
        }
    }//GEN-LAST:event_jtBuscaClientePorNomeMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(ViewBuscaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewBuscaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewBuscaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewBuscaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewBuscaCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtBuscaClientePorNome;
    private javax.swing.JLabel lblBuscaCliente;
    private javax.swing.JLabel lblFiltro;
    private javax.swing.JTextField tfBuscaClientePorNome;
    // End of variables declaration//GEN-END:variables
}
