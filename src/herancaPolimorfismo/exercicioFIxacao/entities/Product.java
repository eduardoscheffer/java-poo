package herancaPolimorfismo.exercicioFIxacao.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private String name;
    private Double price;

    public String priceTag() {
        StringBuilder sb = new StringBuilder();

        sb.append(name + " $ " + String.format("%.2f", price));

        return sb.toString();
    }
}
