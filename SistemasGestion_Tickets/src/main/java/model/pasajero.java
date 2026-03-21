/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.time.Period;

public abstract class pasajero extends persona {
    protected LocalDate fechaNacimiento;

    public pasajero(String cedula, String nombre, LocalDate fechaNacimiento) {
        super(cedula, nombre);
        this.fechaNacimiento = fechaNacimiento;
    }

    // Calcula automaticamente si el pasajero tiene 60 años o mas
    public boolean esAdultoMayor() {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears() >= 60;
    }

    public LocalDate getFechaNacimiento() { return fechaNacimiento; }

    public abstract double calcularDescuento();
    public abstract String getTipo();

    public String toFileLine() {
        return cedula + ";" + nombre + ";" + getTipo() + ";" + fechaNacimiento;
    }
}
