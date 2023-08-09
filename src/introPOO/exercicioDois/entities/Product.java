package introPOO.exercicioDois.entities;

public class Product {
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String name;
    public double price;
    public int quantity;

    public double totalValueInStock() {
        return price * quantity;
    }
    public void addProducts(int qtd) {
        quantity += qtd;
    }
    public void removeProducts(int qtd) {
        quantity -= qtd;
    }

    @Override
    public String toString() {
        return name
            + ", $ " + String.format("%.2f", price)
            + ", " + quantity + " units, Total: "
            + "$ " + String.format("%.2f", totalValueInStock());
    }
}
