package arraysListas.exerciciosFixacao;

public class Employee {
    private int id;
    private String name;
    private Double salary;
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RESET = "\u001B[0m";

    public Employee(int id, String name, Double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public void increaseSalary (double percentage) {
        salary = salary * (1 + (percentage / 100));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return ANSI_PURPLE + id + ", " + name + ", " + String.format("%.2f", salary) + ANSI_RESET;
    }
}
