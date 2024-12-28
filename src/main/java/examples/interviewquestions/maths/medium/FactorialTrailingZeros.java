package examples.interviewquestions.maths.medium;

public class FactorialTrailingZeros {

    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            n /= 5;
            count += n;
        }
        return count;
    }

    public static void main(String[] args) {
        FactorialTrailingZeros sol = new FactorialTrailingZeros();

        System.out.println(sol.trailingZeroes(3));
        System.out.println(sol.trailingZeroes(5));
        System.out.println(sol.trailingZeroes(0));


        System.out.println(sol.trailingZeroes(25));
    }
}
