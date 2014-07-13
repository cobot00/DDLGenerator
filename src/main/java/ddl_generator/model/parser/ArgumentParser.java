package ddl_generator.model.parser;

import java.util.*;

import ddl_generator.context.*;
import ddl_generator.io.*;
import ddl_generator.model.*;
import ddl_generator.util.*;

public class ArgumentParser {

    private static final int MIN_ARGUMENT_NUMBER = 2;

    private static final int DB_TYPE = 0;

    public DDLGeneratorContext parse(String[] args) {
        if (args.length < MIN_ARGUMENT_NUMBER) {
            throw new IllegalArgumentException("need 2 arguments");
        }

        final DBType dbType = DBType.convert(args[DB_TYPE]);
        final ArgumentType conditionType = (args.length == 2) ? ArgumentType.TABLE : ArgumentType.FILE;

        List<String> conditions;
        if (conditionType.equals(ArgumentType.TABLE)) {
            conditions = Utils.split(args[1]);
        } else if (conditionType.equals(ArgumentType.FILE)) {
            conditions = read(args[2]);
        } else {
            throw new IllegalArgumentException();
        }

        System.out.println("dbType = " + dbType);
        System.out.println("conditionType = " + conditionType);
        System.out.println("conditions = " + Utils.unionComma(conditions));

        return new DDLGeneratorContext(dbType, conditions);
    }

    private List<String> read(String filePath) {
        final TextFileReader reader = new TextFileReader();
        return reader.read(filePath);
    }
}
