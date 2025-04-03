package examples.daily.april;

public class MaximumOrderedTripletValue {

    public static long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long maxVal = 0;
        int maxI = nums[0];
        int[] maxRight = new int[n];
        maxRight[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], nums[i]);
        }

        for (int j = 1; j < n - 1; j++) {
            long value = (long)(maxI - nums[j]) * maxRight[j + 1];
            maxVal = Math.max(maxVal, value);
            maxI = Math.max(maxI, nums[j]);
        }

        return Math.max(maxVal, 0);
    }

    public static void main(String[] args) {
        int[] nums1 = {12, 6, 1, 2, 7};
        int[] nums2 = {1, 10, 3, 4, 19};
        int[] nums3 = {1, 2, 3};
        int[] nums4 = {1000000, 1, 1000000};

        System.out.println(maximumTripletValue(nums1)); //  77
        System.out.println(maximumTripletValue(nums2)); //  133
        System.out.println(maximumTripletValue(nums3)); //  0
        System.out.println(maximumTripletValue(nums4)); //  999999000000
    }
}
