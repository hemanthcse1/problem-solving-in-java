package examples.interviewquestions.arrays.medium;

import java.util.Stack;

public class MaximumWidthRamp {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }

        int maxWidth = 0;

        for (int j = n - 1; j >= 0; j--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[j]) {
                maxWidth = Math.max(maxWidth, j - stack.pop());
            }
        }

        return maxWidth;
    }

    public static void main(String[] args) {
        MaximumWidthRamp solution = new MaximumWidthRamp();
        int[] nums1 = {6, 0, 8, 2, 1, 5};
        System.out.println(solution.maxWidthRamp(nums1));

        int[] nums2 = {9, 8, 1, 0, 1, 9, 4, 0, 4, 1};
        System.out.println(solution.maxWidthRamp(nums2));
    }
}
