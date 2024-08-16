package examples.interviewquestions.arrays.easy;

import java.util.Arrays;

public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] result = new int[2];
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1;

            if (nums[index] < 0) {
                result[0] = Math.abs(nums[i]);
            } else {
                nums[index] = -nums[index];
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                result[1] = i + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SetMismatch sm = new SetMismatch();

        int[] nums1 = {1, 2, 2, 4};
        System.out.println(Arrays.toString(sm.findErrorNums(nums1)));  // Output: [2, 3]
    }
}
