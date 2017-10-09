import java.util.function.Function;
import java.util.function.IntToDoubleFunction;

public class Demo {
    public static void main(String[] args) {

        int a = 10;
        System.out.println(operation(a, number -> number * 5));
        System.out.println(operation(a, number -> number - 5));
        System.out.println(operation(a, number -> number % 5));
        System.out.println(operation(a, number -> number / 5));


    }

    public static int operation(int number, Function<Integer, Integer> function) {
        return function.apply(number);
    }
}
