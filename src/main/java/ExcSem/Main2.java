package ExcSem;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/** Для ДЗ
 * Строки, состоящие из последовательностей цифр,
 * формируются следующим образом. Первая строка состоит из
 * четырех единиц. Каждая из последующих строк создается
 * следующим действием: берется предыдущая строка и после
 * каждой ее цифры вставляется цифра на единицу большая. Вот
 * первые 3 строки, созданные по этому правилу:
 * (1) 1111
 * (2) 12121212
 * (3) 1223122312231223
 * Сколько цифр 5 и сколько цифр 7 будет в строке с номером
 * (9)?
 * В ответе укажите через пробел два целых числа: сначала
 * количество цифр 5 в девятой строке, а затем количество цифр
 * 7 в девятой строке.
 */

/**
 * Запишите в файл следующие строки:
 * Анна=4
 * Елена=5
 * Марина=6
 * Владимир=?
 * Константин=?
 * Иван=4
 * Реализуйте метод, который считывает данные из файла и сохраняет в двумерный массив
 * (либо HashMap, если студенты с ним знакомы). В отдельном методе нужно будет пройти
 * по структуре данных, если сохранено значение ?, заменить его на соответствующее число.
 * Если на каком-то месте встречается символ, отличный от числа или ?,
 * бросить подходящее исключение. Записать в тот же файл данные с замененными символами ?.
 * 280 5-рок и 112 семерок (7) - должно получиться
 */
public class Main2 {
    public static void main(String[] args) {
        Map<String, Integer> result = new HashMap<>();
        File file = new File("text.txt");
        result = readFile(file);
        writeFile(file, result);

        try (Counter myCounter = new Counter()) {
            myCounter.add();
            System.out.println(myCounter.getIndex());
        } catch (MyException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            Counter myCounter = new Counter();
            myCounter.close();
            myCounter.add();
            System.out.println(myCounter.getIndex());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Map<String, Integer> readFile (File file) {
        Map<String, Integer> result = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lines = line.split("=");
                int index = 0;
                try {
                    index = Integer.parseInt(lines[1]);
                } catch (NumberFormatException e) {
                    index = lines[0].length();
                } finally {
                    result.put(lines[0], index);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public static void writeFile (File file, Map<String, Integer> result) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String key: result.keySet()) {
                writer.write(key + "=" + result.get(key) + '\n');
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
