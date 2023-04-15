package controlWork;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] test1 = {"hello", "2", "world", ":-)"};
        String[] test2 = {"1234", "1567", "-2", "computer science"};
        String[] test3 = {"Russia", "Denmark", "Kazan"};
        System.out.println(Arrays.toString(threeLeft(test1, 3)));
        System.out.println(Arrays.toString(threeLeft(test2, 3)));
        System.out.println(Arrays.toString(threeLeft(test3, 3)));
    }

    private static String[] threeLeft(String[] test, int maxLength) {
        return Arrays.stream(test)
                .filter(x -> x.length() <= maxLength)
                .toArray(String[]::new);
    }
}
