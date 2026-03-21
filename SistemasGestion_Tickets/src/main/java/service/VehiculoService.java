/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.VehiculoDao;
import model.Vehiculo;
import model.Ruta;
import java.util.ArrayList;
import java.util.List;

public class VehiculoService {
    private final VehiculoDao vDao;
    private final List<Vehiculo> vehiculos;
    private final List<Ruta> rutasMaestras; // Rutas creadas en el sistema

    public VehiculoService() {
        this.vDao = new VehiculoDao();
        this.vehiculos = vDao.cargarVehiculos();
        this.rutasMaestras = new ArrayList<>();
        
        // Carga inicial de rutas (Requisito: deben existir antes de asignar)
        rutasMaestras.add(new Ruta("R001", "Valledupar", "Bosconia", 90, 80));
        rutasMaestras.add(new Ruta("R002", "Valledupar", "Aguachica", 280, 240) {});
    }

    public String registrarVehiculo(Vehiculo nuevo, String codigoRuta) {
        // 1. Validar placa (Ya lo tenías)
        for (Vehiculo v : vehiculos) {
            if (v.getPlaca().equalsIgnoreCase(nuevo.getPlaca())) {
                return "Error: Placa duplicada.";
            }
        }

        // 2. Usar la clase ValidacionRuta para encontrar la ruta
        Ruta rutaValida = ValidacionRuta.buscarRutaExistente(codigoRuta, rutasMaestras);
        
        if (rutaValida == null) {
            return "Error: La ruta " + codigoRuta + " no es válida o no existe.";
        }

        // 3. Asignación automática al objeto vehículo
        nuevo.setRuta(rutaValida);

        vehiculos.add(nuevo);
        vDao.guardarVehiculo(nuevo);
        return "Vehículo registrado exitosamente en la ruta: " + rutaValida.getOrigen() + " - " + rutaValida.getDestino();
    }
}
