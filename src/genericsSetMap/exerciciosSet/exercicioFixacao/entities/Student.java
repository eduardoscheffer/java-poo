package genericsSetMap.exerciciosSet.exercicioFixacao.entities;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Student {

    @EqualsAndHashCode.Include
    @ToString.Include
    private Integer id;


}
