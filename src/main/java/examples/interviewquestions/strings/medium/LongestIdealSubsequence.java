package examples.interviewquestions.strings.medium;

public class LongestIdealSubsequence {
    public int longestIdealString(String s, int k) {
        int[] dp = new int[26];

        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            int maxLen = 0;

            for (int i = Math.max(0, idx - k); i <= Math.min(25, idx + k); i++) {
                maxLen = Math.max(maxLen, dp[i]);
            }

            dp[idx] = maxLen + 1;
        }

        int longest = 0;
        for (int len : dp) {
            longest = Math.max(longest, len);
        }

        return longest;
    }

    public static void main(String[] args) {
        LongestIdealSubsequence solution = new LongestIdealSubsequence();
        System.out.println(solution.longestIdealString("acfgbd", 2));
        System.out.println(solution.longestIdealString("abcd", 3));
    }
}
