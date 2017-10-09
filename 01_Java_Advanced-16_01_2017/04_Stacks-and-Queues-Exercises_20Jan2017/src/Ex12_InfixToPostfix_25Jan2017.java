import java.util.*;

public class Ex12_InfixToPostfix_25Jan2017 {
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
                if (operatorStack.isEmpty()){
                    operatorStack.push(s);
                } else {
                    String lastOperator = operatorStack.peek();
                    if (s.equals("+") || s.equals("-")) {
                        if (lastOperator.equals("(")) {
                            operatorStack.push(s);
                        } else {
                            numbersQueue.offer(operatorStack.pop());
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
                    }
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

//Input 1: 5 / ( 3 + 2 )

//Input 2: 1 + 2 + 3

//Input 3: 7 + 13 / ( 12 - 4 )
//Input 4: ( 3 + x ) - y