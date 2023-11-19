//Ignacio Parrado - 303400
//Ezequiel Peña - 224585
package Dominio;

import java.io.Serializable;
import java.util.ArrayList;

public class Respaldo  implements Serializable {

    private ArrayList<Postulante> listaPostulantes;
    private ArrayList<Evaluador> listaEvaluadores;
    private ArrayList<Puesto> listaPuestos;
    private ArrayList<Entrevista> listaEntrevistas;
    private ArrayList<Tematica> listaTematicas;

    public ArrayList<Postulante> getListaPostulantes(){
        return listaPostulantes;
    }

    public void setListaPostulantes(ArrayList<Postulante> listaPostulantes) {
        this.listaPostulantes = listaPostulantes;
    }

    public ArrayList<Evaluador> getListaEvaluadores() {
        return listaEvaluadores;
    }

    public void setListaEvaluadores(ArrayList<Evaluador> listaEvaluadores) {
        this.listaEvaluadores = listaEvaluadores;
    }

    public ArrayList<Puesto> getListaPuestos() {
        return listaPuestos;
    }

    public void setListaPuestos(ArrayList<Puesto> listaPuestos) {
        this.listaPuestos = listaPuestos;
    }

    public ArrayList<Entrevista> getListaEntrevistas() {
        return listaEntrevistas;
    }

    public void setListaEntrevistas(ArrayList<Entrevista> listaEntrevistas) {
        this.listaEntrevistas = listaEntrevistas;
    }

    public ArrayList<Tematica> getListaTematicas() {
        return listaTematicas;
    }

    public void setListaTematicas(ArrayList<Tematica> listaTematicas) {
        this.listaTematicas = listaTematicas;
    }

    public Respaldo(Sistema miSistema) {
        listaPostulantes = miSistema.getListaPostulantes();
        listaEvaluadores = miSistema.getListaEvaluadores();
        listaPuestos = miSistema.getListaPuestos();
        listaEntrevistas = miSistema.getListaEntrevistas();
        listaTematicas = miSistema.getListaTematicas();
    }
}
