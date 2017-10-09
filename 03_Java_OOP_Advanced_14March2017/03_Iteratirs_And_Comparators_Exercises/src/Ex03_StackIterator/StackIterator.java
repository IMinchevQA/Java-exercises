package Ex03_StackIterator;


import java.util.*;

public class StackIterator<T> implements Iterable<T> {
    private List<T> customStack;


    public StackIterator() {
        this.customStack = new ArrayList<>();
    }


    public void push(T element) {
        this.customStack.add(0, element);
    }

    public void pop() {
       this.customStack.remove(0);
    }

    @Override
    public Iterator<T> iterator() {
        return new stackIterator();
    }

    private final class stackIterator implements Iterator<T> {
        int index = 0;

        @Override
        public boolean hasNext() {
            return this.index < customStack.size();
        }

        @Override
        public T next() {
            return customStack.get(this.index++);
        }
    }
}