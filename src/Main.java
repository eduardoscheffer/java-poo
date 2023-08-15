
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault((Locale.US));
        Scanner sc = new Scanner(System.in);

        // instanciar:
        LocalDate d01 = LocalDate.now();
        System.out.println("d01 - " + d01); // d01 - 2023-08-15

        LocalDateTime d02 = LocalDateTime.now();
        System.out.println("d02 - " + d02); // d02 - 2023-08-15T12:56:19.445384200

        Instant d03 = Instant.now();
        // data-hora GMT:
        System.out.println("d03 - " + d03); // d03 - 2023-08-15T15:57:29.803839800Z

        LocalDate d04 = LocalDate.parse("2022-07-20");
        System.out.println("d04 - " + d04); // d04 - 2022-07-20

        LocalDateTime d05 = LocalDateTime.parse("2022-07-20T01:30:26");
        System.out.println("d05 - " + d05); // d05 - 2022-07-20T01:30:26

        Instant d06 = Instant.parse("2022-07-20T01:30:26Z"); // horario de Londres (Z = GMT)
        System.out.println("d06 - " + d06); // d06 - 2022-07-20T01:30:26Z

        // DateTimeFormatter: https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate d08 = LocalDate.parse("09/09/1997", fmt1);
        System.out.println("d08 - " + d08); // d08 - 1997-09-09

        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime d09 = LocalDateTime.parse("09/09/1997 15:30", fmt2);
        System.out.println("d09 - " + d09); // d09 - 1997-09-09T15:30

        // instanciando a partir de dados isolados:
        LocalDate d10 = LocalDate.of(1997, 9, 9);
        System.out.println("d10 - " + d10); // d10 - 1997-09-09
        LocalDateTime d11 = LocalDateTime.of(2023, 9, 9, 12, 0);
        System.out.println("d11 - " + d11); // d11 - 2023-09-09T12:00
        System.out.println(d11.getDayOfWeek()); // SATURDAY

        sc.close();

    }
}
