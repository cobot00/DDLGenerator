package ddl_generator.dao.connection;

import static org.junit.Assert.*;

import java.sql.*;

import org.junit.*;

import ddl_generator.dao.*;

public class H2ConnectionManagerTest {

    @Test
    public void getConnection() {
        Connection conn = null;
        try {
            conn = H2ConnectionManager.getInstance().getConnection();
        } catch (Exception e) {
            fail();
        } finally {
            DBUtils.closeIfNotNull(conn);
        }

    }

}
