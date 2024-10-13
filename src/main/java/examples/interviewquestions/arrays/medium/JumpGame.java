package examples.interviewquestions.arrays.medium;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int farthest = 0;

        for (int i = 0; i < n; i++) {
            if (i > farthest) {

                return false;
            }

            farthest = Math.max(farthest, i + nums[i]);


            if (farthest >= n - 1) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        JumpGame solution = new JumpGame();

        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println(solution.canJump(nums1));

        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println(solution.canJump(nums2));

        int[] nums3 = {0};
        System.out.println(solution.canJump(nums3));
    }
}
