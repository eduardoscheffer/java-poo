package enumsComposicoes.exercicioWorker.entities;

import enumsComposicoes.exercicioWorker.entities.enums.WorlerLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Worker {
    private String name;

    private WorlerLevel level;

    private Double baseSalary;

    private Department department;

    private List<HourContract> contracts = new ArrayList<>();

    public Worker (String name, WorlerLevel worlerLevel, Double baseSalary, Department workerDepartment) {
        this.name = name;
        this.level = worlerLevel;
        this.baseSalary = baseSalary;
        this.department = workerDepartment;
    }

    public void addContract(HourContract contract) {
        contracts.add(contract);
    }

    public void removeContract(HourContract contract) {
        contracts.remove(contract);
    }

    public Double income(int year, int month) {
        Double total = baseSalary;
        for (var contract : contracts) {
            if (contract.getDate().getYear() == year && contract.getDate().getMonthValue() == month)
                total += contract.totalValue();
        }

        return total;
    }

}
