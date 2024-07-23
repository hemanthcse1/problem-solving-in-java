package examples.interviewquestions.maths;

public class DoubleReversal {
    public static boolean isSameAfterReversals(int num) {
        int reversed1 = reverse(num);
        int reversed2 = reverse(reversed1);
        return num == reversed2;
    }

    private static int reverse(int num) {
        int reversed = 0;
        while (num != 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        return reversed;
    }

    public static void main(String[] args) {
        System.out.println(isSameAfterReversals(2021));
        System.out.println(isSameAfterReversals(12300));
        System.out.println(isSameAfterReversals(0));
        System.out.println(isSameAfterReversals(12321));
    }
}
