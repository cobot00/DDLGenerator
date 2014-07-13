package ddl_generator.dao.loader;

import java.sql.*;
import java.util.*;

import ddl_generator.dao.*;

public abstract class SimpleListLoader<E, E2> {

    public List<E> load(Connection conn) {
        return load(conn, null);
    }

    public List<E> load(Connection conn, List<E2> conditions) {
        final List<E> result = new ArrayList<E>();

        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(getSql());
            setParameters(ps, conditions);
            final ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                result.add(createEntity(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeIfNotNull(ps);
        }

        return result;
    }

    protected abstract String getSql();

    protected void setParameters(PreparedStatement ps, List<E2> conditions) throws SQLException {
        // if you need override
    }

    protected abstract E createEntity(ResultSet rs) throws SQLException;
}
