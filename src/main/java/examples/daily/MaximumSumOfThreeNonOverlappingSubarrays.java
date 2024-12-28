package examples.daily;

public class MaximumSumOfThreeNonOverlappingSubarrays {

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n - k + 1];
        int windowSum = 0;

        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        sum[0] = windowSum;
        for (int i = 1; i <= n - k; i++) {
            windowSum += nums[i + k - 1] - nums[i - 1];
            sum[i] = windowSum;
        }

        int[] left = new int[n - k + 1];
        int best = 0;
        for (int i = 0; i < n - k + 1; i++) {
            if (sum[i] > sum[best]) {
                best = i;
            }
            left[i] = best;
        }

        int[] right = new int[n - k + 1];
        best = n - k;
        for (int i = n - k; i >= 0; i--) {
            if (sum[i] >= sum[best]) {
                best = i;
            }
            right[i] = best;
        }

        int[] ans = new int[]{-1, -1, -1};
        int maxSum = 0;


        for (int j = k; j <= n - 2 * k; j++) {
            int i = left[j - k];
            int l = right[j + k];
            int total = sum[i] + sum[j] + sum[l];
            if (total > maxSum) {
                maxSum = total;
                ans[0] = i;
                ans[1] = j;
                ans[2] = l;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,2,6,7,5,1};
        int k = 2;
        int[] result = new MaximumSumOfThreeNonOverlappingSubarrays().maxSumOfThreeSubarrays(nums, k);
        for (int index : result) {
            System.out.print(index + " ");
        }
    }
}
