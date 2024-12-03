package examples.interviewquestions.arrays.medium;

public class MaximumBitwiseORSubsets {

    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;
        for (int num : nums) {
            maxOr |= num;
        }
        return countSubsets(nums, 0, 0, maxOr);
    }

    private int countSubsets(int[] nums, int index, int currentOr, int maxOr) {
        if (index == nums.length) {
            return currentOr == maxOr ? 1 : 0;
        }
        int include = countSubsets(nums, index + 1, currentOr | nums[index], maxOr);
        int exclude = countSubsets(nums, index + 1, currentOr, maxOr);
        return include + exclude;
    }

    public static void main(String[] args) {
        MaximumBitwiseORSubsets solution = new MaximumBitwiseORSubsets();
        System.out.println(solution.countMaxOrSubsets(new int[]{3, 1}));
        System.out.println(solution.countMaxOrSubsets(new int[]{2, 2, 2}));
        System.out.println(solution.countMaxOrSubsets(new int[]{3, 2, 1, 5}));
    }
}
