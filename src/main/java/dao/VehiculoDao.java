package dao;

import model.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VehiculoDao {
    private final String[] ARCHIVOS = {"buseta.txt", "microbus.txt", "bus.txt"};

    public void guardarVehiculo(Vehiculo v) {
        String archivo = v instanceof Buseta ? "buseta.txt" 
                       : v instanceof MicroBus ? "microbus.txt" 
                       : "bus.txt";
        try (PrintWriter out = new PrintWriter(new FileWriter(archivo, true))) {
            // Guardamos placa, ruta y pasajerosActuales
            out.println(v.getPlaca() + ";" + v.getRuta() + ";" + v.getPasajerosActuales());
        } catch (IOException e) {
            System.err.println("Error al guardar vehículo: " + e.getMessage());
        }
    }

    public List<Vehiculo> cargarVehiculos() {
        List<Vehiculo> lista = new ArrayList<>();

        for (String nombreArchivo : ARCHIVOS) {
            File archivo = new File(nombreArchivo);
            if (!archivo.exists()) continue;

            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    String[] partes = linea.split(";");
                    if (partes.length < 3) continue;

                    String placa     = partes[0];
                    String ruta      = partes[1];
                    int pasajeros    = Integer.parseInt(partes[2]);

                    Vehiculo v = switch (nombreArchivo) {
                        case "buseta.txt"   -> new Buseta(placa, ruta);
                        case "microbus.txt" -> new MicroBus(placa, ruta);
                        default             -> new Bus(placa, ruta);
                    };
                    v.setPasajerosActuales(pasajeros);
                    lista.add(v);
                }
            } catch (IOException | NumberFormatException e) {
                System.err.println("Error al cargar " + nombreArchivo + ": " + e.getMessage());
            }
        }
        return lista;
    }
}
