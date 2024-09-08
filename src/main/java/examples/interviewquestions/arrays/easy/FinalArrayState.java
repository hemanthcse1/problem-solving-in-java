package examples.interviewquestions.arrays.easy;

public class FinalArrayState {
    public static int[] applyOperations(int[] nums, int k, int multiplier) {
        for (int i = 0; i < k; i++) {
            int minIndex = 0;
            for (int j = 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }

            nums[minIndex] *= multiplier;
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 4, 2};
        int k = 3;
        int multiplier = 2;

        int[] result = applyOperations(nums, k, multiplier);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
