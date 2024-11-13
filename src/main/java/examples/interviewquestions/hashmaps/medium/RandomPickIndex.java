package examples.interviewquestions.hashmaps.medium;

import java.util.Random;

public class RandomPickIndex {

    private int[] nums;
    private Random random;

    public RandomPickIndex(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    public int pick(int target) {
        int result = -1;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
                if (random.nextInt(count) == 0) {
                    result = i;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        RandomPickIndex solution = new RandomPickIndex(new int[]{1, 2, 3, 3, 3});
        System.out.println(solution.pick(3));
        System.out.println(solution.pick(1));
        System.out.println(solution.pick(3));
    }
}
