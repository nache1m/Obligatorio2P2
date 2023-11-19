/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz;

import Dominio.Utilidades.ArchivoGrabacion;
import Dominio.Postulante;
import Dominio.Puesto;
import Dominio.Sistema;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

public class VentanaConsultaPuestos extends javax.swing.JFrame implements PropertyChangeListener {

    private Sistema modelo;
    private boolean ag = false;
    public VentanaConsultaPuestos(Sistema miModelo) {
        this.modelo = miModelo;
        initComponents();
        modelo.agregarEscuchas(this);
        lstPuestos.setListData(modelo.getListaPuestos().toArray());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstPuestos = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        spnNivel = new javax.swing.JSpinner();
        btnConsultar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstPostulantes = new javax.swing.JList<>();
        btnCancelar = new javax.swing.JButton();
        btnExportar = new javax.swing.JButton();
        lblBajaPostulante = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta para Puestos");
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel2.setText("Puestos:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(34, 71, 56, 16);

        jScrollPane1.setViewportView(lstPuestos);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(34, 93, 321, 130);

        jLabel3.setText("Nivel:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(34, 252, 52, 22);
        getContentPane().add(spnNivel);
        spnNivel.setBounds(123, 252, 111, 22);

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });
        getContentPane().add(btnConsultar);
        btnConsultar.setBounds(275, 253, 80, 22);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(34, 293, 321, 10);

        jLabel4.setText("Postulantes:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(34, 309, 62, 16);

        jScrollPane2.setViewportView(lstPostulantes);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(34, 331, 321, 130);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar);
        btnCancelar.setBounds(34, 527, 76, 23);

        btnExportar.setText("Exportar");
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });
        getContentPane().add(btnExportar);
        btnExportar.setBounds(274, 527, 80, 23);

        lblBajaPostulante.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblBajaPostulante.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBajaPostulante.setText("Consulta para puestos");
        getContentPane().add(lblBajaPostulante);
        lblBajaPostulante.setBounds(120, 20, 140, 16);

        setSize(new java.awt.Dimension(403, 587));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        Puesto p = (Puesto) lstPuestos.getSelectedValue();
        int nivel = (int) spnNivel.getValue();
        ArrayList<Postulante> pstCumplen = modelo.ordenarPostulantesPorEntrevista(this.modelo.listaPostulantesParaPuesto(p, nivel));
        lstPostulantes.setListData(modelo.doyArrayListConMasDatos(pstCumplen));

    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        ListModel<String> misStrings = lstPostulantes.getModel();
        Puesto p = (Puesto) lstPuestos.getSelectedValue();
        this.grabarArchivo("Consulta.txt", misStrings, p);
        JOptionPane.showMessageDialog(null, "La información fue exportada con éxito", "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnExportarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnExportar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblBajaPostulante;
    private javax.swing.JList<String> lstPostulantes;
    private javax.swing.JList lstPuestos;
    private javax.swing.JSpinner spnNivel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        lstPuestos.setListData(modelo.getListaPuestos().toArray());
    }

     public void grabarArchivo (String miArchivo, ListModel<String> misPostulantes, Puesto p) {
        ArchivoGrabacion arch = new ArchivoGrabacion (miArchivo, this.ag);
        this.setag(true); // Luego de usar el método la primera vez siempre le voy a pasar un valor true para que siga extendiendo el archivo en vez de hacer uno nuevo
        arch.grabarLinea(p.getNombre());
        System.out.println(p.getNombre());
        for (int i = 0; i < misPostulantes.getSize(); i++) {   
            String [] res = misPostulantes.getElementAt(i).split(" \\s*/\\s*");
            String txt = res[0] + " / " + res[1] + " / " + res[2];
            arch.grabarLinea(txt);
        }
        arch.cerrar();
        
    }

    private void setag(boolean b) {
       this.ag = b;
    }

}
