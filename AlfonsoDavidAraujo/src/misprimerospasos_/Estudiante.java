package misprimerospasos_;


public class Estudiante {
    private String nombre;
    private String apellido;
    private String cedula;
    private String fechaNacimiento; 
    private String grado;

    public Estudiante() {
    }

    public Estudiante(String nombre, String apellido, String cedula, String fechaNacimiento, String grado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.fechaNacimiento = fechaNacimiento;
        this.grado = grado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre + " " + apellido);
        System.out.println("Cedula: " + cedula);
        System.out.println("Fecha de Nacimiento: " + fechaNacimiento);
        System.out.println("Grado: " + grado);
    }
    //Alfonso David Araujo Patiño
}
