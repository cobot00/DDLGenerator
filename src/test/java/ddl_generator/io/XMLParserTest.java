package ddl_generator.io;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

public class XMLParserTest {

    @Test
    public void parseLevel2() {
        final XMLParser target = new XMLParser();
        final List<Map<String, String>> actual = target.parseLevel2("DBInfo.xml");
        assertThat(actual.size(), is(3));
    }

}
