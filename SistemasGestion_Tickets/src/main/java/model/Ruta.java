/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Familia
 */
public abstract class Ruta implements imprimible {
    protected String placa;
    protected Ruta ruta; // <-- Ahora es un objeto, no un String
   
    
    public void asignarRuta(Ruta nuevaRuta) {
        this.ruta = nuevaRuta;
    }
}
