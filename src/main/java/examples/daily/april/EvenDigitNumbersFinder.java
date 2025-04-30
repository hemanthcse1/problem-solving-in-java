package examples.daily.april;

public class EvenDigitNumbersFinder {

    public static void main(String[] args) {
        EvenDigitNumbersFinder solution = new EvenDigitNumbersFinder();

        int[] nums1 = {12, 345, 2, 6, 7896};
        int[] nums2 = {555, 901, 482, 1771};

        System.out.println("Test Case 1: " + solution.findNumbers(nums1));  //  2
        System.out.println("Test Case 2: " + solution.findNumbers(nums2));  //  1
    }
    public int findNumbers(int[] nums) {
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
