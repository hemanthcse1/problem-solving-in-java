package examples.interviewquestions.maths.easy;

public class UglyNumber {
    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }

        while (n % 2 == 0) {
            n /= 2;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 5 == 0) {
            n /= 5;
        }

        return n == 1;
    }

    public static void main(String[] args) {
        UglyNumber solution = new UglyNumber();

        System.out.println("Is 6 an ugly number? " + solution.isUgly(6));
        System.out.println("Is 1 an ugly number? " + solution.isUgly(1));
        System.out.println("Is 14 an ugly number? " + solution.isUgly(14));
    }
}
