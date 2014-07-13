package ddl_generator.io;

import java.io.*;
import java.util.*;

public class TextFileWriter {

    public void write(String filePath, List<String> lines) {
        try {
            final File file = new File(filePath);
            final BufferedWriter br = new BufferedWriter(new FileWriter(file));

            for (String line : lines) {
                br.write(line);
                br.newLine();
            }
            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
