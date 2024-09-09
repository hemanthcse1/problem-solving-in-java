package examples.interviewquestions.arrays.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAverage {
    public static double minAverage(int[] nums) {
        Arrays.sort(nums);
        List<Double> averages = new ArrayList<>();

        int left = 0;
        int right = nums.length - 1;


        while (left < right) {

            int minElement = nums[left];
            int maxElement = nums[right];


            double avg = (minElement + maxElement) / 2.0;
            averages.add(avg);


            left++;
            right--;
        }

        return averages.stream().min(Double::compare).orElse(0.0);
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9, 11};
        System.out.println("Minimum average: " + minAverage(nums));
    }
}
