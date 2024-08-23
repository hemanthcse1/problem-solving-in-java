package examples.interviewquestions.arrays.easy;

import java.util.Arrays;

public class MinimumAverageOfSmallestAndLargest {
    public double minAverage(int[] nums) {
        Arrays.sort(nums);
        double[] averages = new double[nums.length / 2];

        for (int i = 0; i < nums.length / 2; i++) {
            int minElement = nums[i];
            int maxElement = nums[nums.length - 1 - i];
            averages[i] = (minElement + maxElement) / 2.0;
        }
        double minAverage = averages[0];
        for (double avg : averages) {
            if (avg < minAverage) {
                minAverage = avg;
            }
        }

        return minAverage;
    }

    public static void main(String[] args) {
        MinimumAverageOfSmallestAndLargest solution = new MinimumAverageOfSmallestAndLargest();

        int[] nums = {1, 3, 3, 5, 5, 7};
        double result = solution.minAverage(nums);
        System.out.println("Minimum average: " + result);
    }
}
