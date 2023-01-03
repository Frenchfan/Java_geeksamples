package Homework3;

import com.google.gson.internal.bind.util.ISO8601Utils;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> newList = new ArrayList<>();
        newList.add(15);
        newList.add(2);
        newList.add(20);
        newList.add(16);
        newList.add(3);
        newList.add(4);
        System.out.println("Задача 1 - сортировка слиянием: ");
        System.out.println("Исходный список: " + newList);
        mergeSort(newList);
        System.out.println("Отсортированный список: " + newList);
        System.out.println("Задача 2 - убрать четные числа из списка: ");
        List<Integer> myList = myRandomList();
        System.out.println("После удаления четных чисел остались: " + removeEven(myList));
        System.out.println("Задача 3 - мин, макс и среднее из списка: ");
        List<Integer> myList2 = myRandomList();
        mergeSort(myList2);
        System.out.println("мин - " + myList2.get(0) + ", макс - " + myList2.get(myList2.size() - 1) +
                ", среднее - " + myList2.stream().mapToInt(Integer::intValue).sum() / myList2.size());
    }

    /**
     * Реализовать алгоритм сортировки слиянием
     */
    public static void mergeSort(List<Integer> values)
    {
        if (values.size() > 1) {
            int mid = values.size()/2;
            List<Integer> left = new ArrayList<>(values.subList(0, mid));
            //При таком создании subList родительский List не будет меняться!
            List<Integer> right = new ArrayList<>(values.subList(mid, values.size()));
            mergeSort(left);
            mergeSort(right);
            merge(left,right,values);
        }
    }
    public static void merge (List<Integer>left,List<Integer>right,List<Integer>values)
    {
        int i1 = 0;// left Index
        int i2 = 0;// right Index
        for (int i = 0; i < values.size(); i++) {

            if(i1 == left.size()){
                values.set(i, right.get(i2));
                i2++;
            }
            else{
                if (i2 == right.size()){
                    values.set(i,left.get(i1));
                    i1++;
                }
                else{
                    if (left.get(i1) <= right.get(i2)) {
                        values.set(i,left.get(i1));
                        i1++;
                    }
                    else {
                        if (left.get(i1) >= right.get(i2)) {
                            values.set(i, right.get(i2));
                            i2++;
                        }
                    }
                }
            }

        }

    }
    /**
     * Пусть дан произвольный список целых чисел, удалить из него четные числа
     */
    private static List<Integer> myRandomList() {
        List<Integer> myList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            Random random = new Random();
            int val = random.nextInt(101);
            myList.add(val);
        }
        System.out.println("Сгенерирован список случайных чисел: " + myList);
        return myList;
    }
    private static List<Integer> removeEven (List<Integer> myList) {
        return myList.stream()
                .filter(x -> x % 2 != 0)
                .toList();
    }
}
