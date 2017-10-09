import java.util.*;

public class Ex10_StackFibonacci_25Jan2017 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Deque<Long> fibonacciNums = new ArrayDeque<>();
        fibonacciNums.push(Long.parseLong("1"));
        fibonacciNums.push(Long.parseLong("1"));

        while (n > 1) {
            long lastNum = fibonacciNums.pop();
            long fibNum = lastNum + fibonacciNums.peek();
            fibonacciNums.push(lastNum);
            fibonacciNums.push(fibNum);
            n--;
        }

        System.out.println(fibonacciNums.pop());
    }
}

//Input - any integer number btw. 1 and 49
