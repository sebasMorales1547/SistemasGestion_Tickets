package misprimerospasos.talentotech;


public class Curso {
    private String codigo;
    private String nombreCurso;
    private int duracionSemanas;
    private String modalidad; 
    private String instructor;
    private int cuposMaximos;
    private boolean activo;
    
    public Curso() {
    }

    public Curso(String codigo, String nombreCurso, int duracionSemanas, String modalidad,
                 String instructor, int cuposMaximos, boolean activo) {
        this.codigo = codigo;
        this.nombreCurso = nombreCurso;
        this.duracionSemanas = duracionSemanas;
        this.modalidad = modalidad;
        this.instructor = instructor;
        this.cuposMaximos = cuposMaximos;
        this.activo = activo;
    }


    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getNombreCurso() { return nombreCurso; }
    public void setNombreCurso(String nombreCurso) { this.nombreCurso = nombreCurso; }

    public int getDuracionSemanas() { return duracionSemanas; }
    public void setDuracionSemanas(int duracionSemanas) { this.duracionSemanas = duracionSemanas; }

    public String getModalidad() { return modalidad; }
    public void setModalidad(String modalidad) { this.modalidad = modalidad; }

    public String getInstructor() { return instructor; }
    public void setInstructor(String instructor) { this.instructor = instructor; }

    public int getCuposMaximos() { return cuposMaximos; }
    public void setCuposMaximos(int cuposMaximos) { this.cuposMaximos = cuposMaximos; }

    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }

    @Override
    public String toString() {
        return "Curso [Codigo: " + codigo +
                ", Nombre: " + nombreCurso +
                ", Duracion: " + duracionSemanas + " semanas" +
                ", Modalidad: " + modalidad +
                ", Instructor: " + instructor +
                ", Cupos: " + cuposMaximos +
                ", Estado: " + (activo ? "Activo" : "Inactivo") + "]";
    }
    //Alfonso David Araujo Patiño
}
