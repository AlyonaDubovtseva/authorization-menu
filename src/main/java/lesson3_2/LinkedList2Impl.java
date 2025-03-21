package lesson3_2;

import lesson1.IndexOutOfRangeException;
import lesson2_3.LinkedList;

public class LinkedList2Impl<T> implements LinkedList2<T> {

    private Node head;

    class Node {
        public T value;
        public Node next;
        public Node prev;

        public Node(T value) {
            this.value = value;
        }
    }

    public void add(T element){
        if(head == null) {
            head = new Node(element);
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(element);
            current.next.prev = current;
        }
    }

    public void add(T element, int position) throws IndexOutOfRangeException{
        if(position < 1) {
            throw new IndexOutOfRangeException("Введена отрицательная позиция!");
        }
        Node newNode = new Node(element);

        if(position == 1) {
            if(head != null) {
                newNode.next = head;
                head.prev = head;
            }
            head = newNode;
            return;
        }

        Node current = head;
        for (int i = 0; i < position - 1; ++i) {
            if (current == null) {
                throw new IndexOutOfRangeException("Позиция больше самого списка");
            }
            current = current.next;
        }

        newNode.next = current.next;
        if (current.next != null) {
            current.next.prev = newNode;
        }
        newNode.prev = current;
        current.next = newNode;
    }

    public T remove(int position) throws IndexOutOfRangeException {
        if(position < 1 || head == null) {
            throw new IndexOutOfRangeException("Введена отрицательная позиция или список пустой!");
        }
        Node current = head;

        if(position == 1) {
            head = head.next;
            if(head != null) {
                head.prev = null;
                return current.value;
            }
        }

        for (int i = 0; i < position - 1; ++i) {
            if (current == null) {
                throw new IndexOutOfRangeException("Позиция больше самого списка");
            }
            current = current.next;
        }

        if (current.next != null) current.next.prev = current.prev;
        if (current.prev != null) current.prev.next = current.next;
        return current.value;
    }

    public T get(int position) throws IndexOutOfRangeException {

        if(head == null || position < 0) {
            throw new IndexOutOfRangeException("Введена отрицательная позиция или список пустой!");
        }
        Node current = head;
        for (int i = 0; i < position - 1; ++i) {
            if(current == null) {
                throw new IndexOutOfRangeException("Позиция больше самого списка");
            }
            current = current.next;
        }
        return current.value;
    }

    public int size() {
        int counter = 0;
        Node current = head;
        while(current.next != null) {
            current = current.next;
            counter++;
        }
        return counter;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node current = head;
        while (current != null) {
            stringBuilder.append(current.value).append(" ");
            current = current.next;
        }
        return stringBuilder.toString();
    }
}
