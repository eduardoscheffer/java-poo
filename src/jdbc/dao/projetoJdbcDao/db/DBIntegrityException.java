package jdbc.dao.projetoJdbcDao.db;

public class DBIntegrityException extends RuntimeException{
    public DBIntegrityException(String message) {
        super(message);
    }
}
