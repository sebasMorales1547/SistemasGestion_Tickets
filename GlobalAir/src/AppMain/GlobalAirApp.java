package AppMain;

import Model.Passenger;
import Service.BaggageService;
import Service.FlightService;
import Service.PassengerService;
import Service.ReportService;
import Service.ReservationService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class GlobalAirApp {
    public static void main(String[] args) {
        PassengerService passengerService = new PassengerService();
        FlightService flightService = new FlightService();
        ReservationService reservationService = new ReservationService(flightService, passengerService);
        BaggageService baggageService = new BaggageService(reservationService);
        ReportService reportService = new ReportService(passengerService, flightService, reservationService, baggageService);

        try (Scanner sc = new Scanner(System.in)) {
            boolean salir = false;
            
            while (!salir) {
   
                System.out.println("\n||---------------------------------------------------------||");
                System.out.println("||              SISTEMA DE VUELOS- GLOBAL AIR              ||");
                System.out.println("||                    Valledupar - Cesar                   ||");
                System.out.println("||---------------------------------------------------------||");
                System.out.println("||  1. REGISTRAR PASAJERO                                  ||");
                System.out.println("||  2. CREAR VUELO INTERNACIONAL                           ||");
                System.out.println("||  3. CREAR RESERVA                                       ||");
                System.out.println("||  4. REGISTRAR EQUIPAJE                                  ||");
                System.out.println("||  5. VER REPORTES                                        ||");
                System.out.println("||  6. SALIR                                               ||");
                System.out.println("||---------------------------------------------------------||");
                
                
                System.out.print("Elige una opcion: ");
                
                int opcion = sc.nextInt();
                sc.nextLine();
                
                try {
                    switch (opcion) {
                        case 1:
                            System.out.print("Cedula: ");
                            String cedula = sc.nextLine();
                            System.out.print("Nombre: ");
                            String nombre = sc.nextLine();
                            System.out.print("Apellido: ");
                            String apellido = sc.nextLine();
                            System.out.print("Edad: ");
                            int edad = sc.nextInt(); sc.nextLine();
                            System.out.print("Email: ");
                            String email = sc.nextLine();
                            System.out.print("Telefono: ");
                            String telefono = sc.nextLine();
                            System.out.print("Pasaporte: ");
                            String pasaporte = sc.nextLine();
                            System.out.print("Nacionalidad: ");
                            String nacionalidad = sc.nextLine();
                            
                            Passenger p = new Passenger(cedula, nombre, apellido, edad, email, telefono, pasaporte, nacionalidad);
                            passengerService.registrarPasajero(p);
                            System.out.println("Pasajero registrado correctamente.");
                            break;
                            
                        case 2:
                            System.out.print("Codigo vuelo: ");
                            String codigoVuelo = sc.nextLine();
                            System.out.print("Ciudad origen: ");
                            String origen = sc.nextLine();
                            System.out.print("Ciudad destino: ");
                            String destino = sc.nextLine();
                            System.out.print("Fecha (YYYY-MM-DD): ");
                            LocalDate fecha = LocalDate.parse(sc.nextLine());
                            System.out.print("Hora salida (HH:MM): ");
                            LocalTime salida = LocalTime.parse(sc.nextLine());
                            System.out.print("Hora llegada (HH:MM): ");
                            LocalTime llegada = LocalTime.parse(sc.nextLine());
                            System.out.print("Capacidad: ");
                            int capacidad = sc.nextInt(); sc.nextLine();
                            System.out.print("Precio base: ");
                            double precio = sc.nextDouble(); sc.nextLine();
                            System.out.print("Pais destino: ");
                            String pais = sc.nextLine();
                            System.out.print("Es internacional (true/false): ");
                            boolean internacional = sc.nextBoolean(); sc.nextLine();
                            System.out.print("Tarifa equipaje: ");
                            double tarifaEquipaje = sc.nextDouble(); sc.nextLine();
                            
                            flightService.crearVueloInternacional(codigoVuelo, origen, destino, fecha, salida, llegada, capacidad, precio, pais, internacional, tarifaEquipaje);
                            System.out.println("Vuelo creado correctamente.");
                            break;
                            
                        case 3:
                            System.out.print("Codigo reserva: ");
                            String codigoRes = sc.nextLine();
                            System.out.print("Cedula pasajero: ");
                            String cedulaRes = sc.nextLine();
                            System.out.print("Codigo vuelo: ");
                            String vueloRes = sc.nextLine();
                            System.out.print("Cantidad asientos: ");
                            int asientos = sc.nextInt(); sc.nextLine();
                            reservationService.crearReserva(codigoRes, cedulaRes, vueloRes, asientos, LocalDate.now());
                            System.out.println("Reserva creada correctamente.");
                            break;
                            
                        case 4:
                            System.out.print("Codigo equipaje: ");
                            String codigoEq = sc.nextLine();
                            System.out.print("Peso: ");
                            double peso = sc.nextDouble(); sc.nextLine();
                            System.out.print("Tipo (BODEGA/MANO): ");
                            String tipoStr = sc.nextLine();
                            System.out.print("Codigo reserva: ");
                            String resEq = sc.nextLine();
                            BaggageService.BaggageType tipo;
                            try {
                                tipo = BaggageService.valueOf(tipoStr.toUpperCase());
                            } catch (IllegalArgumentException e) {
                                System.out.println("Tipo invalido. Usa BODEGA o MANO.");
                                break;
                            }
                            baggageService.registrarEquipaje(codigoEq, peso, tipo, resEq);
                            System.out.println("Equipaje registrado correctamente.");
                            break;
                            
                        case 5:
                            System.out.println("Ingresos por reservas: " + reportService.ingresosTotalesReservas());
                            System.out.println("Ingresos por equipaje: " + reportService.ingresosTotalesEquipaje());
                            var vueloMas = reportService.vueloMasReservado();
                            System.out.println("Vuelo mas reservado: " + (vueloMas != null ? vueloMas.getCodigo() : "N/A"));
                            System.out.println("Ocupacion promedio: " + reportService.ocupacionPromedio());
                            System.out.println("Total pasajeros: " + reportService.totalPasajeros());
                            break;
                            
                        case 6:
                            salir = true;
                            System.out.println("Saliendo del sistema...");
                            break;
                            
                        default:
                            System.out.println("Opcion no válida.");
                            break;
                    }
                } catch (IllegalArgumentException ex) {
                    System.err.println("Error: " + ex.getMessage());
                }
            }
        }
    }
}
