package examples.interviewquestions.arrays.medium;

import java.util.PriorityQueue;

public class MaximalScoreAfterOperations {

    // 2530. Maximal Score After Applying K Operations

    public long maxScore(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            maxHeap.add(num);
        }

        long score = 0;

        for (int i = 0; i < k; i++) {
            int max = maxHeap.poll();
            score += max;
            maxHeap.add((int) Math.ceil(max / 3.0));
        }

        return score;
    }

    public static void main(String[] args) {
        MaximalScoreAfterOperations solution = new MaximalScoreAfterOperations();
        System.out.println(solution.maxScore(new int[]{10, 10, 10, 10, 10}, 5));
        System.out.println(solution.maxScore(new int[]{1, 10, 3, 3, 3}, 3));
    }
}
