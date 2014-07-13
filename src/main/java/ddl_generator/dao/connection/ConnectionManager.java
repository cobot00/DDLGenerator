package ddl_generator.dao.connection;

import java.sql.*;

public interface ConnectionManager {

    Connection getConnection();
}
