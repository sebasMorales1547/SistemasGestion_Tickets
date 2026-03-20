/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaGestion_Tickets.dao;

/**
 *
 * @author PC
 */

import sistemaGestion_Tickets.model.pasajero;
import sistemaGestion_Tickets.model.pasajeroRegular;
import sistemaGestion_Tickets.model.pasajeroEstudiante;
import sistemaGestion_Tickets.model.pasajeroAdultoMayor;
import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class pasajeroDao {
    private static final String ARCHIVO = "pasajeros:txt";
    
public void guardar(pasajero p) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO, true))) {
            bw.write(p.toFileLine());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar pasajero: " + e.getMessage());
        }
    }

    public List<pasajero> cargarTodos() {
        List<pasajero> lista = new ArrayList<>();
        File archivo = new File(ARCHIVO);
        if (!archivo.exists()) return lista;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length == 3) {
                    String cedula = datos[0];
                    String nombre = datos[1];
                    String tipo   = datos[2];

                    switch (tipo) {
                        case "Estudiante"  -> lista.add(new pasajeroEstudiante(cedula, nombre));
                        case "AdultoMayor" -> lista.add(new pasajeroAdultoMayor(cedula, nombre));
                        default            -> lista.add(new pasajeroRegular(cedula, nombre));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar pasajeros: " + e.getMessage());
        }
        return lista;
    }
}
