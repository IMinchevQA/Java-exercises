import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Ex04_FindEvenOrOdds_10Feb2017 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String rangeStr = reader.readLine();

        int[] range = Arrays.stream(rangeStr.substring(0, rangeStr.length()).split("\\s+"))
                .map(String::trim).mapToInt(Integer::parseInt).toArray();

        String oddOrEven = reader.readLine();

        Predicate<Integer> tester = createTester(oddOrEven);
        Consumer<Integer> printer = num -> System.out.print(num + " ");

        for (int i = range[0]; i <= range[1]; i++) {
            if (tester.test(i)) {
                printer.accept(i);
            }
        }
    }

    private static Predicate<Integer> createTester(String oddOrEven) {
        switch(oddOrEven) {
            case "odd" :
                return x -> x % 2 != 0;
            case "even" :
                return x -> x % 2 == 0;
            default:
                return null;
        }
    }
}



/*
Input 1:
1 10
odd

Output 1:
1 3 5 7 9


Input 2:
20 30
even

Output 2:
20 22 24 26 28 30


 */