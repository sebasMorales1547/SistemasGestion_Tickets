package model;

public abstract class Vehiculo implements imprimible {
    protected String placa;
    protected String ruta;
    protected int capacidadMaxima;
    protected int pasajerosActuales;
    protected boolean disponible;

    public Vehiculo(String placa, String ruta, int capacidadMaxima) {
        this.placa = placa;
        this.ruta = ruta;
        this.capacidadMaxima = capacidadMaxima;
        this.pasajerosActuales = 0;
        this.disponible = true;
    }

    // Getters necesarios para la lógica de negocio y persistencia 
    public String getPlaca() { return placa; }
    public String getRuta() { return ruta; }
    public int getCapacidadMaxima() { return capacidadMaxima; }
    public int getPasajerosActuales() { return pasajerosActuales; }
    public boolean isDisponible() { return disponible; }
    
    public void setPasajerosActuales(int pasajeros) { this.pasajerosActuales = pasajeros; }

    public abstract double getTarifaBase(); // Cada vehículo tiene su tarifa

    // Validación de cupo requerida por el taller 
    public boolean hayCupoDisponible() {
        return pasajerosActuales < capacidadMaxima;
    }

    public void setRuta(Ruta rutaValida) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}