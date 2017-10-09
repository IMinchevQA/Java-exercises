import java.util.*;

public class Ex08_BalancedParentheses_24Jan2017 {
    public static void main(String[] args){
        Locale.setDefault(Locale.ROOT);

        Scanner sc = new Scanner(System.in);
        char[] braces = sc.nextLine().toCharArray();

        if (braces.length % 2 !=0){
            System.out.println("NO");
            return;
        }

        Deque<Character> openBraces = new ArrayDeque<Character>();
        boolean isBalanced = true;

        for (Character brace : braces) {
            if (brace == '{' || brace == '[' || brace == '('){
                openBraces.push(brace);
            } else {
                char currentBrace = openBraces.pop();
                if(brace == '}') {
                    brace = '{';
                }
                if (brace == ']') {
                    brace = '[';
                }
                if (brace == ')') {
                    brace = '(';
                }
                if (brace != currentBrace){
                    System.out.println("NO");
                    return;
                }
            }
        }

        if(isBalanced){
            System.out.println("YES");
        }
    }
}

//Input
// {[()]} --> output "YES"

//---------
//{[(])} --> output "NO"

//--------
//{{[[(())]]}} --> output "YES"