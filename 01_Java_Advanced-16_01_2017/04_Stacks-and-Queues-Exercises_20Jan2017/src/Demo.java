import java.util.*;

public class Demo {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split("\\s+");
        Deque<String> numbersQueue = new ArrayDeque<>();
        Deque<String> operatorStack = new ArrayDeque<>();


        for (String s : input) {
            if(Character.isDigit(s.charAt(0)) || Character.isLetter(s.charAt(0))) {
                numbersQueue.offer(s);
            } else {
                String lastOperator = operatorStack.peek();
                try {
                    if (s.equals("+") || s.equals("-")) {
                        if (lastOperator.equals("+") || lastOperator.equals("-")) {
                            numbersQueue.offer(operatorStack.pop());
                            operatorStack.push(s);
                        } else {
                            operatorStack.push(s);
                        }
                    } else if (s.equals("*") || s.equals("/")) {
                        if (lastOperator.equals("*") || lastOperator.equals("/")) {
                            numbersQueue.offer(operatorStack.pop());
                            operatorStack.push(s);
                        } else {
                            operatorStack.push(s);
                        }
                    } else if (s.equals("(")) {
                        operatorStack.push(s);
                    } else if (s.equals(")")) {
                        while (!operatorStack.peek().equals("(")) {
                            numbersQueue.offer(operatorStack.pop());
                        }
                        //Removing the non-necessary open parenthesis '('
                        operatorStack.pop();
                    } else {

                    }
                } catch (Exception ex){
                    operatorStack.push(s);
                }
            }
        }

        while (!numbersQueue.isEmpty()){
            System.out.print(numbersQueue.poll() + " ");
        }

        while (!operatorStack.isEmpty()){
            System.out.print(operatorStack.pop() + " ");
        }
        System.out.println();
    }
}
