package examples.daily.april;

public class PartitionEqualSubsetSumApp {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) return false;
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        PartitionEqualSubsetSumApp checker = new PartitionEqualSubsetSumApp();

        int[] nums1 = {1, 5, 11, 5};
        int[] nums2 = {1, 2, 3, 5};

        System.out.println(checker.canPartition(nums1)); // true
        System.out.println(checker.canPartition(nums2)); // false
    }


}
