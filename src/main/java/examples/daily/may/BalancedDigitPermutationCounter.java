package examples.daily.may;

import java.util.Arrays;

public class BalancedDigitPermutationCounter {
    private static final int MOD = 1_000_000_007;

    public int countBalancedPermutations(String num) {
        int[] digits = num.chars().map(c -> c - '0').toArray();
        int totalSum = Arrays.stream(digits).sum();

        if (totalSum % 2 != 0) return 0;

        Arrays.sort(digits);

        int n = digits.length;
        int even = (n + 1) / 2;
        int odd = n / 2;
        int targetEvenSum = totalSum / 2;

        Long[][][] memo = new Long[even + 1][odd + 1][targetEvenSum + 1];
        long validArrangements = countWays(digits, even, odd, targetEvenSum, memo);
        long totalPermutations = permutationsWithDuplicates(digits);

        return (int)((validArrangements * modInverse(totalPermutations)) % MOD);
    }

    private long countWays(int[] digits, int evenLeft, int oddLeft, int evenSum, Long[][][] memo) {
        if (evenSum < 0) return 0;
        if (evenLeft == 0) return evenSum == 0 ? factorial(oddLeft) : 0;
        if (oddLeft == 0) {
            int sum = 0;
            for (int i = digits.length - evenLeft; i < digits.length; i++) sum += digits[i];
            return sum == evenSum ? factorial(evenLeft) : 0;
        }
        if (memo[evenLeft][oddLeft][evenSum] != null)
            return memo[evenLeft][oddLeft][evenSum];

        int index = digits.length - evenLeft - oddLeft;
        long placeEven = countWays(digits, evenLeft - 1, oddLeft, evenSum - digits[index], memo) * evenLeft % MOD;
        long placeOdd = countWays(digits, evenLeft, oddLeft - 1, evenSum, memo) * oddLeft % MOD;

        return memo[evenLeft][oddLeft][evenSum] = (placeEven + placeOdd) % MOD;
    }

    private long permutationsWithDuplicates(int[] digits) {
        long result = 1;
        int[] freq = new int[10];
        for (int d : digits) freq[d]++;
        for (int f : freq) result = result * factorial(f) % MOD;
        return result;
    }

    private long factorial(int n) {
        long res = 1;
        for (int i = 2; i <= n; i++) res = res * i % MOD;
        return res;
    }

    private long modInverse(long a) {
        long m = MOD, x = 1, y = 0;
        while (a > 1) {
            long q = a / m;
            long t = m;
            m = a % m;
            a = t;
            t = y;
            y = x - q * y;
            x = t;
        }
        return x < 0 ? x + MOD : x;
    }

    public static void main(String[] args) {
        BalancedDigitPermutationCounter counter = new BalancedDigitPermutationCounter();
        System.out.println(counter.countBalancedPermutations("123"));
        System.out.println(counter.countBalancedPermutations("112233"));
    }
}
