
package Dominio;

import java.io.Serializable;
import java.util.*;

public class Evaluador extends Persona implements Serializable{
    private String añoDeIngreso;

    // Getters y Setters.
    public String getAñoDeIngreso() {
        return añoDeIngreso;
    }
    
    // Constructor.
    public Evaluador (String nombre, String cedula, String direccion, String año){
        super.setNombre(nombre);
        super.setCedula(cedula);
        super.setDireccion(direccion);
        this.añoDeIngreso = año;
    }
    
    // Metodos.
    public String toString() {

        return super.getNombre();
    }
}
