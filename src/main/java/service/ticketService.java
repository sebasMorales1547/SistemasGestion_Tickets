/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author PC
 */
import model.Vehiculo;
import dao.ticketDao;
import model.ticket;
import model.pasajero;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class ticketService {
    private ticketDao ticketDao = new ticketDao();
    private List<ticket> tickets;
    
    
    private static final List<LocalDate> FESTIVOS = new ArrayList<>(List.of(
        LocalDate.of(LocalDate.now().getYear(), 1, 1),   // Año nuevo
        LocalDate.of(LocalDate.now().getYear(), 5, 1),   // Dia del trabajo
        LocalDate.of(LocalDate.now().getYear(), 7, 20),  // Independencia
        LocalDate.of(LocalDate.now().getYear(), 8, 7),   // Batalla de Boyaca
        LocalDate.of(LocalDate.now().getYear(), 12, 8),  // Inmaculada Concepcion
        LocalDate.of(LocalDate.now().getYear(), 12, 25)  // Navidad
    ));

    public ticketService(List<pasajero> pasajeros) {
        this.tickets = ticketDao.cargarTodos(pasajeros);
    }
    
    private boolean esFestivo(LocalDate fecha) {
        return FESTIVOS.contains(fecha);
    }

    
    private long ticketsHoyPorPasajero(String cedula) {
        return tickets.stream()
                .filter(t -> t.getPasajero().getCedula().equals(cedula)
                        && t.getFechaCompra().equals(LocalDate.now()))
                .count();
    }

    public String venderTicket(pasajero p, Vehiculo v, String origen, String destino) {
        if (!v.hayCupoDisponible()) {
            return "Error: el vehiculo " + v.getPlaca() + " no tiene cupos disponibles.";
        }

        long ticketsHoy = ticketsHoyPorPasajero(p.getCedula());
        if (ticketsHoy >= 3) {
            return "Error: el pasajero ya tiene " + ticketsHoy + " tickets comprados hoy. No puede comprar mas.";
        }

        double tarifa = v.getTarifaBase();
        if (esFestivo(LocalDate.now())) {
            tarifa = tarifa * 1.20;
            System.out.println("Hoy es festivo, se aplica recargo del 20%.");
        }

    
    ticket t = new ticket(p, v.getPlaca(), origen, destino, v.getTarifaBase());
    v.setPasajerosActuales(v.getPasajerosActuales() + 1);
    tickets.add(t);
    ticketDao.guardar(t);
    return "Ticket generado. Total a pagar: $" + (int) t.calcularTotal();
}
    
    public void listarTickets() {
        if (tickets.isEmpty()) {
            System.out.println("No hay tickets registrados.");
            return;
        }
        tickets.forEach(t -> t.imprimirDetalle());
    }

    public double calcularTotalRecaudado() {
        return tickets.stream().mapToDouble(t -> t.calcularTotal()).sum();
    }

    public void mostrarTipoPasajero() {
        Map<String, Long> conteo = tickets.stream()
                .collect(Collectors.groupingBy( t -> t.getPasajero().getTipo(), Collectors.counting()
                ));
        conteo.forEach((tipo, cantidad) ->
                System.out.println(tipo + ": " + cantidad + " ticket(s)"));
    }

    public String vehiculoConMasTickets() {
        return tickets.stream()
                .collect(Collectors.groupingBy( t -> t.getPlacaVehiculo(),Collectors.counting()
                ))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(e -> "Placa: " + e.getKey() + " con " + e.getValue() + " tickets")
                .orElse("Sin datos.");
    }

    public List<ticket> gettickets() { return tickets; }

    public List<ticket> buscarPorFecha(LocalDate fecha) {
        return tickets.stream()
                .filter(t -> t.getFechaCompra().equals(fecha))
                .collect(Collectors.toList());
    }

    public List<ticket> buscarPorTipoVehiculo(String tipo) {
    VehiculoService vehiculoService = new VehiculoService();
    List<String> placas = vehiculoService.buscarPorTipo(tipo).stream()
            .map(Vehiculo::getPlaca)
            .collect(Collectors.toList());

    return tickets.stream()
            .filter(t -> placas.contains(t.getPlacaVehiculo()))
            .collect(Collectors.toList());
}

    public List<ticket> buscarPorTipoPasajero(String tipo) {
        return tickets.stream()
                .filter(t -> t.getPasajero().getTipo().equalsIgnoreCase(tipo))
                .collect(Collectors.toList());
    }

    public void resumenDia() {
        LocalDate hoy = LocalDate.now();
        List<ticket> ticketsHoy = buscarPorFecha(hoy);
        System.out.println("Total tickets vendidos hoy: " + ticketsHoy.size());
        System.out.println("Total recaudado hoy: $" + (int) ticketsHoy.stream()
                .mapToDouble(t -> t.calcularTotal()).sum());
    }
}
