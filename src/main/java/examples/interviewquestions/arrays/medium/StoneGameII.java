package examples.interviewquestions.arrays.medium;

import java.util.Arrays;

public class StoneGameII {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] suffixSum = new int[n];
        suffixSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }

        int[][] dp = new int[n][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(0, 1, piles, suffixSum, dp);
    }

    private int helper(int index, int M, int[] piles, int[] suffixSum, int[][] dp) {
        if (index == piles.length) return 0;
        if (2 * M >= piles.length - index) return suffixSum[index];
        if (dp[index][M] != -1) return dp[index][M];

        int maxStones = 0;
        for (int X = 1; X <= 2 * M; X++) {
            if (index + X > piles.length) break;
            maxStones = Math.max(maxStones, suffixSum[index] - helper(index + X, Math.max(M, X), piles, suffixSum, dp));
        }
        dp[index][M] = maxStones;
        return maxStones;
    }

    public static void main(String[] args) {
        StoneGameII solution = new StoneGameII();
        System.out.println(solution.stoneGameII(new int[]{2, 7, 9, 4, 4}));
        System.out.println(solution.stoneGameII(new int[]{1, 2, 3, 4, 5, 100}));
    }
}
