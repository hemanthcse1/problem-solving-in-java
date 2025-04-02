package examples.daily.april;

public class MaxTripletValueCalculator {
    public static long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long max = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    long value = (long)(nums[i] - nums[j]) * nums[k];
                    max = Math.max(max, value);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1000000, 1, 1000000};
        long result = maximumTripletValue(nums);
        System.out.println("Maximum Triplet Value: " + result);
    }
}
