package examples.interviewquestions.arrays.easy;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        SearchInsertPosition sip = new SearchInsertPosition();

        int[] nums1 = {1, 3, 5, 6};
        System.out.println(sip.searchInsert(nums1, 5));  // Output: 2
        System.out.println(sip.searchInsert(nums1, 2));  // Output: 1
        System.out.println(sip.searchInsert(nums1, 7));  // Output: 4
        System.out.println(sip.searchInsert(nums1, 0));  // Output: 0
    }
}
