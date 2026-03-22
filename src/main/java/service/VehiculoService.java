package service;

import dao.VehiculoDao;
import model.Vehiculo;
import model.Buseta;
import model.MicroBus;
import model.Bus;
import java.util.List;

public class VehiculoService {
    private final VehiculoDao vDao;
    private final List<Vehiculo> vehiculos;

    public VehiculoService() {
        this.vDao = new VehiculoDao();
        this.vehiculos = vDao.cargarVehiculos();
    }

    public String registrarVehiculo(Vehiculo nuevo) {
        for (Vehiculo v : vehiculos) {
            if (v.getPlaca().equalsIgnoreCase(nuevo.getPlaca())) {
                return "Error: Ya existe un vehículo con esa placa.";
            }
        }
        vehiculos.add(nuevo);
        vDao.guardarVehiculo(nuevo);
        return "Vehículo registrado con éxito.";
    }

    public Vehiculo buscarPorPlaca(String placa) {
        return vehiculos.stream()
                .filter(v -> v.getPlaca().equalsIgnoreCase(placa))
                .findFirst()
                .orElse(null);
    }

    public List<Vehiculo> buscarPorTipo(String tipo) {
        return vehiculos.stream()
                .filter(v -> switch (tipo.toLowerCase()) {
                    case "buseta"   -> v instanceof Buseta;
                    case "microbus" -> v instanceof MicroBus;
                    case "bus"      -> v instanceof Bus;
                    default         -> false;
                })
                .toList();
    }
 //Obtener todooo
    public List<Vehiculo> obtenerTodos() {
        return vehiculos;
    }
}