//Ignacio Parrado - 303400
//Ezequiel Peña - 224585
package Interfaz;

import Dominio.Postulante;
import Dominio.Sistema;
import Dominio.Tematica;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

/**
 *
 * @author elnac
 */
public class VentanaAltaPostulante2 extends javax.swing.JFrame implements PropertyChangeListener {

    private Sistema modelo;
    private Postulante postulante;

    public VentanaAltaPostulante2(Sistema miSistema, Postulante miPostulante, VentanaAltaPostulante miVentanaAltaPostualnte) {
        initComponents();
        this.modelo = miSistema;
        modelo.agregarEscuchas(this);
        this.postulante = miPostulante;
        agregarTemasAlCombo(cbTema, modelo.getListaTematicas());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblExperiencia = new javax.swing.JLabel();
        cbTema = new javax.swing.JComboBox<>();
        lblTema1 = new javax.swing.JLabel();
        spinNivel = new javax.swing.JSpinner();
        btnRegistrar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        lblTema2 = new javax.swing.JLabel();
        btnAgregar1 = new javax.swing.JButton();
        btnEliminar1 = new javax.swing.JButton();
        btnCancelar1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstExperiencia = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alta Postulante");
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(java.awt.Color.white);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        lblExperiencia.setText("Experiencia:");
        getContentPane().add(lblExperiencia);
        lblExperiencia.setBounds(40, 130, 70, 16);

        cbTema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTemaActionPerformed(evt);
            }
        });
        getContentPane().add(cbTema);
        cbTema.setBounds(130, 30, 211, 22);

        lblTema1.setText("Tema:");
        getContentPane().add(lblTema1);
        lblTema1.setBounds(40, 30, 37, 16);
        getContentPane().add(spinNivel);
        spinNivel.setBounds(130, 70, 80, 22);

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar);
        btnRegistrar.setBounds(260, 230, 80, 23);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(40, 110, 320, 10);

        lblTema2.setText("Nivel:");
        getContentPane().add(lblTema2);
        lblTema2.setBounds(40, 70, 40, 16);

        btnAgregar1.setText("Agregar");
        btnAgregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar1);
        btnAgregar1.setBounds(240, 70, 80, 23);

        btnEliminar1.setText("Eliminar");
        btnEliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar1);
        btnEliminar1.setBounds(40, 160, 73, 23);

        btnCancelar1.setText("Cancelar");
        btnCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar1);
        btnCancelar1.setBounds(40, 230, 80, 23);

        jScrollPane1.setViewportView(lstExperiencia);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(130, 130, 210, 80);

        setSize(new java.awt.Dimension(398, 299));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbTemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTemaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTemaActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        this.modelo.altaPostulante(this.postulante);
        this.dispose();
        JOptionPane.showMessageDialog(null, "El postulante fue creado con éxito", "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnAgregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar1ActionPerformed

        int nivel1 = Integer.parseInt(String.valueOf(spinNivel.getValue()));
        if (nivel1 <= 10 && nivel1 >= 0) {
        Tematica tema = (Tematica) cbTema.getSelectedItem();
        this.postulante.agregarTema(tema, nivel1);
        spinNivel.setValue(0);
        cbTema.setSelectedIndex(0);
        lstExperiencia.setListData(modelo.darExperiencias(this.postulante));
        } else {
            JOptionPane.showMessageDialog(null, "El nivel seleccionado tiene que estár comprendido entre 0 y 10.", "Alerta", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btnAgregar1ActionPerformed

    private void btnEliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar1ActionPerformed

        String[] experiencia = lstExperiencia.getSelectedValue().split("\\(");
        String nombreTematica = experiencia[0];
        modelo.borrarExperiencia(nombreTematica, this.postulante);
        lstExperiencia.setListData(modelo.darExperiencias(this.postulante));
    }//GEN-LAST:event_btnEliminar1ActionPerformed

    private void btnCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar1ActionPerformed
        //Si apreta Cancelar Borra todo el progreso hecho hasta el moemento.
        List<String> experienciasABorrar = lstExperiencia.getSelectedValuesList();
        this.modelo.borrarPostulante(this.postulante);
        this.borrarTemas(experienciasABorrar, this.postulante);
        this.dispose();
    }//GEN-LAST:event_btnCancelar1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar1;
    private javax.swing.JButton btnCancelar1;
    private javax.swing.JButton btnEliminar1;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<Tematica> cbTema;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblExperiencia;
    private javax.swing.JLabel lblTema1;
    private javax.swing.JLabel lblTema2;
    private javax.swing.JList<String> lstExperiencia;
    private javax.swing.JSpinner spinNivel;
    // End of variables declaration//GEN-END:variables

    private void agregarTemasAlCombo(JComboBox<Tematica> cbTema, ArrayList<Tematica> listaTematicas) {
        cbTema.removeAllItems();
        for (Tematica elem : modelo.getListaTematicas()) {
            cbTema.addItem(elem);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        lstExperiencia.setListData(modelo.darExperiencias(this.postulante));
        agregarTemasAlCombo(cbTema, modelo.getListaTematicas());
    }

    public void borrarTemas(List<String> experienciasABorrar, Postulante p) {
        for (String elem : experienciasABorrar) {
            String elemento = elem.split("\\(")[0];
            Tematica tema = p.obtenerTematicaPorNombre(elemento);
            p.getNivelYTemas().remove(tema);
        }
        ArrayList<Postulante> copiaListaPostulantes = new ArrayList<>(this.modelo.getListaPostulantes());
        this.modelo.getListaPostulantes().remove(p);
        this.modelo.getManejador().firePropertyChange("listaPostulantes", copiaListaPostulantes, this.modelo.getListaPostulantes());
    }
}
