package Ex01_ListyIterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListyIterator<T> implements Iterable<T> {

    private List<T> elements;
    private int index;


    public ListyIterator(T... elements) {
        this.elements = Arrays.asList(elements);

    }

    @Override
    public Iterator<T> iterator() {
        return new LIterator();
    }

    boolean move() {
        if (this.iterator().hasNext()) {
            this.iterator().next();
            return true;
        }
        return false;
    }

    private final class LIterator implements Iterator<T> {

        @Override
        public boolean hasNext() {
            return index < elements.size() - 1;
        }

        @Override
        public T next() {
            return elements.get(index++);
        }

        @Override
        public String toString() {
            return elements.get(index).toString();
        }
    }
}
