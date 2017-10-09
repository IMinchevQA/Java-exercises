import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex08_BoundedNumbers_12Feb2017 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> bounds = Stream.of(reader.readLine()
                .split("\\s+"))
                .map(Integer::valueOf)
                .sorted()
                .collect(Collectors.toList());

        Stream.of(reader.readLine()
            .split("\\s+"))
            .map(Integer::valueOf)
            .filter(x -> bounds.get(0) <= x && x <= bounds.get(1))
            .forEach(x -> System.out.print(x + " "));
    }
}


/*
Input 1:
5 7
1 2 3 4 5 6 7 8 9



Output 1:
5 6 7



Input 2:
7 5
9 5 7 2 6 8


Output 2:
5 7 6



Input 3:
3 4
5 6 7 8


Output 3:
(no output)

 */