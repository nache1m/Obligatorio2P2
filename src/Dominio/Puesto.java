
package Dominio;

import java.util.*;

public class Puesto {
    private String nombre;
    private int tipo;
    private ArrayList<Tematica> temas;

    // Getters y Setters.
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Tematica> getTemas() {
        return temas;
    }

    public void setTemas(ArrayList<Tematica> temas) {
        this.temas = temas;
    }
    
    // Constructor.
    
    // Metodos.
}
