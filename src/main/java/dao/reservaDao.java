/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author PC
 */
import model.reserva;
import model.pasajero;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.*;

public class reservaDao {
    
    private static final String ARCHIVO = "reservas.txt";

    public void guardar(reserva r) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO, true))) {
            bw.write(r.toFileLine());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar reserva: " + e.getMessage());
        }
    }

   
    public void actualizarArchivo(List<reserva> reservas) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO, false))) {
            for (reserva r : reservas) {
                bw.write(r.toFileLine());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al actualizar reservas: " + e.getMessage());
        }
    }

    public List<reserva> cargarTodos(List<pasajero> pasajeros) {
        List<reserva> lista = new ArrayList<>();
        File archivo = new File(ARCHIVO);
        if (!archivo.exists()) return lista;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                
                String[] datos = linea.split(";");
                if (datos.length == 6) {
                    String codigo = datos[0];
                    String cedula = datos[1];
                    String placa = datos[2];
                    LocalDateTime fechaCreacion = LocalDateTime.parse(datos[3]);
                    LocalDate fechaViaje = LocalDate.parse(datos[4]);
                    reserva.Estado estado = reserva.Estado.valueOf(datos[5]);

                    pasajero p = pasajeros.stream()
                            .filter(x -> x.getCedula().equals(cedula))
                            .findFirst()
                            .orElse(null);

                    if (p != null) {
                        lista.add(new reserva(codigo, p, placa, fechaCreacion, fechaViaje, estado));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar reservas: " + e.getMessage());
        }
        return lista;
    }
}
    
