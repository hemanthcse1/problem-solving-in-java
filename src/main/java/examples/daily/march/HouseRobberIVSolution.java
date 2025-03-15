package examples.daily.march;

public class HouseRobberIVSolution {

    public static void main(String[] args) {
        int[] houseValues1 = {2, 3, 5, 9};
        int k1 = 2;
        System.out.println("Minimum Capability (Example 1): " + minCapability(houseValues1, k1));

        int[] houseValues2 = {2, 7, 9, 3, 1};
        int k2 = 2;
        System.out.println("Minimum Capability (Example 2): " + minCapability(houseValues2, k2));
    }

    public static int minCapability(int[] nums, int k) {
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;

        for (int num : nums) {
            low = Math.min(low, num);
            high = Math.max(high, num);
        }

        int result = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canRob(nums, k, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    private static boolean canRob(int[] nums, int k, int capability) {
        int robbed = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] <= capability) {
                robbed++;
                i += 2;
            } else {
                i++;
            }
            if (robbed >= k) return true;
        }
        return false;
    }
}
