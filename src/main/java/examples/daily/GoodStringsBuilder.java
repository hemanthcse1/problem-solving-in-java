package examples.daily;

public class GoodStringsBuilder {

    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        System.out.println(countGoodStrings(3, 3, 1, 1));
        System.out.println(countGoodStrings(2, 3, 1, 2));
    }

    public static int countGoodStrings(int low, int high, int zero, int one) {
        long[] dp = new long[high + 1];
        dp[0] = 1;
        long result = 0;
        for (int length = 1; length <= high; length++) {
            if (length - zero >= 0) {
                dp[length] = (dp[length] + dp[length - zero]) % MOD;
            }
            if (length - one >= 0) {
                dp[length] = (dp[length] + dp[length - one]) % MOD;
            }
            if (length >= low) {
                result = (result + dp[length]) % MOD;
            }
        }
        return (int) result;
    }
}
