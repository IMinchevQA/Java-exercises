package Ex09_CollectionHierarchy.implementation;

import Ex09_CollectionHierarchy.interfaces.Addable;
import Ex09_CollectionHierarchy.interfaces.Removable;
import Ex09_CollectionHierarchy.interfaces.Usable;

import java.util.ArrayList;
import java.util.List;


public class MyListImpl implements Usable {
    private List<String> elements;

    public MyListImpl() {
        this.elements = new ArrayList<>();
    }

    @Override
    public int used() {
        return this.elements.size();
    }

    @Override
    public int add(String element) {
        this.elements.add(0, element);
        return 0;
    }

    @Override
    public String remove() {
        return this.elements.remove(0);
    }
}
