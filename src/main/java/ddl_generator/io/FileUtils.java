package ddl_generator.io;

import java.io.*;
import java.util.*;

import org.apache.commons.io.*;

import ddl_generator.util.*;

public class FileUtils {

    private FileUtils() {
        // コンストラクタの隠蔽
    }

    public static List<String> searchFiles(String path, String extention) {
        final List<String> result = new ArrayList<String>();

        final File dir = new File(path);
        final File[] files = dir.listFiles();
        if (files == null) {
            return result;
        }

        for (File file : files) {
            if (file.isFile() && getExtention(file.getName()).equals(extention)) {
                result.add(file.getPath());
            }
        }

        return result;
    }

    /**
     * 
     * depend: commons-io-2.4.jar
     * 
     * @param fileName
     * @return
     */
    public static String getExtention(String fileName) {
        return FilenameUtils.getExtension(fileName);
    }

    public static String getFileName(String filePath) {
        return FilenameUtils.getName(filePath);
    }

    public static String makeFilePath(String directory, String fileName, String extention) {
        final StringBuilder sb = new StringBuilder();
        sb.append(directory);
        sb.append(File.separator);
        sb.append(fileName);
        sb.append(extention);

        return sb.toString();
    }

    public static String makeDirectoryString(List<String> dirs) {
        return Utils.unionSeparator(dirs, File.separator);
    }

    public static boolean mkdir(String path) {
        final File directory = new File(path);
        return directory.mkdirs();
    }

    public static boolean rmdir(String path) {
        final File directory = new File(path);
        return directory.delete();
    }
}
