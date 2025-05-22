package examples.daily.may;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ZeroArrayTransformationApp {

    public static void main(String[] args) {
        ZeroArrayTransformationApp solution = new ZeroArrayTransformationApp();

        int[] nums1 = {2, 0, 2};
        int[][] queries1 = {{0, 2}, {0, 2}, {1, 1}};
        System.out.println(solution.maxRemoval(nums1, queries1)); // 1

        int[] nums2 = {1, 1, 1, 1};
        int[][] queries2 = {{1, 3}, {0, 2}, {1, 3}, {1, 2}};
        System.out.println(solution.maxRemoval(nums2, queries2)); //  2

        int[] nums3 = {1, 2, 3, 4};
        int[][] queries3 = {{0, 3}};
        System.out.println(solution.maxRemoval(nums3, queries3)); //  -1
    }

    public int maxRemoval(int[] nums, int[][] queries) {
        Arrays.sort(queries, Comparator.comparingInt(q -> q[0]));

        PriorityQueue<Integer> available = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> active = new PriorityQueue<>();
        int queryIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            while (queryIndex < queries.length && queries[queryIndex][0] <= i) {
                available.offer(queries[queryIndex][1]);
                queryIndex++;
            }

            while (!active.isEmpty() && active.peek() < i) {
                active.poll();
            }

            while (nums[i] > active.size()) {
                if (available.isEmpty() || available.peek() < i) {
                    return -1;
                }
                active.offer(available.poll());
            }
        }

        return available.size();
    }
}
