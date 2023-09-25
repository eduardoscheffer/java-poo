package jdbc.dao.projetoJdbcDao.model.entities;

import lombok.Getter;

import java.io.Serializable;
import java.util.Objects;

@Getter
public class Department implements Serializable {

    private Integer id;
    private String name;

    @Override
    public String toString() {
        return "Department {" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(id, that.id);
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

    public Department() {
    }

    public Department(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
