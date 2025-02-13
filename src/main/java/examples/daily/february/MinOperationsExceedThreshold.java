package examples.daily.february;

import java.util.PriorityQueue;

public class MinOperationsExceedThreshold {

    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();


        for (int num : nums) {
            minHeap.offer((long) num);
        }

        int operations = 0;
        while (minHeap.peek() < k) {
            long x = minHeap.poll();
            long y = minHeap.poll();
            long newElement = x * 2 + y;
            minHeap.offer(newElement);
            operations++;
        }

        return operations;
    }

    public static void main(String[] args) {
        MinOperationsExceedThreshold solution = new MinOperationsExceedThreshold();
        System.out.println(solution.minOperations(new int[]{2, 11, 10, 1, 3}, 10)); //  2
        System.out.println(solution.minOperations(new int[]{1, 1, 2, 4, 9}, 20));  //  4
    }
}
