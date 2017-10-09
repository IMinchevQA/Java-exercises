import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;

public class Ex04_AveragOfDoubles_12Feb2017 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> tokens = Arrays.asList(reader.readLine().split("\\s+"));

        DoubleStream stream = tokens.stream()
                .filter(x -> !x.isEmpty())
                .mapToDouble(x -> Double.valueOf(x));
        OptionalDouble result = stream.average();
        if (result.isPresent()) {
            System.out.printf("%.2f", result.getAsDouble());
        } else {
            System.out.println("No match");
        }
    }
}


/*
Input 1:
3 4 5 6

Output 1:
4.50

Input 2:
3.14 5.2 6.18

Output 2:
4.84


Input 3:
(empty list)

Output 3:
No match
 */
