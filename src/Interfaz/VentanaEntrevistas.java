//Ignacio Parrado - 303400
//Ezequiel Peña - 224585
package Interfaz;

import Dominio.Entrevista;
import Dominio.Evaluador;
import Dominio.Postulante;
import Dominio.Sistema;
import Excepciones.CampoVacioException;
import Excepciones.verificoPuntajeException;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author elnac
 */
public class VentanaEntrevistas extends javax.swing.JFrame implements PropertyChangeListener {

    private Sistema modelo;

    public VentanaEntrevistas(Sistema miDominio) {
        this.modelo = miDominio;
        initComponents();
        modelo.agregarEscuchas(this);
        lstPostulantes.setListData(modelo.getListaPostulantes().toArray());
        lstEvaluadores.setListData(modelo.getListaEvaluadores().toArray());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblBajaPostulante = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstEvaluadores = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstPostulantes = new javax.swing.JList();
        lblPuntaje = new javax.swing.JLabel();
        spnPuntaje = new javax.swing.JSpinner();
        lblPuntaje1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtComent = new javax.swing.JTextArea();
        btnIngresar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ingreso de Entrevistas");
        setResizable(false);
        getContentPane().setLayout(null);

        lblBajaPostulante.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblBajaPostulante.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBajaPostulante.setText("Ingreso de Entrevistas");
        getContentPane().add(lblBajaPostulante);
        lblBajaPostulante.setBounds(170, 30, 140, 16);

        lstEvaluadores.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lstEvaluadores.setDragEnabled(true);
        jScrollPane1.setViewportView(lstEvaluadores);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(160, 80, 210, 80);

        jLabel1.setText("Evaluador:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(50, 80, 70, 16);

        jLabel2.setText("Postulante:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 190, 70, 16);

        lstPostulantes.setSelectedIndex(1);
        jScrollPane2.setViewportView(lstPostulantes);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(160, 190, 210, 80);

        lblPuntaje.setText("Comentarios:");
        getContentPane().add(lblPuntaje);
        lblPuntaje.setBounds(50, 350, 80, 16);
        getContentPane().add(spnPuntaje);
        spnPuntaje.setBounds(160, 300, 64, 22);

        lblPuntaje1.setText("Puntaje:");
        getContentPane().add(lblPuntaje1);
        lblPuntaje1.setBounds(50, 300, 60, 16);

        txtComent.setColumns(20);
        txtComent.setRows(5);
        jScrollPane3.setViewportView(txtComent);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(160, 350, 234, 86);

        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnIngresar);
        btnIngresar.setBounds(312, 470, 80, 23);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar);
        btnCancelar.setBounds(160, 470, 80, 23);

        setSize(new java.awt.Dimension(492, 562));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        Evaluador ev = (Evaluador) lstEvaluadores.getSelectedValue();
        Postulante p = (Postulante) lstPostulantes.getSelectedValue();
        int puntaje = Integer.parseInt(String.valueOf(spnPuntaje.getValue()));
        String com = txtComent.getText();
        try {
            if (this.modelo.campoNoEstaVacio(com, "Comentarios") && this.modelo.verificoPuntaje(puntaje)) {
                if (!(lstEvaluadores.getSelectedValue() == null) && !(lstPostulantes.getSelectedValue() == null)) {
                    Entrevista ent = new Entrevista(ev, p, puntaje, com);
                    modelo.agregarEntrevista(ent);
                    spnPuntaje.setValue(0);
                    txtComent.setText("");
                    JOptionPane.showMessageDialog(null, "La entrevista fue agregada", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Debe seleccionar un postulante y un evaluador para seguir adelante.", "Alerta", JOptionPane.WARNING_MESSAGE);
                }
            }
        } catch (CampoVacioException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Alerta", JOptionPane.WARNING_MESSAGE);
        } catch (verificoPuntajeException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Alerta", JOptionPane.WARNING_MESSAGE);
        }


    }//GEN-LAST:event_btnIngresarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblBajaPostulante;
    private javax.swing.JLabel lblPuntaje;
    private javax.swing.JLabel lblPuntaje1;
    private javax.swing.JList lstEvaluadores;
    private javax.swing.JList lstPostulantes;
    private javax.swing.JSpinner spnPuntaje;
    private javax.swing.JTextArea txtComent;
    // End of variables declaration//GEN-END:variables

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        lstPostulantes.setListData(modelo.getListaPostulantes().toArray());
        lstEvaluadores.setListData(modelo.getListaEvaluadores().toArray());
    }
}
