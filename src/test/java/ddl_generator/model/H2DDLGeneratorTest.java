package ddl_generator.model;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

import ddl_generator.model.dto.*;

public class H2DDLGeneratorTest {

    private static final String NEW_LINE = System.getProperty("line.separator");

    private static final String CREATE_TABLE_HOGE = "CREATE TABLE hoge(" + NEW_LINE
            + "  id INT(10) DEFAULT 0 NOT NULL," + NEW_LINE
            + "  com VARCHAR(200)" +
            ");";

    @Test
    public void generateCreateTable() {
        final ColumnInfo intColumn = new ColumnInfo("id", H2ColumnType.INT);
        intColumn.setLength(10);
        intColumn.setIsNotNull(true);
        intColumn.setDefaultValue("0");

        final ColumnInfo varchar = new ColumnInfo("com", H2ColumnType.VARCHAR);
        varchar.setLength(200);

        final List<ColumnInfo> columns = Arrays.asList(intColumn, varchar);

        final H2DDLGenerator target = new H2DDLGenerator();
        final String actual = target.generateCreateTable("hoge", columns);

        assertThat(actual, is(CREATE_TABLE_HOGE));
    }

    @Test
    public void test() {
        final H2DDLGenerator target = new H2DDLGenerator();
        final String actual = target.generatePrimaryKey("hoge", Arrays.asList("id"));
        assertThat(actual, is("ALTER TABLE hoge ADD PRIMARY KEY(id)"));
    }

}
