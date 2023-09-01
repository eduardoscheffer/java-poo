import genericsSetMap.generics.GenericNumericFunctions;
import genericsSetMap.generics.MyGenericClass;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault((Locale.US));
        Scanner sc = new Scanner(System.in);

        List<Integer> lista = new ArrayList<>();
        lista.add(3);
        lista.add(5);
        printFirstOfList(lista);

        List<String> listaStrings = new ArrayList<>();
        listaStrings.add("Joao");
        listaStrings.add("Pedro");
        printFirstOfList(listaStrings);

        sc.close();

    }

    private static void printFirstOfList(List<?> list) {
        System.out.println(list.get(0));
    }
}