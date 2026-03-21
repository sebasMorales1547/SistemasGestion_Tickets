package Service;


import Model.Baggage;
import Model.Reservation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BaggageService {

    public static Object BaggageType;
    public static BaggageType BODEGA;

    public static BaggageType valueOf(String toUpperCase) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private final List<Baggage> equipajes = new ArrayList<>();

    private final ReservationService reservationService;

    public BaggageService(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    public void registrarEquipaje(String codigoEquipaje, double pesoKg, BaggageType tipo, String codigoReserva) {
        Reservation r = reservationService.buscarPorCodigo(codigoReserva);
        if (r == null) throw new IllegalArgumentException("El equipaje debe estar asociado a una reserva existente");
        Baggage b = new Baggage(codigoEquipaje, pesoKg, tipo, r);
        equipajes.add(b);
    }

    public List<Baggage> listarPorReserva(String codigoReserva) {
        return equipajes.stream()
                .filter(e -> e.getReserva().getCodigo().equals(codigoReserva))
                .collect(Collectors.toList());
    }

    public double ingresosTotalesEquipaje() {
        return equipajes.stream().mapToDouble(Baggage::getCargoAdicional).sum();
    }

    public static class BaggageType {

        public BaggageType() {
        }
    }
}