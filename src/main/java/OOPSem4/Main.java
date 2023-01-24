package OOPSem4;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student Kolya = new Student("Kolya", 5.0f, 2005);
        Student Masha = new Student("Masha", 4.7f, 2007);
        Student Larisa = new Student("Larisa", 4.8f, 2006);
        System.out.println(Kolya.compareTo(Masha));
        List<Student> students = new ArrayList<>();
        students.add(Kolya);
        students.add(Masha);
        students.add(Larisa);
        System.out.println("Студенты до сортировки");
        students.forEach(System.out::println);
        System.out.println("Сортируем по году окончания учебы");
        Collections.sort(students);
        students.forEach(System.out::println);
        StudentComparator comparator = new StudentComparator();
        students.sort(comparator);
        System.out.println("Сортируем по среднему баллу");
        students.forEach(System.out::println);
    }
}
