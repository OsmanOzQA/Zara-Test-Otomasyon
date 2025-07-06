package utilities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TxtUtil {

    private String filePath;

    public TxtUtil(String filePath) {
        this.filePath = filePath;
    }

    // Dosyaya tek satır yazmak için
    public void writeLine(String line) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) { // true => ekleme modu
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Dosyaya birden fazla satır yazmak için
    public void writeLines(java.util.List<String> lines) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   public void writeToFile(String s) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
        writer.write(s);
        writer.newLine();  // satır atlamak için
    } catch (IOException e) {
        e.printStackTrace();
    }
}

}
