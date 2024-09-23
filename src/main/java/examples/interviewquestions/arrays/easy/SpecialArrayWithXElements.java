package examples.interviewquestions.arrays.easy;

import java.util.Arrays;

public class SpecialArrayWithXElements {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;

        for (int x = 0; x <= n; x++) {
            int count = 0;

            for (int i = 0; i < n; i++) {
                if (nums[i] >= x) {
                    count = n - i;
                    break;
                }
            }
            if (count == x) {
                return x;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SpecialArrayWithXElements solution = new SpecialArrayWithXElements();

        int[] nums1 = {3, 5};
        System.out.println(solution.specialArray(nums1));

        int[] nums2 = {0, 0};
        System.out.println(solution.specialArray(nums2));

        int[] nums3 = {0, 4, 3, 0, 4};
        System.out.println(solution.specialArray(nums3));
    }
}
