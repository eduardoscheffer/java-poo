import arraysListas.exerciciosFixacao.Employee;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault((Locale.US));
        Scanner sc = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>(); // ArrayList<Employee>

        System.out.print("How many employees will be registered? ");
        int qtdEmployees = sc.nextInt();

        System.out.println();

        for (int i = 1; i <= qtdEmployees; i++) {
            System.out.println("Employee #" + i + ":");
            System.out.print("ID: ");
            int id = sc.nextInt();
            sc.nextLine(); // Consumir a quebra de linha pendente

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Salary: ");
            Double salary = sc.nextDouble();

            employees.add(new Employee(id, name, salary));
            System.out.println();
        }


        System.out.print("Enter the employee id that will have salary increase: ");
        int idEmployee = sc.nextInt();

        // Calculo do aumento de salario com base no ID do funcionario:
        Employee emp = employees.stream().filter(x -> x.getId() == idEmployee).findFirst().orElse(null);
        if (emp == null) {
            System.out.println("This id does not exist!");
        } else {
            System.out.print("Enter the percentage: ");
            double percentage = sc.nextDouble();
            emp.increaseSalary(percentage);
        }

        // Printando os funcionarios com salario atualizado:
        System.out.println("List of employees:");
        for (var func : employees) {
            System.out.println(func);
        }

        sc.close();

    }
}
