import interfaces.exercicioFixacao.model.entities.Contract;
import interfaces.exercicioFixacao.model.services.ContractService;
import interfaces.exercicioFixacao.model.services.PayPalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault((Locale.US));
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Entre os dados do contrato:");
        System.out.print("Numero: ");
        Integer contractNumber = sc.nextInt();

        sc.nextLine();

        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate contractDate = LocalDate.parse(sc.nextLine(), fmt);

        System.out.print("Valor do contrato: ");
        Double totalValue = sc.nextDouble();

        System.out.print("Entre com o numero de parcelas: ");
        Integer numberOfInstallments = sc.nextInt();

        Contract contract = new Contract(contractNumber, contractDate, totalValue);

        ContractService contractService = new ContractService( new PayPalService() );

        contractService.processContract(contract, numberOfInstallments);

        System.out.println("Parcelas:");
        contract.getInstallments().forEach(installment -> {
            System.out.println(fmt.format(installment.getDueDate())
                    + " - " + String.format("%.2f", installment.getAmount()));
        });

        sc.close();

    }
}