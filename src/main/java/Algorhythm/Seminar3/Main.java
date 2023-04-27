package Algorhythm.Seminar3;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        LinkedListOneWay myList = new LinkedListOneWay();
        for (int i = -5; i < 10; i++) {
            myList.addToEnd(i);
        }
        myList.printOut();
        myList.reverseLoop();
        myList.printOut();
        myList.reverseStack();
        myList.printOut();
        myList.reverseListRecursive();
        myList.printOut();
        System.out.println("Дублируем четные числа: ");
        myList.doubleEvenNumbers();
        myList.printOut();
        List<LinkedListOneWay> result = myList.fromOneToTwoListsWithPositiveAndNegativeEls();
        System.out.println("Распечатаем 2 списка, которые получились из одного - с положительными и отрицательными числами: ");
        result.forEach(LinkedListOneWay::printOut);
        System.out.println("А теперь к 2-связному списку");
        LinkedList2Ways myList2 = new LinkedList2Ways();
        for (int i = 0; i < 10; i++) {
            myList2.addToStart(i);
        }
        myList2.printOut();
        myList2.reverseLoop();
        myList2.printOut();
    }
}
