package examples.interviewquestions.arrays.easy;

public class LargestNumberAtLeastTwiceOfOthers {

    public int dominantIndex(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        int largestIndex = 0;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[largestIndex]) {
                secondLargest = nums[largestIndex];
                largestIndex = i;
            } else if (nums[i] > secondLargest) {
                secondLargest = nums[i];
            }
        }

        if (nums[largestIndex] >= 2 * secondLargest) {
            return largestIndex;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        LargestNumberAtLeastTwiceOfOthers solution = new LargestNumberAtLeastTwiceOfOthers();

        int[] nums1 = {3, 6, 1, 0};
        System.out.println("Test case 1 output: " + solution.dominantIndex(nums1));

        int[] nums2 = {1, 2, 3, 4};
        System.out.println("Test case 2 output: " + solution.dominantIndex(nums2));
    }
}
