/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author PC
 */

import model.conductor;
import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class conductorDao{
 private static final String ARCHIVO = "conductores.txt";

    public void guardar(conductor c) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO, true))) {
            bw.write(c.toFileLine());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar conductor: " + e.getMessage());
        }
    }
    
    public List<conductor> cargarTodos() {
        List<conductor> lista = new ArrayList<>();
        File archivo = new File(ARCHIVO);
        if (!archivo.exists()) return lista;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length == 4) {
                    lista.add(new conductor(datos[0], datos[1], datos[2], datos[3]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar conductores: " + e.getMessage());
        }
        return lista;
    }
}