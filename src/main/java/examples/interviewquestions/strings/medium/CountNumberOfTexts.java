package examples.interviewquestions.strings.medium;

public class CountNumberOfTexts {
    private static final int MOD = 1_000_000_007;

    public int countTexts(String pressedKeys) {
        int n = pressedKeys.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            char current = pressedKeys.charAt(i - 1);
            int maxLen = (current == '7' || current == '9') ? 4 : 3;

            dp[i] = 0;
            for (int j = 1; j <= maxLen && i - j >= 0; j++) {
                if (pressedKeys.charAt(i - j) != current) {
                    break;
                }
                dp[i] = (dp[i] + dp[i - j]) % MOD;
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        CountNumberOfTexts solution = new CountNumberOfTexts();

        String pressedKeys1 = "22233";
        System.out.println(solution.countTexts(pressedKeys1));

        String pressedKeys2 = "222222222222222222222222222222222222";
        System.out.println(solution.countTexts(pressedKeys2));
    }
}
