
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault((Locale.US));
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmtGlobal = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());

        LocalDate d04 = LocalDate.parse("2022-07-20");

        LocalDateTime d05 = LocalDateTime.parse("2022-07-20T01:30:26");

        Instant d06 = Instant.parse("2022-07-20T01:30:26Z");

        // subtraindo 1 semana do d04:
        LocalDate pastWeekLocalDate = d04.minusDays(7);
        System.out.println("1 Week ago from d04 - " + pastWeekLocalDate); // 1 Week ago from d04 - 2022-07-13

        // adicionando 1 semana do d04:
        LocalDate nextWeekLocalDate = d04.plusDays(7);
        System.out.println("1 Week from d04 - " + nextWeekLocalDate); // 1 Week from d04 - 2022-07-27

        // adicinando e subtraindo horas e minutos e segundos do LocalDatetIme d05:
        LocalDateTime pastHourLocalDateTime = d05.minusHours(1);
        System.out.println("1 hour ago from d05 " +
                    pastHourLocalDateTime.format(DateTimeFormatter
                                         .ofPattern("dd/MM/yyyy HH:mm"))); // 1 hour ago from d05 20/07/2022 00:30

        LocalDateTime nextHourLocalDateTime = d05.plusHours(10);
        System.out.println("10 hour from d05 " +
                nextHourLocalDateTime.format(DateTimeFormatter
                        .ofPattern("dd/MM/yyyy HH:mm"))); // 10 hour from d05 20/07/2022 11:30

        // calculos com Instants:
        Instant pastWeekInstant = d06.minus(7, ChronoUnit.DAYS);
        System.out.println("1 Week ago from d06 - " + fmtGlobal.format(pastWeekInstant)); // 1 Week ago from d06 - 12/07/2022 22:30

        Instant nextWeekInstant = d06.plus(7, ChronoUnit.DAYS);
        System.out.println("1 Week from d06 - " + fmtGlobal.format(nextWeekInstant)); // 1 Week from d06 - 26/07/2022 22:30

        // Duração:
        // Duration var = Duration.between(instanteInicial, instanteFinal);
        Duration t1 = Duration.between(pastWeekInstant, nextWeekInstant);
        System.out.println("Dias decorridos entre 12/07/2022 e 26/07/2022 = " + t1.toDays());

        // Duration.between só aceita argumento LocalDateTime ou Instant's. Por isso convertemos LocalDate para LocalDateTime usando o .atStartOfDay();:
        Duration t2 = Duration.between(pastWeekLocalDate.atStartOfDay(), d04.atStartOfDay());
        System.out.println("Tempo decorrido entre 2022-07-13 e 2022-07-20 em minutos: " + t2.toMinutes()); // Tempo decorrido entre 2022-07-13 e 2022-07-20 em minutos: 10080
        System.out.println();

        System.out.println("Tempo decorrido do meu nascimento até hoje:");
        LocalDate nascimento = LocalDate.parse("1997-09-09");
        Duration tempoVivido = Duration.between(nascimento.atStartOfDay(), LocalDateTime.now());
        System.out.println("Nascimento: " + nascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("Dias vividos: " + tempoVivido.toDays());


        sc.close();

    }
}
