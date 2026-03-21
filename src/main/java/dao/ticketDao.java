/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author PC
 */

import model.ticket;
import model.pasajero;
import java.time.LocalDate;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ticketDao {
    private static final String ARCHIVO = "tickets.txt";

    public void guardar(ticket t) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO, true))) {
            bw.write(t.toFileLine());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar ticket: " + e.getMessage());
        }
    }

    public List<ticket> cargarTodos(List<pasajero> pasajeros) {
        List<ticket> lista = new ArrayList<>();
        File archivo = new File(ARCHIVO);
        if (!archivo.exists()) return lista;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length == 7) {
                    String cedula   = datos[0];
                    String placa    = datos[1];
                    double tarifa   = Double.parseDouble(datos[2]);
                    String origen   = datos[3];
                    String destino  = datos[4];
                    LocalDate fecha = LocalDate.parse(datos[5]);

                    pasajero p = pasajeros.stream()
                            .filter(x -> x.getCedula().equals(cedula))
                            .findFirst()
                            .orElse(null);

                    if (p != null) {
                        lista.add(new ticket(p, placa, fecha, origen, destino, tarifa));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar tickets: " + e.getMessage());
        }
        return lista;
    }
}
    

