package Ex04_Froggy;


import java.util.Iterator;
import java.util.List;

public class Lake<T> implements Iterable<T> {
    private List<T> lakeNumbers;

    public Lake(List<T> lakeNumbers) {
        this.lakeNumbers = lakeNumbers;
    }



    @Override
    public Iterator<T> iterator() {
        return new lakeIterator();
    }

    private final class lakeIterator implements Iterator<T> {
        private int evenIndex = 0;
        private int oddIndex = 1;

        @Override
        public boolean hasNext() {
            return this.evenIndex < lakeNumbers.size() || this.oddIndex < lakeNumbers.size();
        }

        @Override
        public T next() {
            if (this.evenIndex < lakeNumbers.size()) {
                T current = lakeNumbers.get(this.evenIndex);
                this.evenIndex += 2;
                return current;
            }

            T current = lakeNumbers.get(this.oddIndex);
            this.oddIndex += 2;
            return current;
        }
    }
}
