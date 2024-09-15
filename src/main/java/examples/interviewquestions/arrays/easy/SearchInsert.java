package examples.interviewquestions.arrays.easy;

public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        SearchInsert solution = new SearchInsert();

        // Test case 1
        int[] nums1 = {1, 3, 5, 6};
        System.out.println(solution.searchInsert(nums1, 5));  // Output: 2

        // Test case 2
        int[] nums2 = {1, 3, 5, 6};
        System.out.println(solution.searchInsert(nums2, 2));  // Output: 1

        // Test case 3
        int[] nums3 = {1, 3, 5, 6};
        System.out.println(solution.searchInsert(nums3, 7));  // Output: 4
    }
}
