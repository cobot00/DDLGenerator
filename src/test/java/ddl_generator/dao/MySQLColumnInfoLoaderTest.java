package ddl_generator.dao;

import static ddl_generator.AssertWrapper.*;

import java.util.*;

import org.junit.*;

import ddl_generator.dao.connection.*;
import ddl_generator.dao.loader.*;
import ddl_generator.model.dto.*;

public class MySQLColumnInfoLoaderTest {

    @Test
    public void load() {
        final List<String> conditions = Arrays.asList("data_types");
        final MySQLColumnInfoLoader target = new MySQLColumnInfoLoader();
        final List<ColumnInfo> actual = target.load(MySQLConnectionManager.getInstance().getConnection(), conditions);

        assertThatWrapper(actual.size(), 5);
        assertThatWrapper(actual.get(0).getColumnName(), "id");
        assertThatWrapper(actual.get(1).getColumnName(), "name");
        assertThatWrapper(actual.get(2).getColumnName(), "explanation");
        assertThatWrapper(actual.get(3).getColumnName(), "value");
        assertThatWrapper(actual.get(4).getColumnName(), "modified_date");
    }

}
