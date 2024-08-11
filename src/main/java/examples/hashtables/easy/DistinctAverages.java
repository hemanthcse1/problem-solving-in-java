package examples.hashtables.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DistinctAverages {

    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        Set<Double> distinctAverages = new HashSet<>();

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            double average = (nums[left] + nums[right]) / 2.0;
            distinctAverages.add(average);
            left++;
            right--;
        }

        return distinctAverages.size();
    }

    public static void main(String[] args) {
        DistinctAverages da = new DistinctAverages();

        int[] nums1 = {1, 3, 3, 2, 4, 2};
        System.out.println("Distinct Averages: " + da.distinctAverages(nums1));

        int[] nums2 = {1, 2, 3, 4};
        System.out.println("Distinct Averages: " + da.distinctAverages(nums2));
    }
}
