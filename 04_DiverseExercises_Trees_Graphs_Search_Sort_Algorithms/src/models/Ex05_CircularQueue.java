package models;


public class Ex05_CircularQueue<E> {
    private static final int DEFAULT_CAPACITY = 4;
    private E[] elements;
    private int startIndex;
    private int endIndex;

    // It is the count of elements actually;
    private int size;

    public Ex05_CircularQueue() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public Ex05_CircularQueue(int initialCapacity) {
        this.setSize(0);
        this.elements = (E[]) new Object[initialCapacity];
    }


    public int size() {
        return this.size;
    }

    private  void setSize(int size) {
        this.size = size;
    }

    public void enqueue(E element) {
        if (this.size >= elements.length) {
            this.resize();
        }
        this.elements[this.endIndex] = element;
        this.endIndex = (this.endIndex + 1) % this.elements.length;
        this.size++;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        E[] newArray = (E[]) new Object[this.elements.length * 2];
        this.copyAllElements(newArray);
        this.elements = newArray;
        this.startIndex = 0;
        this.endIndex = this.size();
    }

    private void copyAllElements(E[] newArray) {
        int currentIndex = 0;
        int currentHead = this.startIndex;

        while (currentIndex < this.size()) {
            newArray[currentIndex] = this.elements[currentHead];
            currentHead = (currentHead + 1) % this.elements.length;
            currentIndex++;
        }
    }

    public E dequeue() {
        if (this.size == 0) {
            throw new IllegalArgumentException();
        }
        E result = this.elements[this.startIndex];
        this.startIndex = (this.startIndex + 1) % this.elements.length;
        this.size--;
        return result;
    }

    @SuppressWarnings("unchecked")
    public E[] toArray() {
        // TODO
        if (this.elements.length == 0) {
            throw new UnsupportedOperationException();
        }
        E[] result = (E[]) new Object[this.size()];
        int currentIndex = 0;
        int currentHead = this.startIndex;
        while (currentIndex < this.size()) {
            result[currentIndex] = this.elements[currentHead];
            currentHead = (currentHead + 1) % this.elements.length;
            currentIndex++;
        }

        return result;
    }

}
