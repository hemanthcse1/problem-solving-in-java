package examples.interviewquestions.arrays.easy;

import java.util.Arrays;

public class LargestPerimeter {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);

        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i - 2] + nums[i - 1] > nums[i]) {
                return nums[i - 2] + nums[i - 1] + nums[i];
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        LargestPerimeter solution = new LargestPerimeter();

        int[] nums1 = {2, 1, 2};
        System.out.println(solution.largestPerimeter(nums1));

        int[] nums2 = {1, 2, 1, 10};
        System.out.println(solution.largestPerimeter(nums2));
    }
}
