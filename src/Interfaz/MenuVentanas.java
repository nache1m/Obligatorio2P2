/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/Application.java to edit this template
 */
package Interfaz;

import Dominio.Respaldo;
import Dominio.Sistema;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author elnac
 */
public class MenuVentanas extends javax.swing.JFrame {

    private Sistema modelo;

    public MenuVentanas(Sistema miSistema) {
        initComponents();
        this.modelo = miSistema;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        menPostulantes = new javax.swing.JMenu();
        itmAltaPostulante = new javax.swing.JMenuItem();
        itmBajaPostulante = new javax.swing.JMenuItem();
        itmHistoriaPostulante = new javax.swing.JMenuItem();
        menEvaluadores = new javax.swing.JMenu();
        itmRegistroEvaluador = new javax.swing.JMenuItem();
        itmRegistroEntrevista = new javax.swing.JMenuItem();
        menTematica = new javax.swing.JMenu();
        itmRegistroTematica = new javax.swing.JMenuItem();
        itmConsultaTematica = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        itmRegistroPuesto = new javax.swing.JMenuItem();
        itmConsultaPuesto = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menú Principal");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sin título.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 360, 380);

        menPostulantes.setText("Postulantes");
        menPostulantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menPostulantesActionPerformed(evt);
            }
        });

        itmAltaPostulante.setText("Alta de postulante");
        itmAltaPostulante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmAltaPostulanteActionPerformed(evt);
            }
        });
        menPostulantes.add(itmAltaPostulante);

        itmBajaPostulante.setText("Baja de postulante");
        itmBajaPostulante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmBajaPostulanteActionPerformed(evt);
            }
        });
        menPostulantes.add(itmBajaPostulante);

        itmHistoriaPostulante.setText("Historia postulante");
        itmHistoriaPostulante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmHistoriaPostulanteActionPerformed(evt);
            }
        });
        menPostulantes.add(itmHistoriaPostulante);

        menuBar.add(menPostulantes);

        menEvaluadores.setText("Evaluadores y entrevistas");

        itmRegistroEvaluador.setText("Registro de evaluador");
        itmRegistroEvaluador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmRegistroEvaluadorActionPerformed(evt);
            }
        });
        menEvaluadores.add(itmRegistroEvaluador);

        itmRegistroEntrevista.setText("Registro de entrevista");
        itmRegistroEntrevista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmRegistroEntrevistaActionPerformed(evt);
            }
        });
        menEvaluadores.add(itmRegistroEntrevista);

        menuBar.add(menEvaluadores);

        menTematica.setText("Temática");

        itmRegistroTematica.setText("Registro temática");
        itmRegistroTematica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmRegistroTematicaActionPerformed(evt);
            }
        });
        menTematica.add(itmRegistroTematica);

        itmConsultaTematica.setText("Consulta por temática");
        itmConsultaTematica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmConsultaTematicaActionPerformed(evt);
            }
        });
        menTematica.add(itmConsultaTematica);

        menuBar.add(menTematica);

        jMenu1.setText("Puesto");

        itmRegistroPuesto.setText("Registro de puesto");
        itmRegistroPuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmRegistroPuestoActionPerformed(evt);
            }
        });
        jMenu1.add(itmRegistroPuesto);

        itmConsultaPuesto.setText("Consulta para puesto");
        itmConsultaPuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmConsultaPuestoActionPerformed(evt);
            }
        });
        jMenu1.add(itmConsultaPuesto);

        menuBar.add(jMenu1);

        setJMenuBar(menuBar);

        setSize(new java.awt.Dimension(368, 407));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void itmRegistroTematicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmRegistroTematicaActionPerformed
        VentanaRegistroTematica v = new VentanaRegistroTematica(modelo);
        v.setVisible(true);
        // Metodo para registrar.
    }//GEN-LAST:event_itmRegistroTematicaActionPerformed

    private void itmAltaPostulanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmAltaPostulanteActionPerformed
        if (this.modelo.getListaTematicas().size() >= 1) {
            VentanaAltaPostulante v = new VentanaAltaPostulante(modelo);
            v.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Para crear un postulante necesita antes crear una temática.", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_itmAltaPostulanteActionPerformed

    private void itmRegistroEntrevistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmRegistroEntrevistaActionPerformed
        if (this.modelo.getListaPostulantes().size() >= 1 && this.modelo.getListaPostulantes().size() >= 1) {
            VentanaEntrevistas v = new VentanaEntrevistas(modelo);
            v.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Para crear una entrevista necesita antes tener un postulante y un evaluador.", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_itmRegistroEntrevistaActionPerformed

    private void itmBajaPostulanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmBajaPostulanteActionPerformed
        if (this.modelo.getListaPostulantes().size() >= 1) {
            VentanaBajaPostulante v = new VentanaBajaPostulante(this.modelo);
            v.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Para dar de baja un postulante necesita antes tener un postulante.", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_itmBajaPostulanteActionPerformed

    private void itmRegistroEvaluadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmRegistroEvaluadorActionPerformed
        VentanaRegistroEvaluador v = new VentanaRegistroEvaluador(modelo);
        v.setVisible(true);
    }//GEN-LAST:event_itmRegistroEvaluadorActionPerformed

    private void menPostulantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menPostulantesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menPostulantesActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        guardarSistemaEnArchivo();
    }//GEN-LAST:event_formWindowClosing

    private void itmRegistroPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmRegistroPuestoActionPerformed
        VentanaRegistroPuesto v = new VentanaRegistroPuesto(this.modelo);
        v.setVisible(true);
    }//GEN-LAST:event_itmRegistroPuestoActionPerformed

    private void itmHistoriaPostulanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmHistoriaPostulanteActionPerformed
        if (this.modelo.getListaPostulantes().size() >= 1) {
            VentanaHistoriaPostulante v = new VentanaHistoriaPostulante(this.modelo);
            v.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Para ver la historia de un postulante necesita antes tener un postulante.", "Alerta", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_itmHistoriaPostulanteActionPerformed

    private void itmConsultaPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmConsultaPuestoActionPerformed
        if (this.modelo.getListaPuestos().size() >= 1) {
            VentanaConsultaPuestos v = new VentanaConsultaPuestos(this.modelo);
            v.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Para hacer consulta por puestos necesita antes un puesto.", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_itmConsultaPuestoActionPerformed

    private void itmConsultaTematicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmConsultaTematicaActionPerformed
        if (this.modelo.getListaTematicas().size() >= 1) {
            VentanaConsultaTematica v = new VentanaConsultaTematica(this.modelo);
            v.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Para hacer consultas por temática necesita antes una temática.", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_itmConsultaTematicaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itmAltaPostulante;
    private javax.swing.JMenuItem itmBajaPostulante;
    private javax.swing.JMenuItem itmConsultaPuesto;
    private javax.swing.JMenuItem itmConsultaTematica;
    private javax.swing.JMenuItem itmHistoriaPostulante;
    private javax.swing.JMenuItem itmRegistroEntrevista;
    private javax.swing.JMenuItem itmRegistroEvaluador;
    private javax.swing.JMenuItem itmRegistroPuesto;
    private javax.swing.JMenuItem itmRegistroTematica;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenu menEvaluadores;
    private javax.swing.JMenu menPostulantes;
    private javax.swing.JMenu menTematica;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables

    //Método para persitir la ventana
    private void guardarSistemaEnArchivo() {

        Respaldo miRespaldo = new Respaldo(this.modelo);
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("salida"))) {
            out.writeObject(miRespaldo);
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            // Completar luego
        }
    }

}
