package Seminar4;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //splitString();
        int[] arr = {1, 4, 3, 5, 6, 7};
        addStackArray(arr);
        addQueueArray(arr);
    }
    /**
     * Реализовать консольное приложение, которое:
     * 1. Принимает от пользователя строку вида
     * text~num
     * 1. Нужно рассплитить строку по ~, сохранить текст в связанный список на позицию num
     * 2. Если введено print~num, выводит строку из позиции num в свящном списке
     * и удаляет её из списка
     */
    private static void splitString() {
        int num = 0;
        String text = null;
        String str;

        str = getEnterString();

        String[] words = str.split("~");
        text = words[0];
        num = Integer.parseInt(words[1]);

        List<String> list = new LinkedList<>();
        list = saveLinkedList(num, text);

        str = getEnterString();
        String[] numbers = str.split("~");
        num = Integer.parseInt(numbers[1]);

        removeLinkedListElement(list, num);
    }

    private static void removeLinkedListElement(List<String> list, int num) {
        list.remove(num);
        System.out.println(list);
    }

    private static List<String> saveLinkedList(int num, String text) {
        List<String> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            if (num != 0) {
                list.add(i, "default");
                if (num == i) {
                    list.add(num, text);
                }
            }

        }
        System.out.println(list);
        return list;
    }

    private static String getEnterString() {
        String str;
        System.out.println("Введите строку вида text~num: ");
        Scanner scanner = new Scanner(System.in);
        str = scanner.nextLine();
        System.out.println("Вы ввели строку: ");
        return str;
    }

    /**
     * 1) Написать метод, который принимает массив элементов, помещает их в стэк и
     * выводит на консоль содержимое стэка
     * 2) Написать метод, который принимает массив элементов, помещает их в очередь
     * и выводит на консоль содержимое очереди
     */

    private static void addStackArray(int[] array) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            System.out.println(stack.push(array[i]));
        }
        System.out.println(stack);
        System.out.println();

        for (int i = 0; i < array.length; i++) {
            System.out.println(stack.pop());
        }
    }

    private static void addQueueArray(int[] array) {
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < array.length; i++) {
            queue.push(array[i]);
            queue.add(array[i]);
            System.out.println(array[i]);
        }
        System.out.println();
        for (int i = 0; i < array.length ; i++) {
            System.out.println(queue.pop());
        }
        System.out.println(queue);
    }


}
