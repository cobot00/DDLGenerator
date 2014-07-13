package ddl_generator.model;

import ddl_generator.dao.*;
import ddl_generator.dao.facade.*;

public enum DBType {

    ORACLE("oracle") {
        @Override
        public DBFacade createDBFacade() {
            return new OracleFacade();
        }
    },
    MYSQL("mysql") {
        @Override
        public DBFacade createDBFacade() {
            return new MySQLFacade();
        }
    },
    H2("h2") {
        @Override
        public DBFacade createDBFacade() {
            return new H2Facade();
        }
    };

    private final String dbType;

    private DBType(String dbType) {
        this.dbType = dbType;
    }

    public String getDbType() {
        return dbType;
    }

    public static DBType convert(String dbType) {
        for (DBType each : values()) {
            if (each.getDbType().equals(dbType)) {
                return each;
            }
        }

        throw new IllegalArgumentException("dbType = " + dbType);
    }

    public abstract DBFacade createDBFacade();
}
