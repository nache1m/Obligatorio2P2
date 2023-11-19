//Ignacio Parrado - 303400
//Ezequiel Peña - 224585
package Interfaz;

import Dominio.Postulante;
import Dominio.Sistema;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
/**
 *
 * @author elnac
 */
public class VentanaBajaPostulante extends javax.swing.JFrame implements PropertyChangeListener {

   private Sistema modelo;
   
    public VentanaBajaPostulante(Sistema miDominio) {
        initComponents();
        this.modelo = miDominio;
        lstPostulantes.setListData(modelo.getListaPostulantes().toArray());
        modelo.agregarEscuchas(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblBajaPostulante = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstPostulantes = new javax.swing.JList();
        btnEliminar = new javax.swing.JButton();
        btnCancelar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Baja Postulante");
        setResizable(false);
        getContentPane().setLayout(null);

        lblBajaPostulante.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblBajaPostulante.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBajaPostulante.setText("Baja Postulante");
        getContentPane().add(lblBajaPostulante);
        lblBajaPostulante.setBounds(120, 20, 140, 16);

        jScrollPane1.setViewportView(lstPostulantes);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(70, 60, 250, 130);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar);
        btnEliminar.setBounds(240, 210, 80, 23);

        btnCancelar1.setText("Cancelar");
        btnCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar1);
        btnCancelar1.setBounds(70, 210, 80, 23);

        setSize(new java.awt.Dimension(389, 289));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Postulante p = (Postulante)lstPostulantes.getSelectedValue();
        this.modelo.borrarPostulante(p);
        lstPostulantes.setListData(modelo.getListaPostulantes().toArray());
        
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelar1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar1;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBajaPostulante;
    private javax.swing.JList lstPostulantes;
    // End of variables declaration//GEN-END:variables

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
         lstPostulantes.setListData(modelo.getListaPostulantes().toArray());
    }
}
