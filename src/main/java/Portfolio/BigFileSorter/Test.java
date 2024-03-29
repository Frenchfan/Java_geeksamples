package Portfolio.BigFileSorter;

import java.io.File;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        //File dataFile = new Generator().generate("data.txt", 375_000_000); //с большим файлом тоже работает
        File dataFile = new Generator().generate("data.txt", 8_000);

        System.out.println(new Validator(dataFile).isSorted()); // false
        File sortedFile = new Sorter().sortFile(dataFile);
        System.out.println(new Validator(sortedFile).isSorted()); // true
    }
}
