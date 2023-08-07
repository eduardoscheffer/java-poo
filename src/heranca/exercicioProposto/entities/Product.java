package heranca.exercicioProposto.entities;

public class Product {
    public String name;
    public String lastName;
    public Integer age;

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Product(String name, String lastName, Integer age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }
}
