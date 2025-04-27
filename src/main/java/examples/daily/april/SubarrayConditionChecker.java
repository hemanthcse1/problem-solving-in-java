package examples.daily.april;

public class SubarrayConditionChecker {

    public static void main(String[] args) {
        SubarrayConditionChecker solution = new SubarrayConditionChecker();

        int[] nums1 = {1, 2, 1, 4, 1};
        System.out.println("Result for nums1: " + solution.countSubarrays(nums1));

        int[] nums2 = {1, 1, 1};
        System.out.println("Result for nums2: " + solution.countSubarrays(nums2));
    }

    public int countSubarrays(int[] nums) {
        int count = 0;
        for (int i = 0; i <= nums.length - 3; i++) {
            if (nums[i] + nums[i + 2] == nums[i + 1] / 2.0) {
                count++;
            }
        }
        return count;
    }
}
