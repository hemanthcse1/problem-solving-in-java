package examples.interviewquestions.dynamicprogramming.medium;

public class DominoAndTrominoTilingSolution {

    static class Solution {
        public int numTilings(int n) {
            int MOD = 1_000_000_007;
            if (n == 0) return 0;
            if (n == 1) return 1;
            if (n == 2) return 2;

            long[] dp = new long[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            dp[2] = 2;

            long sum = 0;
            for(int i = 3; i <= n; i++) {
                sum += dp[i - 3];
                dp[i] = (dp[i - 1] + dp[i - 2] + 2 * sum) % MOD;
            }

            return (int) dp[n];
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();

        int n1 = 3;
        System.out.println("Number of ways for n = 3: " + solution.numTilings(n1));


        int n2 = 1;
        System.out.println("Number of ways for n = 1: " + solution.numTilings(n2));

        int n8 = 1000;
        System.out.println("Number of ways for n = 1000: " + solution.numTilings(n8));
    }
}
