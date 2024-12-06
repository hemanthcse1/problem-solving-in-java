package examples.interviewquestions.arrays.medium;

public class LongestSubarrayMaxBitwiseAND {
    public int longestSubarray(int[] nums) {
        int maxValue = 0;

        for (int num : nums) {
            maxValue = Math.max(maxValue, num);
        }

        int maxLength = 0, currentLength = 0;

        for (int num : nums) {
            if (num == maxValue) {
                currentLength++;
                maxLength = Math.max(maxLength, currentLength);
            } else {
                currentLength = 0;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubarrayMaxBitwiseAND solution = new LongestSubarrayMaxBitwiseAND();

        int[] nums1 = {1, 2, 3, 3, 2, 2};
        System.out.println(solution.longestSubarray(nums1));

        int[] nums2 = {1, 2, 3, 4};
        System.out.println(solution.longestSubarray(nums2));
    }
}
