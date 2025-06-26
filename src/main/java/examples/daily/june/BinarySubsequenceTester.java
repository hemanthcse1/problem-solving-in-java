package examples.daily.june;

public class BinarySubsequenceTester {
    public int longestSubsequence(String s, int k) {
        int n = s.length();
        int count = 0;
        int zeros = 0;
        long value = 0;
        int power = 0;

        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '0') {
                zeros++;
            } else {
                if (power < 32 && value + (1L << power) <= k) {
                    value += 1L << power;
                    count++;
                }
                power++;
            }
        }

        return count + zeros;
    }

    public static void main(String[] args) {
        BinarySubsequenceTester sol = new BinarySubsequenceTester();

        String s1 = "1001010";
        int k1 = 5;
        System.out.println(sol.longestSubsequence(s1, k1)); //  5

        String s2 = "00101001";
        int k2 = 1;
        System.out.println(sol.longestSubsequence(s2, k2)); // 6
    }
}
