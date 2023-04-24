package Algorhythm.Seminar3;

public class Dequeue {

    private Node head;
    private Node tail;

    private class Node {
        private int value;
        private Node next;
        private Node previous;
    }

    /**
     * adds el to the start
     *
     * @param value
     */
    public void addToStart(int value) {
        Node node = new Node();
        node.value = value;
        if (head == null) {
            tail = node;
        } else {
            head.previous = node;
            node.next = head;
        }
        head = node;
    }

    public void deleteFirst() {
        if (head != null && head.next != null) {
            head.next.previous = null;
            head = head.next;
        } else {
            head = null;
            tail = null;
        }
    }
    /**
     * Checks if the value exists in any Node
     *
     * @param value - a value to find
     * @return true if the values exists
     */
    public boolean find(int value) {
        Node node = head;
        while (node != null) {
            if (node.value == value) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public void deleteLast() {
        if (tail != null && tail.previous != null) {
            tail.previous.next = null;
            tail = tail.previous;
        } else {
            tail = null;
            head = null;
        }
    }

    /**
     * пузырьковая сортировка двусвязного списка
     */
    public void bubbleSort() {
        boolean finish;
        do {
            Node currentNode = head;
            finish = true;
            while (currentNode != null && currentNode.next != null) {
                if (currentNode.value > currentNode.next.value) {
                    int temp = currentNode.value;
                    currentNode.value = currentNode.next.value;
                    currentNode.next.value = temp;
                    finish = false;
                }
                currentNode = currentNode.next;
            }
        } while (!finish);
    }
}
