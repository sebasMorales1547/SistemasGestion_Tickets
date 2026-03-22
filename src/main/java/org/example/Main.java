package org.example;
import model.*;
import dao.*;
import service.personaService;
import service.ticketService;
import service.*;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) throws InterruptedException {

        Main obj = new Main();
        obj.menu();

    }

    public void menu() throws InterruptedException {

        char OP = 'S';
        int opcion = 0;

        Scanner Scanner = new Scanner(System.in);

        while (OP == 'S') {

            System.out.println("""
                    
                    --------- MENU ---------
                    1. Registrar vehiculo
                    2. Registrar conductor
                    3. Registrar pasajero 
                    4. Vender tickets
                    5. Ver tickets
                    6. Estadisticas
                    7. Ver reportes
                    8. Ver reservas
                    
                    0. Salir
                    """);

            System.out.print("Selecciona una opccion: ");
            try {
                opcion = Scanner.nextInt();

                switch (opcion) {
                    case 0:
                        OP = 'N';
                        System.out.println("Hemos terminado...");
                        break;
                    case 1:
                        menuVehiculos();
                        break;
                    case 2:
                        menuConductor();
                        break;
                    case 3:
                        menuPasajero();
                        break;
                    case 4:
                        menuVenderTicket();
                        break;
                    case 5:
                        menuVerTickets();
                        break;
                    case 6:
                        menuEstadisticas();
                        break;
                    case 7:
                        menuReportes();
                        break;
                    case 8:
                        menuReserva();
                        break;
                    default:
                        System.err.println("Opcion invalida");
                        Thread.sleep(2000);
                        System.out.println("Regresando al menu...");

                }

            } catch (InputMismatchException e) {
                System.err.println("Debe ingresar letras no numeros");
                Scanner.nextLine();
                Thread.sleep(2000);
                System.out.println("Regresando al menu...");
            }

        }
    }


    public void menuVehiculos() throws InterruptedException {

        char OP = 'S';
        int opcion = 0;

        Scanner Scanner = new Scanner(System.in);
        VehiculoDao VehiculoDao = new VehiculoDao();

        while (OP == 'S') {

            System.out.println("""
                    
                    --------- MENU ---------
                    1. Registrar bus
                    2. Registrar buseta
                    3. Registrar microbus
                    
                    0. Salir
                    """);

            System.out.print("Selecciona una opccion: ");
            try {

                opcion = Scanner.nextInt();

                switch (opcion) {
                    case 0:
                        OP = 'N';
                        System.out.println("Hemos terminado...");
                        break;
                    case 1:

                        char continuar = 'S';
                        do {

                            String placa, ruta;
                            System.out.println("*******REGISTRO DE BUS*******");
                            Scanner.nextLine();

                            System.out.print("Ingrese la placa del vehiculo: ");
                            placa = Scanner.nextLine();

                            System.out.print("Ingrese la ruta del vehiculo: ");
                            ruta = Scanner.nextLine();

                            Bus Bus = new Bus(placa, ruta);
                            VehiculoDao.guardarVehiculo(Bus);

                            System.out.println("¿Ingresar otro bus? S/N");
                            continuar = Scanner.next().charAt(0);
                        } while (continuar == 'S');
                        break;

                    case 2:

                        do {

                            String placa, ruta;
                            System.out.println("*******REGISTRO DE BUSETA*******");
                            Scanner.nextLine();

                            System.out.print("Ingrese la placa del vehiculo: ");
                            placa = Scanner.nextLine();

                            System.out.print("Ingrese la ruta del vehiculo: ");
                            ruta = Scanner.nextLine();

                            Buseta Buseta = new Buseta(placa, ruta);
                            VehiculoDao.guardarVehiculo(Buseta);

                            System.out.println("¿Ingresar otro bus? S/N");
                            continuar = Scanner.next().charAt(0);
                        } while (continuar == 'S');
                        break;

                    case 3:

                        do {

                            String placa, ruta;
                            System.out.println("*******REGISTRO DE MICROBUSETA*******");
                            Scanner.nextLine();

                            System.out.print("Ingrese la placa del vehiculo: ");
                            placa = Scanner.nextLine();

                            System.out.print("Ingrese la ruta del vehiculo: ");
                            ruta = Scanner.nextLine();

                            MicroBus MicroBus = new MicroBus(placa, ruta);
                            VehiculoDao.guardarVehiculo(MicroBus);

                            System.out.println("¿Ingresar otro bus? S/N");
                            continuar = Scanner.next().toUpperCase().charAt(0);
                        } while (continuar == 'S');
                        break;


                    default:
                        System.err.println("Opcion invalida");
                        Thread.sleep(2000);
                        System.out.println("Regresando al menu...");

                }

            } catch (InputMismatchException e) {
                System.err.println("Debe ingresar letras no numeros");
                Scanner.nextLine();
                Thread.sleep(2000);
                System.out.println("Regresando al menu...");
            }

        }
    }

    public void menuConductor() throws InterruptedException {

        char OP = 'S';
        String cedula, nombre, numeroLicencia, categoriaLicencia;

        Scanner Scanner = new Scanner(System.in);
        conductorDao conductorDao = new conductorDao();

        while (OP == 'S') {

            try {

                System.out.println("******* REGISTRO DE CONDUCTOR *******");

                System.out.print("Ingrese la cedula: ");
                cedula = Scanner.nextLine();

                System.out.print("Ingrese el nombre: ");
                nombre = Scanner.nextLine();

                System.out.print("Ingrese el numero de licencia: ");
                numeroLicencia = Scanner.nextLine();

                System.out.print("Ingrese la categoria de licencia: ");
                categoriaLicencia = Scanner.nextLine();

                conductor conductor = new conductor(numeroLicencia, categoriaLicencia, cedula, nombre);
                conductorDao.guardar(conductor);

                System.out.println("Desea continuar? S/N");
                OP = Scanner.next().toUpperCase().charAt(0);

            } catch (InputMismatchException e) {
                System.err.println("Debe ingresar letras no numeros");
                Scanner.nextLine();
                Thread.sleep(2000);
                System.out.println("Regresando al menu...");
            }

        }
    }


    public void menuPasajero() throws InterruptedException {
        char OP = 'S';
        String cedula, nombre;

        Scanner Scanner = new Scanner(System.in);
        personaService personaService = new personaService();

        do {
            try {
                System.out.println("******* REGISTRO DE PASAJERO *******");
                Scanner.nextLine();

                System.out.print("Ingrese la cedula: ");
                cedula = Scanner.nextLine();

                System.out.print("Ingrese el nombre: ");
                nombre = Scanner.nextLine();

                System.out.print("Ingrese la fecha de nacimiento (YYYY-MM-DD): ");
                LocalDate fechaNacimiento = LocalDate.parse(Scanner.nextLine());

                System.out.print("¿Es estudiante? S/N: ");
                boolean esEstudiante = Scanner.nextLine().toUpperCase().charAt(0) == 'S';

                String resultado = personaService.registrarPasajero(cedula, nombre, fechaNacimiento, esEstudiante);
                System.out.println(resultado);

                System.out.print("¿Ingresar otro? S/N: ");
                OP = Scanner.nextLine().toUpperCase().charAt(0);

            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
                Thread.sleep(2000);
                System.out.println("Regresando al menu...");
            }

        } while (OP == 'S');
    }

    public void menuVenderTicket() throws InterruptedException {
        char OP = 'S';
        Scanner Scanner = new Scanner(System.in);

        personaService personaService = new personaService();
        VehiculoService vehiculoService = new VehiculoService();
        ticketService ticketService = new ticketService(personaService.getPasajeros());

        do {
            System.out.println("******* VENDER TICKET *******");

            System.out.print("Ingrese la cedula del pasajero: ");
            String cedula = Scanner.nextLine();
            pasajero pasajero = personaService.buscarPasajeroCedula(cedula);

            if (pasajero == null) {
                System.err.println("Pasajero no encontrado.");
                Thread.sleep(2000);
            } else {
                System.out.print("Ingrese la placa del vehiculo: ");
                String placa = Scanner.nextLine();
                Vehiculo vehiculo = vehiculoService.buscarPorPlaca(placa);

                if (vehiculo == null) {
                    System.err.println("Vehiculo no encontrado.");
                    Thread.sleep(2000);
                } else {
                    System.out.print("Ingrese el origen: ");
                    String origen = Scanner.nextLine();

                    System.out.print("Ingrese el destino: ");
                    String destino = Scanner.nextLine();

                    String resultado = ticketService.venderTicket(pasajero, vehiculo, origen, destino);
                    System.out.println(resultado);
                }
            }

            System.out.print("¿Vender otro ticket? S/N: ");
            OP = Scanner.next().toUpperCase().charAt(0);
            Scanner.nextLine();

        } while (OP == 'S');
    }

    public void menuVerTickets() {
        personaService personaService = new personaService();
        ticketService ticketService = new ticketService(personaService.getPasajeros());
        ticketService.listarTickets();
    }

    public void menuEstadisticas() {
        personaService personaService = new personaService();
        ticketService ticketService = new ticketService(personaService.getPasajeros());

        System.out.println("******* ESTADISTICAS *******");

        System.out.println("--- Total recaudado ---");
        System.out.println("$" + (int) ticketService.calcularTotalRecaudado());

        System.out.println("--- Tickets por tipo de pasajero ---");
        ticketService.mostrarTipoPasajero();

        System.out.println("--- Vehiculo con mas tickets ---");
        System.out.println(ticketService.vehiculoConMasTickets());
    }

    public void menuReportes() throws InterruptedException {
        personaService personaService = new personaService();
        ticketService ticketService = new ticketService(personaService.getPasajeros());

        char OP = 'S';
        int opcion = 0;
        Scanner Scanner = new Scanner(System.in);

        while (OP == 'S') {

            System.out.println("""
                    ******* REPORTES *******
                    
                    1. Tickets por fecha
                    2. Tickets por tipo de vehiculo
                    3. Tickets por tipo de pasajero
                    4. Resumen del dia
                    
                    0. Salir
                    """);

            System.out.print("Selecciona una opcion: ");

            try {
                opcion = Scanner.nextInt();

                switch (opcion) {
                    case 0:
                        OP = 'N';
                        System.out.println("Hemos terminado...");
                        break;

                    case 1:
                        System.out.print("Ingrese la fecha (YYYY-MM-DD): ");
                        String fecha = Scanner.next();
                        try {
                            List<ticket> porFecha = ticketService.buscarPorFecha(LocalDate.parse(fecha));
                            if (porFecha.isEmpty()) {
                                System.out.println("No hay tickets para esa fecha.");
                            } else {
                                porFecha.forEach(t -> t.imprimirDetalle());
                            }
                        } catch (Exception e) {
                            System.err.println("Fecha invalida. Use el formato YYYY-MM-DD. Ejemplo: 2026-03-21");
                            Thread.sleep(2000);
                        }
                        break;

                    case 2:
                        System.out.println("""
                                Tipo de vehiculo:
                                1. Bus
                                2. Buseta
                                3. Microbus
                                """);
                        System.out.print("Selecciona: ");
                        int tipoV = Scanner.nextInt();
                        String tipoVehiculo = switch (tipoV) {
                            case 1 -> "Bus";
                            case 2 -> "Buseta";
                            case 3 -> "MicroBus";
                            default -> "";
                        };
                        List<ticket> porVehiculo = ticketService.buscarPorTipoVehiculo(tipoVehiculo);
                        if (porVehiculo.isEmpty()) {
                            System.out.println("No hay tickets para ese tipo de vehiculo.");
                        } else {
                            porVehiculo.forEach(t -> t.imprimirDetalle());
                        }
                        break;

                    case 3:
                        System.out.println("""
                                Tipo de pasajero:
                                1. Adulto mayor
                                2. Estudiante
                                3. Regular
                                """);
                        System.out.print("Selecciona: ");
                        int tipoP = Scanner.nextInt();
                        String tipoPasajero = switch (tipoP) {
                            case 1 -> "Adulto Mayor";
                            case 2 -> "Estudiante";
                            case 3 -> "Regular";
                            default -> "";
                        };
                        List<ticket> porPasajero = ticketService.buscarPorTipoPasajero(tipoPasajero);
                        if (porPasajero.isEmpty()) {
                            System.out.println("No hay tickets para ese tipo de pasajero.");
                        } else {
                            porPasajero.forEach(t -> t.imprimirDetalle());
                        }
                        break;

                    case 4:
                        ticketService.resumenDia();
                        break;

                    default:
                        System.err.println("Opcion invalida");
                        Thread.sleep(2000);
                        System.out.println("Regresando al menu...");
                }

            } catch (InputMismatchException e) {
                System.err.println("Debe ingresar numeros, no letras");
                Scanner.nextLine();
                Thread.sleep(2000);
                System.out.println("Regresando al menu...");
            }
        }
    }

    public void menuReserva() throws InterruptedException {

        personaService personaService = new personaService();
        VehiculoService vehiculoService = new VehiculoService();
        ticketService ticketService = new ticketService(personaService.getPasajeros());
        reservaService reservaService = new reservaService(personaService.getPasajeros());

        char OP = 'S';
        int opcion = 0;
        Scanner Scanner = new Scanner(System.in);

        while (OP == 'S') {

            System.out.println("""
                ******* RESERVAS *******
                
                1. Crear reserva
                2. Cancelar reserva
                3. Listar reservas activas
                4. Historial de reservas de un pasajero
                5. Convertir reserva en ticket
                
                0. Salir
                """);

            System.out.print("Selecciona una opcion: ");

            try {
                opcion = Scanner.nextInt();
                Scanner.nextLine();

                switch (opcion) {
                    case 0:
                        OP = 'N';
                        System.out.println("Hemos terminado...");
                        break;

                    case 1:
                        System.out.print("Ingrese la cedula del pasajero: ");
                        String cedula = Scanner.nextLine();
                        pasajero pasajero = personaService.buscarPasajeroCedula(cedula);

                        if (pasajero == null) {
                            System.err.println("Pasajero no encontrado.");
                            Thread.sleep(2000);
                            break;
                        }

                        System.out.print("Ingrese la placa del vehiculo: ");
                        String placa = Scanner.nextLine();
                        Vehiculo vehiculo = vehiculoService.buscarPorPlaca(placa);

                        if (vehiculo == null) {
                            System.err.println("Vehiculo no encontrado.");
                            Thread.sleep(2000);
                            break;
                        }

                        System.out.print("Ingrese la fecha de viaje (YYYY-MM-DD): ");
                        try {
                            LocalDate fechaViaje = LocalDate.parse(Scanner.nextLine());
                            String resultadoCrear = reservaService.crearReserva(pasajero, vehiculo, fechaViaje, ticketService.gettickets());
                            System.out.println(resultadoCrear);
                        } catch (Exception e) {
                            System.err.println("Fecha invalida. Use el formato YYYY-MM-DD. Ejemplo: 2026-03-21");
                            Thread.sleep(2000);
                        }
                        break;

                    case 2:
                        System.out.print("Ingrese el codigo de la reserva: ");
                        String codigoCancelar = Scanner.nextLine();
                        System.out.println(reservaService.cancelarReserva(codigoCancelar));
                        break;

                    case 3:
                        reservaService.listarReservasActivas();
                        break;

                    case 4:
                        System.out.print("Ingrese la cedula del pasajero: ");
                        String cedulaHistorial = Scanner.nextLine();
                        reservaService.listarHistorialPasajero(cedulaHistorial);
                        break;

                    case 5:
                        System.out.print("Ingrese el codigo de la reserva: ");
                        String codigoConvertir = Scanner.nextLine();

                        System.out.print("Ingrese la placa del vehiculo: ");
                        String placaConvertir = Scanner.nextLine();
                        Vehiculo vehiculoConvertir = vehiculoService.buscarPorPlaca(placaConvertir);

                        if (vehiculoConvertir == null) {
                            System.err.println("Vehiculo no encontrado.");
                            Thread.sleep(2000);
                            break;
                        }

                        String resultadoConvertir = reservaService.convertirEnTicket(codigoConvertir, vehiculoConvertir, ticketService.gettickets());
                        System.out.println(resultadoConvertir);
                        break;

                    default:
                        System.err.println("Opcion invalida");
                        Thread.sleep(2000);
                        System.out.println("Regresando al menu...");
                }

            } catch (InputMismatchException e) {
                System.err.println("Debe ingresar numeros, no letras");
                Scanner.nextLine();
                Thread.sleep(2000);
                System.out.println("Regresando al menu...");
            }
        }
    }
}





