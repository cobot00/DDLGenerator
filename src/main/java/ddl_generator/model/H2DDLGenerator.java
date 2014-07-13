package ddl_generator.model;

import java.util.*;

import ddl_generator.model.dto.*;
import ddl_generator.util.*;

public class H2DDLGenerator {

    public String generateCreateTable(String tableName, List<ColumnInfo> columns) {
        final List<String> columnDefinitions = new ArrayList<String>();
        for (ColumnInfo column : columns) {
            columnDefinitions.add(Constant.NEW_LINE + "  " + column.generateColumnDefinition());
        }

        final StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE ");
        sb.append(tableName);
        sb.append("(");
        sb.append(Utils.unionComma(columnDefinitions));
        sb.append(");");

        return sb.toString();
    }

    public String generatePrimaryKey(String tableName, List<String> primaryKeys) {
        final StringBuilder sb = new StringBuilder();

        sb.append("ALTER TABLE ");
        sb.append(tableName);
        sb.append(" ADD PRIMARY KEY(");
        sb.append(Utils.unionComma(primaryKeys));
        sb.append(")");

        return sb.toString();
    }
}
