package Seminar2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {

    private static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        int n = askforN("Введите положительное число: ");
        System.out.println(myLine(n, "+", "-"));
        String myLine = askforLine("Введите строку для сокращения: ");
        System.out.println(shortLine(myLine));
        String myLine2 = askforLine("Введите строку-палиндром: ");
        System.out.println(isPalyndrom(myLine2));
        createTestString();
        checkFileFolder();
    }

    /**
     * Дано четное число N (>0) и символы c1 и c2.
     * Написать метод, который вернет строку длины N,
     * которая состоит из чередующихся символов c1 и c2, начиная с c1
     */
    public static int askforN(String message) {
        Scanner scanner = new Scanner(System.in);
        int result = 0;
        do {
            try {
                // Get input
                System.out.println(message);
                result = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Это не число");
            }
            scanner.nextLine(); // clears the buffer
        } while (result <= 0);
        return result;
    }

    public static String askforLine(String message) {
        Scanner scanner = new Scanner(System.in);
        String result = null;
        do {
            try{
                System.out.println(message);
                result = scanner.nextLine();
                if (("").equals(result)) throw new InputMismatchException();
            } catch (InputMismatchException e) {
                System.out.println("Нужно ввести непустую строку");
            }
        } while (result == null || ("").equals(result));
        return result;
    }
    public static StringBuilder myLine(int n, String c1, String c2) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if(i % 2 == 0) result.append(c1);
            else result.append(c2);
        }
        return result;
    }

    /**
     * Напишите метод, который сжимает строку. Пример: вход aaaabbbcdd станет a4b3c1d2
     */

    public static StringBuilder shortLine(String myLine) {
        StringBuilder result = new StringBuilder();
        int runLen = 1;
        char runChar = myLine.charAt(0);
        // нужен именно char, иначе будет добавлен номер символа в кодировке

        for (int i = 1; i < myLine.length(); i++) {
            if (myLine.charAt(i) == runChar) ++runLen;
            else {
                result.append(runChar).append(runLen);
                runLen = 1;
                runChar = myLine.charAt(i);
            }
        }
        result.append(runChar).append(runLen);
        System.out.println(result);
        return result;
    }
    /**
     * Напишите метод, который принимает на вход строку (String)
     * и определяет является ли строка палиндромом (возвращает boolean значение).
     */

    public static boolean isPalyndrom(String myLine) {
        StringBuilder sb = new StringBuilder(myLine);
        return sb.toString().equals(sb.reverse().toString());
    }

    /**
     * Напишите метод, который составит строку,
     * состоящую из 100 повторений слова TEST и метод,
     * который запишет эту строку в простой текстовый файл, обработайте исключения.
     */


    public static void createTestString() {
        String str = "TEST".repeat(100);
        try (PrintWriter out = new PrintWriter("testWrite.txt")) {
            out.println(str);
            int a = 1 / 0;
            System.out.println(a);
        }catch (ArithmeticException e) {
            System.out.println("Делить на ноль нельзя!");
        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Напишите метод, который вернет содержимое
     * текущей папки в виде массива строк. Напишите метод, который запишет массив,
     * возвращенный предыдущим методом в файл.
     * Обработайте ошибки с помощью try-catch конструкции.
     * В случае возникновения исключения, оно должно записаться в лог-файл.
     */

    public static void checkFileFolder() {
        File file = new File("C:\\");
        ArrayList<File> files = new ArrayList<>(Arrays.asList(file.listFiles()));

        try(PrintWriter out = new PrintWriter("fileFolders.txt")) {
            out.println(files);
            logger.info("Содержимое текущих папок записано в файл fileFolders.txt");
        }catch (FileNotFoundException e) {
            logger.info(e.getMessage());
        }
    }


}
