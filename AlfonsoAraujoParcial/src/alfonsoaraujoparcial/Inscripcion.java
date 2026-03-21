package alfonsoaraujoparcial;


public class Inscripcion {
    private String codigoInscripcion;
    private String cedulaEstudiante;
    private String codigoCurso; 
    private boolean activo;

    public Inscripcion() {}

    public Inscripcion(String codigoInscripcion, String cedulaEstudiante, String codigoCurso, boolean activo) {
        this.codigoInscripcion = codigoInscripcion;
        this.cedulaEstudiante = cedulaEstudiante;
        this.codigoCurso = codigoCurso;
        this.activo = activo;
    }

    public String getCodigoInscripcion() { return codigoInscripcion; }
    public void setCodigoInscripcion(String codigoInscripcion) { this.codigoInscripcion = codigoInscripcion; }

    public String getCedulaEstudiante() { return cedulaEstudiante; }
    public void setCedulaEstudiante(String cedulaEstudiante) { this.cedulaEstudiante = cedulaEstudiante; }

    public String getCodigoCurso() { return codigoCurso; }
    public void setCodigoCurso(String codigoCurso) { this.codigoCurso = codigoCurso; }

    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }

    @Override
    public String toString() {
        return "Inscripcion [Codigo: " + codigoInscripcion +
               ", Cedula estudiante: " + cedulaEstudiante +
               ", Curso: " + codigoCurso +
               ", Estado: " + (activo ? "Activo" : "Inactivo") + "]";
    }
}
