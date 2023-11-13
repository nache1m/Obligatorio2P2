
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
    public Sistema (){
        listaPostulantes = new ArrayList();
        listaEvaluadores = new ArrayList();
        listaPuestos = new ArrayList();
        listaEntrevistas = new ArrayList();
        listaTematicas = new ArrayList();
    }
    
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
    
    public void agregarEvaluador(Evaluador ev){
        this.getListaEvaluadores().add(ev);
    }
    
    public void agregarTematica (Tematica tema) {
        ArrayList listaDesactualizada = listaTematicas;
        this.listaTematicas.add(tema);
        manejador.firePropertyChange("listaTematicas", listaDesactualizada, listaTematicas);
    }
    
    public void agregarEscuchas (PropertyChangeListener c) {
        manejador.addPropertyChangeListener(c);
    }

    public void altaPostulante(Postulante nuevoPostulante) {
        ArrayList listaDesactualizada = listaPostulantes;
        listaPostulantes.add(nuevoPostulante);
        manejador.firePropertyChange("listaPostulantes", listaDesactualizada, listaPostulantes);
    }
    
    public String [] darExperiencias (Postulante p) {
        String [] res = new String [this.getListaTematicas().size()];
        HashMap<Tematica, Integer> hashMap = p.getNivelYTemas();
        Collection <Tematica> llaves = hashMap.keySet();
        int contador = 0;    
        for (Tematica llave : llaves) {
            String txt = llave + "("+ hashMap.get(llave) +")";
            res[contador] = txt;
            contador++;
            }
        return res;
    }
    
    public void borrarTematicaYNivel(String nombreTematica) {
       //continuarAcá
    }
}
