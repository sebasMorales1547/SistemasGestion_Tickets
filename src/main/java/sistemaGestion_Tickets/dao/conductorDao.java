/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaGestion_Tickets.dao;

/**
 *
 * @author PC
 */

import sistemaGestion_Tickets.model.Conductor;
import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class conductorDao{
 private static final String ARCHIVO = "conductores.txt";

    public void guardar(Conductor conductor) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO, true))) {
            bw.write(conductor.toFileLine());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar conductor: " + e.getMessage());
        }
    }
    
    public List<Conductor> cargarTodos() {
        List<Conductor> lista = new ArrayList<>();
        File archivo = new File(ARCHIVO);
        if (!archivo.exists()) return lista;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length == 4) {
                    lista.add(new Conductor(datos[0], datos[1], datos[2], datos[3]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar conductores: " + e.getMessage());
        }
        return lista;
    }
}