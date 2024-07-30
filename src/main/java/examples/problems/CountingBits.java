package examples.problems;

public class CountingBits {
    public static int[] countBits(int n) {
        int[] ans = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] result = countBits(n);
        System.out.print("Number of 1's in binary representations: ");
        for (int count : result) {
            System.out.print(count + " ");
        }
    }
}
