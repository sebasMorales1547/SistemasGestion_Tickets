package Model;


public class NationalFlight extends Flight {
    private final double duracionHoras;
    private final boolean incluyeAlimentacion;

    public NationalFlight(String codigo, String ciudadOrigen, String ciudadDestino, java.time.LocalDate fecha,
                          java.time.LocalTime horaSalida, java.time.LocalTime horaLlegada, int capacidadTotal,
                          double precioBase, double duracionHoras, boolean incluyeAlimentacion) {
        super(codigo, ciudadOrigen, ciudadDestino, fecha, horaSalida, horaLlegada, capacidadTotal, precioBase);
        this.duracionHoras = duracionHoras;
        this.incluyeAlimentacion = incluyeAlimentacion;
    }

    @Override
    public double calcularPrecioFinal() {
 
        return getPrecioBase();
    }

    public double getDuracionHoras() { return duracionHoras; }
    public boolean isIncluyeAlimentacion() { return incluyeAlimentacion; }

    @Override
    public String toString() {
        return "NationalFlight{" + super.toString() +
                ", duracionHoras=" + duracionHoras +
                ", incluyeAlimentacion=" + incluyeAlimentacion +
                "}";
    }
}