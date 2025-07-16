package examples.daily.july;

public class LongestValidParitySubsequence {

    public static void main(String[] args) {
        LongestValidParitySubsequence solver = new LongestValidParitySubsequence();
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {1, 2, 1, 1, 2, 1, 2};
        int[] nums3 = {1, 3};

        System.out.println(solver.maximumLength(nums1)); // Output: 4
        System.out.println(solver.maximumLength(nums2)); // Output: 6
        System.out.println(solver.maximumLength(nums3)); // Output: 2
    }

    public int maximumLength(int[] nums) {
        int[][] dp = new int[2][2];

        for (int num : nums) {
            int currentParity = num % 2;
            for (int prevParity = 0; prevParity <= 1; prevParity++) {
                dp[currentParity][prevParity] = Math.max(
                        dp[currentParity][prevParity],
                        dp[prevParity][currentParity] + 1
                );
            }
        }

        return Math.max(
                Math.max(dp[0][0], dp[0][1]),
                Math.max(dp[1][0], dp[1][1])
        );
    }
}
