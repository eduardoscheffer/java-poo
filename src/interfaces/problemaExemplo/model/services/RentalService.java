package interfaces.problemaExemplo.model.services;

import interfaces.problemaExemplo.model.entities.CarRental;
import interfaces.problemaExemplo.model.entities.Invoice;

import java.time.Duration;

public class RentalService {
    private Double pricePerHour;
    private Double pricePerDay;

    private TaxService taxService;

    public RentalService(Double pricePerHour, Double pricePerDay, TaxService taxService) {
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.taxService = taxService;
    }

    public void processInvoice(CarRental carRental) {

        double durationMinutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
        Double durationHours = Math.ceil(durationMinutes / 60); // arredondando pra cima as horas do aluguel

        Double basicPayment;
        if(durationHours <= 12) {
            basicPayment = pricePerHour * durationHours;
        }
        else {
            basicPayment = pricePerDay * Math.ceil(durationHours / 24); // arredondando para cima os dias do aluguel
        }

        carRental.setInvoice(new Invoice(basicPayment, taxService.tax(basicPayment)));
    }
}
