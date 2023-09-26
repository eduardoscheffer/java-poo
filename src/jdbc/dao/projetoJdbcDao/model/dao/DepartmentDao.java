package jdbc.dao.projetoJdbcDao.model.dao;

import jdbc.dao.projetoJdbcDao.model.entities.Department;

import java.util.List;

public interface DepartmentDao {

    void insert(Department department);
    void update(Department department);
    void deleteById(Integer id);
    Department findById(Integer id);
    List<Department> findAll();

}
