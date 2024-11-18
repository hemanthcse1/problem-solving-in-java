package examples.interviewquestions.arrays.medium;

public class OnesAndZeros {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (String str : strs) {
            int count0 = 0, count1 = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') count0++;
                else if (c == '1') count1++;
            }

            for (int i = m; i >= count0; i--) {
                for (int j = n; j >= count1; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - count0][j - count1] + 1);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        OnesAndZeros solution = new OnesAndZeros();

        String[] strs1 = {"10", "0001", "111001", "1", "0"};
        int m1 = 5, n1 = 3;
        int result1 = solution.findMaxForm(strs1, m1, n1);
        System.out.println("Example 1 Result: " + result1);

        String[] strs2 = {"10", "0", "1"};
        int m2 = 1, n2 = 1;
        int result2 = solution.findMaxForm(strs2, m2, n2);
        System.out.println("Example 2 Result: " + result2);

    }
}
