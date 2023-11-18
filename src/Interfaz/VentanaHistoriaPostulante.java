package Interfaz;

import Dominio.Entrevista;
import Dominio.Postulante;
import Dominio.Sistema;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class VentanaHistoriaPostulante extends javax.swing.JFrame {

    private Sistema modelo;

    public VentanaHistoriaPostulante(Sistema miModelo) {
        initComponents();
        this.modelo = miModelo;
        modelo.ordenarPostulantesPorCedula();
        lstPostulantes.setListData(modelo.getListaPostulantes().toArray());
        lstPostulantes.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                Postulante p = (Postulante) lstPostulantes.getSelectedValue();
                if (p != null) {
                    lblNombre.setText(p.getNombre());
                    lblCedula.setText(p.getCedula());
                    lblDireccion.setText(p.getDireccion());
                    lblTelefono.setText(p.getTelefono());
                    lblMail.setText(p.getEmail());
                    lblLinkedin.setText(p.getLinkedIn());
                    if (p.getTipoTrabajo() == 0) {
                        lblFormato.setText("Mixto");
                    } else {
                        if (p.getTipoTrabajo() == 2) {
                            lblFormato.setText("Presencial");
                        } else {
                            lblFormato.setText("Remoto");
                        }
                    }
                    lstExperiencia.setListData(modelo.darExperiencias(p));
                    cargarTabla(p);
                }
            }
        });
    }

    public void cargarTabla(Postulante p) {
        ArrayList<Entrevista> listaEntrevistas = new ArrayList();
        for (Entrevista miEntrevista : modelo.getListaEntrevistas()) {
            if (miEntrevista.getPostulante().equals(p)) {
                listaEntrevistas.add(miEntrevista);
            }
        }
        DefaultTableModel modelo = (DefaultTableModel) tblEntrevistas.getModel();
        modelo.setRowCount(0);
        for (int i = 1; i < listaEntrevistas.size(); i++) {
            Entrevista e = listaEntrevistas.get(i);
            modelo.addRow(new Object[]{i, e.getEvaluador(), e.getPuntaje(), e.getComentarios()});
        }
        tblEntrevistas.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblBajaPostulante = new javax.swing.JLabel();
        lblPostulantes = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstPostulantes = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEntrevistas = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstExperiencia = new javax.swing.JList();
        jLabel9 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        lblCedula = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        lblMail = new javax.swing.JLabel();
        lblFormato = new javax.swing.JLabel();
        lblLinkedin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Historial de Postulante");
        setResizable(false);
        getContentPane().setLayout(null);

        lblBajaPostulante.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblBajaPostulante.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBajaPostulante.setText("Historial de Postulante");
        getContentPane().add(lblBajaPostulante);
        lblBajaPostulante.setBounds(390, 30, 140, 16);

        lblPostulantes.setText("Postulantes:");
        getContentPane().add(lblPostulantes);
        lblPostulantes.setBounds(40, 80, 70, 16);

        jScrollPane1.setViewportView(lstPostulantes);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(40, 100, 230, 260);

        jLabel1.setText("Experiencia:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(370, 290, 70, 16);

        tblEntrevistas.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        tblEntrevistas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nro", "Evaluador", "Puntaje", "Comentarios"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEntrevistas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblEntrevistas.getTableHeader().setResizingAllowed(false);
        tblEntrevistas.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblEntrevistas);
        if (tblEntrevistas.getColumnModel().getColumnCount() > 0) {
            tblEntrevistas.getColumnModel().getColumn(0).setResizable(false);
            tblEntrevistas.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblEntrevistas.getColumnModel().getColumn(1).setResizable(false);
            tblEntrevistas.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblEntrevistas.getColumnModel().getColumn(2).setResizable(false);
            tblEntrevistas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblEntrevistas.getColumnModel().getColumn(3).setResizable(false);
            tblEntrevistas.getColumnModel().getColumn(3).setPreferredWidth(498);
        }
        tblEntrevistas.getAccessibleContext().setAccessibleName("");
        tblEntrevistas.getAccessibleContext().setAccessibleDescription("");

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(50, 490, 850, 160);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(40, 420, 850, 10);

        jLabel2.setText("Buscar:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(70, 440, 40, 16);

        jLabel3.setText("Cédula:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(370, 110, 60, 16);

        jLabel4.setText("Dirección:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(370, 140, 60, 16);

        jLabel5.setText("Teléfono:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(370, 170, 60, 16);

        jLabel6.setText("Mail:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(370, 200, 60, 16);

        jLabel7.setText("LinkedIn:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(370, 230, 60, 16);

        jLabel8.setText("Formato:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(370, 260, 60, 16);

        jScrollPane3.setViewportView(lstExperiencia);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(450, 290, 230, 100);

        jLabel9.setText("Nombre:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(370, 80, 60, 16);
        getContentPane().add(txtBuscar);
        txtBuscar.setBounds(120, 440, 310, 22);

        btnLimpiar.setText("Limpiar");
        getContentPane().add(btnLimpiar);
        btnLimpiar.setBounds(570, 440, 90, 23);

        btnBuscar.setText("Buscar");
        getContentPane().add(btnBuscar);
        btnBuscar.setBounds(460, 440, 90, 23);
        getContentPane().add(lblCedula);
        lblCedula.setBounds(450, 110, 210, 20);
        getContentPane().add(lblNombre);
        lblNombre.setBounds(450, 80, 210, 20);
        getContentPane().add(lblTelefono);
        lblTelefono.setBounds(450, 170, 210, 20);
        getContentPane().add(lblDireccion);
        lblDireccion.setBounds(450, 140, 210, 20);
        getContentPane().add(lblMail);
        lblMail.setBounds(450, 200, 210, 20);
        getContentPane().add(lblFormato);
        lblFormato.setBounds(450, 260, 210, 20);
        getContentPane().add(lblLinkedin);
        lblLinkedin.setBounds(450, 230, 210, 20);

        setSize(new java.awt.Dimension(971, 696));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblBajaPostulante;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblFormato;
    private javax.swing.JLabel lblLinkedin;
    private javax.swing.JLabel lblMail;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPostulantes;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JList lstExperiencia;
    private javax.swing.JList lstPostulantes;
    private javax.swing.JTable tblEntrevistas;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
