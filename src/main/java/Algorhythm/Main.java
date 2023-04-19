package Algorhythm;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        System.out.println("Сумма числе от 1 до 5 = " + sum(5));
        List<Integer> myList = primeNumbers(14);
        if (myList != null) {
            myList.forEach(System.out::println);
        }
        System.out.println("кол-во комбинаций 4 коcтей с 6 гранями = " + dice(4, 6));
        long lnSystemTime = System.nanoTime();
        System.out.println("Элемент последовательности Фибоначчи с индексом 10 = " + fib(40));
        System.out.println("Операция заняла " + (System.nanoTime() - lnSystemTime));
        lnSystemTime = System.nanoTime();
        System.out.println("Элемент последовательности Фибоначчи с индексом 10 = " + fibNoRecursion(40));
        System.out.println("Операция заняла " + (System.nanoTime() - lnSystemTime));

    }

    /**
     * Необходимо написать алгоритм,
     * считающий сумму всех чисел от 1 до N.
     * Согласно свойствам линейной сложности,
     * количество итераций цикла будет линейно
     * изменяться относительно изменения размера N.
     *
     * @param number final value to sum-up numbers
     * @return sum of numbers from 1 to number
     */
    public static int sum(int number) {
        if (number < 1) return -1;
        int result = 0;
        for (int i = 1; i <= number; i++) {
            result += i;
        }
        return result;
    }

    /**
     * Написать алгоритм поиска простых чисел (делятся только на себя и
     * на 1) в диапазоне от 1 до N. В алгоритме будет использоваться
     * вложенный for, что явно говорит о квадратичной сложности, на этом
     * стоит акцентировать внимание
     *
     * @param number
     * @return
     */
    public static List<Integer> primeNumbers(int number) {
        if (number < 1) return null;
        List<Integer> result = new ArrayList<>();
        boolean skip = false;
        for (int i = 1; i <= number; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    skip = true;
                    break;
                }
            }
            if (!skip) result.add(i);
            skip = false;
        }
        return result;
    }

    public static int dice(int numberDice, int numberEdges) {
        if (numberDice == 1) return numberEdges;
        int counter = 0;
        for (int i = 0; i < numberDice; i++) {
            counter += dice(numberDice - 1, numberEdges);
        }
        return counter;
    }

    /**
     * Пишем алгоритм поиска нужного числа последовательности Фибоначчи.
     * Считаем, что 1 и 2 значения последовательности равны 1.
     *
     * @param number
     * @return
     */
    public static int fib(int number) {
        if (number <= 1) return 0;
        if (number == 2 ) {
            return 1;
        }
        return fib(number - 1) + fib(number - 2);
    }
    public static int fibNoRecursion(int number) {
        int x = 0;
        int x1 = 1;
        int x2 = 1;
        for (int i = 3; i <= number; i++) {
            x2 = x + x1;
            x = x1;
            x1 = x2;
        }
        return x2;
    }
}

