package Ex05_NullFinder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        List<?> anyList;
//        List<Integer> integers = new ArrayList<>();
//        List<Double> doubles = new ArrayList<>();
//
//        anyList = integers;  //OK
//        anyList = doubles; //OK
//
//        anyList.add(1); // NOK, Compile time error!!!

        List<Integer> ints = new ArrayList<>( Arrays.asList(1, 2, null, 1, 2, 13, null));

        System.out.println(ListUtils.getNullIndices(ints));
    }
}
