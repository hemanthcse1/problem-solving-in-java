package examples.daily.april;

import java.util.HashMap;
import java.util.Map;

public class IdealArrayCounter {

    static final int MOD = 1_000_000_007;
    static int[][] comb;

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n1 = 2, maxValue1 = 5;
        int result1 = solution.idealArrays(n1, maxValue1);
        System.out.println("Input: n = " + n1 + ", maxValue = " + maxValue1 + " → Output: " + result1);  // Expected: 10

        int n2 = 5, maxValue2 = 3;
        int result2 = solution.idealArrays(n2, maxValue2);
        System.out.println("Input: n = " + n2 + ", maxValue = " + maxValue2 + " → Output: " + result2);  // Expected: 11
    }

    static class Solution {

        public int idealArrays(int n, int maxValue) {
            precomputeCombinations(n + 14, 14);
            int res = 0;

            for (int num = 1; num <= maxValue; num++) {
                Map<Integer, Integer> primeFactors = factorize(num);
                long ways = 1;
                for (int exp : primeFactors.values()) {
                    ways = (ways * comb[n + exp - 1][exp]) % MOD;
                }
                res = (int)((res + ways) % MOD);
            }

            return res;
        }

        private void precomputeCombinations(int N, int K) {
            comb = new int[N + 1][K + 1];
            for (int i = 0; i <= N; i++) {
                comb[i][0] = 1;
                for (int j = 1; j <= Math.min(i, K); j++) {
                    comb[i][j] = (comb[i - 1][j - 1] + comb[i - 1][j]) % MOD;
                }
            }
        }

        private Map<Integer, Integer> factorize(int x) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int p = 2; p * p <= x; p++) {
                while (x % p == 0) {
                    map.put(p, map.getOrDefault(p, 0) + 1);
                    x /= p;
                }
            }
            if (x > 1) map.put(x, 1);
            return map;
        }
    }
}
