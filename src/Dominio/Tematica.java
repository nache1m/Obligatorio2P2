//Ignacio Parrado - 303400
//Ezequiel Peña - 224585
package Dominio;

import java.io.Serializable;

public class Tematica implements Serializable {
    private String nombre;
    private String descripcion;
    Tematica() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Getters y Setters.
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public Tematica (String nombre, String desc) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
   public String toString() {
       
       return this.nombre;
   }}
