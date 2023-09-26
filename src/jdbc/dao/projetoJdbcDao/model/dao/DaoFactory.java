package jdbc.dao.projetoJdbcDao.model.dao;

import jdbc.dao.projetoJdbcDao.model.dao.impl.SellerDaoJDBC;

public class DaoFactory {

    public static SellerDao createSellerDao(){
        return new SellerDaoJDBC();
    }

}
