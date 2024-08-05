package examples.interviewquestions.arrays;

public class EvenDigits {
    public static void main(String[] args) {
        int[] nums = {12, 345, 2, 6, 7896};
        System.out.println(findNumbers(nums));
    }

    public static int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (hasEvenNumberOfDigits(num)) {
                count++;
            }
        }
        return count;
    }

    private static boolean hasEvenNumberOfDigits(int num) {
        int digitCount = 0;
        while (num != 0) {
            digitCount++;
            num /= 10;
        }
        return digitCount % 2 == 0;
    }
}
