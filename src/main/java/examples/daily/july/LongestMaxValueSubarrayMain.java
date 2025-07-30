package examples.daily.july;

public class LongestMaxValueSubarrayMain {

    public static void main(String[] args) {
        LongestMaxValueSubarrayMain solution = new LongestMaxValueSubarrayMain();

        int[] nums1 = {1, 3, 3, 2, 3, 3, 3, 1}; // max = 3 → longest = 3
        int[] nums2 = {5, 5, 5, 5, 5};          // max = 5 → longest = 5
        int[] nums3 = {1, 2, 3, 4, 5};          // max = 5 → longest = 1
        int[] nums4 = {7, 1, 7, 7, 3, 7};       // max = 7 → longest = 2

        System.out.println("Longest max subarray in nums1: " + solution.longestSubarray(nums1));
        System.out.println("Longest max subarray in nums2: " + solution.longestSubarray(nums2));
        System.out.println("Longest max subarray in nums3: " + solution.longestSubarray(nums3));
        System.out.println("Longest max subarray in nums4: " + solution.longestSubarray(nums4));
    }

    public int longestSubarray(int[] nums) {
        int maxValue = 0;

        for (int num : nums) {
            maxValue = Math.max(maxValue, num);
        }

        int maxLength = 0, currentLength = 0;

        for (int num : nums) {
            if (num == maxValue) {
                currentLength++;
                maxLength = Math.max(maxLength, currentLength);
            } else {
                currentLength = 0;
            }
        }

        return maxLength;
    }
}
