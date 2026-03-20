package org.example;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static void main(String[] args) {

        Main obj = new Main();
        obj.menu();

        }


        public void menu(){

            char OP='S';
            int opcion=0;

            Scanner Scanner = new Scanner(System.in);

            while(OP=='S') {

                System.out.print("""
                    1. Registrar vehiculo
                    2. Registrar conductor
                    3. Registrar pasajero 
                    4. Vender tickets
                    5. Ver tickets
                    6. Estadisticas
                    
                    0. Salir
                    """);

                System.out.print("Selecciona una opccion: ");
                opcion = Scanner.nextInt();

                switch (opcion){
                    case 0:
                        OP='N';
                        System.out.println("Hemos terminado...");
                        break;

                    default:
                        System.err.println("Opcion invalida");
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("volviendo al menu...");
                }


            }


    }
}
