package ddl_generator.dao.connection;

import java.sql.*;

import ddl_generator.dao.*;
import ddl_generator.model.*;

public class OracleConnectionManager implements ConnectionManager {

    private static OracleConnectionManager instance = new OracleConnectionManager();

    private final DBInfo dbInfo;

    private OracleConnectionManager() {
        dbInfo = DBInfoFactory.getInstance().getDBInfo(DBType.ORACLE);
    }

    public static OracleConnectionManager getInstance() {
        return instance;
    }

    @Override
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
