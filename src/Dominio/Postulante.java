//Postulante

package Dominio;

import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.net.URL;
import java.util.*;

public class Postulante extends Persona implements Serializable {

    private String telefono;
    private String email;
    private String linkedIn;
    private int tipoTrabajo;
    private HashMap<Tematica, Integer> nivelYTemas = new HashMap<>();

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

    //Constructor sin Tematica y Nivel
    public Postulante(String nombre, String cedula, String telefono, String linkedIn, String email, int tipoTrabajo) {
        super.setNombre(nombre);
        super.setCedula(cedula);
        this.telefono = telefono;
        this.email = email;
        this.linkedIn = linkedIn;
        this.tipoTrabajo = tipoTrabajo; // Mixto = 0 Remoto = 1 Presencial = 2

    }

    // Metodos.
    public void borrarExperiencia(Tematica tema) {
        this.nivelYTemas.remove(tema);
    }

    public void agregarTema(Tematica tema, Integer nivel) {
        this.nivelYTemas.put(tema, nivel);
    }

    public Integer darNivelTematica(Tematica tema) {  ///Falta testear
        return (Integer) this.getNivelYTemas().get(tema);

    }

    public ArrayList obtenerTematicas() {
        ArrayList res = new ArrayList();
        for (Object key : this.getNivelYTemas().keySet()) {
            res.add(key);
        }

        return res;
    }

    public String[] obtenerNiveles() {

        return (String[]) this.getNivelYTemas().values().toArray(new String[this.getNivelYTemas().size()]);
    }

    public String toString() {

        return super.getNombre() + "("+this.getCedula()+")";
    }

    public Tematica obtenerTematicaPorNombre(String elem) {
        ArrayList<Tematica> tematicas = this.obtenerTematicas();
        Tematica res = new Tematica();
        for (Tematica miTematica : tematicas) {
            if (miTematica.getNombre().equals(elem)) {
                res = miTematica;
            }
        }
        return res;
    }

    public boolean contieneTematica(Tematica elem) {
        boolean res = false;
        HashMap<Tematica, Integer> hashMapN = this.getNivelYTemas();
        Collection<Tematica> llaves = hashMapN.keySet();
        for (Tematica tema : llaves) {
            if (tema.equals(elem)) {
                res = true;
            }
        }
        return res;
    }

    public boolean contieneTieneNivel(Tematica elem, int nivel) {
        boolean res = false;
        HashMap<Tematica, Integer> hashMap = this.getNivelYTemas();
        if(hashMap.get(elem) >= nivel) {
            res = true;
        }
        return res;
    }
    

}