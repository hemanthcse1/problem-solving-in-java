package examples.interviewquestions.arrays;

public class MinimumOperationsDivisibleByThree {

    public static int minOperations(int[] nums) {
        int operations = 0;
        for (int num : nums) {
            int remainder = num % 3;

            if (remainder == 1) {
                operations += 1;
            } else if (remainder == 2) {
                operations += 1;
            }
        }

        return operations;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 7, 9};

        System.out.println("Result " + minOperations(nums));
    }
}
