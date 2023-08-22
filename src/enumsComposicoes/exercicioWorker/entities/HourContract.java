package enumsComposicoes.exercicioWorker.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HourContract {

    private LocalDate date;

    private Double valuePerHour;

    private Integer hours;

    public Double totalValue()  {
        return hours * valuePerHour;
    }

}
