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
    private PropertyChangeSupport manejador;

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
    public Sistema() {
        listaPostulantes = new ArrayList();
        listaEvaluadores = new ArrayList();
        listaPuestos = new ArrayList();
        listaEntrevistas = new ArrayList();
        listaTematicas = new ArrayList();
        manejador = new PropertyChangeSupport(this);
    }

    // Metodos.
    public boolean tematicaRepetida(String nombre) {
        ArrayList<Tematica> lista = this.listaTematicas;
        boolean encontre = false;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getNombre().equalsIgnoreCase(nombre)) {
                encontre = true;
            }
        }
        return encontre;
    }

    public void agregarEvaluador(Evaluador ev) {
        ArrayList<Evaluador> listaE = new ArrayList<>(this.listaEvaluadores);
        this.getListaEvaluadores().add(ev);
        manejador.firePropertyChange("listaEvaluadores", listaE, listaEvaluadores);

    }

    public void agregarEntrevista(Entrevista ent) {
        ArrayList<Entrevista> lista = new ArrayList<>(listaEntrevistas);
        this.listaEntrevistas.add(ent);
        manejador.firePropertyChange("listaEntrevistas", lista, listaEntrevistas);
    }

    public void agregarTematica(Tematica tema) {
        ArrayList<Tematica> listaTemaVieja = new ArrayList<>(listaTematicas);
        this.listaTematicas.add(tema);
        manejador.firePropertyChange("listaTematicas", listaTemaVieja, listaTematicas);
    }

    public void agregarEscuchas(PropertyChangeListener c) {
        manejador.addPropertyChangeListener(c);
    }

    public void altaPostulante(Postulante nuevoPostulante) {
        ArrayList<Postulante> listaDesactualizada = new ArrayList<>(listaPostulantes);
        listaPostulantes.add(nuevoPostulante);
        manejador.firePropertyChange("listaPostulantes", listaDesactualizada, listaPostulantes);

    }

    public String[] darExperiencias(Postulante p) {
        String[] res = new String[this.getListaTematicas().size()];
        HashMap<Tematica, Integer> hashMap = p.getNivelYTemas();
        Collection<Tematica> llaves = hashMap.keySet();
        int contador = 0;
        for (Tematica llave : llaves) {
            String txt = llave + "(" + hashMap.get(llave) + ")";
            res[contador] = txt;
            contador++;
        }
        this.ordenarExperiencias(p, res);
        return res;
    }

    public void borrarTematica(String nombreTematica) {
        for (Tematica elem : this.listaTematicas) {
            if (elem.getNombre().equals(nombreTematica)) {
                this.listaTematicas.remove(elem);
            }
        }
    }

    public void borrarExperiencia(String nombreTematica, Postulante p) {
        for (Tematica elem : this.listaTematicas) {
            if (elem.getNombre().equals(nombreTematica)) {
                p.borrarExperiencia(elem);
            }
        }
    }

    public void ordenarExperiencias(Postulante postulante, String[] experiencias) {
        Arrays.sort(experiencias, new Comparator() {
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
        for (String elem : experienciasABorrar) {
            String elemento = elem.split("\\(")[0];
            Tematica tema = p.obtenerTematicaPorNombre(elemento);
            p.getNivelYTemas().remove(tema);
        }
        ArrayList<Postulante> copiaListaPostulantes = new ArrayList<>(this.listaPostulantes);
        this.listaPostulantes.remove(p);
        manejador.firePropertyChange("listaPostulantes", copiaListaPostulantes, listaPostulantes);
    }

    public void borrarPostulante(Postulante p) {
        ArrayList<Postulante> copiaListaPostulantes = new ArrayList<>(this.listaPostulantes);
        for (Postulante elem : copiaListaPostulantes) {
            if (elem.equals(p)) {
                this.listaPostulantes.remove(p);
            }
        }
        ArrayList<Entrevista> copiaListaEntrevistas = new ArrayList<>();
        for (Entrevista E : copiaListaEntrevistas) {
            if (E.getPostulante().equals(p)) {
                this.listaEntrevistas.remove(E);
            }

        }
        manejador.firePropertyChange("listaPostulantes", copiaListaPostulantes, listaPostulantes);
        manejador.firePropertyChange("listaEntrevistas", copiaListaEntrevistas, listaEntrevistas);
    }

    public void agregarPuesto(Puesto p) {
        ArrayList<Puesto> copiaListaPuestos = new ArrayList<>(this.listaPuestos);
        this.getListaPuestos().add(p);
        manejador.firePropertyChange("listaPuestps", copiaListaPuestos, listaPuestos);

    }

    public ArrayList<Postulante> listaPostulantesParaPuesto(Puesto p, int nivel) {
        ArrayList<Postulante> misPostulantes = new ArrayList<Postulante>();
        //Chequeo postulantes con almenos una entrevista y tipo de trabajo adecuado
        for (Entrevista elem : this.listaEntrevistas) {
            if (elem.getPostulante().getTipoTrabajo() == p.getTipo()) {
                misPostulantes.add(elem.getPostulante());
            }
        }

        ArrayList<Postulante> listaFinal = new ArrayList(misPostulantes);

        //recorro todos las tematicas del puesto y comparo por cada postulante primero si la tienen y luego si cumplen el ingel
        for (Tematica elem : p.getTemas()) {
            for (Postulante postulante : misPostulantes) {
                if (postulante != null) {
                    if (!postulante.contieneTematica(elem)) {
                        listaFinal.remove(postulante);
                    } else {
                        if (!(postulante.contieneTieneNivel(elem, nivel))) {
                            listaFinal.remove(postulante);
                        }
                    }
                }
            }
        }
        return listaFinal;
    }

    public String[] doyArrayListConMasDatos(ArrayList<Postulante> lis) {
        String[] res = new String[lis.size()];

        for (int i = 0; i < lis.size(); i++) {
            Postulante elem = lis.get(i);
            String txt = elem.getNombre() + " / " + elem.getCedula() + " / " + elem.getEmail();
            res[i] = txt;

        }

        return res;
    }

    public ArrayList<Postulante> ordenarPostulantesPorEntrevista(ArrayList<Postulante> ap) {
        ArrayList<Entrevista> entrevistas = new ArrayList<Entrevista>();
        ArrayList<Postulante> res = new ArrayList<Postulante>();
        //Como la entrevista es la que tiene al postulante preciso sacar la última entrevista de cada postulante;
        for (Postulante elem : ap) {
            boolean esta = false;
            for (int i = 0; i < this.listaEntrevistas.size() && !esta; i++) {
                if (this.listaEntrevistas.get(i).getPostulante().equals(elem)) {
                    if (!entrevistas.contains(this.listaEntrevistas.get(i))) {
                        entrevistas.add(this.listaEntrevistas.get(i));
                        esta = !esta;
                    }
                }
            }
        }
        //Como ya tengo la última entrevista de solo mis candidatos aceptados ordeno las entrevistas
        Collections.sort(entrevistas, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Entrevista e1 = (Entrevista) o1;
                Entrevista e2 = (Entrevista) o2;

                return e1.getPuntaje() - e2.getPuntaje();
            }
        });
        //Saco de mi array de entrevistas de los postulantes aptos sus postulantes para devolverlo en un array de postulantes ordenados
        for (Entrevista elem : entrevistas) {
            res.add(elem.getPostulante());
        }
        
        return res;

    }
}
