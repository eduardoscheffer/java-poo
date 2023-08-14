import arraysListas.exerciciosFixacao.Employee;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault((Locale.US));
        Scanner sc = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>(); // ArrayList<Employee>

        System.out.print("How many employees will be registered? ");
        int qtdEmployees = sc.nextInt();

        for (int i = 1; i <= qtdEmployees; i++) {
            System.out.println();
            System.out.println("Employee #" + i + ":");
            System.out.print("ID: ");
            Integer id = sc.nextInt();

            System.out.print("Name: ");
            System.out.println();
            String name = sc.nextLine();

            System.out.print("Salary");
            Double salary = sc.nextDouble();

            employees.add(new Employee(id, name, salary));

        }

        System.out.print("Enter the employee id that will have salary increase: ");
        Integer idEmployee = sc.nextInt();

        for (var employee: employees) {
            if (employee.getId() == idEmployee) {
                System.out.print("Enter the percentage: ");
                double percentageRaise = sc.nextDouble();
                employee.increaseSalary(percentageRaise);
            } else {
                System.out.println("This id does not exist!");
            }
        }

        for (var emp : employees) {
            System.out.println(emp);
        }

        sc.close();
    }
}
