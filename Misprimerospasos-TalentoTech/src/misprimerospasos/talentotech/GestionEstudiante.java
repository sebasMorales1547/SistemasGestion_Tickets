package misprimerospasos.talentotech;


import java.util.ArrayList;

public class GestionEstudiante {
    private ArrayList<Estudiante> listaEstudiantes;

    public GestionEstudiante() {
        listaEstudiantes = new ArrayList<>();
    }

    public void registrarEstudiante(Estudiante e) {
        listaEstudiantes.add(e);
    }

    public Estudiante consultarEstudiante(String cedula) {
        for (Estudiante e : listaEstudiantes) {
            if (e.getCedula().equals(cedula)) {
                return e;
            }
        }
        return null;
    }

    public boolean modificarEstudiante(String cedula, Estudiante nuevo) {
        for (int i = 0; i < listaEstudiantes.size(); i++) {
            if (listaEstudiantes.get(i).getCedula().equals(cedula)) {
                listaEstudiantes.set(i, nuevo);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarEstudiante(String cedula) {
        return listaEstudiantes.removeIf(e -> e.getCedula().equals(cedula));
    }

    public ArrayList<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }
     //Alfonso David Araujo Patiño
}
