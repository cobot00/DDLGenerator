package ddl_generator.context;

import java.util.*;

import ddl_generator.model.*;

public class DDLGeneratorContext {

    private final DBType dbType;
    private final List<String> tables;

    public DDLGeneratorContext(DBType dbType, List<String> tables) {
        this.dbType = dbType;
        this.tables = tables;
    }

    public DBType getDbType() {
        return dbType;
    }

    public List<String> getTables() {
        return tables;
    }

}
