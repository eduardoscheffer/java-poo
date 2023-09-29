package jdbc.dao.projetoJdbcDao.model.dao;

import jdbc.dao.projetoJdbcDao.db.JDBCPostgreSQLConnection;
import jdbc.dao.projetoJdbcDao.model.dao.impl.DepartmentDaoJDBC;
import jdbc.dao.projetoJdbcDao.model.dao.impl.SellerDaoJDBC;

public class DaoFactory {

    public static SellerDao createSellerDao(){
        return new SellerDaoJDBC(JDBCPostgreSQLConnection.connect());
    }

    public static DepartmentDao createDepartmentDao() {
        return new DepartmentDaoJDBC(JDBCPostgreSQLConnection.connect());
    }

}
