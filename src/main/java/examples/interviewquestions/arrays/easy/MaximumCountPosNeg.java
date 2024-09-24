package examples.interviewquestions.arrays.easy;

public class MaximumCountPosNeg {
    public static int maximumCount(int[] nums) {
        int n = nums.length;
        int positiveCount = 0;
        int negativeCount = 0;

        for (int num : nums) {
            if (num > 0) {
                positiveCount++;
            } else if (num < 0) {
                negativeCount++;
            }
        }

        return Math.max(positiveCount, negativeCount);
    }

    public static void main(String[] args) {
        int[] nums1 = {-2, -1, -1, 1, 2, 3};
        System.out.println(maximumCount(nums1));

        int[] nums2 = {-3, -2, -1, 0, 0, 1, 2};
        System.out.println(maximumCount(nums2));

        int[] nums3 = {5, 20, 66, 1314};
        System.out.println(maximumCount(nums3));
    }
}
