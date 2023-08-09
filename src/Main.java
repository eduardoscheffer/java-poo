import introPOO.exercicioDois.entities.Product;

import java.util.*;

public class Main
{
    public static void main(String[] args) {
        Locale.setDefault((Locale.US));
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter product data:");

        System.out.print("Name: ");
        String productName = sc.nextLine();

        System.out.print("Price: ");
        double productPrice = sc.nextDouble();

        System.out.print("Quantity in stock: ");
        int productQtd = sc.nextInt();
        System.out.println();

        var product = new Product(productName, productPrice, productQtd);
        System.out.print("Product data: " + product);
        System.out.println();

        System.out.print("Enter the number of products to be added in stock: ");
        int qtdToBeAdded = sc.nextInt();
        product.addProducts(qtdToBeAdded);
        System.out.println();

        System.out.print("Updated data: " + product);
        System.out.println();

        System.out.print("Enter the number of products to be removed from stock: ");
        int qtdToBeRemoved = sc.nextInt();
        product.removeProducts(qtdToBeRemoved);
        System.out.println();

        System.out.print("Updated data: " + product);

        sc.close();
    }
}
