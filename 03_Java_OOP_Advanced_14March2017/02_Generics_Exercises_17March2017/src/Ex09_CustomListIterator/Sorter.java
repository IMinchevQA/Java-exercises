package Ex09_CustomListIterator;

import java.text.Collator;
import java.util.*;

@SuppressWarnings("unchecked")
public class Sorter<T extends Comparable<T>> implements Sortable<T> {
    private CustomList<T> sortedList;

    public Sorter() {
        this.sortedList = new CustomListImpl<T>();
    }


    @Override
    @SuppressWarnings("unchecked")
    public CustomList<T> sort(CustomList<T> customList) {
        Collator rootCollator = Collator.getInstance(Locale.ROOT);
        List<T> forSort = new ArrayList<T>();
        for(int i = 0; i < customList.getSize(); i++) {
            forSort.add(customList.getElement(i));
        }

        forSort.sort(rootCollator);
        forSort.forEach(t -> this.sortedList.add(t));
        return this.sortedList;
    }
}
