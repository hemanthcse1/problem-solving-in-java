package examples.interviewquestions.strings.medium;

public class NumberOfWaysToSplitString {

    public int numWays(String s) {
        final int MOD = 1_000_000_007;
        int totalOnes = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') totalOnes++;
        }

        if (totalOnes % 3 != 0) return 0;
        if (totalOnes == 0) {
            int n = s.length();
            return (int) (((long) (n - 1) * (n - 2) / 2) % MOD);
        }

        int onesPerPart = totalOnes / 3;
        int count = 0;
        long ways1 = 0, ways2 = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') count++;
            if (count == onesPerPart) ways1++;
            else if (count == 2 * onesPerPart) ways2++;
        }

        return (int) ((ways1 * ways2) % MOD);
    }

    public static void main(String[] args) {
        NumberOfWaysToSplitString solution = new NumberOfWaysToSplitString();

        System.out.println(solution.numWays("10101")); // Expected Output: 4
        System.out.println(solution.numWays("1001"));  // Expected Output: 0
        System.out.println(solution.numWays("0000"));  // Expected Output: 3
    }
}
