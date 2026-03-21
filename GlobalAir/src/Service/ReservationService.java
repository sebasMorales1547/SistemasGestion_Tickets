package Service;

import Model.Flight;
import Model.Passenger;
import Model.Reservation;
import Model.ReservationStatus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReservationService {

    private final List<Reservation> reservas = new ArrayList<>();
    private final FlightService flightService;
    private final PassengerService passengerService;

    public ReservationService(FlightService flightService, PassengerService passengerService) {
        this.flightService = flightService;
        this.passengerService = passengerService;
    }
    public void crearReserva(String codigoReserva, String cedulaPasajero, String codigoVuelo, int cantidadAsientos, LocalDate fechaReserva) {
        if (buscarPorCodigo(codigoReserva) != null) {
            throw new IllegalArgumentException("No se pueden crear dos reservas con el mismo código");
        }

        Passenger p = passengerService.buscarPorCedula(cedulaPasajero);
        if (p == null) {
            throw new IllegalArgumentException("No se encontró el pasajero con esa cédula");
        }

        Flight f = (Flight) flightService.findByCode(codigoVuelo);
        if (f == null) {
            throw new IllegalArgumentException("No se encontró el vuelo con ese código");
        }

        if (cantidadAsientos < 1 || cantidadAsientos > 5) {
            throw new IllegalArgumentException("No se pueden reservar más de 5 asientos por reserva");
        }

        if (cantidadAsientos > f.getAsientosDisponibles()) {
            throw new IllegalArgumentException("No hay asientos disponibles para este vuelo");
        }

        Reservation r = new Reservation(codigoReserva, p, f, cantidadAsientos, fechaReserva);
        reservas.add(r);
        f.reducirAsientos(cantidadAsientos);
    }
    public Reservation buscarPorCodigo(String codigo) {
        return reservas.stream()
                .filter(r -> r.getCodigo().equals(codigo))
                .findFirst()
                .orElse(null);
    }
    public int cancelarReserva(String codigo) {
        Reservation r = buscarPorCodigo(codigo);
        if (r == null) {
            throw new IllegalArgumentException("No se encontró la reserva con ese código");
        }

        if (r.getEstado() == ReservationStatus.CANCELADA) {
            return 0; 
        }

        r.cancelar();
        r.getVuelo().aumentarAsientos(r.getCantidadAsientos());
        return 1; 
    }
    public List<Reservation> listarPorPasajero(String cedula) {
        return reservas.stream()
                .filter(r -> r.getPasajero().getCedula().equals(cedula))
                .collect(Collectors.toList());
    }
    public List<Reservation> listarTodas() {
        return new ArrayList<>(reservas);
    }
    public double ingresosTotalesReservas() {
        return reservas.stream()
                .filter(r -> r.getEstado() == ReservationStatus.CONFIRMADA || r.getEstado() == ReservationStatus.COMPLETADA)
                .mapToDouble(Reservation::getPrecioTotal)
                .sum();
    }
    public String vueloMasReservado() {
        Map<String, Long> counts = reservas.stream()
                .collect(Collectors.groupingBy(r -> r.getVuelo().getCodigo(), Collectors.counting()));

        return counts.entrySet().stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse(null);
    }
    public double ocupacionPromedio() {
        List<Flight> vuelos = flightService.listarTodos();
        if (vuelos.isEmpty()) return 0.0;

        double sumPorcentajes = 0.0;
        for (Flight v : vuelos) {
            int ocupados = v.getCapacidadTotal() - v.getAsientosDisponibles();
            double porcentaje = ((double) ocupados / v.getCapacidadTotal()) * 100.0;
            sumPorcentajes += porcentaje;
        }
        return sumPorcentajes / vuelos.size();
    }
}