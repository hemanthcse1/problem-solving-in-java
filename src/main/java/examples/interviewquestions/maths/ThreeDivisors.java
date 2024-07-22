package examples.interviewquestions.maths;

public class ThreeDivisors {
    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isThree(int n) {
        int sqrtN = (int) Math.sqrt(n);
        if (sqrtN * sqrtN != n) {
            return false;
        }
        return isPrime(sqrtN);
    }

    public static void main(String[] args) {
        int n1 = 2;
        System.out.println(isThree(n1));

        int n2 = 4;
        System.out.println(isThree(n2));
    }
}
