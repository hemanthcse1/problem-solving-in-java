package examples.daily.july;

import java.util.Collections;
import java.util.PriorityQueue;

public class BalancedArrayPartitionDifferenceCalculator {

    public long minimumDifference(int[] nums) {
        int n = nums.length / 3;
        long ans = Long.MAX_VALUE;
        long leftSum = 0;
        long rightSum = 0;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        long[] minLeftSum = new long[nums.length];

        for (int i = 0; i < 2 * n; i++) {
            maxHeap.offer(nums[i]);
            leftSum += nums[i];
            if (maxHeap.size() > n) {
                leftSum -= maxHeap.poll();
            }
            if (maxHeap.size() == n) {
                minLeftSum[i] = leftSum;
            }
        }

        for (int i = nums.length - 1; i >= n; i--) {
            minHeap.offer(nums[i]);
            rightSum += nums[i];
            if (minHeap.size() > n) {
                rightSum -= minHeap.poll();
            }
            if (minHeap.size() == n) {
                ans = Math.min(ans, minLeftSum[i - 1] - rightSum);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        BalancedArrayPartitionDifferenceCalculator calculator = new BalancedArrayPartitionDifferenceCalculator();
        int[] nums = {1, 3, 5, 2, 8, 6, 4, 7, 9};
        System.out.println("Minimum Difference: " + calculator.minimumDifference(nums));
    }
}
