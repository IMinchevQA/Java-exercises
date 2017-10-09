package Ex06_GenericFlatMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>(Arrays.asList(1, 5, 6, 123, 13, 28));

        List<Double> doubles = new ArrayList<>(Arrays.asList(2.2, 3.2));

        List<List<? extends Number>> jagged = new ArrayList<>(Arrays.asList(ints, doubles));

        List<Number> numbers = new ArrayList<>();

        ListUtils.flatten(numbers, jagged);
    }
}
