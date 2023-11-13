
package Dominio;

import java.util.*;

public class Evaluador extends Persona {
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
}
