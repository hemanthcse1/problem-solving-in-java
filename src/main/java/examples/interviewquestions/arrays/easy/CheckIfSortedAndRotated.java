package examples.interviewquestions.arrays.easy;

public class CheckIfSortedAndRotated {
    public boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
        }
        return count <= 1;
    }

    public static void main(String[] args) {
        CheckIfSortedAndRotated checker = new CheckIfSortedAndRotated();

        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println(checker.check(nums1));  // Output: true

        int[] nums2 = {2, 1, 3, 4};
        System.out.println(checker.check(nums2));  // Output: false
    }
}
