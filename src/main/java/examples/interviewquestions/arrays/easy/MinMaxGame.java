package examples.interviewquestions.arrays.easy;

public class MinMaxGame {
    public int minMaxGame(int[] nums) {
        while (nums.length > 1) {
            int n = nums.length / 2;
            int[] newNums = new int[n];

            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    newNums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
                } else {
                    newNums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
                }
            }
            nums = newNums;
        }
        return nums[0];
    }

    public static void main(String[] args) {
        MinMaxGame game = new MinMaxGame();
        int[] nums3 = {70, 38, 21, 22};
        System.out.println(game.minMaxGame(nums3));
    }
}
