package Ex09_CustomListIterator;

public interface Sortable<T extends Comparable> {

    CustomList<T> sort(CustomList<T> customList);
}
