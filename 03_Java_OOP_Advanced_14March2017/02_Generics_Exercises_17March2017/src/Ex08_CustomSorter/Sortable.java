package Ex08_CustomSorter;

public interface Sortable<T extends Comparable> {

    CustomList<T> sort(CustomList<T> customList);
}
