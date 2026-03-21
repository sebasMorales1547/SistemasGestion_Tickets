/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author PC
 */
public class pasajeroRegular extends pasajero {

    public pasajeroRegular(String cedula, String nombre, LocalDate fechaNacimiento) {
        super(cedula, nombre, fechaNacimiento);
}
    
    @Override
    public double calcularDescuento(){
        return 0.0;
    }
    
    @Override
    public String getTipo(){
        return "Regular";
    }
    
    @Override
    public void imprimirDetalle(){
        System.out.println("===Pasajero===");
        System.out.println("Nombre: "+ nombre);
        System.out.println("Cedula: " + cedula);
        System.out.println("Tipo: Pasajero regular, no aplica descuento");
    }
    
}
