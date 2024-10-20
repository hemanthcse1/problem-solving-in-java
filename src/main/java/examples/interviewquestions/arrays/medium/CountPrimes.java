package examples.interviewquestions.arrays.medium;

public class CountPrimes {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }

        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        CountPrimes solution = new CountPrimes();

        System.out.println("Primes less than 10: " + solution.countPrimes(10));
        System.out.println("Primes less than 0: " + solution.countPrimes(0));
        System.out.println("Primes less than 1: " + solution.countPrimes(1));
    }
}
