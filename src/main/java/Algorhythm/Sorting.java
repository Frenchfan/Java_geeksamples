package Algorhythm;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;


public class Sorting {
    public static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {
        int[] myArray = new int[10000];
        rndArray(myArray);
        int[] myArray2 = myArray.clone();
        int[] myArray3 = myArray.clone();
        int[] myArray4 = myArray.clone();
        int[] myArray5 = myArray.clone();
        bubbleSort(myArray);
        System.out.println(Arrays.toString(myArray));
        insertSort(myArray2);
        System.out.println(Arrays.toString(myArray2));
        selectSort(myArray3);
        System.out.println(Arrays.toString(myArray3));
        counter.set(0);
        long startTime = System.currentTimeMillis();
        quickSort(myArray4, 0, myArray4.length - 1);
        System.out.println("Steps, quickSort: " + counter.get());
        System.out.println("Time spent: " + (System.currentTimeMillis() - startTime));
        System.out.println(Arrays.toString(myArray4));
        counter.set(0);
        startTime = System.currentTimeMillis();
        quickSort2(myArray5, 0, myArray5.length - 1);
        System.out.println("Steps, quickSort2: " + counter.get());
        System.out.println("Time spent: " + (System.currentTimeMillis() - startTime));
        System.out.println(Arrays.toString(myArray5));
        counter.set(0);
        startTime = System.currentTimeMillis();
        int pos = binarySearch(myArray5, 0, myArray5.length - 1, 45);
        System.out.println("Позиция элемента в binary search " + pos);
        System.out.println("Time spent on binary search: " + (System.currentTimeMillis() - startTime));
        System.out.println("Steps, binarySearch - launches of method: " + counter.get());
    }

    public static void rndArray(int[] myArray) {
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = (int) (Math.random() * 10000);
        }
    }

    public static void bubbleSort(int[] myArray) {
        long startTime = System.currentTimeMillis();
        int counter = 0;
        for (int i = myArray.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (myArray[j] > myArray[j + 1]) {
                    int temp = myArray[j];
                    myArray[j] = myArray[j + 1];
                    myArray[j + 1] = temp;
                    counter++;
                }
            }
        }
        System.out.println("Steps, bubbleSort: " + counter);
        System.out.println("Time spent: " + (System.currentTimeMillis() - startTime));
    }

    public static void insertSort(int[] myArray) {
        long startTime = System.currentTimeMillis();
        int counter = 0;
        for (int i = 0; i < myArray.length; i++) {
            int current = myArray[i];
            int prevel = i - 1;
            while (prevel >= 0 && myArray[prevel] > current) {
                myArray[prevel + 1] = myArray[prevel];
                myArray[prevel] = current;
                prevel--;
                counter++;
            }
        }
        System.out.println("Steps, insertSort: " + counter);
        System.out.println("Time spent: " + (System.currentTimeMillis() - startTime));
    }

    public static void selectSort(int[] myArray) {
        long startTime = System.currentTimeMillis();
        int counter = 0;
        for (int i = myArray.length - 1; i > 0; i--) {
            int max = i;
            for (int j = 0; j < i; j++) {
                if (myArray[j] > myArray[max]) {
                    max = j;
                    counter++;
                }
            }
            if (max != i) {
                int temp = myArray[i];
                myArray[i] = myArray[max];
                myArray[max] = temp;
            }
        }
        System.out.println("Steps, selectSort: " + counter);
        System.out.println("Time spent: " + (System.currentTimeMillis() - startTime));
    }

    public static void quickSort2(int[] myArray, int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = myArray[(leftMarker + rightMarker) / 2];
        do {
            // Двигаем левый маркер слева направо пока элемент меньше, чем pivot
            while (myArray[leftMarker] < pivot) {
                leftMarker++;
            }
            // Двигаем правый маркер, пока элемент больше, чем pivot
            while (myArray[rightMarker] > pivot) {
                rightMarker--;
            }
            // Проверим, не нужно обменять местами элементы, на которые указывают маркеры
            if (leftMarker <= rightMarker) {
                // Левый маркер будет меньше правого только если мы должны выполнить swap
                if (leftMarker < rightMarker) {
                    int tmp = myArray[leftMarker];
                    myArray[leftMarker] = myArray[rightMarker];
                    myArray[rightMarker] = tmp;
                    counter.getAndIncrement();
                }
                // Сдвигаем маркеры, чтобы получить новые границы
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);

        // Выполняем рекурсивно для частей
        if (leftMarker < rightBorder) {
            quickSort(myArray, leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            quickSort(myArray, leftBorder, rightMarker);
        }
        /*
        Тут всё очень страшно, так что будем разбираться.

Для входного массива int[] source выставляем два маркера,
левый (L) и правый (R). При первом вызове они соответствуют началу и концу массива.

Далее определяется опорный элемент, он же pivot.
После этого наша задача — переместить значения, меньшие чем pivot,
в левую от pivot часть, а большие — в правую.

Для этого сначала двигаем указатель L, пока не найдём значение,
большее чем pivot. Если меньше значения не нашли, то L совпадёт с pivot.

Потом двигаем указатель R пока не найдём меньшее,
чем pivot значение. Если меньшее значение не нашли, то R совпадёт с pivot.

Далее, если указатель L находится до указателя R или совпадает с ним,
 то пытаемся выполнить обмен элементов, если элемент L меньше, чем R.

Далее L сдвигаем вправо на 1 позицию, R сдвигаем влево на одну позицию.

Когда левый маркер L окажется за правым маркером R это будет означать,
 что обмен закончен, слева от pivot меньшие значения, справа от pivot — большие значения.

После этого рекурсивно вызываем такую же сортировку для участков
массива от начала сортируемого участка до правого маркера и от левого маркера до конца сортируемого участка.

Почему от начала до правого? Потому что в конце итерации так и
получится, что правый маркер сдвинется настолько, что станет границей части слева.

Этот алгоритм более сложный, чем простая сортировка, поэтому
 его лучше зарисовать. Возьмём белый лист бумаги, запишем: 4 2 6 7 3 ,
 а Pivot по центру, т.е. число 6. Обведём его в круг.

Под 4 напишем L, под 3 напишем R. 4 меньше чем 6, 2 меньше чем 6.
Итого, L переместился на положение pivot, т.к. по условию L не может уйти дальше, чем pivot.

Напишем снова 4 2 6 7 3 , обведём 6 вкруг (pivot) и поставим под ним L. Теперь двигаем указатель R.

3 меньше чем 6, поэтому ставим маркер R на цифру 3. Так как 3
меньше, чем pivot 6 выполняем swap, т.е. обмен.

Запишем результат: 4 2 3 7 6 , обводим 6 вкруг, т.к. он по прежнему pivot.

Указатель L на цифре 3, указатель R на цифре 6. Мы помним,
что двигаем указатели до тех пор, пока L не зайдём за R. L двигаем на следующую цифру.

Тут хочется разобрать два варианта: если бы предпоследняя цифра
была 7 и если бы она была не 7, а 1.

Предпоследня цифра 1: Сдвинули указатель L на цифру 1, т.к.
мы можем двигать L до тех пор, пока указатель L указывает на цифру, меньшую чем pivot.
А вот R мы не можем сдвинуть с 6, т.к. R мы можем двигать только если указатель R
указывает на цифру, которая больше чем pivot. swap не делаем, т.к. 1 меньше 6.
Записываем положение: 4 2 3 1 6, обводим pivot 6. L сдвигается на pivot и больше не двигается.
R тоже не двигается. Обмен не производим. Сдвигаем L и R на одну позицию и подписываем
цифру 1 маркером R, а L получается вне числа. Т.к. L вне числа — ничего не делаем,
а вот часть 4 2 3 1 выписываем снова, т.к. это наша левая часть, меньшая, чем pivot 6.
Выделяем новый pivot и начинаем всё снова )

Предпоследняя цифра 7: Сдвинули указать L на цифру 7, правый
указатель не можем двигать, т.к. он уже указывает на pivot.
т.к. 7 больше, чем pivot, то делаем swap. Запишем результат: 4 2 3 6 7,
обводим 6 кружком, т.к. он pivot. Указатель L теперь сдвигается на цифру 7,
а указатель R сдвигается на цифру 3. Часть от L до конца нет смысла сортировать,
т.к. там всего 1 элемент, а вот часть от 4 до указателя R отправляем на сортировку.
Выбираем pivot и начинаем всё снова )

Может на первый взгляд показаться, что если расставить много одинаковых с pivot значений,
это сломает алгоритм, но это не так. Можно напридумывать каверзных вариантов и на бумажке убедиться,
что всё правильно и подивиться, как такие простые действия предоставляют такой надёжный механизм.
Единственный минус — такая сортировка не является стабильной. Т.к. при выполнении обмена
одинаковые элементы могут поменять свой порядок, если один из них встретился до pivot до того,
как другой элемент попал в часть до pivot при помощи обмена.
         */

    }

    public static void quickSort(int[] source, int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = source[(leftMarker + rightMarker) / 2];
        do {
            // Двигаем левый маркер слева направо пока элемент меньше, чем pivot
            while (source[leftMarker] < pivot) {
                leftMarker++;
            }
            // Двигаем правый маркер, пока элемент больше, чем pivot
            while (source[rightMarker] > pivot) {
                rightMarker--;
            }
            // Проверим, не нужно обменять местами элементы, на которые указывают маркеры
            if (leftMarker <= rightMarker) {
                // Левый маркер будет меньше правого только если мы должны выполнить swap
                if (leftMarker < rightMarker) {
                    int tmp = source[leftMarker];
                    source[leftMarker] = source[rightMarker];
                    source[rightMarker] = tmp;
                    counter.getAndIncrement();
                }
                // Сдвигаем маркеры, чтобы получить новые границы
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);

        // Выполняем рекурсивно для частей
        if (leftMarker < rightBorder) {
            quickSort(source, leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            quickSort(source, leftBorder, rightMarker);
        }
    }

    public static int binarySearch(int[] myArray, int left, int right, int value) {
        counter.getAndIncrement();
        if (left > right) {
            return -1;
        }
        int middle = (right - left) / 2 + left;

        if (myArray[middle] == value) {
            return middle;
        }

        if (value < myArray[middle]) {
            return binarySearch(myArray, left, middle - 1, value);
        } else {
            return binarySearch(myArray, middle + 1, right, value);
        }
    }
}
