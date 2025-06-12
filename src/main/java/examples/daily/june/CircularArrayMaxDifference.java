package examples.daily.june;

public class CircularArrayMaxDifference {
    public int maxAbsoluteDifference(int[] nums) {
        int maxDiff = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int next = (i + 1) % n;
            int diff = Math.abs(nums[i] - nums[next]);
            maxDiff = Math.max(maxDiff, diff);
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        CircularArrayMaxDifference solution = new CircularArrayMaxDifference();
        int[] nums1 = {1, 2, 4};
        int[] nums2 = {-5, -10, -5};

        System.out.println(solution.maxAbsoluteDifference(nums1)); //  3
        System.out.println(solution.maxAbsoluteDifference(nums2)); //  5
    }
}
