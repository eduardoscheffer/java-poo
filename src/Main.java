import genericsSetMap.generics.PrintMenu;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault((Locale.US));
        Scanner sc = new Scanner(System.in);

        PrintMenu.printMenu();

        sc.close();

    }
}