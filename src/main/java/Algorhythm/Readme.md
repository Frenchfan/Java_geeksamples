Метод sum

Необходимо написать алгоритм, считающий сумму всех чисел
от 1 до N. Согласно свойствам линейной сложности,
количество итераций цикла будет линейно изменяться
относительно изменения размера N.
<br>
метод primeNumbers

Написать алгоритм поиска простых чисел (делятся только на себя и
на 1) в диапазоне от 1 до N. В алгоритме будет использоваться
вложенный for, что явно говорит о квадратичной сложности, на этом
стоит акцентировать внимание

<br>
метод dice

Необходимо написать алгоритм поиска всех доступных комбинаций
(посчитать количество) для количества кубиков K с количеством граней N.
2.
У вас есть 2 варианта на выбор количество кубиков может быть строго
ограничено (4 кубика, например), либо их количество будет
динамическим. Выбор за вами.
3.
Если вы реализуете простой вариант, обращает внимание, что данное
решение имеет сложность O(n 4 ), но если количество кубиков сделать
переменной, то она трансформируется в O(n k ), что будет представлять
собой экспоненциальную сложность. Для второго решения очевидно, что
его сложность O(n k ) с самого начала


<br>

**Метод fib**

1.
Пишем алгоритм поиска нужного числа последовательности Фибоначчи.
2.
Считаем, что 1 и 2 значения последовательности равны 1.
3.
Искать будем по формуле O n =O n 1 +O n 2 что предполагает использовать
рекурсивного алгоритма.