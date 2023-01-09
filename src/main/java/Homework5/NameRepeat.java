package Homework5;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NameRepeat {
    /*
     * Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
     */
    public static void main(String[] args) {
        List<String> list = Arrays.asList(
                "Иван", "Светлана", "Кристина", "Анна", "Анна",
                "Иван", "Петр", "Павел", "Петр", "Мария",
                "Марина", "Мария", "Мария", "Марина", "Анна", "Иван",
                "Петр", "Иван");

        Map<String, Long> names =
                list.stream().collect(Collectors.groupingBy(
                        Function.identity(), Collectors.counting()));

        names.forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });

    }
}