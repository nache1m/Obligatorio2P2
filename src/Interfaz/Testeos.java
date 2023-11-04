
package Interfaz;

import Dominio.Postulante;
import Dominio.Sistema;
import Dominio.Tematica;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Testeos {
    public static void main (String [] args ) throws FileNotFoundException {
        VentanaPersistencia ventanaPersis = new VentanaPersistencia();
        ventanaPersis.setVisible(true);
        
        Sistema modelo = ventanaPersis.getModelo();
        ObjectOutputStream out;
        try {
            out = new ObjectOutputStream (new FileOutputStream("salida"));
            out.writeObject(modelo);
            out.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "A ocurrido algo inexperado. No se puedo persistir el archivo", "Error", JOptionPane.ERROR_MESSAGE);
        }
       

    }
}
