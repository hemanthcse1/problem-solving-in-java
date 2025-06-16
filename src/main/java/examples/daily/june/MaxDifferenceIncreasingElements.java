package examples.daily.june;

public class MaxDifferenceIncreasingElements {
    public int maximumDifference(int[] nums) {
        int minSoFar = nums[0];
        int maxDiff = -1;

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] > minSoFar) {
                maxDiff = Math.max(maxDiff, nums[j] - minSoFar);
            } else {
                minSoFar = nums[j];
            }
        }

        return maxDiff;
    }

    public static void main(String[] args) {
        MaxDifferenceIncreasingElements sol = new MaxDifferenceIncreasingElements();

        System.out.println(sol.maximumDifference(new int[]{7, 1, 5, 4}));    // 4
        System.out.println(sol.maximumDifference(new int[]{9, 4, 3, 2}));    // -1
        System.out.println(sol.maximumDifference(new int[]{1, 5, 2, 10}));   // 9
    }
}
