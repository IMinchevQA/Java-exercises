import java.util.ArrayDeque;
import java.util.Locale;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args){
        Locale.setDefault(Locale.ROOT);
        Locale.setDefault(Locale.ROOT);
        ArrayDeque<Integer> numbers = new ArrayDeque<Integer>();

        for (int i = 1; i <= 4 ; i++) {
            numbers.add(i);
        }

        numbers.push(5);



        while (!numbers.isEmpty()){
            System.out.println(numbers.remove());
        }

        //Avoid such a stack instantiation.
        //Recommended by Oracle because of performance issues.
//        Stack<Integer> stack = new Stack<Integer>();
//        stack.push(12);
//        int element = stack.peek();
//        System.out.println(stack);
//        element = stack.pop();
//        System.out.println(stack);

        //Recommended stack implementation based on the array
    }
}
