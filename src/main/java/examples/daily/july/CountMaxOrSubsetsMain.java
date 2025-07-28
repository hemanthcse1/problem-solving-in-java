package examples.daily.july;

public class CountMaxOrSubsetsMain {

    public static void main(String[] args) {
        CountMaxOrSubsetsMain solution = new CountMaxOrSubsetsMain();

        int[] nums1 = {3, 1};           //  2
        int[] nums2 = {2, 2, 2};        // 7
        int[] nums3 = {1, 2, 3};        //  6

        System.out.println("Result 1: " + solution.countMaxOrSubsets(nums1));
        System.out.println("Result 2: " + solution.countMaxOrSubsets(nums2));
        System.out.println("Result 3: " + solution.countMaxOrSubsets(nums3));
    }

    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;
        for (int num : nums) {
            maxOr |= num;
        }
        return countSubsets(nums, 0, 0, maxOr);
    }

    private int countSubsets(int[] nums, int index, int currentOr, int maxOr) {
        if (index == nums.length) {
            return currentOr == maxOr ? 1 : 0;
        }
        int include = countSubsets(nums, index + 1, currentOr | nums[index], maxOr);
        int exclude = countSubsets(nums, index + 1, currentOr, maxOr);
        return include + exclude;
    }
}
