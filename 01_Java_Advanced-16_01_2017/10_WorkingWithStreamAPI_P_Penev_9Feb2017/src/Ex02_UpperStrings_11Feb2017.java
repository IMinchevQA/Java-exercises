import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex02_UpperStrings_11Feb2017 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] names = reader.readLine().split("\\s+");

        Arrays.stream(names).map(x -> x.toUpperCase())
                .forEach(x-> System.out.print(x + " "));
    }
}

/*
Input 1:
Pesho Gosho Stefan

Output 1:
PESHO GOSHO STEFAN


Input 2:
Soft Uni Rocks

Output 2:
SOFT UNI ROCKS


Input 3:
(empty line)

Output 3:
(no output)

 */
