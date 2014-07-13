package ddl_generator.dao;

import java.util.*;

import ddl_generator.io.*;
import ddl_generator.model.*;

public class DBInfoFactory {

    private static final DBInfoFactory instance = new DBInfoFactory();

    private static final String XMLURI = "DBInfo.xml";

    private static final String KEY_DBTYPE = "dbtype";
    private static final String KEY_JDBCURL = "jdbcurl";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";

    private final Map<DBType, DBInfo> map;

    private DBInfoFactory() {
        map = createDBInfo();
    }

    public static final DBInfoFactory getInstance() {
        return instance;
    }

    public DBInfo getDBInfo(DBType dbType) {
        return map.get(dbType);
    }

    private Map<DBType, DBInfo> createDBInfo() {
        final Map<DBType, DBInfo> result = new HashMap<DBType, DBInfo>();

        final XMLParser reader = new XMLParser();
        final List<Map<String, String>> values = reader.parseLevel2(XMLURI);
        for (Map<String, String> each : values) {
            final DBInfo dbInfo = new DBInfo(
                    DBType.convert(each.get(KEY_DBTYPE)),
                    each.get(KEY_JDBCURL),
                    each.get(KEY_USERNAME),
                    each.get(KEY_PASSWORD));
            result.put(dbInfo.getDbType(), dbInfo);
        }

        return result;
    }
}
