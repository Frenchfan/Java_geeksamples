package Algorhythm.Seminar3;

/**
 * Описать класс для односвязного списка
 */
public class Queue {
    private Node head;

    private class Node {
        private int value;
        private Node next;
    }

    public void addToStart(int value) {
        Node node = new Node();
        node.value = value;
        if (head != null) {
            node.next = head;
        }
        head = node;
    }

    /**
     * deleting the 1st el
     */
    public void delete() {
        if (head != null) {
            head = head.next;
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

    /**
     * adds el to the end
     * @param value
     */
    public void addToEnd(int value) {
        Node node = new Node();
        node.value = value;
        if (head == null) {
            head = node;
            return;
        } else {
            Node currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = node;
        }
    }

    /**
     * Deletes the last el
     */
    public void deleteFromEnd() {
        if (head != null) {
            Node node = head;
            while (node.next != null) {
                if (node.next.next == null) {
                    node.next = null;
                    return;
                }
                node = node.next;
            }
        }
    }
}
