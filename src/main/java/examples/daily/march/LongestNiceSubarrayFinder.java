package examples.daily.march;

public class LongestNiceSubarrayFinder {

    public static int longestNiceSubarray(int[] nums) {
        int left = 0, maxLen = 0;
        int mask = 0;

        for (int right = 0; right < nums.length; right++) {
            while ((mask & nums[right]) != 0) {
                mask ^= nums[left];
                left++;
            }
            mask |= nums[right];
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 8, 48, 10};
        int[] nums2 = {3, 1, 5, 11, 13};

        System.out.println("Example 1:");
        System.out.println("Input: [1, 3, 8, 48, 10]");
        System.out.println("Longest Nice Subarray Length: " + longestNiceSubarray(nums1));

        System.out.println("\nExample 2:");
        System.out.println("Input: [3, 1, 5, 11, 13]");
        System.out.println("Longest Nice Subarray Length: " + longestNiceSubarray(nums2));
    }
}
