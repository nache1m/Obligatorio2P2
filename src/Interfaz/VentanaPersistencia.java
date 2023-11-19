//Ignacio Parrado - 303400
//Ezequiel Peña - 224585

package Interfaz;

import Dominio.Entrevista;
import Dominio.Evaluador;
import Dominio.Postulante;
import Dominio.Respaldo;
import Dominio.Sistema;
import Dominio.Tematica;
import Excepciones.TematicaYaExisteException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class VentanaPersistencia extends javax.swing.JFrame {

    public VentanaPersistencia() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        pnlPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlPanel.setLayout(null);

        jLabel1.setText("¿Desea tomar los datos cargados anteriormente?");
        pnlPanel.add(jLabel1);
        jLabel1.setBounds(41, 44, 261, 16);

        jButton1.setText("Si");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        pnlPanel.add(jButton1);
        jButton1.setBounds(81, 97, 72, 23);

        jButton2.setText("No");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        pnlPanel.add(jButton2);
        jButton2.setBounds(194, 97, 72, 23);

        getContentPane().add(pnlPanel);
        pnlPanel.setBounds(30, 20, 340, 190);

        setSize(new java.awt.Dimension(410, 257));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            this.crearModeloDesdeCero();
        } catch (TematicaYaExisteException ex) {
            Logger.getLogger(VentanaPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("salida"));
            Sistema sistemaLeido = new Sistema ((Respaldo)in.readObject()) ;
            in.close();

            MenuVentanas menu = new MenuVentanas(sistemaLeido);
            menu.setVisible(true);
            this.dispose();

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "No existe archivo para persistir", "Error", JOptionPane.WARNING_MESSAGE);
            JOptionPane.showMessageDialog(null, "Se creará un nuevo sistema", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            try {
                this.crearModeloDesdeCero();
            } catch (TematicaYaExisteException ex) {
                Logger.getLogger(VentanaPersistencia.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "A ocurrido algo inesperado. No se pudo persistir el archivo", "Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null, "Se creará un nuevo sistema", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            try {
                this.crearModeloDesdeCero();
            } catch (TematicaYaExisteException ex) {
                Logger.getLogger(VentanaPersistencia.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "A ocurrido algo inesperado. No se pudo persistir el archivo", "Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null, "Se creará un nuevo sistema", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            try {
                this.crearModeloDesdeCero();
            } catch (TematicaYaExisteException ex1) {
                Logger.getLogger(VentanaPersistencia.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    public void crearModeloDesdeCero() throws TematicaYaExisteException {
        Sistema modelo = new Sistema();

        MenuVentanas menu = new MenuVentanas(modelo);

        menu.setVisible(true);

        this.setVisible(false);
       
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel pnlPanel;
    // End of variables declaration//GEN-END:variables

}
