package ddl_generator.model;

public enum H2ColumnType {

    VARCHAR("VARCHAR", DataType.STRING), NUMBER("NUMBER", DataType.NUMBER), INT("INT", DataType.NUMBER),
    REAL("REAL", DataType.NUMBER), DECIMAL("DECIMAL", DataType.NUMBER), DATE("DATE", DataType.DATE), TIMESTAMP(
            "TIMESTAMP", DataType.DATE);

    private final String name;
    private final DataType dataType;

    private H2ColumnType(String name, DataType dataType) {
        this.name = name;
        this.dataType = dataType;
    }

    public static H2ColumnType convert(String columnType) {
        for (H2ColumnType each : values()) {
            if (each.toString().equals(columnType)) {
                return each;
            }
        }

        throw new IllegalArgumentException();
    }

    public String getName() {
        return name;
    }

    public DataType getDataType() {
        return dataType;
    }

}
