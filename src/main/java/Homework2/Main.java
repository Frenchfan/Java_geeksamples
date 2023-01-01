package Homework2;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    static {
        try (FileInputStream ins = new FileInputStream("C:\\Users\\sumki\\IdeaProjects\\JSamples\\src\\main\\java\\Homework2\\logging.properties"))
        {
            LogManager.getLogManager().readConfiguration(ins);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IllegalAccessException, FileNotFoundException {
        String jsonString = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":null}";
        String jsonString2 = "{\"name\":\"Иванов\", \"grade\":\"5\", \"subject\":\"Математика\"}";
        System.out.println(sqlRequest(jsonString));
        int[] myArray = new int[] {5, 2, 7, 4, 0};

        bubbleSort(myArray);
        readJSON(jsonString2);
        System.out.println("Задача 4 - калькулятор с логированием");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первое число:");
        int number1 = scanner.nextInt();
        System.out.println("Введите операцию (+ - * или /)");
        String operation = scanner.next();
        System.out.println("Введите второе число:");
        int number2 = scanner.nextInt();
        System.out.println("Результат операции: " + myCalc(number1, number2, operation));

    }

    /**
     * Реализуйте алгоритм сортировки пузырьком числового массива,
     * результат после каждой итерации запишите в лог-файл
     */
    private static void bubbleSort(int[] myArray) {
        for (int i = myArray.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (myArray[j] > myArray[j + 1]) {
                    int temp = myArray[j];
                    myArray[j] = myArray[j + 1];
                    myArray[j + 1] = temp;
                    logger.info("Another iteration of the bubble sorting" + Arrays.toString(myArray));
                }
            }
        }
        logger.info("Final iteration of the bubble sorting" + Arrays.toString(myArray));
        System.out.println("Task 2 - bubble-sorted Array + logging: " + Arrays.toString(myArray));
    }

    /**
     * Дана строка sql-запроса "select * from students where ".
     * Сформируйте часть WHERE этого запроса, используя StringBuilder.
     * Данные для фильтрации приведены ниже в виде json строки.
     * Если значение null, то параметр не должен попадать в запрос.     *
     * Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
     */

    public static void readJSON(String jsonString) throws FileNotFoundException {
        JsonReader reader = new JsonReader(new FileReader("C:\\Users\\sumki\\IdeaProjects\\JSamples\\src\\main\\java\\Homework2\\task3.json"));
        Grades[] grades = new Gson().fromJson(reader, Grades[].class);
        for (Grades grade: grades) {
            System.out.println("Студент(ка) " + grade.name + " получил(а) " + grade.grade + " по предмету " + grade.subject);
        }
    }

    public static StringBuilder sqlRequest(String jsonString) throws IllegalAccessException {
        Gson gson = new Gson();
        StringBuilder result = new StringBuilder("select * from students where ");
        Person person = gson.fromJson(jsonString, Person.class);
        for(Field f: person.getClass().getFields() ) {
            f.setAccessible(true);
            if (f.get(person) != null) {
                //для sql запросов нужно добавлять ' или " при текстовых значениях параметров
                if (f.getType() == String.class) {
                    result.append(f.getName()).append(" = '").append(f.get(person)).append("' and ");
                } else {
                    //а для числовых значений ' или " не нужны - эта проверка
                    // корректно отобразит запрос, если возраст не null
                    result.append(f.getName()).append(" = ").append(f.get(person)).append(" and ");
                }
            }
        }
        result.setLength(result.length() - 4);
        //обрезаем and в конце запроса
        return result;
    }

    /**
     * Калькулятор из предыдущей домашки с логированием
     */

    public static double myCalc(int number1, int number2, String operation) {
        switch (operation) {
            case "+": { int result = number1 + number2;
                logger.info("Калькулятор: " + number1 + " + " + number2 + " = " + result);
                return number1 + number2;}
            case "-": {int result = number1 - number2;
            logger.info("Калькулятор: " + number1 + " - " + number2 + " = " + result);
            return number1 - number2;}
            case "*": {int result = number1 * number2;
                logger.info("Калькулятор: " + number1 + " * " + number2 + " = " + result);
                return number1 * number2;}
            case "/": {int result = number1 / number2;
                logger.info("Калькулятор: " + number1 + " / " + number2 + " = " + result);
                return number1 / number2;}
        }
        return 0;
    }






}
