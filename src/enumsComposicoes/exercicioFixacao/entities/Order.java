package enumsComposicoes.exercicioFixacao.entities;

import enumsComposicoes.exercicioFixacao.entities.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private LocalDate date;
    private OrderStatus status;
    private Client client;
    private List<OrderItem> items = new ArrayList<>();
    private Double totalOrder;

    public void addItem(OrderItem item) {
        items.add(item);
        totalOrder += item.subTotal(); // inves de criar um novo metodo total() podemos adicionar o subtotal de cada pedido a um campo totalOrder da classe Order
    }
    public void removeItem(OrderItem item) {
        items.remove(item);
        totalOrder -= item.subTotal();
    }

    /*public Double total() {
        for (var item : items) {
            totalOrder += item.subTotal();
        }
        return totalOrder;
    }
    */
}
