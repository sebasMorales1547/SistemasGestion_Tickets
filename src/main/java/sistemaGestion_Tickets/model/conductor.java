/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaGestion_Tickets.model;

/**
 *
 * @author PC
 */
public class conductor extends persona {
    
    private String numeroLicencia;
    private String categoriaLicencia;

    public conductor(String numeroLicencia, String categoriaLicencia, String cedula, String nombre) {
        super(cedula, nombre);
        this.numeroLicencia = numeroLicencia;
        this.categoriaLicencia = categoriaLicencia;
    }

    public String getNumeroLicencia() {
        return numeroLicencia;
    }

    public String getCategoriaLicencia() {
        return categoriaLicencia;
    }
    
     public boolean tieneLicencia() {
        return numeroLicencia != null && !numeroLicencia.isBlank();
    }
     
     @Override
     public void imprimirDetalle(){
         System.out.println("---Conductor---");
         System.out.println("Nombre: " + nombre);
         System.out.println("Cedula: " + cedula);
         System.out.println("Licencia: " + numeroLicencia);
         System.out.println("Categoria: " + categoriaLicencia);
     }

  
     public String toFileLine() {
        return cedula + ";" + nombre + ";" + numeroLicencia + ";" + categoriaLicencia;
    }
    
    
}
