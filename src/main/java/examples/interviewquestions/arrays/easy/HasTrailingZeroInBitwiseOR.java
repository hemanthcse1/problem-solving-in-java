package examples.interviewquestions.arrays.easy;

public class HasTrailingZeroInBitwiseOR {
    public boolean hasTrailingZeroInBitwiseOR(int[] nums) {
        int totalOr = 0;

        for (int num : nums) {
            totalOr |= num;
        }

        return (totalOr & (totalOr + 1)) != 0;
    }

    public static void main(String[] args) {
        HasTrailingZeroInBitwiseOR solution = new HasTrailingZeroInBitwiseOR();
        System.out.println(solution.hasTrailingZeroInBitwiseOR(new int[]{1, 2, 3, 4, 5})); // Output: true
        System.out.println(solution.hasTrailingZeroInBitwiseOR(new int[]{2, 4, 8, 16}));   // Output: true
        System.out.println(solution.hasTrailingZeroInBitwiseOR(new int[]{1, 3, 5, 7, 9})); // Output: false
    }
}
