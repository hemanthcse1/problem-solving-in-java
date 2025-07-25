package examples.daily.july;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaxUniqueSubarraySumAfterDeletion {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5};        //  15
        int[] nums2 = {1, 1, 0, 1, 1};        // 1
        int[] nums3 = {1, 2, -1, -2, 1, 0, -1}; //  3

        System.out.println(maxSum(nums1));
        System.out.println(maxSum(nums2));
        System.out.println(maxSum(nums3));
    }

    public static int maxSum(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        if (max <= 0) {
            return max;
        }

        Set<Integer> unique = new HashSet<>();
        for (int num : nums) {
            if (num > 0) {
                unique.add(num);
            }
        }

        int sum = 0;
        for (int num : unique) {
            sum += num;
        }

        return sum;
    }
}
