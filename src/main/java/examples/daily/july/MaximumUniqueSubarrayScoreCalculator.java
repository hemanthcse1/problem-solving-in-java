package examples.daily.july;

import java.util.HashSet;
import java.util.Set;

public class MaximumUniqueSubarrayScoreCalculator {

    public static void main(String[] args) {
        int[] nums = {4, 2, 4, 5, 6};
        MaximumUniqueSubarrayScoreCalculator solution = new MaximumUniqueSubarrayScoreCalculator();
        int result = solution.maximumUniqueSubarray(nums);
        System.out.println("Maximum Unique Subarray Score: " + result);
    }

    public int maximumUniqueSubarray(int[] nums) {
        int maxScore = 0;
        int currentScore = 0;

        Set<Integer> uniqueElements = new HashSet<>();

        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            while (!uniqueElements.add(nums[right])) {
                currentScore -= nums[left];
                uniqueElements.remove(nums[left]);
                left++;
            }

            currentScore += nums[right];
            maxScore = Math.max(maxScore, currentScore);
        }

        return maxScore;
    }
}
