package ddl_generator.model;

import java.util.*;

public final class MySQLColumnTypeConverter {

    static final String VARCHAR = "varchar";
    static final String INT = "int";
    static final String TINYINT = "tinyint";
    static final String FLOAT = "float";
    static final String DOUBLE = "double";
    static final String DATE = "date";
    static final String DATETIME = "datetime";
    static final String TIMESTAMP = "timestamp";

    private static final List<TypeConverter> typeConverters = Arrays.asList(
            new TypeConverter(VARCHAR, H2ColumnType.VARCHAR),
            new TypeConverter(INT, H2ColumnType.INT),
            new TypeConverter(TINYINT, H2ColumnType.INT),
            new TypeConverter(FLOAT, H2ColumnType.DECIMAL),
            new TypeConverter(DOUBLE, H2ColumnType.DECIMAL),
            new TypeConverter(DATE, H2ColumnType.DATE),
            new TypeConverter(DATETIME, H2ColumnType.TIMESTAMP),
            new TypeConverter(TIMESTAMP, H2ColumnType.TIMESTAMP)
            );

    private MySQLColumnTypeConverter() {
        // コンストラクタの隠蔽
    }

    public static H2ColumnType convert(String dataType) {
        for (TypeConverter each : typeConverters) {
            if (dataType.equals(each.getDataType())) {
                return each.getH2ColumnType();
            }
        }

        throw new IllegalArgumentException("dataType = " + dataType);
    }
}
