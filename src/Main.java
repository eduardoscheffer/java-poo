import heranca.exercicioProposto.entities.Product;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner console = new Scanner(System.in);
        Product product = new Product();
        product.setName("Eduardo");
        product.setLastName("Scheffer");
        product.setAge(25);
        System.out.println(product);

        System.out.print("Enter nota um: ");
        double notaUm = console.nextDouble();
        System.out.print("Enter nota dois: ");
        double notaDois = console.nextDouble();
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
        double media = (notaUm + notaDois) / 2;
        System.out.printf("Media %.2f", media);
        System.out.println();
        for (var number : list) {
            System.out.println("-> "+ number);
        }

        checkChoice();
//      Product{name='Eduardo', lastName='Scheffer', age=25}
//      Enter nota um: 15.2
//      Enter nota dois: 25.2
//      Media 20.20
//      -> 1
//      -> 2
//      -> 3
//      Metodo rodando

        console.close();

    }

    static void checkChoice() {
        System.out.println("Metodo rodando");
    }
}