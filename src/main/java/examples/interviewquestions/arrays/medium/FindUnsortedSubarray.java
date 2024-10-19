package examples.interviewquestions.arrays.medium;

public class FindUnsortedSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int left = -1, right = -1;
        int maxSeen = Integer.MIN_VALUE;
        int minSeen = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            maxSeen = Math.max(maxSeen, nums[i]);
            if (nums[i] < maxSeen) {
                right = i;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            minSeen = Math.min(minSeen, nums[i]);
            if (nums[i] > minSeen) {
                left = i;
            }
        }

        if (right == -1) {
            return 0;
        }

        return right - left + 1;
    }

    public static void main(String[] args) {
        FindUnsortedSubarray solution = new FindUnsortedSubarray();

        int[] nums1 = {2, 6, 4, 8, 10, 9, 15};
        System.out.println("Unsorted Subarray Length: " + solution.findUnsortedSubarray(nums1));

        int[] nums2 = {1, 2, 3, 4};
        System.out.println("Unsorted Subarray Length: " + solution.findUnsortedSubarray(nums2));

        int[] nums3 = {1};
        System.out.println("Unsorted Subarray Length: " + solution.findUnsortedSubarray(nums3));
    }
}
