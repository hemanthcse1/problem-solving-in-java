package examples.daily.april;

public class SubsetXorSumCalculator {

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {5, 1, 6};
        int[] nums3 = {3, 4, 5, 6, 7, 8};

        System.out.println("Sum of XOR totals (Example 1): " + calculateSubsetXorSum(nums1));
        System.out.println("Sum of XOR totals (Example 2): " + calculateSubsetXorSum(nums2));
        System.out.println("Sum of XOR totals (Example 3): " + calculateSubsetXorSum(nums3));
    }

    public static int calculateSubsetXorSum(int[] nums) {
        return dfs(nums, 0, 0);
    }

    private static int dfs(int[] nums, int index, int currentXor) {
        if (index == nums.length) {
            return currentXor;
        }
        int include = dfs(nums, index + 1, currentXor ^ nums[index]);
        int exclude = dfs(nums, index + 1, currentXor);
        return include + exclude;
    }
}
