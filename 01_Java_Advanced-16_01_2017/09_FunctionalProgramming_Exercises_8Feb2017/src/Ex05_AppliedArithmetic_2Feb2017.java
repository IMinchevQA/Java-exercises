import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class Ex05_AppliedArithmetic_2Feb2017 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BiFunction<String, Integer, Integer> calculate = (op, number) -> {
            switch (op) {
                case "add":
                    return number + 1;
                case "multiply":
                    return number * 2;
                case "subtract":
                    return number - 1;
                default:
                    return null;
            }
        };

        Consumer<int[]> print = x -> {
            StringBuilder sb = new StringBuilder();
            for (int i : x) {
                sb.append(i).append(" ");
            }
            System.out.println(sb.toString().trim());
        };


        int[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        String command = "";
        while (!("end".equals(command = reader.readLine()))) {
            if (!"print".equals(command)) {
                for (int i = 0; i < numbers.length; i++) {
                    numbers[i] = calculate.apply(command, numbers[i]);
                }
            } else {
                print.accept(numbers);
            }
        }
    }
}


/*
Input 1:
1 2 3 4 5
add
add
print
end


Output 1:
3 4 5 6 7




Input 2:
5 10
multiply
subtract
print
end

Output 2:
9 19


 */
