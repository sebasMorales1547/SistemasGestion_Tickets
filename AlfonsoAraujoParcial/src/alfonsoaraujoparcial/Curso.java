package alfonsoaraujoparcial;


public class Curso {
    private String codigo;
    private String nombreCurso;
    private boolean activo;

    public Curso() {}

    public Curso(String codigo, String nombreCurso) {
        this.codigo = codigo;
        this.nombreCurso = nombreCurso;
        this.activo = true;
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getNombreCurso() { return nombreCurso; }
    public void setNombreCurso(String nombreCurso) { this.nombreCurso = nombreCurso; }

    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }

    @Override
    public String toString() {
        return "Curso [Codigo: " + codigo +
               ", Nombre: " + nombreCurso +
               ", Estado: " + (activo ? "Activo" : "Inactivo") + "]";
    }
     //Alfonso David Araujo Patiño
}
