import programacaoFuncional.interfaceComparator.Produto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        // pegando a media dos produtos:
        double avg = (lista.stream()
                .map(Produto::getPrice)
                .reduce(0.0, Double::sum)) / lista.size();
        System.out.println("MEDIA: R$ " + String.format("%.2f", avg)); // MEDIA: R$ 345.35

        sc.close();

    }



}