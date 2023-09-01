package genericsSetMap.generics;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PrintMenu {

    // Cores ANSI para realce no console
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static void printMenu() {
        System.out.println("=========================================");
        System.out.println(ANSI_BLUE + "            Menu de Opções" + ANSI_RESET);
        System.out.println("=========================================");
        System.out.println(ANSI_YELLOW + " 1. Realizar ação 1" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + " 2. Realizar ação 2" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + " 3. Realizar ação 3" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + " 4. Realizar ação 4" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + " 5. Realizar ação 5" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + " 6. Realizar ação 6" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + " 7. Sair" + ANSI_RESET);
        System.out.println("=========================================");
    }

    public static int option() {

        Scanner sc = new Scanner(System.in);
        int option;
        do {
            try {
                System.out.print("Opção desejada: ");
                option = sc.nextInt();

                if (option < 1 || option > 7)
                    System.out.println("Escolha uma opção entre 1 e 7");
            }
            catch (InputMismatchException e) {
                System.out.println("Digite um número válido para seguir adiante");
                sc.nextLine(); // Limpa o buffer do scanner
                option = 0; // Atribui um valor inválido para continuar no loop
            }
        } while (option < 1 || option > 7);

        sc.close();

        return option;

    }
}
