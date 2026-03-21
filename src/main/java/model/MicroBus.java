/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Familia
 */
public class MicroBus extends Vehiculo {
    public MicroBus(String placa, String ruta) {
        super(placa, ruta, 25); // Capacidad: 25 
    }
    @Override
    public double getTarifaBase() { return 10000.0; } // Tarifa: 10k 
    @Override
    public void imprimirDetalle() {
        System.out.println("MicroBus [" + placa + "] - Ruta: " + ruta + " - Cupos: " + (capacidadMaxima - pasajerosActuales));
    }
}
