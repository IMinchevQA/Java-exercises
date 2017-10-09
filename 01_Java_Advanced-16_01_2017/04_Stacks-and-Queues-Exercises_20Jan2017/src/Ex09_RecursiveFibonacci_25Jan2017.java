import java.util.*;

public class Ex09_RecursiveFibonacci_25Jan2017 {
    private static long[] memo;

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        long[] fibonacciNumbers = new long[n + 1];

        fibonacciNumbers[0] = 1;
        fibonacciNumbers[1] = 1;
        for (int i = 2; i <= n; i++) {
            fibonacciNumbers[i] = fibonacciNumbers[i - 1] + fibonacciNumbers[i - 2];

        }
        System.out.println(fibonacciNumbers[n]);

    }
}

//Input - any integer number btw. 1 and 49


//Alternative solution with Top down DP: recursion + memoization
//private static long recursiveFibonacciWithMemoization(int n) {
//    if (n <= 1) {
//        return 1;
//    }
//
//    if (memo[n] != 0) {
//        return memo[n];
//    }
//
//    memo[n] =
//            recursiveFibonacciWithMemoization(n - 1) +
//                    recursiveFibonacciWithMemoization(n - 2);
//    return memo[n];
//}