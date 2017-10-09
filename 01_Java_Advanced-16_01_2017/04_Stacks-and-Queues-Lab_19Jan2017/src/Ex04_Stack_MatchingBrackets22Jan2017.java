import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayDeque;

public class Ex04_Stack_MatchingBrackets22Jan2017 {
    public static void main(String[] args){
        Locale.setDefault(Locale.ROOT);
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();

        ArrayDeque<Integer> indexParentheses = new ArrayDeque<Integer>();

        for (int index = 0; index < expression.length(); index++) {
            char currentSymbol = expression.charAt(index);
            if(currentSymbol == '('){
                indexParentheses.push(index);
            } else if(currentSymbol == ')'){
                int startIndex = indexParentheses.pop();
                String sub = expression.substring(startIndex, index + 1);
                System.out.println(sub);
            }
        }
    }
}
//Input
//1 + (2 - (2 + 3) * 4 / (3 + 1)) * 5
//(2 + 3) - (2 + 3)