package Service;


import Model.Passenger;
import java.util.ArrayList;
import java.util.List;

public class PassengerService {
    private final List<Passenger> pasajeros = new ArrayList<>();

    public void registrarPasajero(Passenger p) {
        if (buscarPorCedula(p.getCedula()) != null) {
            throw new IllegalArgumentException("Ya existe un pasajero con esa cédula");
        }
        if (buscarPorPasaporte(p.getPasaporte()) != null) {
            throw new IllegalArgumentException("Ya existe un pasajero con ese pasaporte");
        }
        pasajeros.add(p);
    }

    public Passenger buscarPorCedula(String cedula) {
        return pasajeros.stream()
                .filter(p -> p.getCedula().equals(cedula))
                .findFirst().orElse(null);
    }

    public Passenger buscarPorPasaporte(String pasaporte) {
        return pasajeros.stream()
                .filter(p -> p.getPasaporte().equals(pasaporte))
                .findFirst().orElse(null);
    }

    public List<Passenger> listarTodos() {
        return new ArrayList<>(pasajeros);
    }

    public int totalPasajeros() {
        return pasajeros.size();
    }
}
