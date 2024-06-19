package utils;

import java.io.FileWriter;
import java.io.IOException;

public class CsvExportUtil {
    
    public static void exportCsv(String filename, String content) {
        try {
            FileWriter writer = new FileWriter(filename);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
