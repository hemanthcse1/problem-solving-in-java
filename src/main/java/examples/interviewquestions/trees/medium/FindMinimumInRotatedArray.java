package examples.interviewquestions.trees.medium;

public class FindMinimumInRotatedArray {

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        FindMinimumInRotatedArray solver = new FindMinimumInRotatedArray();

        int[] nums1 = {3,4,5,1,2};
        System.out.println(solver.findMin(nums1));

        int[] nums2 = {4,5,6,7,0,1,2};
        System.out.println(solver.findMin(nums2));

        int[] nums3 = {11,13,15,17};
        System.out.println(solver.findMin(nums3));
    }
}
