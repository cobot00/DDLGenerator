package ddl_generator.model.dto;

import ddl_generator.model.*;

public class ColumnInfo {

    private final String columnName;
    private final H2ColumnType columnType;
    private int length;
    private int decimalPart;
    private boolean isNotNull = false;
    private String defaultValue = "";

    public ColumnInfo(String columnName, H2ColumnType columnType) {
        this.columnName = columnName;
        this.columnType = columnType;
    }

    public String getColumnName() {
        return columnName;
    }

    public H2ColumnType getColumnType() {
        return columnType;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getDecimalPart() {
        return decimalPart;
    }

    public void setDecimalPart(int decimalPart) {
        this.decimalPart = decimalPart;
    }

    public boolean isNotNull() {
        return isNotNull;
    }

    public void setIsNotNull(boolean isNotNull) {
        this.isNotNull = isNotNull;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        if (defaultValue == null) {
            return;
        }

        this.defaultValue = defaultValue;
    }

    public String generateColumnDefinition() {
        final StringBuilder sb = new StringBuilder();

        sb.append(getColumnName());
        sb.append(" ");
        sb.append(generateDataType());
        if (!getDefaultValue().isEmpty()) {
            sb.append(" DEFAULT ");
            sb.append(getDefaultValue());
        }
        if (isNotNull()) {
            sb.append(" NOT NULL");
        }

        return sb.toString();
    }

    String generateDataType() {
        final StringBuilder sb = new StringBuilder();

        sb.append(columnType.getName());
        if (getLength() > 0) {
            sb.append("(");
            sb.append(getLength());
            if (getDecimalPart() > 0) {
                sb.append(",");
                sb.append(getDecimalPart());
            }
            sb.append(")");

        }

        return sb.toString();
    }
}
