package Seminar4;

import java.util.EmptyStackException;

/**
 * Реализовать стэк с помощью масссива. Нужно реализовать методы:
 * size(), empty(), push(), peek(), pop()
 */
public class ArrayStack<E> {
    public static final int CAPACITY = 1000;

    private int topIndex;

    private E[] data;

    public ArrayStack() {
        this(CAPACITY);
    }
    public ArrayStack(int capacity) {
        topIndex = -1;
        data = (E[]) new Object[capacity];
    }

    public int size() {
        return (topIndex + 1);
    }

    public boolean empty() {
        return (topIndex == -1);
    }

    public void push(E e) throws IllegalStateException {
        if(size() == data.length) throw new IllegalStateException("Stack is full");
        data[++topIndex] = e;
    }

    public E peek() throws EmptyStackException {
        if(empty()) throw new EmptyStackException();
        return data[topIndex];
    }

    public E pop() throws EmptyStackException {
        if(empty()) throw new EmptyStackException();
        E answer = data[topIndex];
        data[topIndex] = null;
        topIndex--;
        return answer;
    }
    public static void main(String[] args) {
        ArrayStack<Integer> myStack = new ArrayStack();
        myStack.push(9);
        myStack.push(3);
        myStack.push(8);
        myStack.push(2);
        System.out.println("Top element is: " + myStack.peek());
        System.out.println("Element removed is: " + myStack.pop());
        System.out.println("Size of stack: " + myStack.size());
        System.out.println("Element removed is: " + myStack.pop());
        System.out.println("Top element is: " + myStack.peek());
        myStack.push(10);
        System.out.println("Stack is empty: " + myStack.empty());
    }
}
