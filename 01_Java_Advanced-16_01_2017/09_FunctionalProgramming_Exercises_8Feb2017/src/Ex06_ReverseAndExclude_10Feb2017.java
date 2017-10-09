import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class Ex06_ReverseAndExclude_10Feb2017 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(String::trim).mapToInt(Integer::parseInt).toArray();

        int n = Integer.parseInt(reader.readLine());

        BiPredicate<Integer, Integer> divCheck = (x, y) -> x % y != 0;

        Consumer<int[]> printRevNums = x -> {
            StringBuilder sb = new StringBuilder();

            for (int i = x.length - 1; i >= 0; i--) {
                if(divCheck.test(x[i], n)){
                    sb.append(x[i]).append(" ");
                }
            }

            System.out.println(sb.toString().trim());
        };
        printRevNums.accept(numbers);
    }
}

/*
Input 1:
1 2 3 4 5 6
2

Output 1:
5 3 1


Input 2:
20 10 40 30 60 50
3

Output 2:
50 40 10 20

 */
