package enumsComposicoes.exercicioFixacao.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
    private Integer quantity;
    private Double price;
    private Product product;

    public Double subTotal() {
        return quantity * price;
    }
}
