package examples.interviewquestions.arrays;

public class SubsetXORSum {

    public static int subsetXORSum(int[] nums) {
        return subsetXORSumHelper(nums, 0, 0);
    }

    public static int subsetXORSumHelper(int[] nums, int index, int currentXOR) {
        if (index == nums.length) {
            return currentXOR;
        }

        int include = subsetXORSumHelper(nums, index + 1, currentXOR ^ nums[index]);
        int exclude = subsetXORSumHelper(nums, index + 1, currentXOR);

        return include + exclude;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3};

        System.out.println("Sum of all subset XOR total "+subsetXORSum(nums));

    }
}
