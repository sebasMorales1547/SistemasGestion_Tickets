/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class reserva implements imprimible {

    public enum Estado { ACTIVA, CONVERTIDA, CANCELADA }

    private String codigo;
    private pasajero pasajero;
    private String placaVehiculo;
    private LocalDateTime fechaCreacion;
    private LocalDate fechaViaje;
    private Estado estado;

    public reserva(String codigo, pasajero pasajero, String placaVehiculo, LocalDate fechaViaje) {
        this.codigo = codigo;
        this.pasajero = pasajero;
        this.placaVehiculo = placaVehiculo;
        this.fechaCreacion = LocalDateTime.now();
        this.fechaViaje = fechaViaje;
        this.estado = Estado.ACTIVA; // Inicia siempre como activa
    }

    public reserva(String codigo, pasajero pasajero, String placaVehiculo,
                   LocalDateTime fechaCreacion, LocalDate fechaViaje, Estado estado) {
        this.codigo = codigo;
        this.pasajero = pasajero;
        this.placaVehiculo = placaVehiculo;
        this.fechaCreacion = fechaCreacion;
        this.fechaViaje = fechaViaje;
        this.estado = estado;
    }

    public boolean estaVencida() {
        return LocalDateTime.now().isAfter(fechaCreacion.plusHours(24))
                && estado == Estado.ACTIVA;
    }

    public void cancelar() { this.estado = Estado.CANCELADA; }
    public void convertir() { this.estado = Estado.CONVERTIDA; }

    public String getCodigo() { return codigo; }
    public pasajero getPasajero() { return pasajero; }
    public String getPlacaVehiculo() { return placaVehiculo; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public LocalDate getFechaViaje() { return fechaViaje; }
    public Estado getEstado() { return estado; }

    @Override
    public void imprimirDetalle() {
        System.out.println("=== RESERVA ===");
        System.out.println("Codigo: " + codigo);
        System.out.println("Pasajero: " + pasajero.getNombre());
        System.out.println("Vehiculo (placa): " + placaVehiculo);
        System.out.println("Fecha creacion: " + fechaCreacion);
        System.out.println("Fecha viaje: " + fechaViaje);
        System.out.println("Estado: " + estado);
    }

    public String toFileLine() {
        return codigo + ";" + pasajero.getCedula() + ";" + placaVehiculo + ";"
                + fechaCreacion + ";" + fechaViaje + ";" + estado;
    }
}
