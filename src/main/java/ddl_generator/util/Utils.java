package ddl_generator.util;

import java.util.*;

public class Utils {

    public static String unionComma(List<String> elements) {
        return unionSeparator(elements, ",");
    }

    public static String unionSeparator(List<String> elements, String separator) {
        final StringBuilder sb = new StringBuilder();

        sb.append(elements.get(0));
        for (int i = 1; i < elements.size(); i++) {
            sb.append(separator);
            sb.append(elements.get(i));
        }

        return sb.toString();
    }

    public static List<String> split(String value) {
        final String[] values = value.split(",");
        return Arrays.asList(values);
    }

    public static String debugList(List<Object> list) {
        final StringBuilder sb = new StringBuilder();
        for (Object each : list) {
            sb.append(each.toString());
        }

        return sb.toString();
    }
}
