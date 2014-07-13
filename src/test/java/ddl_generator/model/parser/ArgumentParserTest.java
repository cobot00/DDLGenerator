package ddl_generator.model.parser;

import static ddl_generator.AssertWrapper.*;

import java.io.*;

import org.junit.*;

import ddl_generator.context.*;
import ddl_generator.model.*;

public class ArgumentParserTest {

    private static final String FILE_PATH = "in" + File.separator + "condition" + File.separator + "table.txt";

    @Test
    public void parse() {
        final ArgumentParser target = new ArgumentParser();

        final DDLGeneratorContext actual = target.parse(new String[] { "mysql", "hoge" });
        assertThatWrapper(actual.getDbType(), DBType.MYSQL);
        assertThatWrapper(actual.getTables().size(), 1);
        assertThatWrapper(actual.getTables().get(0), "hoge");

        final DDLGeneratorContext actualMulti = target.parse(new String[] { "mysql", "hoge,fuga" });
        assertThatWrapper(actualMulti.getDbType(), DBType.MYSQL);
        assertThatWrapper(actualMulti.getTables().size(), 2);
        assertThatWrapper(actualMulti.getTables().get(0), "hoge");
        assertThatWrapper(actualMulti.getTables().get(1), "fuga");

        final DDLGeneratorContext actualFile = target.parse(new String[] { "mysql", "-f", FILE_PATH });
        assertThatWrapper(actualFile.getDbType(), DBType.MYSQL);
        assertThatWrapper(actualFile.getTables().size(), 3);
        assertThatWrapper(actualFile.getTables().get(0), "hoge");
        assertThatWrapper(actualFile.getTables().get(1), "fuga");
        assertThatWrapper(actualFile.getTables().get(2), "moge");

    }

}
