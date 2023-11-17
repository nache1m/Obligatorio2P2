
package Dominio;

import java.io.Serializable;
import java.util.*;

public class Puesto implements Serializable {
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
    public Puesto (String nombre, int tipo, ArrayList<Tematica> lista){
        this.nombre =  nombre;
        this.tipo = tipo;
        this.temas = lista;
    }
    // Metodos.
}
