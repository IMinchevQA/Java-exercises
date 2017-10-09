import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;

public class Ex03_CustomMinFunction_10Feb2017 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        int[] numbers = Arrays.stream(input.substring(0, input.length()).split("\\s+"))
                .map(String::trim).mapToInt(Integer::parseInt).toArray();

        Function<int[], Integer> minNum = n -> Arrays.stream(n).min().getAsInt();
        Consumer<String> printMinNumber = minNumber -> System.out.println(minNumber);

        printMinNumber.accept(minNum.apply(numbers).toString());
    }
}

/*
Input 1:
1 4 3 2 1 7 13

Output 1:
1
 */