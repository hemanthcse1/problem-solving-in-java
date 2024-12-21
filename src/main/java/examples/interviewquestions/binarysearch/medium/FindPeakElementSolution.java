package examples.interviewquestions.binarysearch.medium;

public class FindPeakElementSolution {

    static class Solution {
        public int findPeakElement(int[] nums) {
            int low = 0, high = nums.length - 1;
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (nums[mid] > nums[mid + 1]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();


        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Peak Index for [1, 2, 3, 1]: " + solution.findPeakElement(nums1));


        int[] nums2 = {1, 2, 1, 3, 5, 6, 4};
        int peakIndex2 = solution.findPeakElement(nums2);
        System.out.println("Peak Index for [1, 2, 1, 3, 5, 6, 4]: " + peakIndex2);

    }
}
