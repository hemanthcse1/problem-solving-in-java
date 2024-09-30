package examples.interviewquestions.arrays.easy;

public class LongestEvenOddSubarray {
    public int longestEvenOddSubarray(int[] nums, int threshold) {
        int maxLength = 0;

        int n = nums.length;

        for (int start = 0; start < n; start++) {
            if (nums[start] % 2 == 0 && nums[start] <= threshold) {
                int length = 1;

                for (int i = start + 1; i < n; i++) {
                    if (nums[i] % 2 != nums[i - 1] % 2 && nums[i] <= threshold) {
                        length++;
                    } else {
                        break;
                    }
                }

                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestEvenOddSubarray solution = new LongestEvenOddSubarray();

        int[] nums1 = {3, 2, 5, 4};
        int threshold1 = 5;
        System.out.println(solution.longestEvenOddSubarray(nums1, threshold1));

        int[] nums2 = {1, 2};
        int threshold2 = 2;
        System.out.println(solution.longestEvenOddSubarray(nums2, threshold2));

        int[] nums3 = {2, 3, 4, 5};
        int threshold3 = 4;
        System.out.println(solution.longestEvenOddSubarray(nums3, threshold3));
    }
}
