
package Dominio;

import java.util.*;

public class Postulante extends Persona {
    private String telefono;
    private String email;
    private String linkedIn;
    private int tipoTrabajo;
    private HashMap nivelYTemas;

    
    // Getters y Setters.
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLinkedIn() {
        return linkedIn;
    }
    
    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }

    public int getTipoTrabajo() {
        return tipoTrabajo;
    }

    public void setTipoTrabajo(int tipoTrabajo) {
        this.tipoTrabajo = tipoTrabajo;
    }

    public HashMap getNivelYTemas() {
        return nivelYTemas;
    }

    public void setNivelYTemas(HashMap nivelYTemas) {
        this.nivelYTemas = nivelYTemas;
    }
    
    // Constructor.
    public Postulante(){
        this.telefono = telefono;
        this.email = email;
        this.linkedIn = linkedIn;
        this.tipoTrabajo = tipoTrabajo;
        this.nivelYTemas = nivelYTemas;
    }
    
    // Metodos.
    public static void borrarTema(){
        
    }
    
    public static void agregarTema(){
        
    }
    
}
