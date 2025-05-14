package examples.daily.may;

import java.util.Arrays;
import java.util.List;

public class LengthAfterTransformations {

    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        final int MOD = 1_000_000_007;
        long[] count = new long[26];
        for (char c : s.toCharArray())
            count[c - 'a']++;

        long[][] trans = new long[26][26];
        for (int i = 0; i < 26; i++) {
            for (int j = 1; j <= nums.get(i); j++) {
                trans[i][(i + j) % 26]++;
            }
        }

        count = matrixPowerMultiply(count, trans, t, MOD);

        long result = 0;
        for (long c : count)
            result = (result + c) % MOD;

        return (int) result;
    }

    private static long[] matrixPowerMultiply(long[] count, long[][] trans, int power, int MOD) {
        long[][] result = new long[26][26];
        for (int i = 0; i < 26; i++)
            result[i][i] = 1;

        while (power > 0) {
            if ((power & 1) == 1)
                result = multiplyMatrices(result, trans, MOD);
            trans = multiplyMatrices(trans, trans, MOD);
            power >>= 1;
        }

        long[] finalCount = new long[26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                finalCount[i] = (finalCount[i] + count[j] * result[j][i]) % MOD;
            }
        }
        return finalCount;
    }

    private static long[][] multiplyMatrices(long[][] a, long[][] b, int MOD) {
        long[][] result = new long[26][26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                for (int k = 0; k < 26; k++) {
                    result[i][j] = (result[i][j] + a[i][k] * b[k][j]) % MOD;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LengthAfterTransformations sol = new LengthAfterTransformations();
        System.out.println(sol.lengthAfterTransformations("abcyy", 2, Arrays.asList(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2))); // Output: 7
        System.out.println(sol.lengthAfterTransformations("azbk", 1, Arrays.asList(2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2)));  // Output: 8
    }
}
