package enumsComposicoes.exercicioFixacao.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    private String name;
    private String email;
    private LocalDate date;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(name).append(" (").append(date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))).append(") ").append("- ").append(email);
        return sb.toString();
    }
}
