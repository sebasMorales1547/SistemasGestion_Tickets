package misprimerospasos.talentotech;


import java.util.Scanner;

public class PruebaEstudiante {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestionEstudiante gestionEst = new GestionEstudiante();
        GestionCurso gestionCurso = new GestionCurso();
        int opcionPrincipal, opcionSecundaria;

        do {
            System.out.println("\n||---------------------------------------------------------||");
            System.out.println("||      SISTEMA DE INFORMACION - MIS PRIMEROS PASOS        ||");
            System.out.println("||                    Valledupar - Cesar                   ||");
            System.out.println("||---------------------------------------------------------||");
            System.out.println("||  1. GESTION DE ESTUDIANTES                              ||");
            System.out.println("||  2. GESTION DE CURSOS TALENTO TECH                      ||");
            System.out.println("||  0. SALIR                                               ||");
            System.out.println("||---------------------------------------------------------||");
            System.out.print("Elija la Opcion: ");
            opcionPrincipal = sc.nextInt();
            sc.nextLine();

            switch (opcionPrincipal) {
                case 1:
                    System.out.println("\n-- GESTION DE ESTUDIANTES --");
                    System.out.println("1. Agregar estudiante");
                    System.out.println("2. Mostrar todos los estudiantes");
                    System.out.println("3. Consultar estudiante");
                    System.out.println("4. Modificar estudiante");
                    System.out.println("5. Eliminar estudiante");
                    System.out.print("Seleccione una opción: ");
                    opcionSecundaria = sc.nextInt();
                    sc.nextLine();

                    switch (opcionSecundaria) {
                        case 1: 
                            System.out.print("Ingrese nombre: ");
                            String nombre = sc.nextLine();
                            System.out.print("Ingrese apellido: ");
                            String apellido = sc.nextLine();
                            System.out.print("Ingrese cedula: ");
                            String cedula = sc.nextLine();
                            System.out.print("Ingrese grado: ");
                            String grado = sc.nextLine();
                            gestionEst.registrarEstudiante(new Estudiante(nombre, apellido, cedula, grado));
                            System.out.println("Estudiante agregado correctamente!");
                            break;
                        case 2: 
                            for (Estudiante e : gestionEst.getListaEstudiantes()) {
                                System.out.println(e);
                            }
                            break;
                        case 3: 
                            System.out.print("Ingrese cédula: ");
                            String cedBuscar = sc.nextLine();
                            Estudiante e = gestionEst.consultarEstudiante(cedBuscar);
                            System.out.println(e != null ? e : "No encontrado.");
                            break;
                        case 4:
                            System.out.print("Ingrese cédula del estudiante a modificar: ");
                            String cedMod = sc.nextLine();
                            System.out.print("Nuevo nombre: ");
                            String nuevoNom = sc.nextLine();
                            System.out.print("Nuevo apellido: ");
                            String nuevoApe = sc.nextLine();
                            System.out.print("Nuevo grado: ");
                            String nuevoGrado = sc.nextLine();
                            boolean modificado = gestionEst.modificarEstudiante(
                                    cedMod, new Estudiante(nuevoNom, nuevoApe, cedMod, nuevoGrado));
                            System.out.println(modificado ? "Modificado!" : "No encontrado.");
                            break;
                        case 5: 
                            System.out.print("Ingrese cedula: ");
                            String cedElim = sc.nextLine();
                            boolean eliminado = gestionEst.eliminarEstudiante(cedElim);
                            System.out.println(eliminado ? "Eliminado!" : "No encontrado.");
                            break;
                    }
                    break;

                case 2:
                    System.out.println("\n-- GESTION DE CURSOS --");
                    System.out.println("1. Agregar curso");
                    System.out.println("2. Mostrar todos los cursos");
                    System.out.println("3. Consultar curso");
                    System.out.println("4. Modificar curso");
                    System.out.println("5. Activar/Desactivar curso");
                    System.out.print("Seleccione una opción: ");
                    opcionSecundaria = sc.nextInt();
                    sc.nextLine();

                    switch (opcionSecundaria) {
                        case 1: 
                            System.out.print("Código: ");
                            String cod = sc.nextLine();
                            System.out.print("Nombre: ");
                            String nomCurso = sc.nextLine();
                            System.out.print("Duración (semanas): ");
                            int dur = sc.nextInt(); sc.nextLine();
                            System.out.print("Modalidad: ");
                            String mod = sc.nextLine();
                            System.out.print("Instructor: ");
                            String inst = sc.nextLine();
                            System.out.print("Cupos máximos: ");
                            int cupos = sc.nextInt(); sc.nextLine();
                            gestionCurso.registrarCurso(new Curso(cod, nomCurso, dur, mod, inst, cupos, true));
                            System.out.println("Curso agregado!");
                            break;
                        case 2: 
                            for (Curso c : gestionCurso.getListaCursos()) {
                                System.out.println(c);
                            }
                            break;
                        case 3: 
                            System.out.print("Codigo del curso: ");
                            String codBuscar = sc.nextLine();
                            Curso c = gestionCurso.consultarCurso(codBuscar);
                            System.out.println(c != null ? c : "No encontrado.");
                            break;
                        case 4:
                            System.out.print("Codigo del curso a modificar: ");
                            String codMod = sc.nextLine();
                            System.out.print("Nuevo nombre: ");
                            String nuevoNomCurso = sc.nextLine();
                            System.out.print("Nueva duracion (semanas): ");
                            int nuevaDur = sc.nextInt(); sc.nextLine();
                            System.out.print("Nueva modalidad: ");
                            String nuevaMod = sc.nextLine();
                            System.out.print("Nuevo instructor: ");
                            String nuevoInst = sc.nextLine();
                            System.out.print("Nuevos cupos: ");
                            int nuevosCupos = sc.nextInt(); sc.nextLine();
                            boolean modCurso = gestionCurso.modificarCurso(
                                    codMod, new Curso(codMod, nuevoNomCurso, nuevaDur, nuevaMod, nuevoInst, nuevosCupos, true));
                            System.out.println(modCurso ? "Modificado!" : "No encontrado.");
                            break;
                        case 5: 
                            System.out.print("Codigo del curso: ");
                            String codAct = sc.nextLine();
                            Curso curso = gestionCurso.consultarCurso(codAct);
                            if (curso != null) {
                                curso.setActivo(!curso.isActivo());
                                System.out.println("Estado cambiado-Nuevo estado: " + (curso.isActivo() ? "Activo" : "Inactivo"));
                            } else {
                                System.out.println("No encontrado.");
                            }
                            break;
                    }
                    break;

                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
            }
        } while (opcionPrincipal != 0);
    }
     //Alfonso David Araujo Patiño
}
