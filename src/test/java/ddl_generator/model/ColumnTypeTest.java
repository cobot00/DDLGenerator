package ddl_generator.model;


public class ColumnTypeTest {

    //    @Test
    //    public void generateDataType() {
    //        final ColumnInfo varchar = new ColumnInfo("com", ColumnType.VARCHAR);
    //        varchar.setLength(50);
    //        assertThat(varchar.getColumnType().generateDataType(varchar), is("VARCHAR(50)"));
    //
    //        final ColumnInfo intColumn = new ColumnInfo("id", ColumnType.INT);
    //        intColumn.setLength(10);
    //        assertThat(intColumn.getColumnType().generateDataType(intColumn), is("INT(10)"));
    //
    //        final ColumnInfo number = new ColumnInfo("val", ColumnType.NUMBER);
    //        number.setLength(5);
    //        number.setDecimalPart(2);
    //        assertThat(number.getColumnType().generateDataType(number), is("NUMBER(5,2)"));
    //    }
    //
    //    @Test
    //    public void generateColumnDefinition() {
    //        final ColumnInfo varchar = new ColumnInfo("com", ColumnType.VARCHAR);
    //        varchar.setLength(50);
    //        assertThat(varchar.getColumnType().generateColumnDefinition(varchar), is("com VARCHAR(50)"));
    //        varchar.setNotNull();
    //        assertThat(varchar.getColumnType().generateColumnDefinition(varchar), is("com VARCHAR(50) NOT NULL"));
    //
    //        final ColumnInfo intColumn = new ColumnInfo("id", ColumnType.INT);
    //        intColumn.setLength(10);
    //        intColumn.setNotNull();
    //        intColumn.setDefaultValue("0");
    //        assertThat(intColumn.getColumnType().generateColumnDefinition(intColumn), is("id INT(10) DEFAULT 0 NOT NULL"));
    //    }
}
