package ddl_generator.model.dto;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.*;

import ddl_generator.model.*;

public class ColumnInfoTest {

    @Test
    public void generateDataType() {
        final ColumnInfo varchar = new ColumnInfo("com", H2ColumnType.VARCHAR);
        varchar.setLength(50);
        assertThat(varchar.generateDataType(), is("VARCHAR(50)"));

        final ColumnInfo intColumn = new ColumnInfo("id", H2ColumnType.INT);
        intColumn.setLength(10);
        assertThat(intColumn.generateDataType(), is("INT(10)"));

        final ColumnInfo number = new ColumnInfo("val", H2ColumnType.NUMBER);
        number.setLength(5);
        number.setDecimalPart(2);
        assertThat(number.generateDataType(), is("NUMBER(5,2)"));
    }

    @Test
    public void generateColumnDefinition() {
        final ColumnInfo varchar = new ColumnInfo("com", H2ColumnType.VARCHAR);
        varchar.setLength(50);
        assertThat(varchar.generateColumnDefinition(), is("com VARCHAR(50)"));
        varchar.setIsNotNull(true);
        assertThat(varchar.generateColumnDefinition(), is("com VARCHAR(50) NOT NULL"));

        final ColumnInfo intColumn = new ColumnInfo("id", H2ColumnType.INT);
        intColumn.setLength(10);
        intColumn.setIsNotNull(true);
        intColumn.setDefaultValue("0");
        assertThat(intColumn.generateColumnDefinition(), is("id INT(10) DEFAULT 0 NOT NULL"));
    }

}
