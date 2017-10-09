import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Ex02_KnightsOfHonor_10Feb2017 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> knightsNames = Arrays.asList(reader.readLine().split("\\s+"));
        Consumer<String> print = name -> System.out.println("Sir " + name);

        for (String name : knightsNames) {
            print.accept(name);
        }
    }
}


/*
Input 1:
Pesho Gosho Adasha StanleyRoyce


Output 1:
Sir Pesho
Sir Gosho
Sir Adasha
Sir StanleyRoyce



 */