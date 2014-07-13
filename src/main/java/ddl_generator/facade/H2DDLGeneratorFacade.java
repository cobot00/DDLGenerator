package ddl_generator.facade;

import java.io.*;
import java.util.*;

import ddl_generator.context.*;
import ddl_generator.dao.*;
import ddl_generator.dao.facade.*;
import ddl_generator.dao.loader.*;
import ddl_generator.io.*;
import ddl_generator.model.*;
import ddl_generator.model.dto.*;

public class H2DDLGeneratorFacade {

    private static final String DDL_OUT_DIR = "ddl" + File.separator + "h2";
    private static final String EXTENTION = ".sql";

    public void execute(DDLGeneratorContext context) {
        final DBFacade facade = context.getDbType().createDBFacade();

        try {
            for (String tableName : context.getTables()) {
                final SimpleListLoader<ColumnInfo, String> loader = facade.createLoader();
                final List<ColumnInfo> columnInfos = loader.load(facade.getConnection(),
                        Arrays.asList(tableName));

                final H2DDLGenerator generator = new H2DDLGenerator();
                final String ddl = generator.generateCreateTable(tableName, columnInfos);
                System.out.println(ddl);

                final String filePath = FileUtils.makeFilePath(DDL_OUT_DIR, tableName, EXTENTION);
                final TextFileWriter writer = new TextFileWriter();
                writer.write(filePath, Arrays.asList(ddl));
            }
        } finally {
            facade.closeConnection();
        }

    }
}
