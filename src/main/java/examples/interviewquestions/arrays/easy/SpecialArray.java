package examples.interviewquestions.arrays.easy;

public class SpecialArray {
    public static boolean isSpecialArray(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if ((nums[i] % 2 == 0 && nums[i + 1] % 2 == 0) || (nums[i] % 2 != 0 && nums[i + 1] % 2 != 0)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};  // True
        int[] nums2 = {2, 4, 6, 8};  // False
        int[] nums3 = {5, 10, 15};   // True

        System.out.println("Is nums1 a special array? " + isSpecialArray(nums1));
        System.out.println("Is nums2 a special array? " + isSpecialArray(nums2));
        System.out.println("Is nums3 a special array? " + isSpecialArray(nums3));
    }
}
