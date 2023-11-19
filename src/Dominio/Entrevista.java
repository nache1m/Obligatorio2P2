//Ignacio Parrado - 303400
//Ezequiel Peña - 224585
package Dominio;

import java.io.Serializable;

public class Entrevista implements Serializable {
    private int id;
    private Evaluador evaluador;
    private Postulante postulante;
    private int puntaje;
    private String comentarios;
    private static int contadorIds = 1;

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
    
    public Entrevista (Evaluador ev, Postulante post, int puntaje, String com){
        this.id = contadorIds;
        this.evaluador = ev;
        this.postulante = post;
        this.puntaje = puntaje;
        this.comentarios = com;
        contadorIds++;
    }
    
    // Metodos.
    
}
