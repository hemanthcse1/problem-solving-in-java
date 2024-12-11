package examples.interviewquestions.arrays.medium;

public class UncrossedLines {
    public static int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m+1][n+1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i-1] == nums2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {

        int[] nums1_1 = {1,4,2}, nums2_1 = {1,2,4};
        System.out.println(maxUncrossedLines(nums1_1, nums2_1));

        int[] nums1_2 = {2,5,1,2,5}, nums2_2 = {10,5,2,1,5,2};
        System.out.println(maxUncrossedLines(nums1_2, nums2_2));

        int[] nums1_3 = {1,3,7,1,7,5}, nums2_3 = {1,9,2,5,1};
        System.out.println(maxUncrossedLines(nums1_3, nums2_3));
    }
}
