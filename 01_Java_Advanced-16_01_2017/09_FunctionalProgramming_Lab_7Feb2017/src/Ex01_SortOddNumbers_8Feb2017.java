import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex01_SortOddNumbers_8Feb2017 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String input = reader.readLine();

        List<String> input = Arrays.asList(reader.readLine().split(", "));

        List<Integer> numbers = new ArrayList<>();

        for (String s : input) {
            numbers.add(Integer.parseInt(s));
        }

        StringBuilder sb = new StringBuilder();

        numbers.removeIf(n -> n %2 != 0);
        for (Integer number : numbers) {
            sb.append(number);
            sb.append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        System.out.println(sb);

        numbers.sort((a,b) -> a.compareTo(b));
        sb.delete(0, sb.length());
        for(Integer number : numbers) {
            sb.append(number);
            sb.append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        System.out.println(sb);
    }
}

/*
Input 1:
4, 2, 1, 3, 5, 7, 1, 4, 2, 12

Expected output 1:
4, 2, 4, 2, 12
2, 2, 4, 4, 12


Input 2:
1, 3, 5

Expected output 2:



Input 3:
2, 4, 6

Expected output 3:
2, 4, 6
2, 4, 6


 */

