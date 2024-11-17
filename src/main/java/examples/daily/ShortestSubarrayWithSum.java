package examples.daily;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestSubarrayWithSum {

    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        Deque<Integer> deque = new ArrayDeque<>();
        int minLength = Integer.MAX_VALUE;

        for (int j = 0; j <= n; j++) {
            while (!deque.isEmpty() && prefix[j] - prefix[deque.peekFirst()] >= k) {
                minLength = Math.min(minLength, j - deque.pollFirst());
            }

            while (!deque.isEmpty() && prefix[j] <= prefix[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.addLast(j);
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

    public static void main(String[] args) {
        ShortestSubarrayWithSum sol = new ShortestSubarrayWithSum();
        System.out.println(sol.shortestSubarray(new int[]{1}, 1));
        System.out.println(sol.shortestSubarray(new int[]{1, 2}, 4));
        System.out.println(sol.shortestSubarray(new int[]{2, -1, 2}, 3));
    }
}
