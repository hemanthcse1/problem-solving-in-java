package examples.interviewquestions.dynamicprogramming.medium;

public class LongestCommonSubsequenceSolution {

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        LongestCommonSubsequenceSolution solution = new LongestCommonSubsequenceSolution();


        String text1_1 = "abcde";
        String text2_1 = "ace";
        System.out.println("Longest Common Subsequence length for \"abcde\" and \"ace\": " + solution.longestCommonSubsequence(text1_1, text2_1));


        String text1_2 = "abc";
        String text2_2 = "abc";
        System.out.println("Longest Common Subsequence length for \"abc\" and \"abc\": " + solution.longestCommonSubsequence(text1_2, text2_2));

    }
}
