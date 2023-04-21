package Algorhythm;

/**
 * Реализуем связанный список
 * - не получится использовать binary search - перебор O(n)
 * - для вставки придется свдинуть все элементы вперед - O(n), перебор, но сама вставка - O(1), константная
 */
public class List2sides {
    Node head;
    Node tail;

    public void add(int value) {
        Node node = new Node();
        node.value = value;
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
    }

    /**
     * добавит node после определенной node
     * операции с индексом в связанном списке ни к чему
     * Вставка в начало, либо в конец не требует поиска - O(1),
     * но вставка в середину почти равнозначна вставке в середину массива - поиск O(n) + вставка O(1), то есть O(n)
     * в массиве поиск - O(1), но вставка - O(n) - приходится копировать данные в новый массив, поскольку
     * динамическое расширение невозможно
     * удаление в массиве - сдвиг, то есть O(n)
     * удаление в связанном списке - O(1), но надо еще искать
     *
     * @param value
     * @param node
     */
    public void add(int value, Node node) {
        Node next = node.next;
        Node newNode = new Node();
        newNode.value = value;
        node.next = newNode;
        newNode.previous = node;
        if (next == null) {
            tail = newNode;
        } else {
            next.previous = newNode;
            newNode.next = next;
        }

    }

    public void delete(Node node) {
        Node previous = node.previous;
        Node next = node.next;
        if (previous == null) {
            next.previous = null;
            head = next;
        } else {
            if (next == null) {
                previous.next = null;
                tail = previous;
            } else {
                previous.next = next;
                next.previous = previous;
            }
        }
    }

    public Node find(int value) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.value == value) {
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        return null;
    }

    public void revert() {
        Node currentNode = head;
        while (currentNode != null) {
            Node next = currentNode.next;
            Node previous = currentNode.previous;
            currentNode.next = previous;
            currentNode.previous = next;
            if (previous == null) {
                tail = currentNode;
            }
            if (next == null) {
                head = currentNode;
            }
            currentNode = next;
        }
    }

    public class Node {
        int value;
        Node next;

        Node previous;
    }
}
