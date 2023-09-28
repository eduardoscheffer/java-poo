package jdbc.dao.projetoJdbcDao.model.dao.impl;

import jdbc.dao.projetoJdbcDao.db.DBException;
import jdbc.dao.projetoJdbcDao.db.JDBCPostgreSQLConnection;
import jdbc.dao.projetoJdbcDao.model.dao.SellerDao;
import jdbc.dao.projetoJdbcDao.model.entities.Department;
import jdbc.dao.projetoJdbcDao.model.entities.Seller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SellerDaoJDBC implements SellerDao {

    private Connection conn;
    public SellerDaoJDBC(Connection conn) {
        this.conn = conn;
    }
    @Override
    public void insert(Seller Seller) {

    }

    @Override
    public void update(Seller Seller) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Seller findById(Integer id) {

        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                    "SELECT seller.*,department.Name as DepName " +
                            "FROM seller INNER JOIN department " +
                            "ON seller.DepartmentId = department.Id " +
                            "WHERE seller.Id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) { // se teve resultado do banco de dados, temos que converter o ResultSet em um objeto

                Department dep = instantiateDepartment(rs);

                return instantiateSeller(rs, dep);

            }

            return null;


        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        } finally {
            JDBCPostgreSQLConnection.closeStatement(st);
            JDBCPostgreSQLConnection.closeResultSet(rs);
        }

    }

    private Seller instantiateSeller(ResultSet rs, Department dep) throws SQLException {
        Seller obj = new Seller();
        obj.setId(rs.getInt("Id"));
        obj.setName(rs.getString("Name"));
        obj.setEmail(rs.getString("Email"));
        obj.setBaseSalary(rs.getDouble("BaseSalary"));
        obj.setBirthDate(rs.getDate("BirthDate").toLocalDate());
        obj.setDepartment(dep);

        return obj;
    }

    private Department instantiateDepartment(ResultSet rs) throws SQLException {
        Department dep = new Department();
        dep.setId(rs.getInt("DepartmentId"));
        dep.setName("DepName");
        return dep;
    }

    @Override
    public List<Seller> findAll() {
        return null;
    }

    @Override
    public List<Seller> findByDepartment(Department department) {

        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                    "SELECT seller.*,department.Name as DepName " +
                            "FROM seller INNER JOIN department " +
                            "ON seller.DepartmentId = department.id " +
                            "WHERE DepartmentId = ? " +
                            "ORDER BY Name;");
            st.setInt(1, department.getId());
            rs = st.executeQuery();

            List<Seller> sellerList = new ArrayList<>();
            Map<Integer, Department> map = new HashMap<>();

            while (rs.next()) { // se teve resultado do banco de dados, temos que converter o ResultSet em um objeto

                Department dep = map.get(rs.getInt("DepartmentId"));

                if (dep == null) {
                    dep = instantiateDepartment(rs);
                    map.put(rs.getInt("DepartmentId"), dep);
                }


                Seller seller = instantiateSeller(rs, dep);
                sellerList.add(seller);

            }

            return sellerList;


        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        } finally {
            JDBCPostgreSQLConnection.closeStatement(st);
            JDBCPostgreSQLConnection.closeResultSet(rs);
        }

    }
}
