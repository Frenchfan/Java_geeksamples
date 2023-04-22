package ExcSem;


import java.util.*;

public class Main {
    /**
     * Comment the methods below to proceed to the next exception (if you get bored
     * and really interested in this stuff)     *
     * @param args
     */
    public static void main(String[] args) {
        a(5);
        b(new int[]{2, 4, 5});
        c();
        int[] result = difference(new int[]{2, 5, 7}, new int[]{1, 4, 6});
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(difference(new int[]{2, 5, 7}, new int[]{1, 4, 6, 8})));

        System.out.println(Arrays.toString(division(new int[]{6, 8, 10}, new int[]{3, 4, 5})));
        System.out.println(Arrays.toString(division(new int[]{6, 8, 10}, new int[]{3, 4, 5, 8})));
    }

    /**
     * Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
     */

    /**
     * Division by zero sample
     *
     * @param value any value
     */
    public static void a(int value) {
        System.out.println(value / 0);
    }


    /**
     * IndexoutOfBoundsException
     *
     * @param array any int array
     */
    public static void b(int[] array) {
        System.out.println(array[array.length]);
    }

    /**
     * InputMisMatch Exception
     *
     * @return exception if a literal is processed
     */
    public static int c() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    /**
     * Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
     * и возвращающий новый массив, каждый элемент которого равен разности элементов
     * двух входящих массивов в той же ячейке.
     * Если длины массивов не равны, необходимо как-то оповестить пользователя.
     * P.S. в условии нет ничего про Excpetion и это хорошо :)
     *
     * @param array1 first array
     * @param array2 second array
     * @return new int[], where each el = array1[i] - array2[i]
     */
    public static int[] difference(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            System.err.println("Массивы разной длины!");
            return null;
        }
        int[] result = new int[array1.length];
        for (int i = 0; i < array1.length; i++) {
            result[i] = array1[i] - array2[i];
        }
        return result;
    }

    /**
     * Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
     * и возвращающий новый массив, каждый элемент которого равен частному элементов
     * двух входящих массивов в той же ячейке. Если длины массивов не равны, необходимо
     * как-то оповестить пользователя. Важно: При выполнении метода единственное исключение,
     * которое пользователь может увидеть - RuntimeException, т.е. ваше.
     * P.S. тут ни слова нет про catch - поэтому его и нет в реализации
     *
     * @param array1 first array
     * @param array2 second array
     * @return new int[], where each el = array1[i] / array2[i]
     */
    public static int[] division(int[] array1, int[] array2) {
        if (Arrays.stream(array2).
                anyMatch(x -> x == 0)) {
            throw new RuntimeException("0 во втором массиве");
        }
        if (array1.length != array2.length) {
            throw new RuntimeException("Массивы разной длины");
        }
        int[] result = new int[array1.length];
        for (int i = 0; i < array1.length; i++) {
            result[i] = array1[i] / array2[i];
        }
        return result;
    }
}

