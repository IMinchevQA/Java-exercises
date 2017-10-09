package Ex04_GenericSwapMethodInteger;

import java.util.List;

public interface Box<P> {

    @Override
    String toString();

    void addBox(Box box);

    void swap(String[] indices);

    List<Box> getListOfBoxes();
}
