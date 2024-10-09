package examples.interviewquestions.arrays.easy;

public class MinimumElementAfterReplacement {

    public static int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static int findMinimumAfterReplacement(int[] nums) {
        int minElement = Integer.MAX_VALUE;

        for (int num : nums) {
            int digitSum = sumOfDigits(num);
            minElement = Math.min(minElement, digitSum);
        }

        return minElement;
    }

    public static void main(String[] args) {
        int[] nums1 = {10, 12, 13, 14};
        System.out.println(findMinimumAfterReplacement(nums1));

        int[] nums2 = {1, 2, 3, 4};
        System.out.println(findMinimumAfterReplacement(nums2));

        int[] nums3 = {999, 19, 199};
        System.out.println(findMinimumAfterReplacement(nums3));
    }
}
