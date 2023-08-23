
import enumsComposicoes.exercicioFixacao.entities.Client;
import enumsComposicoes.exercicioFixacao.entities.Order;
import enumsComposicoes.exercicioFixacao.entities.OrderItem;
import enumsComposicoes.exercicioFixacao.entities.Product;
import enumsComposicoes.exercicioFixacao.entities.enums.OrderStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault((Locale.US));
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Enter client data");
        System.out.print("Name: ");
        String clientName = sc.nextLine();
        System.out.print("Email: ");
        String clientEmail = sc.next();
        System.out.print("Birth date (DD/MM/YYYY): ");
        LocalDate clientBirthDate = LocalDate.parse(sc.next(), formatter);

        Client client = new Client(clientName, clientEmail, clientBirthDate);

        System.out.println("Enter order data:");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.next());
        Order order = new Order(LocalDateTime.now(), status, client);

        System.out.print("How many item to this order? ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Enter #" + i + " item data:");
            System.out.print("Product name: ");
            sc.nextLine(); // pra consumir a quebra de linha do buffer
            String productName = sc.nextLine();
            System.out.print("Product price: ");
            Double productPrice = sc.nextDouble();

            Product product = new Product(productName, productPrice);

            System.out.print("Quantity: ");
            Integer productQtd = sc.nextInt();

            OrderItem orderItem = new OrderItem(productQtd, productPrice, product);

            order.addItem(orderItem);

        }
        System.out.println();
        System.out.println("ORDER SUMMARY");
        System.out.println(order);


        sc.close();

    }
}