package examples.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KPairsWithSmallestSumsApp {
    public static void main(String[] args) {
        int[] nums1a = {1,7,11}, nums2a = {2,4,6};
        System.out.println(findKSmallestPairs(nums1a, nums2a, 3));

        int[] nums1b = {1,1,2}, nums2b = {1,2,3};
        System.out.println(findKSmallestPairs(nums1b, nums2b, 2));

        int[] nums1c = {1,2}, nums2c = {3};
        System.out.println(findKSmallestPairs(nums1c, nums2c, 5));

        int[] nums1d = {-10,-4,0,0,6}, nums2d = {3,5,6,7,8,100};
        System.out.println(findKSmallestPairs(nums1d, nums2d, 10));
    }

    public static List<List<Integer>> findKSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return result;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            pq.offer(new int[]{nums1[i] + nums2[0], i, 0});
        }
        while (!pq.isEmpty() && result.size() < k) {
            int[] cur = pq.poll();
            int sum = cur[0], i = cur[1], j = cur[2];
            result.add(Arrays.asList(nums1[i], nums2[j]));
            if (j + 1 < nums2.length) {
                pq.offer(new int[]{nums1[i] + nums2[j+1], i, j+1});
            }
        }
        return result;
    }
}
