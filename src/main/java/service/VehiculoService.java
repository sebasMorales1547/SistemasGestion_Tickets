/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Dao.VehiculoDao;
import model.Vehiculo;
import java.util.List;

public class VehiculoService {
    private final VehiculoDao vDao;
    private final List<Vehiculo> vehiculos;

    public VehiculoService() {
        this.vDao = new VehiculoDao();
        this.vehiculos = vDao.cargarVehiculos(); // Carga automática al iniciar 
    }

    public String registrarVehiculo(Vehiculo nuevo) {
        // Validación: No registrar dos vehículos con la misma placa
        for (Vehiculo v : vehiculos) {
            if (v.getPlaca().equalsIgnoreCase(nuevo.getPlaca())) {
                return "Error: Ya existe un vehículo con esa placa.";
            }
        }
        vehiculos.add(nuevo);
        vDao.guardarVehiculo(nuevo); // Guardar inmediatamente 
        return "Vehículo registrado con éxito.";
    }

    public Vehiculo buscarPorPlaca(String placa) {
        return vehiculos.stream()
                .filter(v -> v.getPlaca().equalsIgnoreCase(placa))
                .findFirst()
                .orElse(null);
    }
}