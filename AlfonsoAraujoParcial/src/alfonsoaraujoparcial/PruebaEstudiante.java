package alfonsoaraujoparcial;


import java.util.Scanner;

public class PruebaEstudiante {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            GestionEstudiante gestionEst = new GestionEstudiante();
            GestionCurso gestionCurso = new GestionCurso();
            GestionInscripcion gestionInscripcion = new GestionInscripcion();
            
            int opcionPrincipal;
            
            do {
                System.out.println("\n||---------------------------------------------------------||");
                System.out.println("||      SISTEMA DE INFORMACION - MIS PRIMEROS PASOS        ||");
                System.out.println("||                    Valledupar - Cesar                   ||");
                System.out.println("||---------------------------------------------------------||");
                System.out.println("||  1. GESTION DE ESTUDIANTES                              ||");
                System.out.println("||  2. GESTION DE CURSOS TALENTO TECH                      ||");
                System.out.println("||  3. GESTION DE INSCRIPCIONES                            ||");
                System.out.println("||  0. SALIR                                               ||");
                System.out.println("||---------------------------------------------------------||");
                System.out.print("Elija la Opcion: ");
                opcionPrincipal = sc.nextInt();
                sc.nextLine();
                
                switch (opcionPrincipal) {
                    case 1:
                        int opEst;
                        do {
                            System.out.println("\n--- GESTION DE ESTUDIANTES ---");
                            System.out.println("1. Registrar Estudiante");
                            System.out.println("2. Consultar Estudiante");
                            System.out.println("3. Modificar Estudiante");
                            System.out.println("4. Eliminar Estudiante");
                            System.out.println("5. Listar Estudiantes");
                            System.out.println("0. Volver");
                            System.out.print("Opcion: ");
                            opEst = sc.nextInt();
                            sc.nextLine();
                            
                            switch (opEst) {
                                case 1:
                                    System.out.print("Nombre: ");
                                    String nombre = sc.nextLine();
                                    System.out.print("Apellido: ");
                                    String apellido = sc.nextLine();
                                    System.out.print("Cedula: ");
                                    String cedula = sc.nextLine();
                                    System.out.print("Grado: ");
                                    String grado = sc.nextLine();
                                    gestionEst.registrarEstudiante(new Estudiante(nombre, apellido, cedula, grado));
                                    System.out.println("Estudiante registrado.");
                                    break;
                                case 2:
                                    System.out.print("Cedula del estudiante: ");
                                    String cedulaConsulta = sc.nextLine();
                                    Estudiante e = gestionEst.consultarEstudiante(cedulaConsulta);
                                    System.out.println(e != null ? e : "No encontrado.");
                                    break;
                                case 3:
                                    System.out.print("Cedula actual: ");
                                    String cedulaMod = sc.nextLine();
                                    System.out.print("Nuevo nombre: ");
                                    String nNombre = sc.nextLine();
                                    System.out.print("Nuevo apellido: ");
                                    String nApellido = sc.nextLine();
                                    System.out.print("Nueva cedula: ");
                                    String nCedula = sc.nextLine();
                                    System.out.print("Nuevo grado: ");
                                    String nGrado = sc.nextLine();
                                    boolean modOk = gestionEst.modificarEstudiante(cedulaMod, new Estudiante(nNombre, nApellido, nCedula, nGrado));
                                    System.out.println(modOk ? "Estudiante modificado." : "No encontrado.");
                                    break;
                                case 4:
                                    System.out.print("Cedula a eliminar: ");
                                    String cedulaElim = sc.nextLine();
                                    boolean elimOk = gestionEst.eliminarEstudiante(cedulaElim);
                                    System.out.println(elimOk ? "Eliminado." : "No encontrado.");
                                    break;
                                case 5:
                                    System.out.println("Lista de Estudiantes:");
                                    for (Estudiante est : gestionEst.getListaEstudiantes()) {
                                        System.out.println(est);
                                    }
                                    break;
                            }
                        } while (opEst != 0);
                        break;
                        
                    case 2:
                        int opCurso;
                        do {
                            System.out.println("\n--- GESTION DE CURSOS ---");
                            System.out.println("1. Registrar Curso");
                            System.out.println("2. Consultar Curso");
                            System.out.println("3. Modificar Curso");
                            System.out.println("4. Eliminar Curso");
                            System.out.println("5. Listar Cursos");
                            System.out.println("0. Volver");
                            System.out.print("Opcion: ");
                            opCurso = sc.nextInt();
                            sc.nextLine();
                            
                            switch (opCurso) {
                                case 1 -> {
                                    System.out.print("Codigo: ");
                                    String codigo = sc.nextLine();
                                    System.out.print("Nombre del curso: ");
                                    String nombreCurso = sc.nextLine();
                                    gestionCurso.registrarCurso(new Curso(codigo, nombreCurso));
                                    System.out.println("Curso registrado.");
                        }
                                case 2 -> {
                                    System.out.print("Codigo del curso: ");
                                    String codConsulta = sc.nextLine();
                                    Curso c = gestionCurso.consultarCurso(codConsulta);
                                    System.out.println(c != null ? c : "No encontrado.");
                        }
                                case 3 -> {
                                    System.out.print("Codigo actual: ");
                                    String codMod = sc.nextLine();
                                    System.out.print("Nuevo codigo: ");
                                    String nCod = sc.nextLine();
                                    System.out.print("Nuevo nombre: ");
                                    String nNomCurso = sc.nextLine();
                                    boolean modOkC = gestionCurso.modificarCurso(codMod, new Curso(nCod, nNomCurso));
                                    System.out.println(modOkC ? "Curso modificado." : "No encontrado.");
                        }
                                case 4 -> {
                                    System.out.print("Codigo a eliminar: ");
                                    String codElim = sc.nextLine();
                                    boolean elimOkC = gestionCurso.eliminarCurso(codElim);
                                    System.out.println(elimOkC ? "Eliminado." : "No encontrado.");
                        }
                                case 5 -> {
                                    System.out.println("Lista de Cursos:");
                                    for (Curso cur : gestionCurso.getListaCursos()) {
                                        System.out.println(cur);
                                    }
                        }
                            }
                        } while (opCurso != 0);
                        break;
                        
                    case 3:
                        int opIns;
                        do {
                            System.out.println("\n--- GESTION DE INSCRIPCIONES ---");
                            System.out.println("1. Registrar nueva inscripcion");
                            System.out.println("2. Consultar Inscripcion");
                            System.out.println("3. Buscar por inscripcion por estudiante");
                            System.out.println("4. Buscar por inscripcion por curso");
                            System.out.println("5. Casmbiar estado de inscripcion");
                            System.out.println("6. Listar Inscripciones");
                            System.out.println("0. Volver");
                            System.out.print("Opcion: ");
                            opIns = sc.nextInt();
                            sc.nextLine();
                            
                            switch (opIns) {
                                case 1:
                                    System.out.print("Codigo inscripcion: ");
                                    String codIns = sc.nextLine();
                                    System.out.print("Cedula estudiante: ");
                                    String cedEst = sc.nextLine();
                                    System.out.print("Codigo curso: ");
                                    String codCur = sc.nextLine();
                                    gestionInscripcion.registrarInscripcion(new Inscripcion(codIns, cedEst, codCur, true));
                                    System.out.println("Inscripcion registrada.");
                                    break;
                                case 2:
                                    System.out.print("Codigo inscripcion: ");
                                    String codConsultI = sc.nextLine();
                                    Inscripcion ins = gestionInscripcion.consultarInscripcion(codConsultI);
                                    System.out.println(ins != null ? ins : "No encontrada.");
                                    break;
                                case 3:
                                    System.out.print("Cedula estudiante: ");
                                    String cedEstBus = sc.nextLine();
                                    System.out.println("Inscripciones:");
                                    for (Inscripcion i : gestionInscripcion.buscarPorEstudiante(cedEstBus)) {
                                        System.out.println(i);
                                    }
                                    break;
                                case 4:
                                    System.out.print("Codigo curso: ");
                                    String codCursoBus = sc.nextLine();
                                    System.out.println("Inscripciones:");
                                    for (Inscripcion i : gestionInscripcion.buscarPorCurso(codCursoBus)) {
                                        System.out.println(i);
                                    }
                                    break;
                                case 5:
                                    System.out.print("Inscripcion a inactivar: ");
                                    String cedulaElim = sc.nextLine();
                                    boolean elimOk = gestionEst.eliminarEstudiante(cedulaElim);
                                    System.out.println(elimOk ? "Inactivo." : "No encontrado.");
                                    
                                case 6:
                                    System.out.println("Todas las inscripciones:");
                                    for (Inscripcion i : gestionInscripcion.getListaInscripcion()) {
                                        System.out.println(i);
                                    }
                                    break;
                                    
                            }
                        } while (opIns != 0);
                        break;
                        
                    case 0:
                        System.out.println("Saliendo del sistema...");
                        break;
                        
                    default:
                        System.out.println("Opcion invalida.");
                }
            } while (opcionPrincipal != 0);
        }
    }
    //Alfonso David Araujo Patiño
}
