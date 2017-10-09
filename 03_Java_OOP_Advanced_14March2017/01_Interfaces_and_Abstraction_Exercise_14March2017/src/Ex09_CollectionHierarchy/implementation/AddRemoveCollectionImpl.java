package Ex09_CollectionHierarchy.implementation;

import Ex09_CollectionHierarchy.interfaces.Removable;

import java.util.ArrayList;
import java.util.List;

public class AddRemoveCollectionImpl implements Removable {

    private List<String> elements;

    public AddRemoveCollectionImpl() {
        this.elements = new ArrayList<>();
    }

    @Override
    public String remove() {
        return this.elements.remove(this.elements.size() - 1);
    }

    @Override
    public int add(String element) {
        elements.add(0, element);
        return 0;
    }
}
