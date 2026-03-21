package misprimerospasos.talentotech;


public class Estudiante {
    private String nombre;
    private String apellido;
    private String cedula;
    private String grado;


    public Estudiante() {
    }


    public Estudiante(String nombre, String apellido, String cedula, String grado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.grado = grado;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }

    public String getGrado() { return grado; }
    public void setGrado(String grado) { this.grado = grado; }

    // Mostrar información
    @Override
    public String toString() {
        return "Estudiante [Nombre: " + nombre + " " + apellido +
               ", Cedula: " + cedula +
               ", Grado: " + grado + "]";
    }
     //Alfonso David Araujo Patiño
}
