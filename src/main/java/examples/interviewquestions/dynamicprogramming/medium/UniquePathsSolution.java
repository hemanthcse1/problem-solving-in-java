package examples.interviewquestions.dynamicprogramming.medium;

import java.util.Arrays;

public class UniquePathsSolution {

    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        UniquePathsSolution solution = new UniquePathsSolution();


        int m1 = 3, n1 = 7;
        System.out.println("Unique Paths for m=3, n=7: " + solution.uniquePaths(m1, n1));


        int m2 = 3, n2 = 2;
        System.out.println("Unique Paths for m=3, n=2: " + solution.uniquePaths(m2, n2));

    }
}
