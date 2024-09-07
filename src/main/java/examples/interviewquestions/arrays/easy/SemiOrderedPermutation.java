package examples.interviewquestions.arrays.easy;

public class SemiOrderedPermutation {
    public static int minOperations(int[] nums) {
        int n = nums.length;
        int pos1 = -1;
        int posN = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                pos1 = i;
            }
            if (nums[i] == n) {
                posN = i;
            }
        }

        if (pos1 < posN) {
            return pos1 + (n - 1 - posN);
        } else {
            return pos1 + (n - 1 - posN) - 1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 4, 3};
        System.out.println("Minimum operations: " + minOperations(nums));
    }
}
