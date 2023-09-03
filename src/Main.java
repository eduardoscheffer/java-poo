import genericsSetMap.hashCodeEquals.Client;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault((Locale.US));
        Scanner sc = new Scanner(System.in);

        Client c1 = new Client("Joao", "joao@gmail.com");
        Client c2 = new Client("Eduardo", "eduardo@gmail.com");
        Client c3 = new Client("Joao", "joao@gmail.com");

        System.out.println("C1 Hash Code - " + c1.hashCode());
        System.out.println("C2 Hash Code - " + c2.hashCode());
        System.out.println("C1 == C2: " + c1.equals(c2));

        System.out.println();

        System.out.println("C3 Hash Code: " + c3.hashCode());
        System.out.println("C3 == C1: " + c3.equals(c1));;

        /*
        C1 Hash Code - 2314354
        C2 Hash Code - -212785871
        C1 == C2: false

        C3 Hash Code: 2314354
        C3 == C1: true
        * */

        sc.close();

    }


}