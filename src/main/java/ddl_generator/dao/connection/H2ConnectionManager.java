package ddl_generator.dao.connection;

import java.sql.*;

import ddl_generator.dao.*;
import ddl_generator.model.*;

public class H2ConnectionManager implements ConnectionManager {

    private static H2ConnectionManager instance = new H2ConnectionManager();

    private final DBInfo dbInfo;

    private H2ConnectionManager() {
        dbInfo = DBInfoFactory.getInstance().getDBInfo(DBType.H2);
    }

    public static H2ConnectionManager getInstance() {
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
