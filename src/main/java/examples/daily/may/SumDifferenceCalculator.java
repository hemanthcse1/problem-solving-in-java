package examples.daily.may;

public class SumDifferenceCalculator {
    public static void main(String[] args) {
        SumDifferenceCalculator solution = new SumDifferenceCalculator();

        int n = 10;
        int m = 3;

        int result = solution.differenceOfSums(n, m);
        System.out.println("Difference of sums: " + result);
    }
    public int differenceOfSums(int n, int m) {
        int num1 = 0;
        int num2 = 0;

        for (int i = 1; i <= n; i++) {
            if (i % m == 0) {
                num2 += i;
            } else {
                num1 += i;
            }
        }

        return num1 - num2;
    }
}
