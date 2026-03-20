/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaGestion_Tickets.service;

/**
 *
 * @author PC
 */
import sistemaGestion_Tickets.dao.ticketDao;
import sistemaGestion_Tickets.model.ticket;
import sistemaGestion_Tickets.model.pasajero;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ticketService {
    private ticketDao ticketDao = new ticketDao();
    private List<ticket> tickets;

    public ticketService(List<pasajero> pasajeros) {
        this.tickets = ticketDao.cargarTodos(pasajeros);
    }

    // implementar venderTicket cuando Desarrollador 1 termine vehiculo
    
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
