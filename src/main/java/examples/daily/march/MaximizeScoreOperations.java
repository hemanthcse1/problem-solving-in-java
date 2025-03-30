package examples.daily.march;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class MaximizeScoreOperations {
    private static final int MOD = 1_000_000_007;

    public int maximumScore(List<Integer> nums, int k) {
        int n = nums.size();
        int[] primeScore = new int[100001];
        for (int i = 2; i < primeScore.length; i++) {
            if (primeScore[i] == 0) {
                for (int j = i; j < primeScore.length; j += i) {
                    primeScore[j]++;
                }
            }
        }

        int[] score = new int[n];
        for (int i = 0; i < n; i++) {
            score[i] = primeScore[nums.get(i)];
        }

        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, -1);
        Arrays.fill(right, n);

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && score[stack.peek()] < score[i]) {
                right[stack.pop()] = i;
            }
            stack.push(i);
        }

        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && score[stack.peek()] <= score[i]) {
                left[stack.pop()] = i;
            }
            stack.push(i);
        }

        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) indices[i] = i;
        Arrays.sort(indices, (a, b) -> Integer.compare(nums.get(b), nums.get(a)));

        long res = 1;
        for (int i = 0; i < n && k > 0; i++) {
            int idx = indices[i];
            long total = (long)(idx - left[idx]) * (right[idx] - idx);
            long take = Math.min(k, total);
            res = (res * modPow(nums.get(idx), take, MOD)) % MOD;
            k -= take;
        }

        return (int) res;
    }

    private long modPow(long base, long exp, int mod) {
        long res = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        MaximizeScoreOperations obj = new MaximizeScoreOperations();

        List<Integer> nums1 = Arrays.asList(8, 3, 9, 3, 8);
        int k1 = 2;
        System.out.println(obj.maximumScore(nums1, k1)); //  81

        List<Integer> nums2 = Arrays.asList(19, 12, 14, 6, 10, 18);
        int k2 = 3;
        System.out.println(obj.maximumScore(nums2, k2)); //  4788
    }
}
