package examples.daily.february;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MaxSumPairEqualDigitSum {

    public int maximumSum(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> digitSumMap = new HashMap<>();
        int maxSum = -1;

        for (int num : nums) {
            int digitSum = getDigitSum(num);
            digitSumMap.putIfAbsent(digitSum, new PriorityQueue<>(Collections.reverseOrder()));
            digitSumMap.get(digitSum).offer(num);
        }

        for (PriorityQueue<Integer> pq : digitSumMap.values()) {
            if (pq.size() >= 2) {
                int first = pq.poll();
                int second = pq.poll();
                maxSum = Math.max(maxSum, first + second);
            }
        }

        return maxSum;
    }

    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        MaxSumPairEqualDigitSum solution = new MaxSumPairEqualDigitSum();
        System.out.println(solution.maximumSum(new int[]{18, 43, 36, 13, 7}));
        System.out.println(solution.maximumSum(new int[]{10, 12, 19, 14}));
    }
}
