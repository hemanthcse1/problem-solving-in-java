package examples.interviewquestions.arrays.easy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubarraysDistinctElementSumOfSquares {

    public static int sumsOfSquaresOfDistCounts(List<Integer> nums) {
        int n = nums.size();
        int totalSum = 0;

        for (int i = 0; i < n; i++) {
            Set<Integer> distinctElements = new HashSet<>();
            for (int j = i; j < n; j++) {
                distinctElements.add(nums.get(j));
                int distinctCount = distinctElements.size();
                totalSum += distinctCount * distinctCount;
            }
        }

        return totalSum;
    }

    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {1, 2, 1};
       // System.out.println(sumsOfSquaresOfDistCounts(nums1));

        // Test case 2
        int[] nums2 = {1, 1};
     //   System.out.println(sumsOfSquaresOfDistCounts(nums2));
    }
}
