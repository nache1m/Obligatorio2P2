/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

/**
 *
 * @author 59891
 */
public class VerificoAñoException extends Exception {

    public VerificoAñoException(String el_año_debe_estar_comprendido_entre_1900_) {
        super(el_año_debe_estar_comprendido_entre_1900_);
    }
    
}
