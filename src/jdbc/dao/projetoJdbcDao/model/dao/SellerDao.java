package jdbc.dao.projetoJdbcDao.model.dao;

import jdbc.dao.projetoJdbcDao.model.entities.Department;
import jdbc.dao.projetoJdbcDao.model.entities.Seller;

import java.util.List;

public interface SellerDao {

    void insert(Seller Seller);
    void update(Seller Seller);
    void deleteById(Integer id);
    Seller findById(Integer id);
    List<Seller> findAll();
    List<Seller> findByDepartment(Department department);

}
