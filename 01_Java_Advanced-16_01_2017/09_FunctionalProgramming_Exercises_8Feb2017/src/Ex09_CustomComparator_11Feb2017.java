import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Ex09_CustomComparator_11Feb2017 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = Arrays.stream(reader.readLine().split("\\s+"))
                .map(String::trim).toArray(String[]::new);

        List<Integer> numbers = new ArrayList<>();

        for (String s : input) {
            numbers.add(Integer.parseInt(s));
        }

        numbers.sort((a, b) -> a.compareTo(b));

        Predicate<Integer> isEven = x -> x % 2 == 0;
        Consumer<List<Integer>> print = x -> {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < x.size();  i++) {
                if (isEven.test(x.get(i))) {
                    sb.append(x.get(i)).append(" ");
                }
            }
            for (int i = 0; i < x.size();  i++) {
                if (!isEven.test(x.get(i))) {
                    sb.append(x.get(i)).append(" ");
                }
            }
            System.out.println(sb.toString().trim());
        };
        print.accept(numbers);
    }
}


/*
Input 1:
1 2 3 4 5 6

Output 1:
2 4 6 1 3 5


Input 2:
-3 2

Output 1:
2 -3
 */
