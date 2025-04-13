package examples.daily.april;

public class CountGoodDigitStrings {
    private static final int MOD = 1_000_000_007;


    public int countGoodNumbers(long n) {

        long evenPositions = (n + 1) / 2;


        long oddPositions = n / 2;


        long countEvenDigits = power(5, evenPositions);
        long countOddDigits = power(4, oddPositions);

        return (int)((countEvenDigits * countOddDigits) % MOD);
    }


    private long power(long base, long exp) {
        long result = 1;
        base %= MOD;

        while (exp > 0) {

            if ((exp & 1) == 1) {
                result = (result * base) % MOD;
            }


            base = (base * base) % MOD;
            exp >>= 1;
        }

        return result;
    }

    public static void main(String[] args) {
        CountGoodDigitStrings solution = new CountGoodDigitStrings();

        System.out.println(solution.countGoodNumbers(1));   //  5
        System.out.println(solution.countGoodNumbers(4));   //  400
        System.out.println(solution.countGoodNumbers(50));  //  564908303
    }

}
