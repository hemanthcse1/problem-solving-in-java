package examples.daily.april;

public class PowerfulIntegerCounter {

    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        int len = s.length();
        long suffixValue = Long.parseLong(s);
        long multiplier = (long) Math.pow(10, len);

        if (finish < suffixValue) return 0;

        long minQ = start > suffixValue ? (start - suffixValue + multiplier - 1) / multiplier : 0;
        long maxQ = (finish - suffixValue) / multiplier;
        if (minQ > maxQ) return 0;

        long powerfulCount = countDigitsLessThanLimit(maxQ, limit) - countDigitsLessThanLimit(minQ - 1, limit);
        return powerfulCount;
    }

    private long countDigitsLessThanLimit(long n, int limit) {
        if (n < 0) return 0;
        char[] digits = Long.toString(n).toCharArray();
        Long[][] memo = new Long[digits.length][2];
        return digitDP(digits, 0, true, limit, memo);
    }

    private long digitDP(char[] digits, int pos, boolean isTight, int limit, Long[][] memo) {
        if (pos == digits.length) return 1;
        int tight = isTight ? 1 : 0;
        if (memo[pos][tight] != null) return memo[pos][tight];

        int maxDigit = isTight ? Math.min(digits[pos] - '0', limit) : limit;
        long count = 0;

        for (int d = 0; d <= maxDigit; d++) {
            boolean newTight = isTight && (d == digits[pos] - '0');
            count += digitDP(digits, pos + 1, newTight, limit, memo);
        }

        memo[pos][tight] = count;
        return count;
    }

    public static void main(String[] args) {
        PowerfulIntegerCounter sol = new PowerfulIntegerCounter();
        System.out.println(sol.numberOfPowerfulInt(1, 6000, 4, "124"));     //  5
        System.out.println(sol.numberOfPowerfulInt(15, 215, 6, "10"));      //  2
        System.out.println(sol.numberOfPowerfulInt(1000, 2000, 4, "3000")); //  0
    }
}
