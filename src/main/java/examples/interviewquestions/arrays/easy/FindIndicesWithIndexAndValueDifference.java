package examples.interviewquestions.arrays.easy;

public class FindIndicesWithIndexAndValueDifference {
    public static int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (Math.abs(i - j) >= indexDifference && Math.abs(nums[i] - nums[j]) >= valueDifference) {
                    return new int[] {i, j};
                }
            }
        }

        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int[] nums1 = {5, 1, 4, 1};
        int indexDifference1 = 2;
        int valueDifference1 = 4;
        int[] result1 = findIndices(nums1, indexDifference1, valueDifference1);
        System.out.println("Result 1: [" + result1[0] + ", " + result1[1] + "]");

        int[] nums2 = {2, 1};
        int indexDifference2 = 0;
        int valueDifference2 = 0;
        int[] result2 = findIndices(nums2, indexDifference2, valueDifference2);
        System.out.println("Result 2: [" + result2[0] + ", " + result2[1] + "]");

        int[] nums3 = {1, 2, 3};
        int indexDifference3 = 2;
        int valueDifference3 = 4;
        int[] result3 = findIndices(nums3, indexDifference3, valueDifference3);
        System.out.println("Result 3: [" + result3[0] + ", " + result3[1] + "]");
    }
}
