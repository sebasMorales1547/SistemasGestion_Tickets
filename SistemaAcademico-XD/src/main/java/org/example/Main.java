package SistemaAcademico;

import java.util.ArrayList;

public class GestionNota {

    private ArrayList<Nota> listaNotas;

    public GestionNota() {
        listaNotas = new ArrayList<>();
    }

    // registrar
    public void registrarNota(Nota nota) {
        listaNotas.add(nota);
    }

    // consultar
    public Nota consultarNota(String codigoEstudiante, String codigoAsignatura, String periodo) {
        for (Nota n : listaNotas) {
            if (n.getEstudiante().getCodigo().equals(codigoEstudiante) &&
                n.getAsignatura().getCodigo().equals(codigoAsignatura) &&
                n.getPeriodo().equalsIgnoreCase(periodo)) {
                return n;
            }
        }
        return null;
    }

    // modificar
    public boolean modificarNota(String codigoEstudiante, String codigoAsignatura, String periodo, double nuevoValor) {
        Nota nota = consultarNota(codigoEstudiante, codigoAsignatura, periodo);
        if (nota != null) {
            nota.setValor(nuevoValor);
            return true;
        }
        return false;
    }

    // eliminar
    public boolean eliminarNota(String codigoEstudiante, String codigoAsignatura, String periodo) {
        return listaNotas.removeIf(n ->
                n.getEstudiante().getCodigo().equals(codigoEstudiante) &&
                n.getAsignatura().getCodigo().equals(codigoAsignatura) &&
                n.getPeriodo().equalsIgnoreCase(periodo)
        );
    }

    public ArrayList<Nota> getListaNotas() {
        return listaNotas;
    }
}

