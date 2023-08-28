import exceptions.exercicioFixacao.model.entities.Account;
import exceptions.exercicioFixacao.model.exceptions.DomainException;

import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault((Locale.US));
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        List<String> nomes = Arrays.asList("Joao", "Maria");

        nomes.forEach(nome -> {
            nome = nome.toUpperCase();
            System.out.println(nome);
        });

        nomes.forEach(nome -> {
            System.out.println(nome);
        });

        sc.close();

    }
}