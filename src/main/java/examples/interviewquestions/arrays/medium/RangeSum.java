package examples.interviewquestions.arrays.medium;

import java.util.PriorityQueue;

public class RangeSum {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int n = nums.length;
        int left = 1;
        int right = 5;
        int result = rangeSum(nums, n, left, right);
        System.out.println(result);
    }

    public static int rangeSum(int[] nums, int n, int left, int right) {
        long mod = 1000000007;
        long[] prefix = new long[n+1];
        for (int i = 0; i < n; i++) prefix[i+1] = prefix[i] + nums[i];

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> Long.compare((prefix[a[1]] - prefix[a[0]]), (prefix[b[1]] - prefix[b[0]]))
        );
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{i, i+1});
        }

        long res = 0;
        for (int i = 1; i <= right; i++) {
            int[] top = pq.poll();
            long val = prefix[top[1]] - prefix[top[0]];
            if (i >= left) {
                res = (res + val) % mod;
            }
            if (top[1] < n) {
                pq.offer(new int[]{top[0], top[1]+1});
            }
        }

        return (int) res;
    }
}
