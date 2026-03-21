package dao;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import model.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VehiculoDao {
    private final String[] ARCHIVOS = {"buseta.txt", "microbus.txt", "bus.txt"}; 

    public void guardarVehiculo(Vehiculo v) {
        String archivo = v instanceof Buseta ? "buseta.txt" : v instanceof MicroBus ? "microbus.txt" : "bus.txt";
        try (PrintWriter out = new PrintWriter(new FileWriter(archivo, true))) {
            out.println(v.getPlaca() + ";" + v.getCapacidadMaxima() + ";" + v.getPasajerosActuales()); // Formato simple 
        } catch (IOException e) {
            System.err.println("Error al guardar vehículo: " + e.getMessage());
        }
    }

    public List<Vehiculo> cargarVehiculos() {
        List<Vehiculo> lista = new ArrayList<>();
        // Logica para leer cada archivo y reconstruir los objetos al iniciar el sistema
        return lista;
    }
}
