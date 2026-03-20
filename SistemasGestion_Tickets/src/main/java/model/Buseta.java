/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Familia
 */
public class Buseta extends Vehiculo {
    public Buseta(String placa, String ruta) {
        super(placa, ruta, 19); // Capacidad: 19 
    }
    @Override
    public double getTarifaBase() { return 8000.0; } // Tarifa: 8k 
    @Override
    public void imprimirDetalle() {
        System.out.println("Buseta [" + placa + "] - Ruta: " + ruta + " - Cupos: " + (capacidadMaxima - pasajerosActuales));
    }
}