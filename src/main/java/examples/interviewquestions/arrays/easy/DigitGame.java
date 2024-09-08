package examples.interviewquestions.arrays.easy;

public class DigitGame {
    public static boolean canAliceWin(int[] nums) {
        int sumSingleDigits = 0;
        int sumDoubleDigits = 0;

        for (int num : nums) {
            if (num >= 1 && num <= 9) {
                sumSingleDigits += num;
            } else if (num >= 10 && num <= 99) {
                sumDoubleDigits += num;
            }
        }

        if (sumSingleDigits > sumDoubleDigits) {
            return true;
        }

        if (sumDoubleDigits > sumSingleDigits) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {5, 12, 3, 21, 8};
        System.out.println("Can Alice win? " + canAliceWin(nums));
    }
}
