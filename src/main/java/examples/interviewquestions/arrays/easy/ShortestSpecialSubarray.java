package examples.interviewquestions.arrays.easy;

public class ShortestSpecialSubarray {
    public static int shortestSubarrayWithORAtLeastK(int[] nums, int k) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;

        for (int start = 0; start < n; start++) {
            int orResult = 0;
            for (int end = start; end < n; end++) {
                orResult |= nums[end];

                if (orResult >= k) {
                    minLength = Math.min(minLength, end - start + 1);
                    break;
                }
            }
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int k = 6;
        System.out.println("Shortest subarray length: " + shortestSubarrayWithORAtLeastK(nums, k));
    }
}
