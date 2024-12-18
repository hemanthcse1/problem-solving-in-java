package examples.interviewquestions.arrays.medium;

import java.util.Arrays;

public class MaxNumberOfKSumPairs {
    public static int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int count = 0;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == k) {
                count++;
                left++;
                right--;
            } else if (sum < k) {
                left++;
            } else {
                right--;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 4};
        int k1 = 5;
        int result1 = maxOperations(nums1, k1);
        System.out.println(result1);


        int[] nums2 = {3, 1, 3, 4, 3};
        int k2 = 6;
        int result2 = maxOperations(nums2, k2);
        System.out.println(result2);

    }
}
