package Model;

import Service.BaggageService;


public class Baggage {
    private String codigo; // único
    private double pesoKg; // > 0
    private BaggageType tipo;
    private Reservation reserva;
    private double cargoAdicional; // calculado

    public Baggage(String codigo, double pesoKg, BaggageType tipo, Reservation reserva, Object par4) {
        if (pesoKg <= 0) throw new IllegalArgumentException("El peso del equipaje debe ser mayor a 0");
        if (tipo == BaggageType.MANO && pesoKg > 10)
            throw new IllegalArgumentException("El equipaje de mano no puede superar los 10kg");
        this.codigo = codigo;
        this.pesoKg = pesoKg;
        this.tipo = tipo;
        this.reserva = reserva;
        this.cargoAdicional = calcularCargo();
    }

    public Baggage(String codigoEquipaje, double pesoKg, BaggageService.BaggageType tipo, Reservation r) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private double calcularCargo() {
        if (tipo == BaggageType.MANO) {
            return 0;
        } else { // bodega
            double base = 15000;
            if (pesoKg <= 23) return base;
            else return base + 30000; // 45,000
        }
    }

    public String getCodigo() { return codigo; }
    public double getPesoKg() { return pesoKg; }
    public BaggageType getTipo() { return tipo; }
    public Reservation getReserva() { return reserva; }
    public double getCargoAdicional() { return cargoAdicional; }

    @Override
    public String toString() {
        return "Baggage{" +
                "codigo='" + codigo + '\'' +
                ", pesoKg=" + pesoKg +
                ", tipo=" + tipo +
                ", reserva=" + reserva.getCodigo() +
                ", cargoAdicional=" + cargoAdicional +
                '}';
    }
}