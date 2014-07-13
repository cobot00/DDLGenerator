package ddl_generator.dao.loader;

import java.sql.*;
import java.util.*;

import ddl_generator.model.*;
import ddl_generator.model.dto.*;

public class MySQLColumnInfoLoader extends SimpleListLoader<ColumnInfo, String> {

    private static final String COLUMN_NAME = "COLUMN_NAME";
    private static final String DATA_TYPE = "DATA_TYPE";
    private static final String COLUMN_DEFAULT = "COLUMN_DEFAULT";
    private static final String IS_NULLABLE = "IS_NULLABLE";
    private static final String CHARACTER_MAXIMUM_LENGTH = "CHARACTER_MAXIMUM_LENGTH";
    private static final String NUMERIC_PRECISION = "NUMERIC_PRECISION";
    private static final String NUMERIC_SCALE = "NUMERIC_SCALE";

    @Override
    protected String getSql() {
        final StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append("table_name, ordinal_position, column_name, data_type,");
        sb.append("column_default, is_nullable, character_maximum_length,");
        sb.append("numeric_precision, numeric_scale ");
        sb.append("FROM INFORMATION_SCHEMA.COLUMNS ");
        sb.append("WHERE table_name = ? ");
        sb.append("ORDER BY table_name, ordinal_position");

        return sb.toString();
    }

    @Override
    protected void setParameters(PreparedStatement ps, List<String> conditions) throws SQLException {
        int index = 0;
        ps.setString(++index, conditions.get(0));
    }

    @Override
    protected ColumnInfo createEntity(ResultSet rs) throws SQLException {
        final H2ColumnType columnType = MySQLColumnTypeConverter.convert(rs.getString(DATA_TYPE));

        final ColumnInfo result = new ColumnInfo(rs.getString(COLUMN_NAME), columnType);
        result.setIsNotNull(rs.getString(IS_NULLABLE).equals("NO"));
        result.setDefaultValue(rs.getString(COLUMN_DEFAULT));
        result.setLength(getDataLength(columnType, rs));
        result.setDecimalPart(getDecimalPlace(columnType, rs));

        return result;
    }

    private int getDataLength(H2ColumnType columnType, ResultSet rs) throws SQLException {
        switch (columnType.getDataType()) {
        case NUMBER:
            return rs.getInt(NUMERIC_PRECISION);
        case STRING:
            return rs.getInt(CHARACTER_MAXIMUM_LENGTH);
        default:
            return 0;
        }
    }

    private int getDecimalPlace(H2ColumnType columnType, ResultSet rs) throws SQLException {
        switch (columnType.getDataType()) {
        case NUMBER:
            return rs.getInt(NUMERIC_SCALE);
        default:
            return 0;
        }
    }
}
