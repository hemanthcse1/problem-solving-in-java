package examples.interviewquestions.arrays.easy;

import java.util.HashMap;

public class MaxOperationsWithSameScore {
    public int maxOperations(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        int maxOperations = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            int initialScore = nums[i] + nums[i + 1];

            int countOperations = 0;
            int j = 0;

            while (j < nums.length - 1) {
                int currentScore = nums[j] + nums[j + 1];
                if (currentScore == initialScore) {
                    countOperations++;
                    j += 2;
                } else {
                    break;
                }
            }

            maxOperations = Math.max(maxOperations, countOperations);
        }

        return maxOperations;
    }

    public static void main(String[] args) {
        MaxOperationsWithSameScore solution = new MaxOperationsWithSameScore();

        // Test case 1
        int[] nums1 = {3, 2, 1, 4, 5};
        System.out.println(solution.maxOperations(nums1));  // Output: 2

        // Test case 2
        int[] nums2 = {1, 5, 3, 3, 4, 1, 3, 2, 2, 3};
        System.out.println(solution.maxOperations(nums2));  // Output: 1

        // Test case 3
        int[] nums3 = {5, 3};
        System.out.println(solution.maxOperations(nums3));  // Output: 1
    }
}
