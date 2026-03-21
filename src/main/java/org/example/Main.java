package org.example;
import model.Bus;
import dao.VehiculoDao;
import model.Buseta;
import model.MicroBus;

import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

     static void main(String[] args) throws InterruptedException {

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



    public void menuVehiculos() throws InterruptedException{

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

                        char continuar='S';
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
                        }while(continuar == 'S');
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
                        }while(continuar == 'S');
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

                            MicroBus MicroBus = new MicroBus(placa,ruta);
                            VehiculoDao.guardarVehiculo(MicroBus);

                            System.out.println("¿Ingresar otro bus? S/N");
                            continuar = Scanner.next().charAt(0);
                        }while(continuar == 'S');
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







}

