/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
/**
 *
 * @author PC
 */
import dao.reservaDao;
import dao.ticketDao;
import model.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class reservaService {
    private reservaDao reservaDao = new reservaDao();
    private ticketDao ticketDao = new ticketDao();
    private List<reserva> reservas;

    public reservaService(List<pasajero> pasajeros) {
        this.reservas = reservaDao.cargarTodos(pasajeros);
        reservasVencidas();
    }

   
    private String generarCodigo() {
        return "RES-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    public String crearReserva(pasajero p, Vehiculo v, LocalDate fechaViaje,
             List<ticket> ticketsVendidos) {
        long reservasActivas = contarReservasActivas(v.getPlaca());
        long ticketsVendidosVehiculo = ticketsVendidos.stream()
                .filter(t -> t.getPlacaVehiculo().equals(v.getPlaca()))
                .count();

        if (reservasActivas + ticketsVendidosVehiculo >= v.getCapacidadMaxima()) {
            return "Error: el vehiculo no tiene cupos disponibles.";
        }
     
        boolean yaTieneReserva = reservas.stream().anyMatch(r -> r.getPasajero().getCedula().equals(p.getCedula())
                        && r.getPlacaVehiculo().equals(v.getPlaca())
                        && r.getFechaViaje().equals(fechaViaje)
                        && r.getEstado() == reserva.Estado.ACTIVA);

        if (yaTieneReserva) {
            return "Error: el pasajero ya tiene una reserva activa para ese vehiculo y fecha.";
        }

        reserva r = new reserva(generarCodigo(), p, v.getPlaca(), fechaViaje);
        reservas.add(r);
        reservaDao.guardar(r);
        return "Reserva creada exitosamente. Codigo: " + r.getCodigo();
    }

    public String cancelarReserva(String codigo) {
        reserva r = buscarPorCodigo(codigo);
        if (r == null) {
            return "Error: reserva no encontrada.";
        }
        if (r.getEstado() != reserva.Estado.ACTIVA) {
            return "Error: la reserva no esta activa.";
        }
        r.cancelar();
        reservaDao.actualizarArchivo(reservas);
        return "Reserva cancelada exitosamente.";
    }

    public String convertirEnTicket(String codigo, Vehiculo v,
                                     List<ticket> ticketsVendidos) {
        reserva r = buscarPorCodigo(codigo);
        if (r == null) {
            return "Error: reserva no encontrada.";
        }
        if (r.getEstado() != reserva.Estado.ACTIVA) {
            return "Error: la reserva no esta activa.";
        }

        
        double tarifa = v.getTarifaBase();
        if (esFestivo(LocalDate.now())) {
            tarifa = tarifa * 1.20;
            System.out.println("Hoy es festivo, se aplica recargo del 20%.");
        }

        ticket t = new ticket(r.getPasajero(), v.getPlaca(),
                r.getFechaViaje().toString(), r.getFechaViaje().toString(), tarifa);
        ticketsVendidos.add(t);
        ticketDao.guardar(t);

        r.convertir();
        reservaDao.actualizarArchivo(reservas);
        return "Reserva convertida en ticket. Total a pagar: $" + (int) t.calcularTotal();
    }

    public int reservasVencidas() {
        int canceladas = 0;
        for (reserva r : reservas) {
            if (r.estaVencida()) {
                r.cancelar();
                canceladas++;
            }
        }
        if (canceladas > 0) {
            reservaDao.actualizarArchivo(reservas);
        }
        return canceladas;
    }

    public void listarReservasActivas() {
        List<reserva> activas = reservas.stream()
                .filter(r -> r.getEstado() == reserva.Estado.ACTIVA)
                .collect(Collectors.toList());

        if (activas.isEmpty()) {
            System.out.println("No hay reservas activas.");
            return;
        }
        activas.forEach(r -> r.imprimirDetalle());
    }

    public void listarHistorialPasajero(String cedula) {
        List<reserva> historial = reservas.stream()
                .filter(r -> r.getPasajero().getCedula().equals(cedula))
                .collect(Collectors.toList());

        if (historial.isEmpty()) {
            System.out.println("No hay reservas para ese pasajero.");
            return;
        }
        historial.forEach(r -> r.imprimirDetalle());
    }

    private long contarReservasActivas(String placa) {
        return reservas.stream()
                .filter(r -> r.getPlacaVehiculo().equals(placa)
                        && r.getEstado() == reserva.Estado.ACTIVA)
                .count();
    }

    private reserva buscarPorCodigo(String codigo) {
        return reservas.stream()
                .filter(r -> r.getCodigo().equals(codigo))
                .findFirst()
                .orElse(null);
    }

    private boolean esFestivo(LocalDate fecha) {
        List<LocalDate> festivos = List.of(
                LocalDate.of(fecha.getYear(), 1, 1),
                LocalDate.of(fecha.getYear(), 5, 1),
                LocalDate.of(fecha.getYear(), 7, 20),
                LocalDate.of(fecha.getYear(), 8, 7),
                LocalDate.of(fecha.getYear(), 12, 8),
                LocalDate.of(fecha.getYear(), 12, 25)
        );
        return festivos.contains(fecha);
    }
    public List<reserva> getReservas() { return reservas; }
}