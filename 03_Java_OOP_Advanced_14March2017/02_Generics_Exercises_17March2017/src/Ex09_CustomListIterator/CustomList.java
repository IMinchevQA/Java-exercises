package Ex09_CustomListIterator;


import java.util.Iterator;

public interface CustomList<T> {

    void add(T element);

    T remove(int index);

    boolean contains(T element);

    void swap(int index1, int index2);

    int countGreatherThat(T element);

    T getMax();

    T getMin();

    int getSize();

    T getElement(int index);

    void sort();

}
