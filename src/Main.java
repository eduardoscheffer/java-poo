import contrutoresThisSobrecargaEncapsul.exercicioFixacao.entities.Account;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault((Locale.US));
        Scanner sc = new Scanner(System.in);
        Account acc;

        System.out.print("Enter account number: ");
        Integer accNumber = sc.nextInt();
        System.out.print("Enter account holder: ");
        sc.nextLine();
        String accHolder = sc.nextLine();
        System.out.print("Is there an initial deposit (y/n)?: ");
        char response = sc.next().charAt(0);
        if (response == 'y') {
            System.out.print("Enter initial deposit value: ");
            double initialDeposit = sc.nextDouble();
            acc = new Account(accNumber, accHolder, initialDeposit);
        } else {
            acc = new Account(accNumber, accHolder);
        }
        System.out.println();

        System.out.println("Account data:");
        System.out.println(acc);
        System.out.println();

        System.out.print("Enter a deposit value: ");
        acc.deposit(sc.nextDouble());
        System.out.println("Updated account data:");
        System.out.println(acc);
        System.out.println();

        System.out.print("Enter a withdraw value: ");
        acc.withdraw(sc.nextDouble());
        System.out.println("Updated account data:");
        System.out.println(acc);

    }
}
