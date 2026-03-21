package Service;


import Model.Flight;
import Model.InternationalFlight;
import Model.NationalFlight;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class FlightService {
    private final List<Flight> vuelos = new ArrayList<>();

    public void crearVueloNacional(String codigo, String origen, String destino, LocalDate fecha,
                                   LocalTime salida, LocalTime llegada, int capacidad, double precioBase,
                                   double duracionHoras, boolean incluyeAlimentacion) {
        if (findByCode(codigo) != null) throw new IllegalArgumentException("Ya existe un vuelo con ese código");
        Flight f = null;
       NationalFlight(codigo, origen, destino, fecha, salida, llegada, capacidad, precioBase, duracionHoras, incluyeAlimentacion);
        vuelos.add(f); f = new NationalFlight(codigo, origen, destino, fecha, salida, llegada, capacidad, precioBase, duracionHoras, incluyeAlimentacion);
        vuelos.add(f);
    }

    public void crearVueloInternacional(String codigo, String origen, String destino, LocalDate fecha,
                                        LocalTime salida, LocalTime llegada, int capacidad, double precioBase,
                                        String paisDestino, boolean requiereVisa, double cargoInternacional) {
        if (findByCode(codigo) != null) throw new IllegalArgumentException("Ya existe un vuelo con ese código");
        Flight f = new InternationalFlight(codigo, origen, destino, fecha, salida, llegada, capacidad, precioBase, paisDestino, requiereVisa, cargoInternacional);
        vuelos.add(f);
    }

    public Flight findByCode(String codigo) {
        return vuelos.stream().filter(v -> v.getCodigo().equals(codigo)).findFirst().orElse(null);
    }

    public List<Flight> listarTodos() {
        return new ArrayList<>(vuelos);
    }

    public List<Flight> buscarPorDestino(String destino) {
        List<Flight> res = new ArrayList<>();
        for (Flight f : vuelos) {
            if (f.getCiudadDestino().equalsIgnoreCase(destino)) res.add(f);
        }
        return res;
    }

    public int contarPorTipo(Class<? extends Flight> tipo) {
        int c = 0;
        for (Flight f : vuelos) if (tipo.isInstance(f)) c++;
        return c;
    }

    private void NationalFlight(String codigo, String origen, String destino, LocalDate fecha, LocalTime salida, LocalTime llegada, int capacidad, double precioBase, double duracionHoras, boolean incluyeAlimentacion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  }