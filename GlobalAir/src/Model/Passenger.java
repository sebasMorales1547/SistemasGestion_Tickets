package Model;


public class Passenger {
    private String cedula; // única
    private String nombres;
    private String apellidos;
    private int edad; // >= 0
    private String email; // debe contener '@'
    private String telefono;
    private String pasaporte; // único
    private String nacionalidad;

    public Passenger(String cedula, String nombres, String apellidos, int edad,
                     String email, String telefono, String pasaporte, String nacionalidad) {
        if (cedula == null || cedula.isBlank()) throw new IllegalArgumentException("Cédula requerida");
        if (pasaporte == null || pasaporte.isBlank()) throw new IllegalArgumentException("Pasaporte requerido");
        if (email == null || !email.contains("@")) throw new IllegalArgumentException("El email debe contener el símbolo @");
        if (edad < 0) throw new IllegalArgumentException("Edad inválida");
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.email = email;
        this.telefono = telefono;
        this.pasaporte = pasaporte;
        this.nacionalidad = nacionalidad;
    }

    // getters y setters
    public String getCedula() { return cedula; }
    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }
    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    public int getEdad() { return edad; }
    public void setEdad(int edad) {
        if (edad < 0) throw new IllegalArgumentException("Edad inválida");
        this.edad = edad;
    }
    public String getEmail() { return email; }
    public void setEmail(String email) {
        if (email == null || !email.contains("@")) throw new IllegalArgumentException("El email debe contener el símbolo @");
        this.email = email;
    }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getPasaporte() { return pasaporte; }
    public void setPasaporte(String pasaporte) { this.pasaporte = pasaporte; }
    public String getNacionalidad() { return nacionalidad; }
    public void setNacionalidad(String nacionalidad) { this.nacionalidad = nacionalidad; }

    @Override
    public String toString() {
        return "Passenger{" +
                "cedula='" + cedula + '\'' +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", edad=" + edad +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", pasaporte='" + pasaporte + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                '}';
    }
}