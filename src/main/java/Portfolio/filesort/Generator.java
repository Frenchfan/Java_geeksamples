package Portfolio.filesort;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class Generator {
    /**
     * Generates file with a predefined amount of long
     * @param name name of the file to generate
     * @param count amount of long to generate
     * @return reference to the generated file
     * @throws IOException Input-output exceptions if any problems with the file occur
     */
    public File generate(String name, int count) throws IOException {
        Random random = new Random();
        File file = new File(name);
        try (PrintWriter pw = new PrintWriter(file)) {
            for (int i = 0; i < count; i++) {
                pw.println(random.nextLong());
            }
            pw.flush();
        }
        return file;
    }
}