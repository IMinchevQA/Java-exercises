package Ex04_LinkedStack;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Ivan Minchev on 9/25/2017.
 */
public class Main {
    public static void main(String[] args) {
        LinkedStack<Integer> stack = new LinkedStack<>();

        stack.push(5);
        stack.push(8);
        stack.push(-2);
        stack.push(11);
        stack.push(6);

        Integer[] array = stack.toArray(Integer.class);
        String[] resultArr = Stream.of(array)
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(" "))
                .split("\\s+");

        System.out.println(String.join(", ", resultArr));
    }
}
