package Algorhythm;


public class Queue {
    Node head;

    Node tail;


    public class Node {
        int value;
        Node next;

        Node previous;

    }

    /**
     * Реализация для очереди - идентично стеку, почти!
     * Добавляем элемент
     * @param value
     */
    public void push(int value) {
        Node node = new Node();
        node.value = value;
        node.next = head;
        head.previous = node;
        head = node;
    }

    /**
     * извлекаем верхний элемент из стека
     * для очереди - нужен будет tail
     * @return
     */
    public Integer peek(){
        Integer result = null;
        if (tail != null) {
            result = tail.value;
            tail.previous.next = null;
            tail = tail.previous;
        }
        return result;
    }
}
