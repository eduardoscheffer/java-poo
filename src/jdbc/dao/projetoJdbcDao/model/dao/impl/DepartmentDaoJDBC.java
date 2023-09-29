package jdbc.dao.projetoJdbcDao.model.dao.impl;

import jdbc.dao.projetoJdbcDao.db.DBException;
import jdbc.dao.projetoJdbcDao.db.JDBCPostgreSQLConnection;
import jdbc.dao.projetoJdbcDao.model.dao.DepartmentDao;
import jdbc.dao.projetoJdbcDao.model.entities.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDao {

    private Connection conn;

    public DepartmentDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Department department) {

    }

    @Override
    public void update(Department department) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Department findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT * FROM department WHERE iD = ?");
            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) { // se teve resultado do banco de dados, temos que converter o ResultSet em um objeto

                return instantiateDepartment(rs);

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
    public List<Department> findAll() {
        return null;
    }

    private Department instantiateDepartment(ResultSet rs) throws SQLException {
        Department dep = new Department();
        dep.setId(rs.getInt("Id"));
        dep.setName(rs.getString("Name"));
        return dep;
    }
}
