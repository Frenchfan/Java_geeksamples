package ExcSem;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HW2Sem2 {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
    }

    public static void task1() {
        Float number = null;
        do {
            try {
                System.out.println("Введите дробное число: ");
                Scanner scanner = new Scanner(System.in);
                number = scanner.nextFloat();
                scanner.close();
            } catch (InputMismatchException e) {
                System.out.println("Ай-ай-ай, нужно именно число, давай по-честному");
            }
        } while (number == null);
        System.out.println("Молодец, ты ввел число " + number);
    }

    /**
     * Хорошо бы пояснить в задании, а что нужно
     * Чтобы что-то исправлять, нужно понимать,
     * какова цель алгоритма. Я исправил так, чтобы
     * ловилось исключение, не было infinity;
     */
    public static void task2() {
        try {
            int d = 0;
            int[] intArray = new int[9];
            intArray[8] = 15;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }
    }

    /**
     * Снова не очень понятно задание.
     * Я просто переставил catch блоки, чтобы ловить
     * по принципу от частному к общему, а не сразу
     * общее исключение, перехват которого делает
     * остальные блоки беполезными
     * Также убрал на printSum странное throws того, чего нет
     */
    public static void task3() {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = {1, 2};
            abc[3] = 9;
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }
    }

    public static void printSum(Integer a, Integer b) {
        System.out.println(a + b);
    }

    public static void task4() {
        String line = null;
        do {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("Введите хоть что-нибудь: ");
                line = scanner.nextLine();
                if ("".equals(line)) {
                    throw new InputMismatchException();
                }
                scanner.close();
            } catch (InputMismatchException e) {
                System.out.println("Нельзя вводить пустую строку");
            }
        } while (line == null || "".equals(line));
        System.out.println("Молодец, ты ввел: " + line);
    }
}
