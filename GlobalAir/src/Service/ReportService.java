package Service;


import Model.Flight;

public class ReportService {
    private final PassengerService passengerService;
    private final ReservationService reservationService;
    private final BaggageService baggageService;
    private final FlightService flightService;

    public ReportService(PassengerService passengerService, FlightService flightService,
                         ReservationService reservationService, BaggageService baggageService) {
        this.passengerService = passengerService;
        this.flightService = flightService;
        this.reservationService = reservationService;
        this.baggageService = baggageService;
    }

    public double ingresosTotalesReservas() {
        return reservationService.ingresosTotalesReservas();
    }

    public double ingresosTotalesEquipaje() {
        return baggageService.ingresosTotalesEquipaje();
    }

    public Flight vueloMasReservado() {
        String codigo = reservationService.vueloMasReservado();
        if (codigo == null) return null;
        return flightService.findByCode(codigo);
    }

    public double ocupacionPromedio() {
        return reservationService.ocupacionPromedio();
    }

    public int totalPasajeros() {
        return passengerService.totalPasajeros();
    }

    public int cantidadVuelosNacionales() {
        return flightService.contarPorTipo(Model.NationalFlight.class);
    }

    public int cantidadVuelosInternacionales() {
        return flightService.contarPorTipo(Model.InternationalFlight.class);
    }
}
