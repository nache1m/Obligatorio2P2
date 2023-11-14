
package Dominio;

import java.io.Serializable;

public class Persona implements Serializable{
    private String nombre;
    private String cedula;
    private String direccion;
    
    // Getters y Setters.
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    // Constructor.
    
    // Metodos.
    
}
