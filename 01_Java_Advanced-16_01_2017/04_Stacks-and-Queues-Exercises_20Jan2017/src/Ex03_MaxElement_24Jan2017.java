import java.util.*;

public class Ex03_MaxElement_24Jan2017 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner scanner = new Scanner(System.in);
        int countCommandLines = scanner.nextInt();
        Deque<Integer> numbers = new ArrayDeque<Integer>();
        Deque<Integer> maxNumbers = new ArrayDeque<Integer>();
        int maxNumber = Integer.MIN_VALUE;

        for (int i = 0; i < countCommandLines; i++) {
            int command = scanner.nextInt();
            if(command == 1) {

                int numToPush = scanner.nextInt();
                numbers.push(numToPush);
                if (maxNumber <= numToPush) {
                    maxNumber = numToPush;
                    maxNumbers.push(maxNumber);
                }
            } else if(command == 2) {
                int poppedNumber = numbers.pop();
                if (poppedNumber == maxNumber) {
                    maxNumbers.pop();
                    if (maxNumbers.size() > 0) {
                        maxNumber = maxNumbers.peek();
                    } else {
                        maxNumber = Integer.MIN_VALUE;
                    }
                }
            } else {
                System.out.println(maxNumber);
            }
        }
    }
}

//Input
//9
//        1 97
//        2
//        1 20
//        2
//        1 26
//        1 20
//        3
//        1 91
//        3
//Inportant link - http://forum.tutorials7.com/1587/maximum-element-java-task-stacks
//Remark: the first number is for 1 - Push element on the top, 2 Delete element on the top, 3 - print max num
// the second num is the number that will be pushed in the stack.



//Lambda slows down the program and the execution exceeds - Time: 0.686 s
//            String currentLine = scanner.nextLine();
//The following array contains - Index 0: operation, Index 1: operation number
//            int[] numsRow = Arrays.stream(currentLine.substring(0, currentLine.length()).split("\\s+"))
//                    .map(String::trim).mapToInt(Integer::parseInt).toArray();