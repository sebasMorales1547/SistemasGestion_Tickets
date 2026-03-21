/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author PC
 */

import dao.conductorDao;
import dao.pasajeroDao;
import model.conductor;
import model.pasajero;
import java.util.List;

public class personaService {
    private conductorDao conductorDao = new conductorDao();
    private pasajeroDao  pasajeroDao = new pasajeroDao();
    
    private List<conductor> conductores;
    private List<pasajero> pasajeros;
    
    public personaService(){
        this.conductores = conductorDao.cargarTodos();
        this.pasajeros = pasajeroDao.cargarTodos();
    }
    
    public String registrarConductor(conductor c) {
        if (!c.tieneLicencia()) {
            return "Error: el conductor no tiene licencia registrada.";
        }
        conductores.add(c);
        conductorDao.guardar(c);
        return "Conductor registrado exitosamente.";
    }

    public String registrarPasajero(pasajero p) {
        pasajeros.add(p);
        pasajeroDao.guardar(p);
        return "Pasajero registrado exitosamente.";
    }

    public conductor buscarConductorCedula(String cedula) {
        return conductores.stream()
                .filter(c -> c.getCedula().equals(cedula))
                .findFirst()
                .orElse(null);
    }

    public pasajero buscarPasajeroCedula(String cedula) {
        return pasajeros.stream()
                .filter(p -> p.getCedula().equals(cedula))
                .findFirst()
                .orElse(null);
    }

    public List<conductor> getConductores() { return conductores; }
    public List<pasajero> getPasajeros() { return pasajeros; }
    
    
    
}
