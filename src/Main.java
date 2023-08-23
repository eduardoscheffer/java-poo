
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault((Locale.US));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Enter client data");
        System.out.print("Name: ");
        String clientName = sc.nextLine();
        System.out.print("Email: ");
        String clientEmail = sc.next();
        System.out.print("Birth date (DD/MM/YYYY): ");
        LocalDate clientBirthDate = LocalDate.parse(sc.next(), formatter);

        System.out.println("Enter order data:");

        sc.close();

    }
}