package examples.interviewquestions.maths.medium;

public class TwoKeysKeyboard {

    public int minSteps(int n) {
        int result = 0;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                result += i;
                n /= i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TwoKeysKeyboard solution = new TwoKeysKeyboard();

        System.out.println(solution.minSteps(3));
        System.out.println(solution.minSteps(1));
        System.out.println(solution.minSteps(6));
    }
}
