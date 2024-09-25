package examples.interviewquestions.arrays.easy;

public class GetMinDistance {
    public int getMinDistance(int[] nums, int target, int start) {
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                int distance = Math.abs(i - start);
                minDistance = Math.min(minDistance, distance);
            }
        }

        return minDistance;
    }

    public static void main(String[] args) {
        GetMinDistance solution = new GetMinDistance();

        int[] nums1 = {1, 2, 3, 4, 5};
        System.out.println(solution.getMinDistance(nums1, 5, 3));

        int[] nums2 = {1};
        System.out.println(solution.getMinDistance(nums2, 1, 0));

        int[] nums3 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(solution.getMinDistance(nums3, 1, 0));
    }
}
