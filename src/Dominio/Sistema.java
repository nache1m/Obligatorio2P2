
package Dominio;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.*;

public class Sistema implements Serializable {
    
    private ArrayList<Postulante> listaPostulantes;
    private ArrayList<Evaluador> listaEvaluadores;
    private ArrayList<Puesto> listaPuestos;
    private ArrayList<Entrevista> listaEntrevistas;
    private ArrayList<Tematica> listaTematicas;
    private PropertyChangeSupport manejador = new PropertyChangeSupport(this);
    // Getters y Setters.
    public ArrayList<Postulante> getListaPostulantes() {
        return listaPostulantes;
    }
    
    public ArrayList<Evaluador> getListaEvaluadores() {
        return listaEvaluadores;
    }
    
    public ArrayList<Puesto> getListaPuestos() {
        return listaPuestos;
    }
    
    public ArrayList<Entrevista> getListaEntrevistas() {
        return listaEntrevistas;
    }
    
    public ArrayList<Tematica> getListaTematicas() {
        return listaTematicas;
    }
    
    // Constructor.
    
    // Metodos.
    public boolean tematicaRepetida (String nombre){
        ArrayList<Tematica> lista = this.listaTematicas;
        boolean encontre = false;
        for (int i=0; i < lista.size(); i++){
            if (lista.get(i).getNombre().equalsIgnoreCase(nombre)){
                encontre = true;
            }
        }
        return encontre;
    }
    
    public void agregarTematica (Tematica tema) {
        this.listaTematicas.add(tema);
    }
    
    public void agregarEscuchas (PropertyChangeListener c) {
        manejador.addPropertyChangeListener(c);
    }

    public void altaPostulante(Postulante nuevoPostulante) {
        ArrayList listaDesactualizada = listaPostulantes;
        listaPostulantes.add(nuevoPostulante);
        manejador.firePropertyChange("listaPostulantes", listaDesactualizada, listaPostulantes);
    }
}
