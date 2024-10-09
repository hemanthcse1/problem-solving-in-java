package examples.interviewquestions.arrays.easy;

public class CheckBitwiseOrTrailingZeros {
    public static boolean hasTrailingZero(int num) {
        return (num & 1) == 0;
    }

    public static boolean canSelectElementsWithTrailingZero(int[] nums) {
        int countTrailingZero = 0;

        for (int num : nums) {
            if (hasTrailingZero(num)) {
                countTrailingZero++;
            }
            if (countTrailingZero >= 2) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5};
        System.out.println(canSelectElementsWithTrailingZero(nums1));

        int[] nums2 = {2, 4, 8, 16};
        System.out.println(canSelectElementsWithTrailingZero(nums2));

        int[] nums3 = {1, 3, 5, 7, 9};
        System.out.println(canSelectElementsWithTrailingZero(nums3));
    }
}
