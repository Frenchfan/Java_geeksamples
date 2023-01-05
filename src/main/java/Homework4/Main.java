package Homework4;

import java.io.FileInputStream;
import java.util.*;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Homework2.Main.class.getName());

    static {
        try (FileInputStream ins = new FileInputStream("C:\\Users\\sumki\\IdeaProjects\\JSamples\\src\\main\\java\\Homework4\\logging.properties"))
        {
            LogManager.getLogManager().readConfiguration(ins);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        task1();

        task2();

        task3();
    }

    private static void task3() {
        System.out.println("Задача 3 - калькулятор с логированием и отменой");
        Scanner scanner = new Scanner(System.in);
        Deque<Double> deque = new LinkedList<>();
        String numorCommand = null;
        while (!"exit".equals(numorCommand)) {
            System.out.println("Введите первое число: ");
            int number1 = scanner.nextInt();
            System.out.println("Введите операцию (+ - * или /)");
            String operation = scanner.next();
            System.out.println("Введите второе число:");
            int number2 = scanner.nextInt();
            deque.add(myCalc(number1, number2, operation));
            logger.info("Записали в очередь результат операции " + deque.getLast());
            System.out.println("Результат операции: " + deque.getLast());
            System.out.println("Для выхода наберите exit, " +
                    "для отмены - back, следующий пример - любая другая команда или" +
                    " цифра + ввод");
            numorCommand = scanner.next();
            if ("back".equals(numorCommand)) {
                if (deque.size() == 1) {
                    System.out.println("Вы ввели только один пример, возвращаемся к исходному 0");
                    deque.removeLast();
                    logger.info("Откатили на исходный 0 ");
                } else {
                    deque.removeLast();
                    System.out.println("Предыдущий результат: " + deque.getLast());
                    logger.info("Откатили на шаг назад к результату: " + deque.getLast());
                }
            }
        }
    }

    private static void task2() {
        Deque<Integer> deque = new LinkedList<>();
        deque.add(5);
        deque.add(7);
        deque.add(56);
        deque.add(15);
        System.out.println("Задача 2 - очередь и её методы ");
        System.out.println("Исходная очередь: " + deque);
        System.out.println("Добавим элемент 17 в конец очереди: ");
        enque(deque, 17);
        System.out.println(deque);
        System.out.println("Возвращаем первый элемент из очереди и удаляем его: ");
        System.out.println("Первый элемент: " + dequeue(deque));
        System.out.println("Обновленная очередь: " + deque);
        System.out.println("Возвращаем первый элемент из очереди, не удаляя его: ");
        System.out.println("Первый элемент: " + first(deque));
        System.out.println("Обновленная очередь: " + deque);
    }

    private static void task1() {
        List<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(7);
        list.add(1);
        list.add(15);
        System.out.println("Задача 1 - перевернуть LinkedList: ");
        System.out.println("Исходный список: " + list);
        System.out.println("Перевернутый LinkedList: " + reverseList(list));
    }

    private static int first(Deque<Integer> deque) {
        return deque.getFirst();
    }

    private static int dequeue(Deque<Integer> deque) {
        return deque.removeFirst();
    }

    private static void enque(Deque<Integer> deque, int i) {
        deque.addLast(i);
    }

    /**
     * 1. Пусть дан LinkedList с несколькими элементами.
     * Реализуйте метод, который вернет “перевернутый” список.
     */
    private static List<Integer> reverseList(List<Integer> list) {
        List<Integer> reversed = new LinkedList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            reversed.add(list.get(i));
        }
        return reversed;
    }

    /**
     * 2. Реализуйте очередь с помощью LinkedList со следующими методами:
     * enqueue() - помещает элемент в конец очереди,
     * dequeue() - возвращает первый элемент из очереди и удаляет его,
     * first() - возвращает первый элемент из очереди, не удаляя.
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
