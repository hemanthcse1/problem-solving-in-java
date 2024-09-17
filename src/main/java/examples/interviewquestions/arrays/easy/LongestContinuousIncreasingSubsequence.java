package examples.interviewquestions.arrays.easy;

public class LongestContinuousIncreasingSubsequence {

    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int maxLength = 1;
        int currentLength = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                currentLength++;
            } else {
                currentLength = 1;
            }

            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestContinuousIncreasingSubsequence solution = new LongestContinuousIncreasingSubsequence();

        int[] nums1 = {1, 3, 5, 4, 7};
        System.out.println("Test case 1 output: " + solution.findLengthOfLCIS(nums1));

        int[] nums2 = {2, 2, 2, 2, 2};
        System.out.println("Test case 2 output: " + solution.findLengthOfLCIS(nums2));
    }
}
