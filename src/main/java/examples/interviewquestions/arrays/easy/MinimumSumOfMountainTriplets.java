package examples.interviewquestions.arrays.easy;

public class MinimumSumOfMountainTriplets {
    public int minimumSumOfMountainTriplets(int[] nums) {
        int n = nums.length;
        if (n < 3) return -1;

        int minSum = Integer.MAX_VALUE;
        boolean found = false;

        for (int j = 1; j < n - 1; j++) {
            int leftMin = Integer.MAX_VALUE;
            int rightMin = Integer.MAX_VALUE;

            for (int i = 0; i < j; i++) {
                if (nums[i] < nums[j]) {
                    leftMin = Math.min(leftMin, nums[i]);
                }
            }

            for (int k = j + 1; k < n; k++) {
                if (nums[k] < nums[j]) {
                    rightMin = Math.min(rightMin, nums[k]);
                }
            }

            if (leftMin != Integer.MAX_VALUE && rightMin != Integer.MAX_VALUE) {
                int currentSum = leftMin + nums[j] + rightMin;
                minSum = Math.min(minSum, currentSum);
                found = true;
            }
        }

        return found ? minSum : -1;
    }

    public static void main(String[] args) {
        MinimumSumOfMountainTriplets solution = new MinimumSumOfMountainTriplets();
        System.out.println(solution.minimumSumOfMountainTriplets(new int[]{8,6,1,5,3}));
        System.out.println(solution.minimumSumOfMountainTriplets(new int[]{5,4,8,7,10,2}));
        System.out.println(solution.minimumSumOfMountainTriplets(new int[]{6,5,4,3,4,5}));
    }
}
