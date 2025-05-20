package examples.daily.may;

public class ZeroArrayValidatorApp {

    public static void main(String[] args) {
        ZeroArrayValidatorApp solution = new ZeroArrayValidatorApp();

        int[] nums = {3, 2, 2, 1};
        int[][] queries = {
                {0, 2},
                {1, 3}
        };

        boolean result = solution.isZeroArray(nums, queries);

        System.out.println("Can the array be reduced to all zeros using the queries? " + result);
    }

    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];

        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            diff[l]++;
            if (r + 1 < n) {
                diff[r + 1]--;
            }
        }

        int[] decrements = new int[n];
        decrements[0] = diff[0];
        for (int i = 1; i < n; i++) {
            decrements[i] = decrements[i - 1] + diff[i];
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > decrements[i]) {
                return false;
            }
        }
        return true;
    }


}
