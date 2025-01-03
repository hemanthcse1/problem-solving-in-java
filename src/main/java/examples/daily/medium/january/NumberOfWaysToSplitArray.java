package examples.daily.medium.january;

public class NumberOfWaysToSplitArray {

    public int waysToSplitArray(int[] nums) {
        long total = 0;
        for (int num : nums) {
            total += num;
        }
        long runningSum = 0;
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            runningSum += nums[i];
            if (2 * runningSum >= total) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOfWaysToSplitArray solution = new NumberOfWaysToSplitArray();

        int[] nums1 = {10, 4, -8, 7};
        System.out.println(solution.waysToSplitArray(nums1));

        int[] nums2 = {2, 3, 1, 0};
        System.out.println(solution.waysToSplitArray(nums2));
    }
}
