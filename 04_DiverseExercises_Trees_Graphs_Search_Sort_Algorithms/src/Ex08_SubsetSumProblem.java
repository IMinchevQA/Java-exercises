/**
 * Created by Ivan Minchev on 9/27/2017.
 */
public class Ex08_SubsetSumProblem {
    static boolean[][] dp;
    public static void main(String[] args) {
//        int[] ints = {3, 34, 4, 12, 5, 2};
        int[] ints = {1, 2, 4, 5, 1};
        int n = ints.length;

        int sum = 15;

        if (isSubsetSum(ints, n, sum)) {
            System.out.println("Found a subset with given sum");
        } else {
            System.out.println("No subset with given sum found");
        }
    }

    //http://www.geeksforgeeks.org/dynamic-programming-subset-sum-problem/
    static boolean isSubsetSum(int[] set, int n, int sum) {
        if (n == 0 || sum < 0) {
            return false;
        }

        dp = new boolean[n][sum + 1];

        // Sum 0 can be always achieved by 0 elements
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        // Sum set[0] can be achieved
        if (set[0] <= sum) {
            dp[0][set[0]] = true;
        }

        // Fill the rest entries ot dp[][]
        for (int i = 1; i < n; i++) {
            int currentSetElement = set[i];
            for (int j = 1; j <= sum; j++) {
                if (currentSetElement <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - currentSetElement];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n - 1][sum];
    }




//    static boolean isSubsetSum(int[] set, int n, int sum) {
//        // The value of subset[i][j] will be true if there
//        // is a subset of set[0..j-1] with sum equal to i
//        boolean[][] subset = new boolean[sum + 1][n + 1];
//
//        // If sum is 0, then answer is true
//        for (int i = 0; i <= n; i++) {
//            subset[0][i] = true;
//        }
//
//        // If sum is not 0 and set is empty, then answer is false
//        for (int i = 1; i <= sum; i++) {
//            subset[i][0] = false;
//        }
//
//        // Fill the subset table in bottom up manner
//        for (int i = 1; i <= sum; i++) {
//            for (int j = 1; j <= n; j++) {
//                subset[i][j] = subset[i][j - 1];
//                if (i >= set[j - 1]) {
//                    subset[i][j] = subset[i][j] ||
//                    subset[i - set[j-1]][j-1];
//                }
//            }
//        }
//
//        for (int i = 0; i <= sum; i++) {
//            for (int j = 0; j <= n; j++) {
//                System.out.printf("%s ", subset[i][j]);
//            }
//            System.out.println();
//        }
//        return subset[sum][n];
//    }
}
