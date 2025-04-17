package examples.daily.april;

public class CountEqualAndDivisiblePairs {
    public int countPairs(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j] && (i * j) % k == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountEqualAndDivisiblePairs solution = new CountEqualAndDivisiblePairs();
        int[] nums = {3, 1, 2, 2, 2, 1, 3};
        int k = 2;
        int result = solution.countPairs(nums, k);
        System.out.println("Number of equal and divisible pairs: " + result);
    }
}
