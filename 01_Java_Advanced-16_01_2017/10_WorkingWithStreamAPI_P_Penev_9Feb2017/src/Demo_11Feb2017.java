import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo_11Feb2017 {
    public static void main(String[] args) {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        List<String> elements = new ArrayList<>();
//        Collections.addAll(elements, "one", "two");
//
//        elements.stream()
//                .distinct()
//                .forEach(s -> System.out.println(s));


//        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 4, 4, 5, 6, 6, 7, 8, 9 ,10));

        String[] strings = { "22", "11", "13" };
        List<Integer> numbers = Arrays.stream(strings)
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        System.out.println(numbers);


//        numbers.stream().distinct().filter(x -> 4 < x && x < 10).forEachOrdered(x-> result.add(x));
//
//        List<Integer> limitTest = new ArrayList<>();
//        numbers.stream()
//                .limit(2).forEachOrdered(x -> limitTest.add(x));
//
//        System.out.println(limitTest);




    }
}


