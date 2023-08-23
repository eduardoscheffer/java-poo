package enumsComposicoes.exercicioFixacao.entities;

import enumsComposicoes.exercicioFixacao.entities.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private LocalDateTime date;
    private OrderStatus status;
    private Client client;
    private List<OrderItem> items = new ArrayList<>();
    private Double totalOrder = 0.0;

    public void addItem(OrderItem item) {
        items.add(item);
        totalOrder += item.subTotal(); // inves de criar um novo metodo total() podemos adicionar o subtotal de cada pedido a um campo totalOrder da classe Order
    }
    public void removeItem(OrderItem item) {
        items.remove(item);
        totalOrder -= item.subTotal();
    }

    public Order(LocalDateTime data, OrderStatus status, Client client) {
        this.date = data;
        this.status = status;
        this.client = client;
    }

    /*
    public Double total() {
        for (var item : items) {
            totalOrder += item.subTotal();
        }
        return totalOrder;
    }
    */

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();

        sb.append("Order moment: ").append(date
                .format(DateTimeFormatter
                .ofPattern("dd/MM/yyyy HH:mm:ss \n")));

        sb.append("Order status: ").append(status + "\n");
        sb.append("Client: ").append(client + "\n");
        sb.append("\n");
        sb.append("Order items:" + "\n");
        for (var item : items) {
            sb.append(item);
            sb.append("\n");
        }
        sb.append("Total price: $" + String.format("%.2f", getTotalOrder()));

        return sb.toString();
    }
}
