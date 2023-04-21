package Algorhythm;

public class Listlinked1side {
    Node head;


    public class Node {
        int value;
        Node next;

    }

    //разворот в односвязном списке через рекурсию делают
    public void revert() {
        if (head != null && head.next != null) {
            revert(head.next, head);
        }
    }

    private void revert(Node currentNode, Node previousNode) {
        if (currentNode.next == null) {
            head = currentNode;
        } else {
            revert(currentNode.next, currentNode);
        }
        currentNode.next = previousNode;
        previousNode.next = null;
    }

    /**
     * Реализация для стека
     * Добавляем элемент
     * @param value
     */
    public void push(int value) {
        Node node = new Node();
        node.value = value;
        node.next = head;
        head = node;
    }

    /**
     * извлекаем верхний элемент из стека
     * для очереди - нужен будет tail
     * @return
     */
    public Integer pop(){
        Integer result = null;
        if (head != null) {
            result = head.value;
            head = head.next;
        }
        return result;
    }
}
