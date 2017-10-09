import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Ex01_TakeTwo_11Feb2017 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split("\\s+");

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < tokens.length; i++) {
            numbers.add(Integer.valueOf(tokens[i]));
        }

        numbers.stream()
                .distinct()
                .filter(x -> 10 <= x && x <= 20)
                .limit(2)
                .forEach(x -> System.out.print(x + " "));

        System.out.println();
    }
}


/*
Input 1:
15 2 15 14 12

Output 1:
15 14


Input 2:
17 -2 3

Output 3:
17


Input 3:
-2 3

Output 3:
(no output)
 */