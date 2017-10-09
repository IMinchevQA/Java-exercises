import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class Ex06_FindAndSumIntegers12Feb2017 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List <String> numbersStr = Arrays.asList(reader.readLine().split("\\s+"));

        OptionalInt sum = numbersStr.stream()
                .filter(x -> isInteger(x))
                .mapToInt(x -> Integer.valueOf(x))
                .reduce((x ,y) -> x + y);

        if (sum.isPresent()) {
            System.out.println(sum.getAsInt());
        } else {
            System.out.println("No match");
        }
    }

    private static boolean isInteger(String string) {
        if (string.isEmpty()) {
            return false;
        }

        char[] characters = string.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            if (i == 0) {
                if (string.charAt(0) == '-' || string.charAt(0) == '+') {
                    continue;
                }
            }

            if (!Character.isDigit(characters[i])) {
                return false;
            }
        }
        return true;
    }
}


/*
Input 1:
Sum 3 and 4

Output 1:
7

Input 2:
Sum -3 and -4

Output 2:
-7


Input 3:
Sum three and four

Output 3:
No match
 */
