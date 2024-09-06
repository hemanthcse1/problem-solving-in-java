package examples.interviewquestions.arrays.easy;

import java.util.Arrays;

public class FindIntegerAddedToArray {
    public static int findX(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int x = nums2[0] - nums1[0];

        for (int i = 1; i < nums1.length; i++) {
            if (nums2[i] - nums1[i] != x) {
                return -1;
            }
        }

        return x;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {4, 5, 6};

        int result = findX(nums1, nums2);
        System.out.println("The integer x is: " + result);
    }
}
