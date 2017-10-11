package models;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * Created by Ivan Minchev on 9/22/2017.
 */
public class Ex04_LinkedList<E> implements Iterable<E> {
    private int size;

    private Node head;
    private Node tail;

    public int size() {
        return this.size;
    }

    public void addFirst(E item) {
        Node oldHead = this.head;
        this.head = new Node(item);
        this.head.setNextNode(oldHead);
        if (this.size() == 0) {
            this.tail = this.head;
        }
        this.size++;
    }

    public void addLast(E item) {
        Node oldTail = this.tail;
        this.tail = new Node(item);

        if (this.size() == 0) {
            this.head = this.tail ;
        } else {
            oldTail.setNextNode(this.tail);
        }
        this.size++;
    }

    public E removeFirst() {
        if (this.size() == 0) {
            throw new UnsupportedOperationException("The list is empty!");
        }
        E item = this.head.getValue();
        this.head = this.head.getNextNode();

        if (this.size() == 1) {
            this.tail = null;
        }
        this.size--;
        return item;
    }

    public E removeLast() {
        if (this.size() == 0) {
            throw new UnsupportedOperationException();
        }

        E item = this.tail.getValue();
        if (this.size() == 1) {
            this.head = null;
            this.tail = null;
        } else {
            Node newTail = this.getBeforeLastNode();
            newTail.next = null;
            this.tail = newTail;
        }

        this.size--;
        return item;
    }

    public Node getBeforeLastNode() {
        Node current = this.head;

        while (current.getNextNode() != this.tail) {
            current = current.getNextNode();
        }
        return current;
    }

    @Override
    public Iterator<E> iterator() {
        return new Ex04_LinkedListIterator();
    }

    private final class Ex04_LinkedListIterator implements Iterator<E> {
        private Node currentNode;

        public Ex04_LinkedListIterator() {
            this.currentNode = head;
        }

        @Override
        public boolean hasNext() {
            return this.currentNode != null;
        }

        @Override
        public E next() {
            E element = this.currentNode.getValue();
            this.currentNode = this.currentNode.getNextNode();
            return element;
        }
    }

    // Defining Node<E> is not necessary because
    // Why? - class Node is nested in the generic class models.Ex04_LinkedList<E> so <E> is already defined.
    private class Node {
        public E value;
        public Node next;

        public Node(E value) {
            this.value = value;
        }

        public Node getNextNode() {
            return next;
        }

        public void setNextNode(Node next) {
            this.next = next;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Ex04_LinkedList<Integer> linkedList = new Ex04_LinkedList();

        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);

        // Check list size - must be 3;
        System.out.println(linkedList.size());

        // Check iterator, must be printed - 3\n 2\n 1\n as a result
        for (Integer item : linkedList) {
            System.out.println(item);
        }

        //Check remove first
        // Element must be equal to - 1
        System.out.println(linkedList.removeFirst());
        // Check the size, it must be - 2;
        System.out.println(linkedList.size());

        linkedList.removeFirst();
        linkedList.removeFirst();
        // Check the size, it must be - 0
        System.out.println(linkedList.size());

        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);

        // Check iterator, must be printed - 1\n 2\n 3\n as a result
        for (Integer item : linkedList) {
            System.out.println(item);
        }

        //Check remove last
        // Element must be equal to - 3
        System.out.println(linkedList.removeLast());
        // Check the size, it must be - 2;
        System.out.println(linkedList.size());

        linkedList.removeLast();
        linkedList.removeLast();
        // Check the size, it must be - 0
        System.out.println(linkedList.size());


    }






}
