package ddl_generator.dao.facade;

import java.sql.*;

import ddl_generator.dao.*;
import ddl_generator.dao.loader.*;
import ddl_generator.model.dto.*;

public interface DBFacade {

    Connection getConnection();

    SimpleListLoader<ColumnInfo, String> createLoader();

    void closeConnection();
}
