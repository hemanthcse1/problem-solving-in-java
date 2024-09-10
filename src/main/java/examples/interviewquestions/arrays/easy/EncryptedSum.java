package examples.interviewquestions.arrays.easy;

public class EncryptedSum {
    public static int encrypt(int x) {
        int largestDigit = 0;
        int num = x;

        while (num > 0) {
            int digit = num % 10;
            largestDigit = Math.max(largestDigit, digit);
            num /= 10;
        }

        int encryptedNumber = 0;
        int placeValue = 1;

        while (x > 0) {
            encryptedNumber += largestDigit * placeValue;
            placeValue *= 10;
            x /= 10;
        }

        return encryptedNumber;
    }

    public static int sumOfEncryptedElements(int[] nums) {
        int totalSum = 0;

        for (int num : nums) {
            totalSum += encrypt(num);
        }

        return totalSum;
    }

    public static void main(String[] args) {
        int[] nums = {523, 213, 45};
        System.out.println("Sum of encrypted elements: " + sumOfEncryptedElements(nums));
    }
}
