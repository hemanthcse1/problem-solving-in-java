package examples.interviewquestions.arrays.easy;

public class DivideArrayMinimumCost {
    public static int minCostDivideArray(int[] nums) {
        int n = nums.length;
        int minCost = Integer.MAX_VALUE;


        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {

                int cost = nums[0] + nums[i + 1] + nums[j + 1];

                minCost = Math.min(minCost, cost);
            }
        }

        return minCost;
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 1, 5, 6, 3};
        System.out.println("Minimum cost to divide array: " + minCostDivideArray(nums));
    }
}
