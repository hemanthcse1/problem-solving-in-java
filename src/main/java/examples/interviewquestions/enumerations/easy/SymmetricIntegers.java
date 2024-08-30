package examples.interviewquestions.enumerations.easy;

public class SymmetricIntegers {
    public static int countSymmetricIntegers(int low, int high) {
        int count = 0;

        for (int i = low; i <= high; i++) {
            if (isSymmetric(i)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isSymmetric(int number) {
        String numStr = Integer.toString(number);
        int len = numStr.length();
        if (len % 2 != 0) {
            return false;
        }

        int half = len / 2;
        int sumFirstHalf = 0;
        int sumSecondHalf = 0;
        for (int i = 0; i < half; i++) {
            sumFirstHalf += numStr.charAt(i) - '0';
            sumSecondHalf += numStr.charAt(len - 1 - i) - '0';
        }

        return sumFirstHalf == sumSecondHalf;
    }

    public static void main(String[] args) {
        int low = 1000;
        int high = 9999;

        int result = countSymmetricIntegers(low, high);
        System.out.println("Number of symmetric integers: " + result);
    }
}
