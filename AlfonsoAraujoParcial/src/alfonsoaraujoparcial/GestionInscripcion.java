package alfonsoaraujoparcial;


import java.util.ArrayList;

public class GestionInscripcion {
    private ArrayList<Inscripcion> listaInscripcion;

    public GestionInscripcion() {
        listaInscripcion = new ArrayList<>();
    }

    public void registrarInscripcion(Inscripcion c) {
        listaInscripcion.add(c);
    }

    public Inscripcion consultarInscripcion(String codigoInscripcion) {
        for (Inscripcion c : listaInscripcion) {
            if (c.getCodigoInscripcion().equals(codigoInscripcion)) {
                return c;
            }
        }
        return null;
    }

    public ArrayList<Inscripcion> buscarPorEstudiante(String cedula) {
        ArrayList<Inscripcion> result = new ArrayList<>();
        for (Inscripcion c : listaInscripcion) {
            if (c.getCedulaEstudiante().equals(cedula)) {
                result.add(c);
            }
        }
        return result;
    }

    public ArrayList<Inscripcion> buscarPorCurso(String codigoCurso) {
        ArrayList<Inscripcion> result = new ArrayList<>();
        for (Inscripcion c : listaInscripcion) {
            if (c.getCodigoCurso().equals(codigoCurso)) {
                result.add(c);
            }
        }
        return result;
    }

    public ArrayList<Inscripcion> getListaInscripcion() {
        return listaInscripcion;
    }
     //Alfonso David Araujo Patiño
}
