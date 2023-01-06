package Seminar5;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        personPassportNumber();
    }

    /**
     * Создать структуру для хранения номеров паспортов и фамилий сотрудников организации
     * 123456 Иванов
     * 321456 Васильев
     * 234561 Петрова
     * 234432 Иванов
     * 654321 Петрова
     * 345678 Иванов
     * Вывести данные по сотрудникам с фамилией Иванов
     */
    private static void personPassportNumber() {
        Passport people = new Passport();
        people.add("Иванов", 123456);
        people.add("Васильев", 321456);
        people.add("Петрова", 234561);
        people.add("Иванов", 234432);
        people.add("Петрова", 654321);
        people.add("Иванов", 345678);

        System.out.println(people.find("Иванов"));
    }
}
