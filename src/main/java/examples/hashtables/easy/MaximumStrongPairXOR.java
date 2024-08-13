package examples.hashtables.easy;

public class MaximumStrongPairXOR {
    public static int maxStrongPairXOR(int[] nums) {
        int maxXOR = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int x = nums[i];
                int y = nums[j];

                if (Math.abs(x - y) <= Math.min(x, y)) {
                    int xorValue = x ^ y;
                    maxXOR = Math.max(maxXOR, xorValue);
                }
            }
        }
        return maxXOR;
    }

    public static void main(String[] args) {
        int[] nums = {5, 1, 10, 12};
        int result = maxStrongPairXOR(nums);
        System.out.println("Maximum Strong Pair XOR: " + result);
    }
}
