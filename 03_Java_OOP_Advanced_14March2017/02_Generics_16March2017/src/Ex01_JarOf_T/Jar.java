package Ex01_JarOf_T;


import java.util.ArrayDeque;
import java.util.Deque;

public class Jar<E> {

    private Deque<E> contents;

    public Jar() {
        this.contents = new ArrayDeque<E>();
    }

    public void add(E element) {
        this.contents.push(element);
    }

    public E remove() {
        return this.contents.pop();
    }


}
