import exceptions.exercicioFixacao.model.entities.Account;
import exceptions.exercicioFixacao.model.exceptions.DomainException;
import interfaces.problemaExemplo.model.entities.CarRental;
import interfaces.problemaExemplo.model.entities.Vehicle;
import interfaces.problemaExemplo.model.services.BrazilTaxService;
import interfaces.problemaExemplo.model.services.RentalService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault((Locale.US));
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("Entre com os dados do aluguel");
        System.out.print("Modelo do carro: ");
        Vehicle vehicle = new Vehicle(sc.nextLine());

        System.out.print("Retirada (dd/MM/yyyy hh:mm): ");
        LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt);

        System.out.print("Retorno (dd/MM/yyyy hh:mm): ");
        LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), fmt);

        System.out.print("Entre com o preço por hora: ");
        Double hourPrice = sc.nextDouble();

        System.out.print("Entre com o preço por dia: ");
        Double dayPrice = sc.nextDouble();

        CarRental carRental = new CarRental(start, finish, vehicle);
        RentalService rentalService = new RentalService(hourPrice, dayPrice, new BrazilTaxService());

        // processa a fatura
        rentalService.processInvoice(carRental);

        System.out.println("FATURA:");
        System.out.println("Pagamento basico: " + carRental.getInvoice().getBasicPayment());
        System.out.println("Imposto: " + carRental.getInvoice().getTax());
        System.out.println("Pagamento total: " + carRental.getInvoice().getTotalPayment());

        sc.close();

    }
}