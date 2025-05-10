package examples.daily.may;

public class MinimumEqualSumAfterReplacingZeros {

    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0, sum2 = 0;
        int zero1 = 0, zero2 = 0;

        for (int n : nums1) {
            sum1 += n;
            if (n == 0) zero1++;
        }
        for (int n : nums2) {
            sum2 += n;
            if (n == 0) zero2++;
        }

        long minPossible1 = sum1 + zero1;
        long minPossible2 = sum2 + zero2;

        if (zero1 == 0 && sum1 < minPossible2) return -1;
        if (zero2 == 0 && sum2 < minPossible1) return -1;

        return Math.max(minPossible1, minPossible2);
    }

    public static void main(String[] args) {
        MinimumEqualSumAfterReplacingZeros solver = new MinimumEqualSumAfterReplacingZeros();

        int[] nums1 = {3, 2, 0, 1, 0};
        int[] nums2 = {6, 5, 0};
        System.out.println(solver.minSum(nums1, nums2)); //  12

        int[] nums3 = {2, 0, 2, 0};
        int[] nums4 = {1, 4};
        System.out.println(solver.minSum(nums3, nums4)); //  -1
    }
}
