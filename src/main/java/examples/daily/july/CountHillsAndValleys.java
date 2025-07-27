package examples.daily.july;

public class CountHillsAndValleys {

    public static void main(String[] args) {
        CountHillsAndValleys sol = new CountHillsAndValleys();

        int[] nums1 = {2, 4, 1, 1, 6, 5};
        int[] nums2 = {6, 6, 5, 5, 4, 1};

        System.out.println("Test 1: " + sol.countHillValley(nums1)); // 3
        System.out.println("Test 2: " + sol.countHillValley(nums2)); // 0
    }

    public int countHillValley(int[] nums) {
        int count = 0;
        int prev = nums[0];

        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) continue;

            if ((prev < nums[i] && nums[i] > nums[i + 1]) ||
                    (prev > nums[i] && nums[i] < nums[i + 1])) {
                count++;
                prev = nums[i];
            }
        }

        return count;
    }
}
