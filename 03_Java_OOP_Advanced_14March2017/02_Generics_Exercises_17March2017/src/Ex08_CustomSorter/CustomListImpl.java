package Ex08_CustomSorter;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomListImpl<T extends Comparable<T>> implements CustomList<T>{
    private List<T> customList;

    public CustomListImpl() {
        this.customList = new ArrayList<>();
    }

    public void add(T element) {
        this.customList.add(element);
    }

    public T remove(int index){
        return this.customList.remove(index);
    }

    public boolean contains(T element){
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
        return (int)this.customList.stream().filter(e -> e.compareTo(element) > 0).count();
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
    public int getSize() {
        return this.customList.size();
    }

    @Override
    public T getElement(int index) {
        return this.customList.get(index);
    }

    public void sort(){
        this.customList.sort((a, b) -> a.compareTo(b));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T t : this.customList) {
            sb.append(String.format("%s%n", t));
        }
        return sb.toString().trim();
    }
}
