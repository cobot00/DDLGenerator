package ddl_generator.model;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.*;

public class MySQLColumnTypeConverterTest {

    @Test
    public void convert() {
        assertThat(MySQLColumnTypeConverter.convert(MySQLColumnTypeConverter.VARCHAR), is(H2ColumnType.VARCHAR));
        assertThat(MySQLColumnTypeConverter.convert(MySQLColumnTypeConverter.INT), is(H2ColumnType.INT));
        assertThat(MySQLColumnTypeConverter.convert(MySQLColumnTypeConverter.DATE), is(H2ColumnType.DATE));
        assertThat(MySQLColumnTypeConverter.convert(MySQLColumnTypeConverter.TIMESTAMP), is(H2ColumnType.TIMESTAMP));

    }

}
