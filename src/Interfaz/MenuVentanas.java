/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/Application.java to edit this template
 */
package Interfaz;

/**
 *
 * @author elnac
 */
public class MenuVentanas extends javax.swing.JFrame {
    
    public MenuVentanas() {
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

        jMenuItem1 = new javax.swing.JMenuItem();
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
        fileMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        menPostulantes.setText("Postulantes");

        itmAltaPostulante.setText("Alta de postulante");
        itmAltaPostulante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmAltaPostulanteActionPerformed(evt);
            }
        });
        menPostulantes.add(itmAltaPostulante);

        itmBajaPostulante.setText("Baja de postulante");
        menPostulantes.add(itmBajaPostulante);

        itmHistoriaPostulante.setText("Historia postulante");
        menPostulantes.add(itmHistoriaPostulante);

        menuBar.add(menPostulantes);

        menEvaluadores.setText("Evaluadores y entrevistas");

        itmRegistroEvaluador.setText("Registro de evaluador");
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
        menTematica.add(itmConsultaTematica);

        menuBar.add(menTematica);

        jMenu1.setText("Puesto");

        itmRegistroPuesto.setText("Registro de puesto");
        jMenu1.add(itmRegistroPuesto);

        itmConsultaPuesto.setText("Consulta para puesto");
        jMenu1.add(itmConsultaPuesto);

        menuBar.add(jMenu1);

        fileMenu.setMnemonic('f');
        fileMenu.setText("Salir");

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Salir");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);

        setSize(new java.awt.Dimension(414, 305));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void itmRegistroTematicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmRegistroTematicaActionPerformed
            VentanaRegistroTematica v = new VentanaRegistroTematica();
            v.setVisible(true);
            // Metodo para registrar.
    }//GEN-LAST:event_itmRegistroTematicaActionPerformed

    private void itmAltaPostulanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmAltaPostulanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itmAltaPostulanteActionPerformed

    private void itmRegistroEntrevistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmRegistroEntrevistaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itmRegistroEntrevistaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem itmAltaPostulante;
    private javax.swing.JMenuItem itmBajaPostulante;
    private javax.swing.JMenuItem itmConsultaPuesto;
    private javax.swing.JMenuItem itmConsultaTematica;
    private javax.swing.JMenuItem itmHistoriaPostulante;
    private javax.swing.JMenuItem itmRegistroEntrevista;
    private javax.swing.JMenuItem itmRegistroEvaluador;
    private javax.swing.JMenuItem itmRegistroPuesto;
    private javax.swing.JMenuItem itmRegistroTematica;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenu menEvaluadores;
    private javax.swing.JMenu menPostulantes;
    private javax.swing.JMenu menTematica;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables

}
