package ddl_generator;

import org.junit.*;

public class H2DDLGeneratorTest {

    @Test
    public void main() {
        DDLGenerator.main(new String[] { "mysql", "data_types" });
    }

}
