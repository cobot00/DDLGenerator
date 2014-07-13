package ddl_generator.io;

import java.io.*;
import java.util.*;

public class TextFileReader {

    public List<String> read(String filePath) {
        final List<String> result = new ArrayList<String>();

        try {
            final File file = new File(filePath);
            final BufferedReader br = new BufferedReader(new FileReader(file));

            String line = "";
            while ((line = br.readLine()) != null) {
                result.add(line);
            }
            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

        return result;
    }
}
