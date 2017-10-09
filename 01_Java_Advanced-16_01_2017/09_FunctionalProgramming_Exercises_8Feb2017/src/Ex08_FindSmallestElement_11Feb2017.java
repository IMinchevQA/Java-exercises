import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Ex08_FindSmallestElement_11Feb2017 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = Arrays.stream(reader.readLine().split("\\s+"))
                .map(String::trim).toArray(String[]::new);

        List<Integer> numbers = new ArrayList<>();

        for (String s : input) {
            numbers.add(Integer.parseInt(s));
        }

        Function<List<Integer>, Integer> minNumIndex = x -> {
            int minValue = x.get(0);
            int minIndex = 0;
            for (int i = 1; i < x.size(); i++) {
                if (x.get(i) <= minValue) {
                    minValue = x.get(i);
                    minIndex = i;
                }
            }
            return minIndex;
        };
        Consumer<Integer> printIndex = i -> System.out.println(i);
        printIndex.accept(minNumIndex.apply(numbers));
    }
}


/*
Input 1:
1 2 3  0  4 5 6

Output 1:
3


Input 2:
123 10     11 3

Output 1:
3
 */