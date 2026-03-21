package alfonsoaraujoparcial;


import java.util.ArrayList;

public class GestionCurso {
    private ArrayList<Curso> listaCursos;

    public GestionCurso() {
        listaCursos = new ArrayList<>();
    }

    public void registrarCurso(Curso c) {
        listaCursos.add(c);
    }

    public Curso consultarCurso(String codigo) {
        for (Curso c : listaCursos) {
            if (c.getCodigo().equals(codigo)) {
                return c;
            }
        }
        return null;
    }

    public boolean modificarCurso(String codigo, Curso nuevo) {
        for (int i = 0; i < listaCursos.size(); i++) {
            if (listaCursos.get(i).getCodigo().equals(codigo)) {
                listaCursos.set(i, nuevo);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarCurso(String codigo) {
        return listaCursos.removeIf(c -> c.getCodigo().equals(codigo));
    }

    public ArrayList<Curso> getListaCursos() {
        return listaCursos;
    }
     //Alfonso David Araujo Patiño
}
