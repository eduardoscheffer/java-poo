import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault((Locale.US));
        Scanner sc = new Scanner(System.in);

        String nome;
        int idadeNome, idadePai, idadeMae;
        nome = sc.nextLine();
        idadeNome = sc.nextInt();
        idadePai = sc.nextInt();
        idadeMae = sc.nextInt();
        System.out.printf(String.format("Nome: %s, Idade: $d, Idade Pai: %d, IdadeMae: %d",
                nome, idadeNome, idadePai, idadeMae));

//        String nome;
//        int idade, idadePai, idadeMae;
//
//        nome = sc.nextLine();
//        idade = sc.nextInt();
//        idadePai = sc.nextInt();
//        idadeMae = sc.nextInt();
//
//        // Agora você pode usar as variáveis nome, idade, idadePai e idadeMae como quiser
//        System.out.println("Nome: " + nome);
//        System.out.println("Idade: " + idade);
//        System.out.println("Idade do Pai: " + idadePai);
//        System.out.println("Idade da Mãe: " + idadeMae);
//
//        // Não se esqueça de fechar o Scanner
//        sc.close();


        sc.close();
    }

    public static void logLn(String message) {
        String BLUE = "\u001B[33m";
        String RESET = "\u001B[0m";
        System.out.println(BLUE + message + RESET);
    }
    public static void log(String message) {
        String YELLOW = "\u001B[33m";
        String RESET = "\u001B[0m";
        System.out.print(YELLOW + message + RESET);
    }
}