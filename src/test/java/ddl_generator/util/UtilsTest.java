package ddl_generator.util;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

public class UtilsTest {

    @Test
    public void unionComma() {
        assertThat(Utils.unionComma(Arrays.asList("1", "2", "3")), is("1,2,3"));
        assertThat(Utils.unionComma(Arrays.asList("a")), is("a"));
    }

}
