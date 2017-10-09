package Ex04_GenericSwapMethodInteger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoxImpl<P> implements Box<P> {
    private static List<Box> listOfBoxes = new ArrayList<>();
    private P value;

    public BoxImpl(P value) {
        this.value = value;
    }

    public BoxImpl() {

    }

    public void swap(String[] swapIndices) {
        int index1 = Integer.parseInt(swapIndices[0]);
        int index2 = Integer.parseInt(swapIndices[1]);
        Box tempElement = listOfBoxes.get(index1);
        listOfBoxes.set(index1, listOfBoxes.get(index2));
        listOfBoxes.set(index2, tempElement);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.value.getClass().toString().substring(6))
                .append(": ")
                .append(value);

        return sb.toString();
    }

    public void addBox(Box box) {
        listOfBoxes.add(box);
    }

    public List<Box> getListOfBoxes() {
        return Collections.unmodifiableList(listOfBoxes);
    }
}
