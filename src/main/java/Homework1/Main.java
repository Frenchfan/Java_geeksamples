package Homework1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задача 1 - факториал");
        System.out.println("Введите целое число >= 0: ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.println("Факториал числа " + number + " равен " + factorial(number));
        System.out.println("Задача 2 - простые числа");
        primeNumbers1TO1000();
        System.out.println("Задача 3 - калькулятор");
        System.out.println("Введите первое число:");
        int number1 = scanner.nextInt();
        System.out.println("Введите операцию (+ - * или /)");
        String operation = scanner.next();
        System.out.println("Введите второе число:");
        int number2 = scanner.nextInt();
        System.out.println("Результат операции: " + myCalc(number1, number2, operation));
    }

    /**
     * Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
     */
    public static int factorial (int number) {
        int result = 1;
        if (number == 0) return result;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }

    /**
     * Вывести все простые числа от 1 до 1000
     */

    public static void primeNumbers1TO1000() {
        System.out.println("Простые числа от 1 до 1000: ");
        for (int i = 1; i < 1001; i++) {
            boolean primeFlag = false;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) primeFlag = true;
            }
            if (!primeFlag) System.out.print(i + " ");
        }
    }

    /**
     * Реализовать простой калькулятор
     */

    public static double myCalc(int number1, int number2, String operation) {
        switch (operation) {
            case "+": return number1 + number2;
            case "-": return number1 - number2;
            case "*": return number1 * number2;
            case "/": return number1 / number2;
        }
        return 0;
    }



}
