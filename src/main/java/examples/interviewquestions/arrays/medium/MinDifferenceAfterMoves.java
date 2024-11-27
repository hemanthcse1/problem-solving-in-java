package examples.interviewquestions.arrays.medium;

import java.util.Arrays;

public class MinDifferenceAfterMoves {
    public int minDifference(int[] nums) {
        if (nums.length <= 4) {
            return 0;
        }

        Arrays.sort(nums);
        int n = nums.length;

        int option1 = nums[n - 1] - nums[3];
        int option2 = nums[n - 2] - nums[2];
        int option3 = nums[n - 3] - nums[1];
        int option4 = nums[n - 4] - nums[0];

        return Math.min(Math.min(option1, option2), Math.min(option3, option4));
    }

    public static void main(String[] args) {
        MinDifferenceAfterMoves solver = new MinDifferenceAfterMoves();

        int[] nums1 = {5, 3, 2, 4};
        System.out.println(solver.minDifference(nums1));

        int[] nums2 = {1, 5, 0, 10, 14};
        System.out.println(solver.minDifference(nums2));

        int[] nums3 = {3, 100, 20};
        System.out.println(solver.minDifference(nums3));
    }
}
