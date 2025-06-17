package examples.daily.june;

public class GoodArraysCounter {
    private static final int MOD = 1_000_000_007;

    public int countGoodArrays(int n, int m, int k) {
        long[][] factInfo = computeFactorials(n);
        long[] fact = factInfo[0];
        long[] invFact = factInfo[1];
        long power = modPow(m - 1, n - k - 1);
        long combinations = nCk(n - 1, k, fact, invFact);
        return (int) (m * power % MOD * combinations % MOD);
    }

    private long modPow(long x, long n) {
        long result = 1;
        x %= MOD;
        while (n > 0) {
            if ((n & 1) == 1) result = (result * x) % MOD;
            x = (x * x) % MOD;
            n >>= 1;
        }
        return result;
    }

    private long[][] computeFactorials(int n) {
        long[] fact = new long[n + 1];
        long[] invFact = new long[n + 1];
        long[] inv = new long[n + 1];

        fact[0] = invFact[0] = inv[0] = inv[1] = 1;

        for (int i = 1; i <= n; i++) {
            if (i >= 2)
                inv[i] = MOD - (MOD / i) * inv[MOD % i] % MOD;
            fact[i] = fact[i - 1] * i % MOD;
            invFact[i] = invFact[i - 1] * inv[i] % MOD;
        }

        return new long[][] { fact, invFact };
    }

    private int nCk(int n, int k, long[] fact, long[] invFact) {
        if (k < 0 || k > n) return 0;
        return (int) (fact[n] * invFact[k] % MOD * invFact[n - k] % MOD);
    }

    public static void main(String[] args) {
        GoodArraysCounter sol = new GoodArraysCounter();
        System.out.println(sol.countGoodArrays(5, 3, 2));
    }
}
