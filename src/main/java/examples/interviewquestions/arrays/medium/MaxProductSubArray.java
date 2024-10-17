package examples.interviewquestions.arrays.medium;

public class MaxProductSubArray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];

            int tempMax = Math.max(current, Math.max(maxProduct * current, minProduct * current));
            minProduct = Math.min(current, Math.min(maxProduct * current, minProduct * current));

            maxProduct = tempMax;

            result = Math.max(result, maxProduct);
        }

        return result;
    }

    public static void main(String[] args) {
        MaxProductSubArray solution = new MaxProductSubArray();

        int[] nums1 = {2, 3, -2, 4};
        System.out.println("Max product: " + solution.maxProduct(nums1));

        int[] nums2 = {-2, 0, -1};
        System.out.println("Max product: " + solution.maxProduct(nums2));
    }
}
