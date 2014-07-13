package ddl_generator.dao.connection;

import static org.junit.Assert.*;

import java.sql.*;

import org.junit.*;

import ddl_generator.dao.*;

public class MySQLConnectionManagerTest {

    @Test
    public void getConnection() {
        Connection conn = null;
        try {
            conn = MySQLConnectionManager.getInstance().getConnection();
        } catch (Exception e) {
            fail();
        } finally {
            DBUtils.closeIfNotNull(conn);
        }

    }

}
