package examples.daily.march;

public class ZeroArrayTransformationII {

    public static void main(String[] args) {
        int[] nums1 = {2, 0, 2};
        int[][] queries1 = {
                {0, 2, 1},
                {0, 2, 1},
                {1, 1, 3}
        };
        System.out.println(minZeroArray(nums1, queries1));
        int[] nums2 = {4, 3, 2, 1};
        int[][] queries2 = {
                {1, 3, 2},
                {0, 2, 1}
        };
        System.out.println(minZeroArray(nums2, queries2));
    }

    private  static boolean feasible(int k, int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        for (int i = 0; i < k; i++) {
            int l = queries[i][0], r = queries[i][1], v = queries[i][2];
            diff[l] += v;
            if (r + 1 < n) diff[r + 1] -= v;
        }
        int current = 0;
        for (int i = 0; i < n; i++) {
            current += diff[i];
            if (current < nums[i]) return false;
        }
        return true;
    }

    public static int minZeroArray(int[] nums, int[][] queries) {
        boolean allZero = true;
        for (int num : nums) {
            if (num != 0) {
                allZero = false;
                break;
            }
        }
        if (allZero) return 0;
        int left = 1, right = queries.length, ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (feasible(mid, nums, queries)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
