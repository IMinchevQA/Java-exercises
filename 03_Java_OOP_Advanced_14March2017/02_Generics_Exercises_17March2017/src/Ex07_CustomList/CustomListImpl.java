package Ex07_CustomList;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomListImpl<T extends Comparable<T>> implements CustomList<T>{
    private List<T> customList;

    public CustomListImpl() {
        this.customList = new ArrayList<T>();
    }

    @Override
    public void add(T element) {
        this.customList.add(element);
    }

    @Override
    public void remove(int index) {
        this.customList.remove(index);
    }

    @Override
    public boolean contains(T element) {
        return this.customList.contains(element);
    }

    @Override
    public void swap(int index1, int index2) {
        T temp = this.customList.get(index1);
        this.customList.set(index1, this.customList.get(index2));
        this.customList.set(index2, temp);
    }

    @Override
    public int countGreatherThat(T element) {
        int counter = 0;
        for (T t : this.customList) {
            if (t.compareTo(element) > 0) {
                counter++;
            }
        }
        return counter;
    }

    @Override
    public T getMax() {
        return Collections.max(this.customList);
    }

    @Override
    public T getMin() {
        return Collections.min(this.customList);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T t : this.customList) {
            sb.append(String.format("%s%n",t));
        }
        return sb.toString().trim();
    }
}
