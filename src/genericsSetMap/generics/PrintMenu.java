package genericsSetMap.generics;

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
}
