package examples.interviewquestions.arrays.easy;

public class MaximumDivisibilityScore {
    public static int maxDivScore(int[] nums, int[] divisors) {
        int maxScore = 0;
        int resultDivisor = Integer.MAX_VALUE;
        for (int divisor : divisors) {
            int currentScore = 0;
            for (int num : nums) {
                if (num % divisor == 0) {
                    currentScore++;
                }
            }
            if (currentScore > maxScore || (currentScore == maxScore && divisor < resultDivisor)) {
                maxScore = currentScore;
                resultDivisor = divisor;
            }
        }

        return resultDivisor;
    }

    public static void main(String[] args) {
        int[] nums = {4, 7, 9, 3, 9};
        int[] divisors = {5, 2, 3};
        System.out.println(maxDivScore(nums, divisors)); // Output: 3
    }
}
