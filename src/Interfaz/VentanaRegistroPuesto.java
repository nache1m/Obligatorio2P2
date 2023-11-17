/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz;

import Dominio.Sistema;
import Dominio.Tematica;
import java.util.ArrayList;

/**
 *
 * @author elnac
 */
public class VentanaRegistroPuesto extends javax.swing.JFrame {
    private Sistema modelo;
    public VentanaRegistroPuesto(Sistema miModelo) {
        this.modelo = miModelo;
        lstTemas.setListData(modelo.getListaTematicas().toArray());
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

        lblTemas = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblNombre1 = new javax.swing.JLabel();
        cbTipo = new javax.swing.JComboBox<>();
        lblTipo1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstTemasRequeridos = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstTemas = new javax.swing.JList();
        lblTemas1 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnRegistrar1 = new javax.swing.JButton();
        btnSumar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        lblTemas.setText("Requeridos:");
        getContentPane().add(lblTemas);
        lblTemas.setBounds(230, 170, 70, 16);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Registro de puesto");
        getContentPane().add(lblTitulo);
        lblTitulo.setBounds(140, 30, 130, 16);

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        getContentPane().add(txtNombre);
        txtNombre.setBounds(140, 60, 170, 22);

        lblNombre1.setText("Nombre:");
        getContentPane().add(lblNombre1);
        lblNombre1.setBounds(51, 65, 50, 16);

        cbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoActionPerformed(evt);
            }
        });
        getContentPane().add(cbTipo);
        cbTipo.setBounds(140, 110, 170, 22);

        lblTipo1.setText("Tipo:");
        getContentPane().add(lblTipo1);
        lblTipo1.setBounds(50, 110, 50, 16);

        jScrollPane2.setViewportView(lstTemasRequeridos);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(210, 190, 100, 120);

        jScrollPane3.setViewportView(lstTemas);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(50, 190, 100, 120);

        lblTemas1.setText("Temas:");
        getContentPane().add(lblTemas1);
        lblTemas1.setBounds(80, 170, 50, 16);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar);
        btnCancelar.setBounds(60, 350, 90, 23);

        btnRegistrar1.setText("Registrar");
        btnRegistrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrar1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar1);
        btnRegistrar1.setBounds(215, 350, 90, 23);

        btnSumar.setText("+");
        getContentPane().add(btnSumar);
        btnSumar.setBounds(170, 230, 20, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void cbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTipoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnRegistrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrar1ActionPerformed
        String nombre = txtNombre.getText();
        String tipo = cbTipo.getSelectedItem().toString();
        ArrayList <Tematica> lista = modelo.getListaTematicas();
    }//GEN-LAST:event_btnRegistrar1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrar1;
    private javax.swing.JButton btnSumar;
    private javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblTemas;
    private javax.swing.JLabel lblTemas1;
    private javax.swing.JLabel lblTipo1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JList lstTemas;
    private javax.swing.JList lstTemasRequeridos;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
