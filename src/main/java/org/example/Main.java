package org.example;
import model.*;
import dao.*;
import service.personaService;
import service.ticketService;
import service.*;

import java.sql.SQLOutput;
import java.util.InputMismatchException;
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
                            System.out.println("*******REGISTRO DE BUSETA*******");
                            Scanner.nextLine();

                            System.out.print("Ingrese la placa del vehiculo: ");
                            placa = Scanner.nextLine();

                            System.out.print("Ingrese la ruta del vehiculo: ");
                            ruta = Scanner.nextLine();

                            MicroBus MicroBus = new MicroBus(placa, ruta);
                            VehiculoDao.guardarVehiculo(MicroBus);

                            System.out.println("¿Ingresar otro bus? S/N");
                            continuar = Scanner.next().charAt(0);
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
                Scanner.nextLine();

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
        int opcion = 0;
        String cedula, nombre;

        Scanner Scanner = new Scanner(System.in);
        pasajeroDao pasajeroDao = new pasajeroDao();

        while (OP == 'S') {

            System.out.println("""
                    REGISTRO PASAJEROS
                    
                    1. Adulto mayor
                    2. Estudiante
                    3. Regular
                    
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
                        do {
                            System.out.println("******* REGISTRO DE ADULTO MAYOR *******");
                            Scanner.nextLine();

                            System.out.print("Ingrese la cedula: ");
                            cedula = Scanner.nextLine();

                            System.out.print("Ingrese el nombre: ");
                            nombre = Scanner.nextLine();

                            pasajeroAdultoMayor pasajeroAdultoMayor = new pasajeroAdultoMayor(cedula, nombre);
                            pasajeroDao.guardar(pasajeroAdultoMayor);
                            System.out.println("Pasajero registrado exitosamente.");

                            System.out.print("¿Ingresar otro? S/N: ");
                            OP = Scanner.next().toUpperCase().charAt(0);
                        } while (OP == 'S');
                        break;

                    case 2:
                        do {
                            System.out.println("******* REGISTRO DE ESTUDIANTE *******");
                            Scanner.nextLine();

                            System.out.print("Ingrese la cedula: ");
                            cedula = Scanner.nextLine();

                            System.out.print("Ingrese el nombre: ");
                            nombre = Scanner.nextLine();

                            pasajeroEstudiante pasajeroEstudiante = new pasajeroEstudiante(cedula, nombre);
                            pasajeroDao.guardar(pasajeroEstudiante);
                            System.out.println("Pasajero registrado exitosamente.");

                            System.out.print("¿Ingresar otro? S/N: ");
                            OP = Scanner.next().toUpperCase().charAt(0);
                        } while (OP == 'S');
                        break;

                    case 3:
                        do {
                            System.out.println("******* REGISTRO DE REGULAR *******");
                            Scanner.nextLine();

                            System.out.print("Ingrese la cedula: ");
                            cedula = Scanner.nextLine();

                            System.out.print("Ingrese el nombre: ");
                            nombre = Scanner.nextLine();

                            pasajeroRegular pasajeroRegular = new pasajeroRegular(cedula, nombre);
                            pasajeroDao.guardar(pasajeroRegular);
                            System.out.println("Pasajero registrado exitosamente.");

                            System.out.print("¿Ingresar otro? S/N: ");
                            OP = Scanner.next().toUpperCase().charAt(0);
                        } while (OP == 'S');
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

}





