//Ignacio Parrado - 303400
//Ezequiel Peña - 224585
package Interfaz;

import Dominio.Sistema;
import Dominio.Tematica;
import Excepciones.CampoVacioException;
import Excepciones.TematicaYaExisteException;
import Interfaz.MenuVentanas;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author elnac
 */
public class VentanaRegistroTematica extends javax.swing.JFrame {
    
    private Sistema modelo;
    
    public VentanaRegistroTematica(Sistema miModelo) {
        initComponents();
        modelo = miModelo;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPanel = new javax.swing.JPanel();
        lblRegistroTematica = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        lblNombre = new javax.swing.JLabel();
        lblNombre1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDesc = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro de Temática");
        setResizable(false);
        getContentPane().setLayout(null);

        pnlPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlPanel.setLayout(null);

        lblRegistroTematica.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblRegistroTematica.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRegistroTematica.setText("Registro de Temática");
        pnlPanel.add(lblRegistroTematica);
        lblRegistroTematica.setBounds(110, 20, 120, 16);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        pnlPanel.add(btnCancelar);
        btnCancelar.setBounds(40, 210, 90, 23);

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        pnlPanel.add(btnRegistrar);
        btnRegistrar.setBounds(220, 210, 90, 23);

        lblNombre.setText("Descripción:");
        pnlPanel.add(lblNombre);
        lblNombre.setBounds(30, 110, 70, 16);

        lblNombre1.setText("Nombre:");
        pnlPanel.add(lblNombre1);
        lblNombre1.setBounds(30, 70, 60, 16);
        pnlPanel.add(txtNombre);
        txtNombre.setBounds(130, 70, 180, 20);

        jScrollPane1.setViewportView(txtDesc);

        pnlPanel.add(jScrollPane1);
        jScrollPane1.setBounds(130, 110, 180, 70);

        getContentPane().add(pnlPanel);
        pnlPanel.setBounds(30, 20, 340, 260);

        setSize(new java.awt.Dimension(414, 333));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        
        try {   
        String nombre = txtNombre.getText();
        String descripcion = txtDesc.getText();
        Tematica nuevaTematica = new Tematica (nombre, descripcion);
        if (this.modelo.campoNoEstaVacio(nombre, "Nombre")&& this.modelo.campoNoEstaVacio(descripcion, "Descripción"));
        modelo.agregarTematica(nuevaTematica);
        txtNombre.setText("");
        txtDesc.setText("");
        this.dispose();
        JOptionPane.showMessageDialog(null, "La temática fue creada con éxito.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (TematicaYaExisteException e) {
             JOptionPane.showMessageDialog(null, e.getMessage(), "Alerta", JOptionPane.WARNING_MESSAGE);
        } catch (CampoVacioException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Alerta", JOptionPane.WARNING_MESSAGE);
        }
        
;
    
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblRegistroTematica;
    private javax.swing.JPanel pnlPanel;
    private javax.swing.JTextPane txtDesc;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
