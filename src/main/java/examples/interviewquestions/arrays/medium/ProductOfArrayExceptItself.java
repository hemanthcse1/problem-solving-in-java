package examples.interviewquestions.arrays.medium;

public class ProductOfArrayExceptItself {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * right;
            right = right * nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptItself solution = new ProductOfArrayExceptItself();

        int[] nums1 = {1, 2, 3, 4};
        int[] result1 = solution.productExceptSelf(nums1);
        System.out.println(java.util.Arrays.toString(result1));

        int[] nums2 = {-1, 1, 0, -3, 3};
        int[] result2 = solution.productExceptSelf(nums2);
        System.out.println(java.util.Arrays.toString(result2));
    }
}
