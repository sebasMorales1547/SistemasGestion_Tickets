/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Familia
 */
public class Bus extends Vehiculo {
    public Bus(String placa, String ruta) {
        super(placa, ruta, 45); // Capacidad: 45 
    }
    @Override
    public double getTarifaBase() { return 15000.0; } // Tarifa: 15k 
    @Override
    public void imprimirDetalle() {
        System.out.println("Bus [" + placa + "] - Ruta: " + ruta + " - Cupos: " + (capacidadMaxima - pasajerosActuales));
    }
}
