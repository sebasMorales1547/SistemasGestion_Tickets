/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
/**
 *
 * @author Familia
 */
package com.mycompany.mavenproject1;

import java.util.Scanner;

// Clase Paciente
class Paciente {
    private String nombre;
    private int edad;
    private String cedula;
    private String direccion;
    private String telefono;
    private String historialMedico;

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getHistorialMedico() { return historialMedico; }
    public void setHistorialMedico(String historialMedico) { this.historialMedico = historialMedico; }
}

// Clase Medico
class Medico {
    private String nombre;
    private String especialidad;
    private String licencia;
    private String telefono;

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    public String getLicencia() { return licencia; }
    public void setLicencia(String licencia) { this.licencia = licencia; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
}

// Clase CitaMedica
class CitaMedica {
    private String fecha;
    private String hora;
    private String motivo;

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public String getHora() { return hora; }
    public void setHora(String hora) { this.hora = hora; }

    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }
}

// Programa principal
public class Hospital {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Crear paciente
        Paciente paciente = new Paciente();
        System.out.print("Ingrese nombre del paciente: ");
        paciente.setNombre(sc.nextLine());
        System.out.print("Ingrese edad: ");
        paciente.setEdad(sc.nextInt());
        sc.nextLine(); // limpiar buffer
        System.out.print("Ingrese cedula: ");
        paciente.setCedula(sc.nextLine());

        // Mostrar datos
        System.out.println("\n--- DATOS PACIENTE ---");
        System.out.println("Nombre: " + paciente.getNombre());
        System.out.println("Edad: " + paciente.getEdad());
        System.out.println("Cedula: " + paciente.getCedula());

        sc.close();
    }
}
}
