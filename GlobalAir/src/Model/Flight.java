package Model;


import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Flight {

    public static FlightStatus PROGRAMADO;
    private String codigo; // único
    private String ciudadOrigen;
    private String ciudadDestino;
    private LocalDate fecha; // DD/MM/YYYY - usando LocalDate
    private LocalTime horaSalida;
    private LocalTime horaLlegada;
    private int capacidadTotal; // > 0
    private int asientosDisponibles;
    private double precioBase; // > 0
    private FlightStatus estado;

    public Flight(String codigo, String ciudadOrigen, String ciudadDestino, LocalDate fecha,
                  LocalTime horaSalida, LocalTime horaLlegada, int capacidadTotal, double precioBase) {
        if (capacidadTotal <= 0) throw new IllegalArgumentException("La capacidad total debe ser mayor a 0");
        if (precioBase <= 0) throw new IllegalArgumentException("El precio del vuelo debe ser mayor a cero");
        this.codigo = codigo;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.fecha = fecha;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.capacidadTotal = capacidadTotal;
        this.asientosDisponibles = capacidadTotal;
        this.precioBase = precioBase;
        this.estado = FlightStatus.PROGRAMADO;
    }

    public String getCodigo() { return codigo; }
    public String getCiudadOrigen() { return ciudadOrigen; }
    public String getCiudadDestino() { return ciudadDestino; }
    public LocalDate getFecha() { return fecha; }
    public LocalTime getHoraSalida() { return horaSalida; }
    public LocalTime getHoraLlegada() { return horaLlegada; }
    public int getCapacidadTotal() { return capacidadTotal; }
    public int getAsientosDisponibles() { return asientosDisponibles; }
    public double getPrecioBase() { return precioBase; }
    public FlightStatus getEstado() { return estado; }
    public void setEstado(FlightStatus estado) { this.estado = estado; }

    // control de asientos
    public void reducirAsientos(int cantidad) {
        if (cantidad < 0) throw new IllegalArgumentException("Cantidad negativa no permitida");
        if (cantidad > asientosDisponibles) throw new IllegalArgumentException("No hay asientos disponibles para este vuelo");
        this.asientosDisponibles -= cantidad;
    }
    public void aumentarAsientos(int cantidad) {
        if (cantidad < 0) throw new IllegalArgumentException("Cantidad negativa no permitida");
        this.asientosDisponibles += cantidad;
        if (this.asientosDisponibles > capacidadTotal) this.asientosDisponibles = capacidadTotal;
    }

    // Precio final depende del tipo (nacional/internacional)
    public abstract double calcularPrecioFinal();

    @Override
    public String toString() {
        return "Flight{" +
                "codigo='" + codigo + '\'' +
                ", origen='" + ciudadOrigen + '\'' +
                ", destino='" + ciudadDestino + '\'' +
                ", fecha=" + fecha +
                ", salida=" + horaSalida +
                ", llegada=" + horaLlegada +
                ", capacidad=" + capacidadTotal +
                ", asientosDisponibles=" + asientosDisponibles +
                ", precioBase=" + precioBase +
                ", estado=" + estado +
                '}';
    }
}