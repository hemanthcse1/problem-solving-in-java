package examples.interviewquestions.arrays.medium;

public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) return 0;

        int totalSlices = 0;
        int currentSlices = 0;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                currentSlices++;
                totalSlices += currentSlices;
            } else {
                currentSlices = 0;
            }
        }

        return totalSlices;
    }

    public static void main(String[] args) {
        ArithmeticSlices solution = new ArithmeticSlices();
        System.out.println(solution.numberOfArithmeticSlices(new int[]{1, 2, 3, 4})); // Output: 3
        System.out.println(solution.numberOfArithmeticSlices(new int[]{1}));          // Output: 0
        System.out.println(solution.numberOfArithmeticSlices(new int[]{7, 7, 7, 7})); // Output: 3
    }
}
