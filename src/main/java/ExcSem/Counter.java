package ExcSem;

/**
 * Создайте класс Счетчик, у которого есть метод add(),
 * увеличивающий значение внутренней int переменной на 1.
 * Сделайте так, чтобы с объектом такого типа можно было
 * работать в блоке try-with-resources. Подумайте, что должно
 * происходить при закрытии этого ресурса? Напишите метод для проверки,
 * закрыт ли ресурс. При попытке вызвать add() у закрытого ресурса,
 * должен выброситься IOException
 */
public class Counter  implements AutoCloseable {
    private int index;
    private boolean isClosed = false;

    public Counter() {
    }

    public void add () throws MyException {
        if (isClosed) {
            throw new MyException("Вот и исключение");
        }
        index++;
    }

    @Override
    public void close() throws Exception {
        isClosed = true;
    }

    public int getIndex() {
        return index;
    }

    public boolean isClosed() {
        return isClosed;
    }
}
