package Ex09_CollectionHierarchy.implementation;

import Ex09_CollectionHierarchy.interfaces.Addable;

import java.util.ArrayList;
import java.util.List;


public class AddCollectionImpl implements Addable {
    private List<String> elements;

    public AddCollectionImpl() {
        this.elements = new ArrayList<>();
    }

    @Override
    public int add(String element) {
        this.elements.add(element);
        return this.elements.lastIndexOf(element);
    }
}
