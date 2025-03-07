package examples.daily.march;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClosestPrimesInRange {

    public static int[] closestPrimes(int left, int right) {
        boolean[] isPrime = new boolean[right + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= right; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= right; j += i) {
                    isPrime[j] = false;
                }
            }
        }


        List<Integer> primes = new ArrayList<>();
        for (int i = Math.max(2, left); i <= right; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }


        if (primes.size() < 2) {
            return new int[]{-1, -1};
        }

        int minDiff = Integer.MAX_VALUE;
        int num1 = -1, num2 = -1;

        for (int i = 1; i < primes.size(); i++) {
            int diff = primes.get(i) - primes.get(i - 1);
            if (diff < minDiff) {
                minDiff = diff;
                num1 = primes.get(i - 1);
                num2 = primes.get(i);
            }
        }

        return new int[]{num1, num2};
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(closestPrimes(10, 19))); // [11, 13]
        System.out.println(Arrays.toString(closestPrimes(4, 6)));   // [-1, -1]
    }
}
