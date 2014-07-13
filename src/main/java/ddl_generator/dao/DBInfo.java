package ddl_generator.dao;

import ddl_generator.model.*;

public class DBInfo {

    private final DBType dbType;
    private final String jdbcUrl;
    private final String userName;
    private final String passWord;

    DBInfo(DBType dbType, String jdbcUrl, String userName, String passWord) {
        this.dbType = dbType;
        this.jdbcUrl = jdbcUrl;
        this.userName = userName;
        this.passWord = passWord;
    }

    public DBType getDbType() {
        return dbType;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

}
