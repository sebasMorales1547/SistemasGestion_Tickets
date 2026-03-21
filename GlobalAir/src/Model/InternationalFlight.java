package Model;


public class InternationalFlight extends Flight {
    private final String paisDestino;
    private final boolean requiereVisa;
    private final double cargoInternacional; // valor adicional

    public InternationalFlight(String codigo, String ciudadOrigen, String ciudadDestino, java.time.LocalDate fecha,
                               java.time.LocalTime horaSalida, java.time.LocalTime horaLlegada, int capacidadTotal,
                               double precioBase, String paisDestino, boolean requiereVisa, double cargoInternacional) {
        super(codigo, ciudadOrigen, ciudadDestino, fecha, horaSalida, horaLlegada, capacidadTotal, precioBase);
        this.paisDestino = paisDestino;
        this.requiereVisa = requiereVisa;
        this.cargoInternacional = cargoInternacional;
    }

    @Override
    public double calcularPrecioFinal() {
        return getPrecioBase() + cargoInternacional;
    }

    public String getPaisDestino() { return paisDestino; }
    public boolean isRequiereVisa() { return requiereVisa; }
    public double getCargoInternacional() { return cargoInternacional; }

    @Override
    public String toString() {
        return "InternationalFlight{" + super.toString() +
                ", paisDestino='" + paisDestino + '\'' +
                ", requiereVisa=" + requiereVisa +
                ", cargoInternacional=" + cargoInternacional +
                "}";
    }
}
