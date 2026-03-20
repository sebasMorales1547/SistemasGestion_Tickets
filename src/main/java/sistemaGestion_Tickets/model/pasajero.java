/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaGestion_Tickets.model;

/**
 *
 * @author PC
 */
public abstract class pasajero extends persona {
    
    public pasajero(String cedula, String nombre) {
        super(cedula, nombre);
    }
    
    public abstract double calcularDescuento();
    public abstract String getTipo();
    
    public String toFileLine(){
        return cedula + ";" + nombre + ";" + getTipo();
    }
    
}
