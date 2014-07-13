package ddl_generator.io;

import java.util.*;

import org.junit.*;

public class TextFileWriterTest {

    @Test
    public void write() {
        final TextFileWriter target = new TextFileWriter();

        final List<String> lines = Arrays.asList("1", "2", "hoge");
        target.write("out\\test.txt", lines);
    }

}
