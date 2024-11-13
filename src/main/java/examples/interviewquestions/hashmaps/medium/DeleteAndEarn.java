package examples.interviewquestions.hashmaps.medium;

import java.util.HashMap;
import java.util.Map;

public class DeleteAndEarn {

    public int deleteAndEarn(int[] nums) {
        int max = 0;
        Map<Integer, Integer> points = new HashMap<>();

        for (int num : nums) {
            points.put(num, points.getOrDefault(num, 0) + num);
            max = Math.max(max, num);
        }

        int[] dp = new int[max + 1];
        dp[0] = 0;
        dp[1] = points.getOrDefault(1, 0);

        for (int i = 2; i <= max; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + points.getOrDefault(i, 0));
        }

        return dp[max];
    }
    public static void main(String[] args) {
        DeleteAndEarn solution = new DeleteAndEarn();
        System.out.println(solution.deleteAndEarn(new int[]{3, 4, 2}));
        System.out.println(solution.deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));
    }
}
