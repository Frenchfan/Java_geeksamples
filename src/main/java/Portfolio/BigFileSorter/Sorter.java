package Portfolio.BigFileSorter;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Sorter {

    /**
     * Implements sorting of long numerics inside the file using the merge sort algorithm
     * @param dataFile file to sort
     * @return sorted file
     * @throws IOException input-output exceptions if any problems with the file occur
     */
    public File sortFile(File dataFile) throws IOException {

        final int filesCounter = 10;

        int sourceLines;
        try (Stream<String> fileStream = Files.lines(dataFile.toPath())) {
            sourceLines = (int) fileStream.count();
        }
        int linesToWrite = (int) Math.ceil((double) sourceLines / filesCounter);

        splitAndSortParts(dataFile, filesCounter, linesToWrite);

        mergeAndWrite(filesCounter, sourceLines);

        return new File("sortedData.txt");
    }

    private static void mergeAndWrite(int filesCounter, int sourceLines) throws IOException {
        try (BufferedWriter sortedWriter = new BufferedWriter(new FileWriter("sortedData.txt"))) {

            BufferedReader[] readers = new BufferedReader[filesCounter];
            long[] temp = new long[filesCounter];
            boolean[] openStatus = new boolean[filesCounter];
            File[] files = new File[filesCounter];
            for (int i = 0; i < filesCounter; i++) {
                files[i] = new File(i + ".txt");
                readers[i] = new BufferedReader(new FileReader(files[i]));
                temp[i] = Long.parseLong(readers[i].readLine());
                openStatus[i] = true;
            }

            for (int i = 0; i < sourceLines; i++) {
                int fileNumber = indexMin(temp, openStatus);
                sortedWriter.write(temp[fileNumber] + "\r\n");
                String line = readers[fileNumber].readLine();
                if (line == null) {
                    openStatus[fileNumber] = false;
                } else {
                    temp[fileNumber] = Long.parseLong(line);
                }
            }

            for (int i = 0; i < filesCounter; i++) {
                readers[i].close();
                if (!files[i].delete()) {
                    System.out.println("Could not delete temporary files");
                }
            }
        }
    }

    private static void splitAndSortParts(File dataFile, int filesCounter, int linestoWrite) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(dataFile))) {
            for (int i = 0; i < filesCounter; i++) {
                List<Long> lines = new ArrayList<>(linestoWrite);
                String line;
                while (lines.size() < linestoWrite && (line = reader.readLine()) != null) {
                    lines.add(Long.parseLong(line));
                }
                Collections.sort(lines);

                try (BufferedWriter targetWriter = new BufferedWriter(new FileWriter(i + ".txt"))) {
                    for (Long l : lines) {
                        targetWriter.write(l + "\n");
                    }
                }
            }
        }
    }

    static int indexMin(long[] array, boolean[] isOpen) {
        int min = 0;
        for (int i = 0; i < array.length; i++) {
            if (isOpen[i]) {
                min = i;
                break;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (isOpen[i] && array[i] < array[min]) {
                min = i;
            }
        }
        return min;
    }
}
