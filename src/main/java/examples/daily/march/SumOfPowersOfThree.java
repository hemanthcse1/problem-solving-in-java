package examples.daily.march;

public class SumOfPowersOfThree {

    public static boolean checkPowersOfThree(int n) {
        while (n > 0) {
            if (n % 3 == 2) {
                return false;
            }
            n /= 3;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] testCases = {12, 91, 21, 27, 243, 59049};

        for (int n : testCases) {
            System.out.println("n = " + n + " → " + checkPowersOfThree(n));
        }
    }
}
