package examples.interviewquestions.maths.easy;

public class PowerOfThree {

    public boolean isPowerOfThreeLoop(int n) {
        if (n < 1) return false;
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }


    public boolean isPowerOfThree(int n) {
        int maxPowerOfThree = 1162261467;
        return n > 0 && maxPowerOfThree % n == 0;
    }

    public static void main(String[] args) {
        PowerOfThree solution = new PowerOfThree();

        System.out.println("Is 27 a power of three? " + solution.isPowerOfThree(27));
        System.out.println("Is 0 a power of three? " + solution.isPowerOfThree(0));
        System.out.println("Is -1 a power of three? " + solution.isPowerOfThree(-1));
        System.out.println("Is 9 a power of three? " + solution.isPowerOfThree(9));
    }
}
