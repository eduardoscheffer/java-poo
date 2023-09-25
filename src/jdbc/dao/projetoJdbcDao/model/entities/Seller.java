package jdbc.dao.projetoJdbcDao.model.entities;

import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Getter
public class Seller implements Serializable {

    private Integer id;
    private String name;
    private String email;
    private LocalDate birthDate;
    private Double baseSalary;
    private Department department;

    public Seller(Integer id, String name, String email, LocalDate birthDate, Double baseSalary, Department department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Seller {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", baseSalary=" + baseSalary +
                ", department=" + department +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seller seller = (Seller) o;
        return Objects.equals(id, seller.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Seller() {
    }
}
