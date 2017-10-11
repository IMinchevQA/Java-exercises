package models;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * Created by Ivan Minchev on 9/26/2017.
 */
public class Ex06_DoublyLinkedList<E> implements Iterable<E> {

    private Node head;
    private Node tail;

    private int size;

    public int size() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void addFirst(E element) {
        Node oldHead = this.head;
        this.head = new Node(element);
        this.head.setNextNode(oldHead);
        if (this.size() == 0) {
            this.tail = this.head;
        } else {
            oldHead.setPrevNode(this.head);
        }

        this.setSize(this.size() + 1);
    }

    public void addLast(E element) {
        Node oldTail = this.tail;
        this.tail = new Node(element);

        if (this.size() == 0) {
            this.head = this.tail;
        } else {
            this.tail.setPrevNode(oldTail);
            oldTail.setNextNode(this.tail);
        }

        this.setSize(this.size() + 1);
    }

    public E removeFirst() {
        if (this.size() == 0) {
            throw new IllegalArgumentException("The list is empty!");
        }
        E firstElement = this.head.getValue();
        this.head = this.head.getNextNode();
        if (this.size() > 1) {
            this.head.setPrevNode(null);
        }
        if (this.size() <= 2) {
            this.tail = this.head;
        }
        this.setSize(this.size() - 1);
        return firstElement;
    }

    public E removeLast() {
        if (this.size() == 0) {
            throw new IllegalArgumentException();
        }

        E lastItem = this.tail.getValue();
        if (this.size() > 2) {
            this.tail = this.tail.getPrevNode();
            this.tail.setNextNode(null);
        } else if (this.size() == 2) { // Size will be 1 after decrement;
            this.head.setNextNode(null);
            this.tail = this.head;
        } else if (this.size() == 1) { // Size will be 0 after decrement;
            this.head = null;
            this.tail = null;
        }

        this.setSize(this.size() - 1);
        return lastItem;
    }

    @Override
    public Iterator<E> iterator() {
        return new Ex06_DoublyLinkedListIterator();
    }

    private final class Ex06_DoublyLinkedListIterator implements Iterator<E> {
        Node currentNode;

        public Ex06_DoublyLinkedListIterator() {
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

    @Override
    public void forEach(Consumer<? super E> action) {
        Node currentNode = this.head;

        while(currentNode != null) {
            action.accept(currentNode.getValue());
            currentNode = currentNode.getNextNode();
        }
    }

    @SuppressWarnings("unchecked")
    public E[] toArray() {
        E[] result = (E[]) new Object[this.size()];
        int index = 0;
        Node currentNode = this.head;

        while(currentNode != null) {
            result[index++] = currentNode.getValue();
            currentNode = currentNode.getNextNode();
        }

        return result;
    }

    private class Node {
        private E value;
        private Node next;
        private Node prev;

        public Node(E value) {
            this.setValue(value);
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Node getNextNode() {
            return next;
        }

        public void setNextNode(Node next) {
            this.next = next;
        }

        public Node getPrevNode() {
            return prev;
        }

        public void setPrevNode(Node prev) {
            this.prev = prev;
        }
    }
}
