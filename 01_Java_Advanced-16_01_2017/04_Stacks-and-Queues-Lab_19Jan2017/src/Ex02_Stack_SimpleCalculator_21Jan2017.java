import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class Ex02_Stack_SimpleCalculator_21Jan2017 {
    public static void main(String[] args){
        Locale.setDefault(Locale.ROOT);
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split("\\s+");

        ArrayDeque<String> stack = new ArrayDeque<String>();
        Collections.addAll(stack, tokens);

        while (stack.size() > 1) {
            int firstOperand = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int secondOperand = Integer.parseInt(stack.pop());

            switch(operator){
                case "+":
                    stack.push(String.valueOf(firstOperand + secondOperand));
                    break;
                case "-":
                    stack.push(String.valueOf(firstOperand - secondOperand));
                    break;
            }
        }
        System.out.println(stack.pop());
    }
}


//Input
//2 + 5 + 10 - 2 - 1
//2 - 2 + 5