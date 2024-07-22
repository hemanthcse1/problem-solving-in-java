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
        int n1 = 9;
        System.out.println(isThree(n1));

        int n2 = 10;
        System.out.println(isThree(n2));

        int n3 = 49;
        System.out.println(isThree(n3));

        int n4 = 25;
        System.out.println(isThree(n4));
    }
}
