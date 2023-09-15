import programacaoFuncional.interfaceComparator.Produto;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault((Locale.US));
        Scanner sc = new Scanner(System.in);

        List<Produto> lista = new ArrayList<>(Arrays.asList(

                new Produto("Tv", 900.00),
                new Produto("Mouse", 50.00),
                new Produto("Tablet", 350.50),
                new Produto("HD Case", 80.90)

        ));

        lista.removeIf((p) -> p.getPrice() > 100.00);

        System.out.println(lista);

        sc.close();

    }


}