import exceptions.exercicioFixacao.model.entities.Account;
import exceptions.exercicioFixacao.model.exceptions.DomainException;

import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault((Locale.US));
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            System.out.println("Enter account data");
            System.out.print("Number: ");
            Integer accNumber = sc.nextInt();

            sc.nextLine();

            System.out.print("Holder: ");
            String accHolder = sc.nextLine();

            System.out.print("Initial balance: ");
            Double accBalance = sc.nextDouble();

            System.out.print("Withdraw limit: ");
            Double accLimit = sc.nextDouble();

            Account acc = new Account(accNumber, accHolder, accBalance, accLimit);

            System.out.println();

            System.out.print("Enter amount for withdraw: ");
            acc.withDraw(sc.nextDouble());

            System.out.println("New balance: $" + String.format("%.2f", acc.getBalance()));

        }
        catch (DomainException e) {
            System.out.println(e.getMessage());
        }

        sc.close();

    }
}