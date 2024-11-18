package examples.interviewquestions.arrays.medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class OneThreeTwoPattern {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;

        Deque<Integer> stack = new ArrayDeque<>();
        int second = Integer.MIN_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < second) {
                return true;
            }

            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                second = stack.pop();
            }

            stack.push(nums[i]);
        }

        return false;
    }

    public static void main(String[] args) {
        OneThreeTwoPattern solution = new OneThreeTwoPattern();

        int[] nums1 = {1, 2, 3, 4};
        boolean result1 = solution.find132pattern(nums1);
        System.out.println("Example 1: " + Arrays.toString(nums1));
        System.out.println("Output: " + result1);

        int[] nums2 = {3, 1, 4, 2};
        boolean result2 = solution.find132pattern(nums2);
        System.out.println("\nExample 2: " + Arrays.toString(nums2));
        System.out.println("Output: " + result2);

    }
}
