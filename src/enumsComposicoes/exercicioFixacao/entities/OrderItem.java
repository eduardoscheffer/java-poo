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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(product.getName() + ", $" + String.format("%.2f", price)
                + ", Quantity: " + quantity + ", Subtotal: $" + String.format("%.2f", subTotal()));
        return sb.toString();
    }
}
