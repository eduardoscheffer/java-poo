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

        List<String> listaString = lista.stream().map((produto -> produto.getName().toUpperCase())).toList(); // metodo map recebe uma interface Function como argumento e aplica essa Function a cada elemento da List

        listaString.forEach(System.out::println); // Reference Method

        // calculando a soma dos precos cujo nome começa com "T";
        Double totalTProducts = lista.stream().filter(produto -> produto.getName().startsWith("T")) // filtrando a lista
                .mapToDouble(Produto::getPrice) // transformando a lista de produtos em uma lista de Doubles
                .reduce(0.0, Double::sum); // somando a lista de doubles

        System.out.printf("%.2f", totalTProducts); // 1250.50


    }


}