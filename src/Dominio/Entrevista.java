
package Dominio;

import java.io.Serializable;

public class Entrevista implements Serializable {
    private int id;
    private Evaluador evaluador;
    private Postulante postulante;
    private int puntaje;
    private String comentarios;

    // Getters y Setters.
    public int getId() {
        return id;
    }

    public Evaluador getEvaluador() {
        return evaluador;
    }

    public Postulante getPostulante() {
        return postulante;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
    
    // Constructor.
    
    // Metodos.
    
}
