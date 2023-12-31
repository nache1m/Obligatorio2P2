//Ignacio Parrado - 303400
//Ezequiel Peña - 224585
package Interfaz;

import Dominio.Puesto;
import Dominio.Sistema;
import Dominio.Tematica;
import Excepciones.CampoVacioException;
import Excepciones.PuestoYaExisteException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

/**
 *
 * @author elnac
 */
public class VentanaRegistroPuesto extends javax.swing.JFrame {

    private Sistema modelo;
    private ArrayList<Tematica> temasRequeridos = new ArrayList();
    private ArrayList<Tematica> listaTemasDisponibles;

    public VentanaRegistroPuesto(Sistema miModelo) {
        initComponents();
        grupoBotones.add(rbtnMixto);
        grupoBotones.add(rbtnPresencial);
        grupoBotones.add(rbtnRemoto);
        rbtnPresencial.setSelected(true);
        this.modelo = miModelo;
        lstTemas.setListData(modelo.getListaTematicas().toArray());
        listaTemasDisponibles = new ArrayList(modelo.getListaTematicas());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBotones = new javax.swing.ButtonGroup();
        lblTemas = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblNombre1 = new javax.swing.JLabel();
        lblTipo1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstTemasRequeridos = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstTemas = new javax.swing.JList();
        lblTemas1 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnRegistrar1 = new javax.swing.JButton();
        btnSumar = new javax.swing.JButton();
        rbtnRemoto = new javax.swing.JRadioButton();
        rbtnPresencial = new javax.swing.JRadioButton();
        rbtnMixto = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro de Puesto");
        setResizable(false);
        getContentPane().setLayout(null);

        lblTemas.setText("Requeridos:");
        getContentPane().add(lblTemas);
        lblTemas.setBounds(270, 170, 70, 16);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Registro de puesto");
        getContentPane().add(lblTitulo);
        lblTitulo.setBounds(120, 20, 130, 16);

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        getContentPane().add(txtNombre);
        txtNombre.setBounds(110, 60, 240, 22);

        lblNombre1.setText("Nombre:");
        getContentPane().add(lblNombre1);
        lblNombre1.setBounds(50, 60, 50, 16);

        lblTipo1.setText("Tipo:");
        getContentPane().add(lblTipo1);
        lblTipo1.setBounds(50, 110, 50, 16);

        jScrollPane2.setViewportView(lstTemasRequeridos);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(250, 190, 100, 120);

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
        btnCancelar.setBounds(50, 350, 90, 23);

        btnRegistrar1.setText("Registrar");
        btnRegistrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrar1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar1);
        btnRegistrar1.setBounds(260, 350, 90, 23);

        btnSumar.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnSumar.setText("Agregar");
        btnSumar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSumarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSumar);
        btnSumar.setBounds(160, 220, 80, 20);

        rbtnRemoto.setText("Remoto");
        rbtnRemoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnRemotoActionPerformed(evt);
            }
        });
        getContentPane().add(rbtnRemoto);
        rbtnRemoto.setBounds(280, 110, 90, 21);

        rbtnPresencial.setText("Presencial");
        rbtnPresencial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnPresencialActionPerformed(evt);
            }
        });
        getContentPane().add(rbtnPresencial);
        rbtnPresencial.setBounds(110, 110, 90, 21);

        rbtnMixto.setText("Mixto");
        rbtnMixto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnMixtoActionPerformed(evt);
            }
        });
        getContentPane().add(rbtnMixto);
        rbtnMixto.setBounds(210, 110, 70, 21);

        setSize(new java.awt.Dimension(419, 440));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnRegistrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrar1ActionPerformed
        String nombre = txtNombre.getText();
        int tipoDeTrabajo;
        // Mixto = 0
        // Remoto = 1
        // Presencial = 2
        if (rbtnMixto.isSelected()) {
            tipoDeTrabajo = 0;
        } else {
            if (rbtnPresencial.isSelected()) {
                tipoDeTrabajo = 2;
            } else {
                tipoDeTrabajo = 1;
            }
        }
        ListModel<Tematica> model = lstTemasRequeridos.getModel();
        int size = model.getSize();
        ArrayList<Tematica> tematicasRequeridas = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Tematica tematica = model.getElementAt(i);
            tematicasRequeridas.add(tematica);
        }
        try {
            if (this.modelo.campoNoEstaVacio(nombre, "Nombre") && !this.modelo.puestoRepetido(nombre)) {
                Puesto p = new Puesto(nombre, tipoDeTrabajo, tematicasRequeridas);
                this.modelo.agregarPuesto(p);
                JOptionPane.showMessageDialog(null, "El puesto se ha creado satisfactoriamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            }
        } catch (CampoVacioException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Alerta", JOptionPane.WARNING_MESSAGE);
        } catch (PuestoYaExisteException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Alerta", JOptionPane.WARNING_MESSAGE);
        }
    
    
    }//GEN-LAST:event_btnRegistrar1ActionPerformed

    private void btnSumarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSumarActionPerformed

        Tematica tema = (Tematica) lstTemas.getSelectedValue();
        temasRequeridos.add(tema);
        listaTemasDisponibles.remove(tema);
        lstTemasRequeridos.setListData(temasRequeridos.toArray());
        lstTemas.setListData(listaTemasDisponibles.toArray());
    }//GEN-LAST:event_btnSumarActionPerformed

    private void rbtnRemotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnRemotoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnRemotoActionPerformed

    private void rbtnPresencialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnPresencialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnPresencialActionPerformed

    private void rbtnMixtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnMixtoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnMixtoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrar1;
    private javax.swing.JButton btnSumar;
    private javax.swing.ButtonGroup grupoBotones;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblTemas;
    private javax.swing.JLabel lblTemas1;
    private javax.swing.JLabel lblTipo1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JList lstTemas;
    private javax.swing.JList lstTemasRequeridos;
    private javax.swing.JRadioButton rbtnMixto;
    private javax.swing.JRadioButton rbtnPresencial;
    private javax.swing.JRadioButton rbtnRemoto;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
