package examples.daily.may;

public class TransformationsMain {

    public static int lengthAfterTransformations(String s, int t) {
        final int MOD = 1_000_000_007;
        int[] count = new int[26];

        for (char c : s.toCharArray())
            count[c - 'a']++;

        while (t-- > 0) {
            int z = count[25];
            System.arraycopy(count, 0, count, 1, 25);
            count[0] = z;
            count[1] = (count[1] + z) % MOD;
        }

        int result = 0;
        for (int c : count)
            result = (result + c) % MOD;

        return result;
    }

    public static void main(String[] args) {
        System.out.println(lengthAfterTransformations("abcyy", 2)); // 7
        System.out.println(lengthAfterTransformations("azbk", 1));  // 5
    }
}
