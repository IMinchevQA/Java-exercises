import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

public class Ex02_SumNumbers_10Feb2017 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(",\\s+");

        Function<String, Integer> parser = s -> Integer.parseInt(s);

        int sum = 0;

        for (String s : input) {
            sum += parser.apply(s);
        }

        System.out.printf("Count = %1$s\n", input.length);
        System.out.printf("Sum = %1$s\n", sum);
    }
}


/*
Input 1:
4, 2, 1, 3, 5, 7, 1, 4, 2, 12

Expected output 1:
Count = 10
Sum = 41



Input 2:
2, 4, 6

Expected output 2:
Count = 3
Sum = 12


*/