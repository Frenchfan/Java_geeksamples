package Bell_Test;

import java.util.*;
import java.util.function.Function;

public class Main {

    public static List<Map<String, String>> myList = new ArrayList<>(List.of(
            new HashMap<>(Map.of(
                    "name", "Кирилл", "age", "26", "position", "Middle java dev",
                    "salary", "150000", "currency", "rub"
            )),
            new HashMap<>(Map.of(
                    "name", "Виталий", "age", "28", "position",
                    "Senior java automation QA", "salary", "2000", "currency", "USD"
            )),
            new HashMap<>(Map.of(
                    "name", "Александр", "age", "31", "position",
                    "Junior functional tester", "salary", "50000", "currency", "rub"
            )),
            new HashMap<>(Map.of(
                    "name", "Дементий", "age", "35", "position", "dev-ops",
                    "salary", "1500", "currency", "USD"
            ))
    ));

    public static void main(String[] args) {
        System.out.println("Task 3: ");
        task3();

        System.out.println("Task 4:");
        task4();

        System.out.println("Task 5: ");

        task5();

        System.out.println("Task 6: ");

        MyBasket myBasket = new MyBasket();

    }

    private static void task5() {
        Item item1 = new Item(45, 179, "First");
        Item item2 = new Item(45, 179, "Second");
        Item item3 = new Item(52, 179, "Third");
        Item item4 = new Item(63, 186, "Fourth");
        Item item5 = new Item(45, 197, "Fifth");

        System.out.println(item1 + " and " + item2 +
                " equal? " + "\n" + item1.equals(item2));

        System.out.println("Положим все в Set");
        Set<Item> mySet = new HashSet<>();
        mySet.add(item1);
        mySet.add(item2);
        mySet.add(item3);
        mySet.add(item4);
        mySet.add(item5);
        System.out.println("Получилось следующее множество: ");
        System.out.println(mySet);
    }

    private static void task4() {
        int[][] myArray = {
                {1, 2, 3, 4, 5},
                {5, 7, 9, 2, 1},
                {0, 9, 1, 8, 7},
                {6, 3, 6, 6, 6},
                {99, 100, -2, 3, 1}
        };
        System.out.println("Минимальный элемент побочной" +
                " диагонали матрицы без учета пересечения диагоналей: "
                + findMinDiagonal(myArray));
    }

    /**
     * Дана таблица:
     * Имя|Возраст|Должность|Зарплата
     * Кирилл|26|Middle java dev|150000 руб
     * Виталий|28|Senior java automation QA|2000$
     * Александр|31|junior functional tester|50000 руб
     * Дементий|35|dev-ops|1500$
     * <p>
     * Данная таблица представлена в формате
     * List<Map<String,String>>, где каждый элемент list
     * - строка, key в map - название столбца, value в map
     * - значение ячейки
     */
    private static void task3() {
        System.out.println("Сотрудники младше 30 лет: ");
        myList.stream()
                .filter(x -> Integer.parseInt(x.get("age")) < 30)
                .map(x -> x.get("name") + " ")
                .forEach(System.out::print);
        System.out.println();
        System.out.println("Сотрудники, получающие зарплату в рублях: ");
        myList.stream()
                .filter((x -> x.get("currency").equals("rub")))
                .map(x -> x.get("name") + " ")
                .forEach(System.out::print);
        System.out.println();
        System.out.println("Средний возраст сотрудников: ");
        myList.stream()
                .mapToDouble(x -> Integer.parseInt(x.get("age")))
                .average()
                .ifPresent(x -> System.out.println(x + " лет"));
    }

    /**
     * Дан массив NxN. Напишите программу на Java которая находит минимальный элемент побочной диагонали, без учёта элемента пересечения главной и побочной диагонали.
     * Для примера приведена матрица 5х5. Побочная диагональ выделена жирным, минимальный элемент побочной диагонали – красным и подчёркнут:
     * 1	2	3	4	5
     * 5	7	9	2	1
     * 0	9	1	8	7
     * 6	3	6	6	6
     * 99 	100	-2	3	1
     */

    public static int findMinDiagonal(int[][] myArray) {
        int result = myArray[0][myArray.length - 1];
        int centrex = myArray.length / 2;
        for (int i = 1; i < myArray.length; i++) {
            if (myArray[i][myArray[i].length - i - 1] < result
                    && i!=centrex)
                result = myArray[i][myArray[i].length - i - 1];
        }
        return result;
    }
}
