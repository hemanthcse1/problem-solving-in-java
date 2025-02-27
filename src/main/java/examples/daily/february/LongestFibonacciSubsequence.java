package examples.daily.february;

import java.util.HashMap;
import java.util.Map;

public class LongestFibonacciSubsequence {

    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> indexMap = new HashMap<>();
        int[][] dp = new int[n][n];
        int maxLength = 0;


        for (int i = 0; i < n; i++) {
            indexMap.put(arr[i], i);
        }


        for (int j = 0; j < n; j++) {
            for (int k = j + 1; k < n; k++) {
                int expectedPrev = arr[k] - arr[j];
                if (expectedPrev >= arr[j]) continue;

                if (indexMap.containsKey(expectedPrev)) {
                    int i = indexMap.get(expectedPrev);
                    dp[j][k] = Math.max(dp[i][j] + 1, 3);
                    maxLength = Math.max(maxLength, dp[j][k]);
                }
            }
        }

        return maxLength;
    }
    public static void main(String[] args) {
        LongestFibonacciSubsequence solution = new LongestFibonacciSubsequence();


        System.out.println(solution.lenLongestFibSubseq(new int[]{1,2,3,4,5,6,7,8})); //  5
        System.out.println(solution.lenLongestFibSubseq(new int[]{1,3,7,11,12,14,18})); //  3
        System.out.println(solution.lenLongestFibSubseq(new int[]{1,4,10,15,24,25,30})); //  0
    }

}
