import heranca.exercicioProposto.entities.Product;

public class Main {
    public static void main(String[] args) {
        Product product = new Product();
        product.setName("Eduardo");
        product.setLastName("Scheffer");
        product.setAge(25);
        System.out.println(product);
    }
}