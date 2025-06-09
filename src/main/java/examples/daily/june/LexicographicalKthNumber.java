package examples.daily.june;

public class LexicographicalKthNumber {
    public int findKthNumber(int n, int k) {
        int current = 1;
        k--;

        while (k > 0) {
            long gap = countGap(current, current + 1, n);

            if (gap <= k) {
                current++;
                k -= gap;
            } else {
                current *= 10;
                k--;
            }
        }

        return current;
    }

    private long countGap(long first, long next, int n) {
        long gap = 0;
        while (first <= n) {
            gap += Math.min(n + 1L, next) - first;
            first *= 10;
            next *= 10;
        }
        return gap;
    }

    public static void main(String[] args) {
        LexicographicalKthNumber solver = new LexicographicalKthNumber();
        int n = 100;
        int k = 10;
        int result = solver.findKthNumber(n, k);
        System.out.println("The " + k + "-th number in lexicographical order from 1 to " + n + " is: " + result);
    }
}
