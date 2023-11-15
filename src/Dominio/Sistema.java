
package Dominio;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.*;
import static java.util.Arrays.sort;

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
        ArrayList <Tematica> listaTemaVieja = new ArrayList<>(listaTematicas);
        this.listaTematicas.add(tema);
        manejador.firePropertyChange("listaTematicas", listaTemaVieja, listaTematicas);
    }
    
    public void agregarEscuchas (PropertyChangeListener c) {
        manejador.addPropertyChangeListener(c);
    }

    public void altaPostulante(Postulante nuevoPostulante) {
        ArrayList<Postulante> listaDesactualizada = new ArrayList<>(listaPostulantes);
    listaPostulantes.add(nuevoPostulante);
    manejador.firePropertyChange("listaPostulantes", listaDesactualizada, listaPostulantes);

    }
    
    public String [] darExperiencias(Postulante p) {
        String [] res = new String [this.getListaTematicas().size()];
        HashMap<Tematica, Integer> hashMap = p.getNivelYTemas();
        Collection <Tematica> llaves = hashMap.keySet();
        int contador = 0;    
        for (Tematica llave : llaves) {
            String txt = llave + "("+ hashMap.get(llave) +")";
            res[contador] = txt;
            contador++;
            }
        this.ordenarExperiencias(p, res);
        return res;
    }
    
    public void borrarTematica(String nombreTematica) {
       for(Tematica elem : this.listaTematicas) {
           if (elem.getNombre().equals(nombreTematica)) {
               this.listaTematicas.remove(elem);
           }
       }
    }

    public void borrarExperiencia(String nombreTematica, Postulante p) {
       for(Tematica elem : this.listaTematicas) {
           if (elem.getNombre().equals(nombreTematica)) {
               p.borrarExperiencia(elem);
           }
       }
    }

    public void ordenarExperiencias(Postulante postulante, String [] experiencias) {
       Arrays.sort(experiencias, new Comparator () {
            @Override
            public int compare(Object o1, Object o2) {
                String e1 = (String) o1;
                String e2 = (String) o2;
                 if (e1 == null && e2 == null) {
                    return 0; 
                } else if (e1 == null) {
                    return 1; 
                } else if (e2 == null) {
                    return -1; 
                } else {
                    return e1.compareTo(e2);
                }
                
            }
        }
       
       );
    
    }
    
    public void borrarTemas(List<String> experienciasABorrar, Postulante p) {
       for (String elem: experienciasABorrar) {
          String elemento = elem.split("\\(")[0]; 
          Tematica tema = p.obtenerTematicaPorNombre(elemento); 
          p.getNivelYTemas().remove(tema);
       }
    }
}
