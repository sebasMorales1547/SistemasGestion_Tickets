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

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ticketService {
    private ticketDao ticketDao = new ticketDao();
    private List<ticket> tickets;

    public ticketService(List<pasajero> pasajeros) {
        this.tickets = ticketDao.cargarTodos(pasajeros);
    }

    public String venderTicket(pasajero p, Vehiculo v, String origen, String destino) {
    if (!v.hayCupoDisponible()) {
        return "Error: el vehículo " + v.getPlaca() + " no tiene cupos disponibles.";
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
}
