package ddl_generator.dao;

import java.sql.*;

public class DBUtils {

    private DBUtils() {
        // コンストラクタの隠蔽
    }

    public static void closeIfNotNull(Connection conn) {
        if (conn == null) {
            return;
        }

        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeIfNotNull(PreparedStatement ps) {
        if (ps == null) {
            return;
        }

        try {
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
