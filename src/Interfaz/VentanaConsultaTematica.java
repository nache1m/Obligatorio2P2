/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz;

import Dominio.Sistema;
import Dominio.Tematica;

/**
 *
 * @author elnac
 */
public class VentanaConsultaTematica extends javax.swing.JFrame {

    private Sistema modelo;

    public VentanaConsultaTematica(Sistema modelo) {
        initComponents();
        this.modelo = modelo;
        lstTematicas.setListData(modelo.getListaTematicas().toArray());
        lstTematicas.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                Tematica t = (Tematica) lstTematicas.getSelectedValue();
                if (t != null){
                    String msj1 = modelo.cantidadPostulantesNivelMayorA5(t)+"";
                    txtCantidadPostulantes.setText(msj1);
                    String msj2 = modelo.cantidadPuestosRequierenConocimiento(t)+"";
                    txtCantidadPuestos.setText(msj2);
                }
            }
        });
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblTematicas = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstTematicas = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCantidadPostulantes = new javax.swing.JLabel();
        txtCantidadPuestos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta por temática");
        setResizable(false);
        getContentPane().setLayout(null);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Consulta por temática");
        getContentPane().add(lblTitulo);
        lblTitulo.setBounds(140, 20, 140, 16);

        lblTematicas.setText("Tematicas:");
        getContentPane().add(lblTematicas);
        lblTematicas.setBounds(30, 70, 70, 16);

        jScrollPane1.setViewportView(lstTematicas);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(110, 70, 160, 130);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel1.setText("Estadísticas");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(170, 240, 80, 16);

        jLabel2.setText("- Cantidad de puestos que requieren dicha temática:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 310, 320, 20);

        jLabel3.setText("- Cantidad de postulantes con nivel mayor a 5 en la temática:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 270, 340, 20);
        getContentPane().add(txtCantidadPostulantes);
        txtCantidadPostulantes.setBounds(380, 270, 30, 20);
        getContentPane().add(txtCantidadPuestos);
        txtCantidadPuestos.setBounds(340, 310, 40, 20);

        setSize(new java.awt.Dimension(437, 403));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTematicas;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JList lstTematicas;
    private javax.swing.JLabel txtCantidadPostulantes;
    private javax.swing.JLabel txtCantidadPuestos;
    // End of variables declaration//GEN-END:variables
}
