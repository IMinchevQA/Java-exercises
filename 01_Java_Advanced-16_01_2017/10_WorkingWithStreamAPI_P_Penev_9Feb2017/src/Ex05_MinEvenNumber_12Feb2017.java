import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ex05_MinEvenNumber_12Feb2017 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> tokens = Arrays.asList(reader.readLine().split("\\s+"));

        OptionalDouble min = tokens.stream()
                .filter(x -> !x.isEmpty())
                .mapToDouble(x -> Double.valueOf(x))
                .filter(x -> x % 2 == 0)
                .min();

        if (min.isPresent()) {
            System.out.printf("%.2f", min.getAsDouble());
        } else {
            System.out.println("No match");
        }
    }
}


/*
Input 1:
1 2 3 4 5 6

Output 1:
2.00

Input 2:
3.14 -2.00 1.33

Output 2:
-2.00


Input 3:
(empty list)

Output 3:
No match
 */
