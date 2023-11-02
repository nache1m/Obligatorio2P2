
package Dominio;
import java.util.*;
public class Sistema {
    
    private ArrayList<Postulante> listaPostulantes;
    private ArrayList<Evaluador> listaEvaluadores;
    private ArrayList<Puesto> listaPuestos;
    private ArrayList<Entrevista> listaEntrevistas;
    private ArrayList<Tematica> listaTematicas;
    
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
}
