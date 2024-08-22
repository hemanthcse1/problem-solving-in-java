package examples.interviewquestions.arrays.easy;

import java.util.Arrays;

public class GreatestCommonDivisor {
    public int findGCD(int[] nums) {
        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();

        return gcd(min, max);
    }
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        GreatestCommonDivisor gcdFinder = new GreatestCommonDivisor();
        int[] nums = {2, 5, 6, 9, 10};
        int result = gcdFinder.findGCD(nums);
        System.out.println("Greatest Common Divisor: " + result);
    }
}
