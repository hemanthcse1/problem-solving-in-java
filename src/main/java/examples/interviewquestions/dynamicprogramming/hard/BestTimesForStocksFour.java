package examples.interviewquestions.dynamicprogramming.hard;

public class BestTimesForStocksFour {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0 || k == 0) return 0;

        if (k >= n / 2) {
            int maxProfit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }

        int[][] dp = new int[k + 1][n];
        for (int t = 1; t <= k; t++) {
            int maxDiff = -prices[0];
            for (int i = 1; i < n; i++) {
                dp[t][i] = Math.max(dp[t][i - 1], prices[i] + maxDiff);
                maxDiff = Math.max(maxDiff, dp[t - 1][i] - prices[i]);
            }
        }

        return dp[k][n - 1];
    }

    public static void main(String[] args) {
        BestTimesForStocksFour solution = new BestTimesForStocksFour();
        System.out.println(solution.maxProfit(2, new int[]{2, 4, 1})); // 2
        System.out.println(solution.maxProfit(2, new int[]{3, 2, 6, 5, 0, 3})); //  7
    }
}
