package examples.interviewquestions.hashmaps.medium;

import java.util.Arrays;

public class PowerOfKSizeSubArrays {
    public int[] findPowerOfKSizeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            boolean isValid = true;
            int maxElement = nums[i];

            for (int j = i + 1; j < i + k; j++) {
                if (nums[j] != nums[j - 1] + 1) {
                    isValid = false;
                    break;
                }
                maxElement = Math.max(maxElement, nums[j]);
            }

            if (isValid) {
                result[i] = maxElement;
            } else {
                result[i] = -1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        PowerOfKSizeSubArrays sol = new PowerOfKSizeSubArrays();
        System.out.println(Arrays.toString(sol.findPowerOfKSizeSubarrays(new int[]{1, 2, 3, 4, 3, 2, 5}, 3)));
        System.out.println(Arrays.toString(sol.findPowerOfKSizeSubarrays(new int[]{2, 2, 2, 2, 2}, 4)));
        System.out.println(Arrays.toString(sol.findPowerOfKSizeSubarrays(new int[]{3, 2, 3, 2, 3, 2}, 2)));
    }
}
