package jdbc.dao.projetoJdbcDao.model.dao.impl;

import jdbc.dao.projetoJdbcDao.db.DBException;
import jdbc.dao.projetoJdbcDao.db.JDBCPostgreSQLConnection;
import jdbc.dao.projetoJdbcDao.model.dao.SellerDao;
import jdbc.dao.projetoJdbcDao.model.entities.Department;
import jdbc.dao.projetoJdbcDao.model.entities.Seller;

import java.sql.*;
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
    public void insert(Seller seller) {

        PreparedStatement st = null;

        try {
            st = conn.prepareStatement(
                    "INSERT INTO seller "
                            + "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
                            + "VALUES "
                            + "(?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, seller.getName());
            st.setString(2, seller.getEmail());
            st.setDate(3, Date.valueOf(seller.getBirthDate()));
            st.setDouble(4, seller.getBaseSalary());
            st.setInt(5, seller.getDepartment().getId());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {

                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()) {
                    int idCreated = rs.getInt(1);
                    seller.setId(idCreated);
                }
                JDBCPostgreSQLConnection.closeResultSet(rs);
            }
            else {
                throw new DBException("Erro inesperado. No rows affected");
            }


        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        } finally {
            JDBCPostgreSQLConnection.closeStatement(st);
        }

    }

    @Override
    public void update(Seller seller) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement(
                    "UPDATE seller "
                    + "SET Name = ?, Email = ?, BirthDate = ?, BaseSalary = ?, DepartmentId = ? "
                    + "WHERE Id = ?");

            st.setString(1, seller.getName());
            st.setString(2, seller.getEmail());
            st.setDate(3, Date.valueOf(seller.getBirthDate()));
            st.setDouble(4, seller.getBaseSalary());
            st.setInt(5, seller.getDepartment().getId());
            st.setInt(6, seller.getId());

            st.executeUpdate();

        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        } finally {
            JDBCPostgreSQLConnection.closeStatement(st);
        }
    }

    @Override
    public void deleteById(Integer id) {

        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("DELETE FROM seller " +
                    "WHERE Id = ?");
            st.setInt(1, id);
            st.executeUpdate();

        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        } finally {
            JDBCPostgreSQLConnection.closeStatement(st);
        }

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

    @Override
    public Seller findByEmail(String email) {

        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                    "SELECT seller.* " +
                            "FROM seller " +
                            "WHERE seller.Email = ?");
            st.setString(1, email);
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

        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                    "SELECT seller.*,department.Name as DepName " +
                            "FROM seller INNER JOIN department " +
                            "ON seller.DepartmentId = department.id " +
                            "ORDER BY Name;");
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
