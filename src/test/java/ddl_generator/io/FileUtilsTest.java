package ddl_generator.io;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.*;
import java.util.*;

import org.junit.*;

public class FileUtilsTest {

    @Test
    public void searchFiles() {
        final List<String> actual = FileUtils.searchFiles("in", "dat");
        assertThat(actual.size(), is(2));

        final List<String> actualEmpty = FileUtils.searchFiles("in" + File.separator + "no_file", "");
        assertThat(actualEmpty.size(), is(0));
    }

    @Test
    public void getExtentions() {
        assertThat(FileUtils.getExtention("hoge.txt"), is("txt"));
        assertThat(FileUtils.getExtention("fuga.csv"), is("csv"));
        assertThat(FileUtils.getExtention("in" + File.separator + "moge.xls"), is("xls"));
    }

    @Test
    public void getFileName() {
        assertThat(FileUtils.getFileName("hoge.txt"), is("hoge.txt"));
        assertThat(FileUtils.getFileName("a" + File.separator + "b" + File.separator + "fuga.csv"), is("fuga.csv"));
        assertThat(FileUtils.getFileName("in" + File.separator + "moge.xls"), is("moge.xls"));
    }

    @Test
    public void mkdir() {
        final String TARGET_PATH = "hoge" + File.separator + "fuga";

        FileUtils.rmdir(TARGET_PATH);
        assertTrue(FileUtils.mkdir(TARGET_PATH));
    }
}
