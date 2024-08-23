package examples.interviewquestions.arrays.easy;

public class MaximumProductOfTwoElements {
    public int maxProduct(int[] nums) {
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > firstMax) {
                secondMax = firstMax;
                firstMax = num;
            } else if (num > secondMax) {
                secondMax = num;
            }
        }
        return (firstMax - 1) * (secondMax - 1);
    }

    public static void main(String[] args) {
        MaximumProductOfTwoElements solution = new MaximumProductOfTwoElements();

        int[] nums = {3, 4, 5, 2};
        int result = solution.maxProduct(nums);
        System.out.println("Maximum product: " + result);
    }
}
