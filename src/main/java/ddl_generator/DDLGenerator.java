package ddl_generator;

import ddl_generator.context.*;
import ddl_generator.facade.*;
import ddl_generator.model.parser.*;

public class DDLGenerator {

    public static void main(String[] args) {
        final DDLGeneratorContext context = new ArgumentParser().parse(args);
        final H2DDLGeneratorFacade facade = new H2DDLGeneratorFacade();
        facade.execute(context);
    }
}
