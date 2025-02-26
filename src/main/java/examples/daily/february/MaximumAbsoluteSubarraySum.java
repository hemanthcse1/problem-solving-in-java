package examples.daily.february;

public class MaximumAbsoluteSubarraySum {

    public int maxAbsoluteSum(int[] nums) {
        int maxSum = 0, minSum = 0, currentMax = 0, currentMin = 0;

        for (int num : nums) {

            currentMax = Math.max(num, currentMax + num);
            maxSum = Math.max(maxSum, currentMax);


            currentMin = Math.min(num, currentMin + num);
            minSum = Math.min(minSum, currentMin);
        }


        return Math.max(maxSum, Math.abs(minSum));
    }

    public static void main(String[] args) {
        MaximumAbsoluteSubarraySum solution = new MaximumAbsoluteSubarraySum();

        System.out.println(solution.maxAbsoluteSum(new int[]{1, -3, 2, 3, -4})); //  5
        System.out.println(solution.maxAbsoluteSum(new int[]{2, -5, 1, -4, 3, -2})); //  8
        System.out.println(solution.maxAbsoluteSum(new int[]{-2, -3, -1, -5})); //  5
        System.out.println(solution.maxAbsoluteSum(new int[]{4, -1, 2, -7, 5})); //  7
    }
}
