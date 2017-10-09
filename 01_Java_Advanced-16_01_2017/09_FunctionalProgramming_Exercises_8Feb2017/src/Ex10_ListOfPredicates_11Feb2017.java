import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Ex10_ListOfPredicates_11Feb2017 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        int[] divisors = Arrays.stream(reader.readLine().split("\\s+"))
                .map(String::trim).mapToInt(Integer::parseInt).toArray();

        List<Predicate<Integer>> isDivisable = new ArrayList<>();

        Function<Integer, Predicate<Integer>> genPredicate = x -> createPredicate(x);

        for (int number : divisors) {
            isDivisable.add(genPredicate.apply(number));
        }

        int startNumber = Arrays.stream(divisors).min().getAsInt();
        StringBuilder result = new StringBuilder();
        for (int i = startNumber; i <= n ; i++) {
            int cnt = 0;
            for (Predicate<Integer> integerPredicate : isDivisable) {
                if (integerPredicate.test(i)) {
                    cnt++;
                }
            }
            if (cnt == isDivisable.size()) {
                result.append(i).append(" ");
            }
        }
        System.out.println(result.toString().trim());
    }
    public static Predicate<Integer> createPredicate(int number) {
        return x -> x % number == 0;
    }
}

/*
Input 1:
10
1 1 1 2

Output 1:
2 4 6 8 10


Input 2:
100
2 5 10 20


Output 2:
20 40 60 80 100


 */
