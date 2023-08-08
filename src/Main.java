import java.util.Locale;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Locale.setDefault((Locale.US));
        Scanner sc = new Scanner(System.in);

        System.out.print("Convert Cº to F (s/n)? ");
        char option = sc.next().charAt(0);

        while (option != 'n') {

            System.out.print("Temperature in Cº ");
            double C = sc.nextDouble();
            double F = (C * 1.8) + 32;
            System.out.printf("Equivalente em Fahrenheit: %.1f%n", F);
            System.out.print("Deseja repetir (s/n)? ");
            option = sc.next().charAt(0);

        }

        sc.close();
    }
}
