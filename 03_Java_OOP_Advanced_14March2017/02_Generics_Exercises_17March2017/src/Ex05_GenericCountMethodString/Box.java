package Ex05_GenericCountMethodString;

import java.util.List;

public interface Box<P> {

    @Override
    String toString();

    void addBox(Box box);

    void swap(String[] indices);

    List<Box> getListOfBoxes();

    int compare(List<Box> listOfBoxes, String str);

    P getValue();
}
