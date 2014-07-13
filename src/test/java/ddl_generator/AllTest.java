package ddl_generator;

import org.junit.runner.*;
import org.junit.runners.*;
import org.junit.runners.Suite.SuiteClasses;

import ddl_generator.dao.connection.*;
import ddl_generator.model.*;
import ddl_generator.model.dto.*;
import ddl_generator.model.parser.*;
import ddl_generator.util.*;

@RunWith(Suite.class)
@SuiteClasses({
        /* dao.connection */
        H2ConnectionManagerTest.class,
        MySQLConnectionManagerTest.class,
        /* dao */
        H2DDLGeneratorTest.class,
        /* model.parser */
        ArgumentParserTest.class,
        /* model.dto */
        ColumnInfoTest.class,
        /* model */
        H2DDLGeneratorTest.class,
        MySQLColumnTypeConverterTest.class,
        /* util */
        UtilsTest.class
})
public class AllTest {

}
