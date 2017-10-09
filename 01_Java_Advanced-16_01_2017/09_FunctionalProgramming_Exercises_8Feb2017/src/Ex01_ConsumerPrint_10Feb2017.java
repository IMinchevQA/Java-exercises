import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

public class Ex01_ConsumerPrint_10Feb2017 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");
        Consumer<String> print = name -> System.out.println(name);

        for (int i = 0; i < input.length; i++) {
            print.accept(input[i]);
        }
    }
}


/*
Input 1:
Pesho Gosho Adasha


Output 1:
Pesho
Gosho
Adasha


 */