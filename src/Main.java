import enumsComposicoes.exercicioWorker.entities.Department;
import enumsComposicoes.exercicioWorker.entities.HourContract;
import enumsComposicoes.exercicioWorker.entities.Worker;
import enumsComposicoes.exercicioWorker.entities.enums.WorlerLevel;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault((Locale.US));
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dateFmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Enter department's name: ");
        Department workerDepartment = new Department(sc.nextLine());

        System.out.println("Enter worker data:");
        System.out.print("Name: ");
        String workerName = sc.nextLine();

        System.out.print("Level: ");
        WorlerLevel workerLevel = WorlerLevel.valueOf(sc.nextLine());

        System.out.print("Base salary: ");
        Double workerBaseSalary = sc.nextDouble();

        Worker worker = new Worker(workerName, workerLevel, workerBaseSalary, workerDepartment);

        System.out.print("How many contracts to this worker? ");
        int n = sc.nextInt();

        sc.nextLine(); // faz o consumo da quebra de linha do buffer


        for (int i = 1; i <= n; i++) {

            System.out.printf("Enter contract #%d data:\n", i);
            System.out.print("Date (DD/MM/YYYY): ");
            LocalDate dataContract = LocalDate.parse(sc.nextLine(), dateFmt);
            System.out.print("Value per hour: ");
            Double contractValuePerHour = sc.nextDouble();
            System.out.print("Duration (hours): ");
            Integer contractHours = sc.nextInt();

            // instancia um novo HourContract e adiciona ao worker:
            worker.addContract(new HourContract(dataContract, contractValuePerHour, contractHours));

            sc.nextLine(); // faz o consumo da quebra de linha do buffer
            System.out.println();

        }

        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        // O YearMonth representa um mês e ano específicos, mas não inclui informações de hora ou dia.
        YearMonth monthAndYear = YearMonth.parse(sc.next(), DateTimeFormatter.ofPattern("MM/yyyy"));

        System.out.println("Name: " + workerName);
        System.out.println("Department: " + workerDepartment.getName());
        System.out.println("Income for "
                + monthAndYear.getMonthValue()
                + "/" + monthAndYear.getYear()
                + ": " + String.format("%.2f", worker.income(monthAndYear.getYear(), monthAndYear.getMonthValue())));
        sc.close();

    }
}