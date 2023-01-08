package Homework5;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Employees {

    private static Map<Integer, Person> employees = new HashMap<>();

    public void add(String name, String lastName) {
        employees.put(employees.size(), new Person(name, lastName));
    }

    public void sortRepeats() {
        Collection<Person> onlyemployees = employees.values();
        ArrayList<String> names = new ArrayList<>();
        for (Person person: onlyemployees) {
            names.add(person.getName());
        }
        Map<String, Long> freq = Stream.of(names.toArray(new String[0]))
                .collect(Collectors.groupingBy(Function.identity(),
                Collectors.counting()));
        freq.entrySet().stream()
                        .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                                .forEach(System.out::println);
    }
}
