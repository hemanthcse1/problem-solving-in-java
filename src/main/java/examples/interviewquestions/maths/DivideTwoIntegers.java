package examples.interviewquestions.maths;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean isNegative = (dividend < 0) ^ (divisor < 0);
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);
        int result = 0;
        while (absDividend >= absDivisor) {
            long tempDivisor = absDivisor, multiple = 1;

            while (absDividend >= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                multiple <<= 1;
            }
            absDividend -= tempDivisor;
            result += multiple;
        }
        return isNegative ? -result : result;
    }
    public static void main(String[] args) {
        DivideTwoIntegers solution = new DivideTwoIntegers();
        int dividend1 = 10, divisor1 = 3;
        int dividend2 = 7, divisor2 = -3;
        System.out.println(solution.divide(dividend1, divisor1));
        System.out.println(solution.divide(dividend2, divisor2));
    }
}
