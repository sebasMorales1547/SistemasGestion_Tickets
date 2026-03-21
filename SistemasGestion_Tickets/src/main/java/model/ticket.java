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
public class ticket implements imprimible,calculable {
    private pasajero pasajero;
    private String placaVehiculo;
    private LocalDate fechaCompra;
    private String origen;
    private String destino;
    private double tarifaBase;

    public ticket(pasajero pasajero, String placaVehiculo, String origen, String destino, double tarifaBase) {
        this.pasajero = pasajero;
        this.placaVehiculo = placaVehiculo;
        this.fechaCompra = LocalDate.now();
        this.origen = origen;
        this.destino = destino;
        this.tarifaBase = tarifaBase;
    }
  
    
    public ticket(pasajero pasajero, String placaVehiculo, LocalDate fechaCompra, String origen, String destino, double tarifaBase) {
        this.pasajero = pasajero;
        this.placaVehiculo = placaVehiculo;
        this.fechaCompra = fechaCompra;
        this.origen = origen;
        this.destino = destino;
        this.tarifaBase = tarifaBase;
    }
    
    @Override 
    public double calcularTotal(){
        double descuento = pasajero.calcularDescuento();
        return tarifaBase *(1 - descuento);
    }
    
    
    @Override
    public void imprimirDetalle() {
        System.out.println("=== TICKET ===");
        System.out.println("Pasajero: " + pasajero.getNombre() + " (" + pasajero.getTipo() + ")");
        System.out.println("Vehículo (placa): " + placaVehiculo);
        System.out.println("Ruta: " + origen + " , " + destino);
        System.out.println("Fecha: " + fechaCompra);
        System.out.printf("Tarifa base: $%.0f%n", tarifaBase);
        System.out.printf("Descuento: %.0f%%%n", pasajero.calcularDescuento() * 100);
        System.out.printf("Total a pagar: $%.0f%n", calcularTotal());
    }
    
     

    public pasajero getPasajero() { return pasajero; }
    public String getPlacaVehiculo() { return placaVehiculo; }
    public double getTarifaBase() { return tarifaBase; }
    public LocalDate getFechaCompra() { return fechaCompra; }
    public String getOrigen() { return origen; }
    public String getDestino() { return destino; }

    public String toFileLine() {
        return pasajero.getCedula() + ";" + placaVehiculo + ";" + tarifaBase + ";"
                + origen + ";" + destino + ";" + fechaCompra + ";" + pasajero.getTipo();
    }
    
}
