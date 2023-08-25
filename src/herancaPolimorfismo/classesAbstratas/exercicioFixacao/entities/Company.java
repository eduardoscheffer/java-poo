package herancaPolimorfismo.classesAbstratas.exercicioFixacao.entities;

public class Company extends TaxPayer{

    private Integer totalEmployees;

    public Company(String name, Double anualIncome, Integer totalEmployees) {
        super(name, anualIncome);
        this.totalEmployees = totalEmployees;
    }

    public Integer getTotalEmployees() {
        return totalEmployees;
    }

    public void setTotalEmployees(Integer totalEmployees) {
        this.totalEmployees = totalEmployees;
    }

    @Override
    public Double tax() {
        if (totalEmployees > 10) return getAnualIncome() * 0.14;
        else return getAnualIncome() * 0.16;
    }
}
