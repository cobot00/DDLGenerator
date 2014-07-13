package ddl_generator.dao.connection;

import java.sql.*;

import ddl_generator.dao.*;
import ddl_generator.model.*;

public class MySQLConnectionManager implements ConnectionManager {

    private static MySQLConnectionManager instance = new MySQLConnectionManager();

    private final DBInfo dbInfo;

    private MySQLConnectionManager() {
        dbInfo = DBInfoFactory.getInstance().getDBInfo(DBType.MYSQL);
    }

    public static MySQLConnectionManager getInstance() {
        return instance;
    }

    public Connection getConnection() {
        Connection result = null;
        try {
            result = DriverManager.getConnection(
                    dbInfo.getJdbcUrl(),
                    dbInfo.getUserName(),
                    dbInfo.getPassWord());
            //System.out.println("Connection Get");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("DB ACCESS ERROR");
        }
        return result;
    }
}
