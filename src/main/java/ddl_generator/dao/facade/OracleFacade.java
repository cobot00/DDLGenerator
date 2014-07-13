package ddl_generator.dao.facade;

import java.sql.*;

import ddl_generator.dao.*;
import ddl_generator.dao.connection.*;
import ddl_generator.dao.loader.*;
import ddl_generator.model.dto.*;

public class OracleFacade implements DBFacade {

    private final Connection conn = OracleConnectionManager.getInstance().getConnection();

    @Override
    public Connection getConnection() {
        return conn;
    }

    @Override
    public void closeConnection() {
        DBUtils.closeIfNotNull(conn);
    }

    @Override
    public SimpleListLoader<ColumnInfo, String> createLoader() {
        return new MySQLColumnInfoLoader();
    }

}
