//Ignacio Parrado - 303400
//Ezequiel Peña - 224585
package Dominio;

import Excepciones.verificoPuntajeException;
import Excepciones.VerificoAñoException;
import Excepciones.verificoLinkedInException;
import Excepciones.PuestoYaExisteException;
import Excepciones.verificarMailException;
import Excepciones.VerificarTelefonoException;
import Excepciones.CedulaFormatoException;
import Excepciones.CampoVacioException;
import Excepciones.CedulaRepetidaException;
import Excepciones.TematicaYaExisteException;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.*;
import javax.swing.JOptionPane;

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

    public Sistema(Respaldo miRespaldo) {
        listaPostulantes = new ArrayList(miRespaldo.getListaPostulantes());
        listaEvaluadores = new ArrayList(miRespaldo.getListaEvaluadores());
        listaPuestos = new ArrayList(miRespaldo.getListaPuestos());
        listaEntrevistas = new ArrayList(miRespaldo.getListaEntrevistas());
        listaTematicas = new ArrayList(miRespaldo.getListaTematicas());
        manejador = new PropertyChangeSupport(this);

    }

    // Metodos.
    public boolean tematicaRepetida(String nombre) throws TematicaYaExisteException {
        ArrayList<Tematica> lista = this.listaTematicas;
        boolean encontre = false;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getNombre().equalsIgnoreCase(nombre)) {
                encontre = true;
            }
        }

        if (encontre) {
            throw new TematicaYaExisteException("La tématica ya existe");
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

    public void agregarTematica(Tematica tema) throws TematicaYaExisteException {
        ArrayList<Tematica> listaTemaVieja = new ArrayList<>(listaTematicas);
        if (!tematicaRepetida(tema.getNombre())) {
            this.listaTematicas.add(tema);
        }

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

    public void ordenarPostulantesPorCedula() {
        if (listaPostulantes != null) {
            Collections.sort(listaPostulantes, new Comparator<Postulante>() {
                @Override
                public int compare(Postulante p1, Postulante p2) {
                    return p1.getCedula().compareTo(p2.getCedula());
                }
            });
        }
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

    public boolean campoNoEstaVacio(String campo, String nombre) throws CampoVacioException {
        boolean res = true;
        if (campo.equals("")) {
            res = false;
            throw new CampoVacioException("El campo " + nombre + " está vacío y es obligatorio.");
        }
        return res;
    }

    public boolean verificoCedula(String cedula) throws CedulaRepetidaException, CedulaFormatoException {
        boolean res = true;

        try {
            int ci = Integer.parseInt(cedula);
        } catch (Exception e) {
            throw new CedulaFormatoException("La cédula debe escribirse sin puntos ni guiones y largo 8");
        }

        if (cedula.length() != 8) {
            res = false;
            throw new CedulaFormatoException("La cédula debe escribirse sin puntos ni guiones y largo 8");
        }
        for (Postulante elem : this.getListaPostulantes()) {
            if (elem.getCedula().equals(cedula)) {
                res = false;
                throw new CedulaRepetidaException("La cédula ingresaga ya existe. Por favor verifique");
            }
        }

        return res;
    }

    ;

   public int cantidadPostulantesNivelMayorA5(Tematica t) {
        int cant = 0;
        for (Postulante p : this.listaPostulantes) {
            HashMap<Tematica, Integer> hashMap = p.getNivelYTemas();
            Collection<Tematica> llaves = hashMap.keySet();
            for (Tematica llave : llaves) {
                if (llave.equals(t) && (hashMap.get(llave) > 5)) {
                    cant++;
                }
            }
        }
        return cant;
    }

    public int cantidadPuestosRequierenConocimiento(Tematica t) {
        int cant = 0;
        for (Puesto p : this.listaPuestos) {
            ArrayList<Tematica> temas = p.getTemas();
            for (Tematica tema : temas) {
                if (tema.equals(t)) {
                    cant++;
                }
            }
        }
        return cant;
    }

    public PropertyChangeSupport getManejador() {
        return this.manejador;
    }

    public boolean verificoTelefono(String telefono) throws VerificarTelefonoException {
        boolean res = false;

        try {
            int tel = Integer.parseInt(telefono);
            if (telefono.length() >= 8 && telefono.length() <= 9) {
                res = true;
            } else {
                throw new VerificarTelefonoException("El télefono debe estar en formato número y tener 8 u 9 carácteres");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El télefono debe estar en formato número y tener 8 u 9 carácteres", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
        return res;

    }

    public boolean verificoMail(String email) throws verificarMailException {
        boolean res = false;
        if (email.contains("@gmail.com") || email.contains("@hotmail.com") || email.contains("@yahoo.com")) {
            res = true;
        } else {
            throw new verificarMailException("El email debe ser @gmail.com, @hotmail.com o @hotmail.com");
        }
        return res;
    }

    public boolean verificoLinkedIn(String LinkedIn) throws verificoLinkedInException {
        boolean res = false;
        if (LinkedIn.contains("https://www.linkedin.com/in/") && LinkedIn.length() > "https://www.linkedin.com/in/".length()) {
            res = true;
        } else {
            throw new verificoLinkedInException("Su LinkedIn debe estar en formato https://www.linkedin.com/in/minickname");
        }
        return res;
    }

    public boolean puestoRepetido(String nombre) throws PuestoYaExisteException {
        ArrayList<Puesto> lista = this.listaPuestos;
        boolean encontre = false;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getNombre().equalsIgnoreCase(nombre)) {
                encontre = true;
            }
        }
        if (encontre) {
            throw new PuestoYaExisteException("El puesto ya existe.");
        }
        return encontre;
    }

    public boolean verificoAño (String año)  throws VerificoAñoException {
        boolean res = false;
        try {
             int n = Integer.parseInt(año);
             if (n >= 1900 && n <= 2023) {
                 res = true;
             } else {
             throw new VerificoAñoException("El año debe estar comprendido entre 1900 y el año actual");
             }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un año en integer XXXX", "Alerta", JOptionPane.WARNING_MESSAGE);
            
        }
        return res;
}

    public boolean verificoPuntaje(int puntaje) throws verificoPuntajeException {
        boolean res = false;
        if (puntaje >= 0 && puntaje <=100) {
            res = true;
        } else {
        throw new verificoPuntajeException("El puntaje debe estar comprendido entre 0 y 100.");
        }
        return res;
    }
    
    public boolean confirmarBaja(Postulante postulante) {
        int opcion = JOptionPane.showConfirmDialog(
            null,
            "¿Estás seguro de dar de baja al Postulante: " + postulante.getNombre() + "?",
            "Confirmación de Baja",
            JOptionPane.YES_NO_OPTION
        );
        return opcion == JOptionPane.YES_OPTION;
    }
    }
