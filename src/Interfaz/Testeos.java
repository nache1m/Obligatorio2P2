/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

import Dominio.Postulante;
import Dominio.Tematica;


public class Testeos {
    public static void main (String [] args ) {
        Tematica temaA = new Tematica ("JavasScript", "Sirve para codear.");
        Tematica temaB = new Tematica ("C#", "Sirve para aprender");
        Postulante posA= new Postulante("Eze", "5.064.910-7", "099364343", "ezequielpepedemonte@gmail.com" ,"elEze",2, temaA, 4);
        Postulante posB= new Postulante("Nacho", "Sin cedula", "091219658", "nacheim@gmail.com" ,"nacheim", 1, temaB, 5);
        //System.out.println(posA.obtenerTematicas());
        //System.out.println(posB.darNivelTematica(temaB));
        System.out.println(posA);
    }
}
