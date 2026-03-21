package Model;


import java.time.LocalDate;

public class Reservation {
    private String codigo; // único
    private Passenger pasajero;
    private Flight vuelo;
    private int cantidadAsientos; // 1..5
    private LocalDate fechaReserva;
    private double precioTotal;
    private ReservationStatus estado;

    public Reservation(String codigo, Passenger pasajero, Flight vuelo, int cantidadAsientos, LocalDate fechaReserva) {
        if (cantidadAsientos < 1 || cantidadAsientos > 5) throw new IllegalArgumentException("No se pueden reservar más de 5 asientos por reserva");
        this.codigo = codigo;
        this.pasajero = pasajero;
        this.vuelo = vuelo;
        this.cantidadAsientos = cantidadAsientos;
        this.fechaReserva = fechaReserva;
        this.precioTotal = vuelo.calcularPrecioFinal() * cantidadAsientos;
        this.estado = ReservationStatus.CONFIRMADA;
    }

    public String getCodigo() { return codigo; }
    public Passenger getPasajero() { return pasajero; }
    public Flight getVuelo() { return vuelo; }
    public int getCantidadAsientos() { return cantidadAsientos; }
    public LocalDate getFechaReserva() { return fechaReserva; }
    public double getPrecioTotal() { return precioTotal; }
    public ReservationStatus getEstado() { return estado; }

    public void cancelar() {
        if (this.estado == ReservationStatus.CANCELADA) return;
        this.estado = ReservationStatus.CANCELADA;
        // la devolución de asientos la maneja el servicio de reservas
    }

    public void completar() {
        this.estado = ReservationStatus.COMPLETADA;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "codigo='" + codigo + '\'' +
                ", pasajero=" + pasajero.getCedula() +
                ", vuelo=" + vuelo.getCodigo() +
                ", cantidadAsientos=" + cantidadAsientos +
                ", fechaReserva=" + fechaReserva +
                ", precioTotal=" + precioTotal +
                ", estado=" + estado +
                '}';
    }
}