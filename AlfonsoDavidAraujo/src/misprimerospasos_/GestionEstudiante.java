package misprimerospasos_;


import java.util.ArrayList;
import java.util.Scanner;

public class GestionEstudiante {
    private ArrayList<Estudiante> estudiantes;

    public GestionEstudiante() {
        estudiantes = new ArrayList<>();
    }

    public void registrarEstudiante(Estudiante e) {
        estudiantes.add(e);
        System.out.println("Estudiante registrado correctamente.\n");
    }

    public void mostrarEstudiantes() {
        if(estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.\n");
            return;
        }
        for (Estudiante e : estudiantes) {
            e.mostrarInfo();
            System.out.println("------------------------");
        }
    }

    public Estudiante buscarEstudiante(String cedula) {
        for (Estudiante e : estudiantes) {
            if (e.getCedula().equals(cedula)) {
                return e;
            }
        }
        return null;
    }

    public void modificarEstudiante(String cedula, Scanner sc) {
        Estudiante e = buscarEstudiante(cedula);
        if(e != null) {
            System.out.print("Nuevo nombre: ");
            e.setNombre(sc.next());
            System.out.print("Nuevo apellido: ");
            e.setApellido(sc.next());
            System.out.print("Nueva fecha de nacimiento: ");
            e.setFechaNacimiento(sc.next());
            System.out.print("Nuevo grado: ");
            e.setGrado(sc.next());
            System.out.println("Estudiante modificado correctamente.\n");
        } else {
            System.out.println("Estudiante no encontrado.\n");
        }
    }

    public void eliminarEstudiante(String cedula) {
        Estudiante e = buscarEstudiante(cedula);
        if(e != null) {
            estudiantes.remove(e);
            System.out.println("Estudiante eliminado correctamente.\n");
        } else {
            System.out.println("Estudiante no encontrado.\n");
        }
    }
     //Alfonso David Araujo Patiño
}
