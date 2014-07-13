package ddl_generator.model;

public final class TypeConverter {

    private final String dataType;
    private final H2ColumnType H2ColumnType;

    public TypeConverter(String dataType, H2ColumnType columnType) {
        this.dataType = dataType;
        this.H2ColumnType = columnType;
    }

    public String getDataType() {
        return dataType;
    }

    public H2ColumnType getH2ColumnType() {
        return H2ColumnType;
    }

}
