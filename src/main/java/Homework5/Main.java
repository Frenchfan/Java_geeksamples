package Homework5;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static Homework5.HeapSort.HeapS;

public class Main {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

    private static void task3() {
        System.out.println("Задача 3 - пирамидальная сортировка (HeapSort): ");
        Integer [] a={12,32,33,8,54,34,35,26,43,88,45};
        System.out.println("Исходный массив: " + Arrays.asList(a));
        HeapS(a,a.length-1);
        System.out.println("Отсортированный массив" + Arrays.asList(a));
    }

    private static void task2() {
        System.out.println("Задача 2 - список сотрудников: ");
        Employees employees = new Employees();
        employees.add("Иван", "Иванов");
        employees.add("Светлана", "Петрова");
        employees.add("Кристина", "Белова");
        employees.add("Анна", "Мусина");
        employees.add("Анна", "Крутова");
        employees.add("Иван", "Юрин");
        employees.add("Петр", "Лыков");
        employees.add("Павел", "Чернов");
        employees.add("Петр", "Чернышов");
        employees.add("Мария", "Федорова");
        employees.add("Марина", "Светлова");
        employees.add("Мария", "Савина");
        employees.add("Мария", "Рыкова");
        employees.add("Марина", "Лугова");
        employees.add("Анна", "Владимирова");
        employees.add("Иван", "Мечников");
        employees.add("Петр", "Петин");
        employees.add("Иван", "Ежов");
        employees.sortRepeats();
    }

    private static void task1() {
        System.out.println("Задача 1 - Реализуйте структуру телефонной книги с помощью HashMap, " +
                "учитывая, что 1 человек может иметь несколько телефонов.");
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов", Stream.of("+79261234561", "+79031234561", "+79161234561").collect(Collectors.toSet()));
        phoneBook.add("Иванов", Stream.of("+79261234561").collect(Collectors.toSet())); // не пропустит повтор
        phoneBook.add("Петров", Stream.of("+79263214561", "+79033214561").collect(Collectors.toSet()));
        phoneBook.add("Сидоров", Stream.of("+79261236541", "+79031236541", "+79161236541").collect(Collectors.toSet()));
        if (phoneBook.delete("Гога", "+79263887573")) System.out.println("Номер +79263887573 абонента Гога успешно удален");
        else System.out.println("В телефонной книге нет абонента Гога");
        if (phoneBook.delete("Иванов", "+79261234561")) System.out.println("Номер +79261234561 абонента Иванов успешно удален");
        else System.out.println("В телефонной книге нет абонента Иванов");
        System.out.println("Поиск по книге: ");
        System.out.println("Абонент Иванов - " + phoneBook.find("Иванов"));
        System.out.println("Распечатка телефонной книги: ");
        System.out.println(phoneBook);
    }
}
