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
    protected Ruta ruta; // <--- Importante: tipo Ruta, no String
    
    // ... constructor y otros métodos
    
    public void setRuta(Ruta ruta) { this.ruta = ruta; }

    public String getOrigen() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}