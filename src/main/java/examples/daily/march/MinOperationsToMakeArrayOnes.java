package examples.daily.march;

public class MinOperationsToMakeArrayOnes {

    public static int minOperations(int[] nums) {
        int n = nums.length;
        int flips = 0;

        for (int i = 0; i <= n - 3; i++) {
            if (nums[i] == 0) {
                flips++;
                nums[i] ^= 1;
                nums[i + 1] ^= 1;
                nums[i + 2] ^= 1;
            }
        }

        for (int num : nums) {
            if (num == 0) return -1;
        }

        return flips;
    }

    public static void main(String[] args) {


        int[] nums1 = {0, 1, 1, 1, 0, 0};
        int result1 = minOperations(nums1);
        System.out.println("Minimum operations (Test case 1): " + result1);  //  3

        int[] nums2 = {0, 1, 1, 1};
        int result2 = minOperations(nums2);
        System.out.println("Minimum operations (Test case 2): " + result2);  // Expected: -1

    }
}
