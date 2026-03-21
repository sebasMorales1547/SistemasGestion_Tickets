/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import model.Ruta;
import java.util.List;

public class ValidacionRuta {

    public static boolean validarFormatoCodigo(String codigo) {
        return codigo != null && codigo.matches("^R\\d+");
    }

    public static Ruta buscarRutaExistente(String codigo, List<Ruta> rutasSistema) {
        if (!validarFormatoCodigo(codigo)) {
            return null;
        }
        
        for (Ruta r : rutasSistema) {
            if (r.getCodigo().equalsIgnoreCase(codigo)) {
                return r;
            }
        }
        return null;
    }

    static Ruta buscarRutaExistente(String codigoRuta, List<Ruta> rutasMaestras) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}