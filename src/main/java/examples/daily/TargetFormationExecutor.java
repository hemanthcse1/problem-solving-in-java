package examples.daily;

public class TargetFormationExecutor {

    public static void main(String[] args) {

        String[] words = {"acca","bbbb","caca"};
        String target = "aba";

        TargetFormationExecutor solution = new TargetFormationExecutor();
        int ways = solution.numWays(words, target);
        System.out.println("Number of ways to form '" + target + "': " + ways);

        String[] words2 = {"abba","baab"};
        String target2 = "bab";
        ways = solution.numWays(words2, target2);
        System.out.println("Number of ways to form '" + target2 + "': " + ways);
    }

    public int numWays(String[] words, String target) {
        int wordCount = words.length;
        int columnCount = words[0].length();
        int targetLength = target.length();
        int MOD = 1_000_000_007;
        long[][] columnFrequency = new long[26][columnCount];
        for (int j = 0; j < columnCount; j++) {
            for (int i = 0; i < wordCount; i++) {
                columnFrequency[words[i].charAt(j) - 'a'][j]++;
            }
        }
        long[][] dp = new long[targetLength + 1][columnCount + 1];
        for (int j = 0; j <= columnCount; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i <= targetLength; i++) {
            for (int j = 1; j <= columnCount; j++) {
                dp[i][j] = dp[i][j - 1];
                char c = target.charAt(i - 1);
                dp[i][j] = (dp[i][j] + dp[i - 1][j - 1] * columnFrequency[c - 'a'][j - 1]) % MOD;
            }
        }
        return (int) dp[targetLength][columnCount];
    }
}
