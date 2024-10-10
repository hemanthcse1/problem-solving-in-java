package examples.interviewquestions.arrays.medium;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int closestSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];

                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }

                if (currentSum < target) {
                    left++;
                } else if (currentSum > target) {
                    right--;
                } else {
                    return currentSum;
                }
            }
        }

        return closestSum;
    }

    public static void main(String[] args) {
        ThreeSumClosest solution = new ThreeSumClosest();

        int[] nums1 = {-1, 2, 1, -4};
        int target1 = 1;
        int result1 = solution.threeSumClosest(nums1, target1);
        System.out.println("The closest sum to target " + target1 + " is: " + result1);

        int[] nums2 = {0, 0, 0};
        int target2 = 1;
        int result2 = solution.threeSumClosest(nums2, target2);
        System.out.println("The closest sum to target " + target2 + " is: " + result2);

        int[] nums3 = {-1, -1, -1, 0, 1, 1};
        int target3 = 2;
        int result3 = solution.threeSumClosest(nums3, target3);
        System.out.println("The closest sum to target " + target3 + " is: " + result3);

        int[] nums4 = {1, 1, 1, 1};
        int target4 = 3;
        int result4 = solution.threeSumClosest(nums4, target4);
        System.out.println("The closest sum to target " + target4 + " is: " + result4);
    }
}
