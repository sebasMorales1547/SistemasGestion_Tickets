package misprimerospasos_;


import java.util.Scanner;

public class PruebaEstudiante {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestionEstudiante gestion = new GestionEstudiante();
        int opcion;

        do {
            System.out.println("||-----------------------------------------------------------||");
            System.out.println("||            SISTEMA DE GESTION DE ESTUDIANTES              ||");
            System.out.println("||               Mis Primeros Pasos - Valledupar             ||");
            System.out.println("||-----------------------------------------------------------||");
            System.out.println("||  1. Agregar estudiante                                    ||");
            System.out.println("||  2. Mostrar todos los estudiantes                         ||");
            System.out.println("||  3. Buscar estudiante por cedula                          ||");
            System.out.println("||  4. Modificar estudiante                                  ||");
            System.out.println("||  5. Eliminar estudiante                                   ||");
            System.out.println("||  0. Salir                                                 ||");
            System.out.println("||-----------------------------------------------------------||");
            System.out.print("Elija la opcion: ");
            opcion = sc.nextInt();

            switch(opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.next();
                    System.out.print("Apellido: ");
                    String apellido = sc.next();
                    System.out.print("Cedula: ");
                    String cedula = sc.next();
                    System.out.print("Fecha de nacimiento: ");
                    String fechaNacimiento = sc.next();
                    System.out.print("Grado: ");
                    String grado = sc.next();
                    Estudiante e = new Estudiante(nombre, apellido, cedula, fechaNacimiento, grado);
                    gestion.registrarEstudiante(e);
                    break;

                case 2:
                    gestion.mostrarEstudiantes();
                    break;

                case 3:
                    System.out.print("Ingrese la cedula: ");
                    Estudiante buscado = gestion.buscarEstudiante(sc.next());
                    if(buscado != null) {
                        buscado.mostrarInfo();
                    } else {
                        System.out.println("Estudiante no encontrado.\n");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese la cedula del estudiante a modificar: ");
                    gestion.modificarEstudiante(sc.next(), sc);
                    break;

                case 5:
                    System.out.print("Ingrese la cedula del estudiante a eliminar: ");
                    gestion.eliminarEstudiante(sc.next());
                    break;

                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción invalida. Intente nuevamente.\n");
            }
        } while(opcion != 0);

        sc.close();
    }
     //Alfonso David Araujo Patiño
}
