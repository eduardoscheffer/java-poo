import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String product1 = "Computer";
        String product2 = "Office desk";
        int age = 30;
        int code = 5290;
        char gender = 'F';
        double price1 = 2100.0;
        double price2 = 650.50;
        double measure = 53.234567;

/*
        %f = ponto flutuante
        %d = inteiro
        %s = texto
        %n = quebra de linha
*/

        System.out.println("Products");
        System.out.printf("Computer, which price is $ %.2f\n", price1);
        System.out.printf("Office desk, which price is $ %.2f\n", price2);
        System.out.println();
        System.out.printf("Record: %d years old, code %d and gender: %s\n", age, code, gender);
        System.out.println();
        System.out.printf("Measure with eight decimal places: %.8f\n", measure);
        System.out.printf("Rounded (three decimal places): %.3f\n", measure);

        Locale.setDefault(Locale.US);
        System.out.printf("US decimal point: %.3f", measure);

/*
        Products
        Computer, which price is $ 2100,00
        Office desk, which price is $ 650,50

        Record: 30 years old, code 5290 and gender: F

        Measure with eight decimal places: 53,23456700
        Rounded (three decimal places): 53,235
        US decimal point: 53.235
*/

        sc.close();
    }

    public static void logLn(String message) {
        String BLUE = "\u001B[33m";
        String RESET = "\u001B[0m";
        System.out.println(BLUE + message + RESET);
    }
    public static void log(String message) {
        String YELLOW = "\u001B[33m";
        String RESET = "\u001B[0m";
        System.out.print(YELLOW + message + RESET);
    }
}