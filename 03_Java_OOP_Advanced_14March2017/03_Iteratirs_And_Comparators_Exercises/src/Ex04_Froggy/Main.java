package Ex04_Froggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = Arrays.stream(reader.readLine().split("[ ,]+")).map(Integer::parseInt).collect(Collectors.toList());
        reader.readLine();

        Lake<Integer> lake = new Lake<>(numbers);
        StringBuilder sb = new StringBuilder();


        for (Integer number : lake) {
            sb.append(String.format("%s, ", number));
        }
        sb.setLength(sb.length() - 2);
        System.out.println(sb);

    }
}

/*
Input 1:
1, 2, 3, 4, 5, 6, 7, 8
END

Expected output 1:
1, 3, 5, 7, 2, 4, 6, 8



Input 2:
1, 2, 3
END

Expected output 2:
1, 3, 2

 */
