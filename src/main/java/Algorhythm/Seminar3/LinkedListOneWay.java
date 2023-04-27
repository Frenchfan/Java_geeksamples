package Algorhythm.Seminar3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * класс для односвязного списка
 */
public class LinkedListOneWay {

    private Node head;

    public class Node {

        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
            next = null;
        }
    }

    /**
     * Reverse with a loop
     */
    public void reverseLoop() {
        if (head != null) {
            Node prev = null;
            Node curr = head;

            while (curr != null) {
                Node tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }
            head = prev;
        }
    }

    /**
     * reverse with a Stack (ArrayDeque<Node>)
     */
    public void reverseStack() {
        if (head != null) {
            Deque<Node> stack = new ArrayDeque<>();
            Node curr = head;
            while(curr != null) {
                stack.push(curr);
                curr = curr.next;
            }
            head = stack.pop();
            curr = head;
            while (!stack.isEmpty()) {
                curr.next = stack.pop();
                curr = curr.next;
            }
            curr.next = null;
        }
    }

    public void reverseListRecursive() {
        if (head != null) {
            head = recursion(null, head);
        }
    }

    private Node recursion(Node prev, Node curr) {
        if (curr == null) {
            return prev;
        }
        Node next = curr.next;
        curr.next = prev;
        return recursion(curr, next);
    }

    public void doubleEvenNumbers() {
        if (head != null) {
            Node curr = head;
            while (curr != null) {
                Node next = curr.next;
                if (curr.value % 2 == 0) {
                    curr.next = new Node(curr.value);
                    curr.next.next = next;
                }
                curr = next;
            }
        }
    }

    public List<LinkedListOneWay> fromOneToTwoListsWithPositiveAndNegativeEls() {
        if (head != null) {
            LinkedListOneWay negative = new LinkedListOneWay();
            LinkedListOneWay positive = new LinkedListOneWay();
            Node curr = head;
            while (curr != null) {
                if (curr.value < 0) {
                    negative.addToStart(curr.value);
                } else {
                    positive.addToStart(curr.value);
                }
                curr = curr.next;
            }
            List<LinkedListOneWay> result = new ArrayList<>();
            result.add(negative);
            result.add(positive);
            return result;
        }
        return null;
    }

    public void addToStart(int value) {
        Node node = new Node(value);
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
        Node node = new Node(value);
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
    public void printOut() {
        if (head != null) {
            Node node = head;
            while (node != null) {
                System.out.print(node.value + " ");
                node = node.next;
            }
            System.out.print('\n');
        }
    }
}
