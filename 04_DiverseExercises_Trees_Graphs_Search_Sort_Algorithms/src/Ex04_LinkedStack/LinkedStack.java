package Ex04_LinkedStack;

import java.lang.reflect.Array;
import java.util.Iterator;

/**
 * Created by Ivan Minchev on 9/25/2017.
 */
public class LinkedStack<E> {
    private StackNode top;
    private int count;

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void push(E element) {
        this.top = new StackNode(element, this.top);
        this.count++;
    }

    public E pop() {
        if (this.count == 0) {
            throw new UnsupportedOperationException();
        }
        E result = this.top.getValue();
        this.top = this.top.getNextNode();
        this.count--;
        return result;
    }

    public E peek() {
        if (this.count == 0) {
            throw new UnsupportedOperationException();
        }
        return this.top.getValue();
    }

    @SuppressWarnings("unchecked")
    public E[] toArray(Class<E> cl) {
        E[] arr = (E[]) Array.newInstance(cl, this.count);
        StackNode current = this.top;
        int index = 0;
        while (current != null) {
            arr[index++] = current.getValue();
            current = current.getNextNode();
        }
        return arr;
    }

    private  class StackNode {
        private E value;
        private StackNode next;

        public StackNode(E value , StackNode next) {
            this.value = value;
            this.next = next;
        }

        public StackNode getNextNode() {
            return this.next;
        }

        public void setNextNode(StackNode next) {
            this.next = next;
        }

        public E getValue() {
            return this.value;
        }

        public void setValue(E value) {
            this.value = value;
        }
    }
}
