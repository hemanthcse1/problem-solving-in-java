package examples.interviewquestions.arrays.medium;

public class MinimumSwapsToGroup {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int totalOnes = 0;

        for (int num : nums) {
            totalOnes += num;
        }

        int currentOnes = 0;
        for (int i = 0; i < totalOnes; i++) {
            currentOnes += nums[i];
        }

        int maxOnesInWindow = currentOnes;
        for (int i = 1; i < n; i++) {
            currentOnes = currentOnes - nums[i - 1] + nums[(i + totalOnes - 1) % n];
            maxOnesInWindow = Math.max(maxOnesInWindow, currentOnes);
        }

        return totalOnes - maxOnesInWindow;
    }

    public static void main(String[] args) {
        MinimumSwapsToGroup solution = new MinimumSwapsToGroup();
        System.out.println(solution.minSwaps(new int[]{0, 1, 0, 1, 1, 0, 0}));
        System.out.println(solution.minSwaps(new int[]{0, 1, 1, 1, 0, 0, 1, 1, 0}));
    }
}
