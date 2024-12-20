package examples.interviewquestions.queues;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumSubsequenceScoreSolution {

    public static void main(String[] args) {

        int[] nums1_1 = {1,3,3,2};
        int[] nums2_1 = {2,1,3,4};
        int k1 = 3;
        System.out.println(maxScore(nums1_1, nums2_1, k1));

        int[] nums1_2 = {4,2,3,1,1};
        int[] nums2_2 = {7,5,10,9,6};
        int k2 = 1;
        System.out.println(maxScore(nums1_2, nums2_2, k2));

        int[] nums1_3 = {2,1,14,12};
        int[] nums2_3 = {11,7,13,6};
        int k3 = 3;
        System.out.println(maxScore(nums1_3, nums2_3, k3));
    }

    public static long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        Integer[] indices = new Integer[n];
        for(int i=0;i<n;i++) indices[i] = i;
        Arrays.sort(indices, (a, b) -> nums2[b] - nums2[a]);
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        long sum = 0;
        long maxScore = 0;
        for(int i=0;i<n;i++){
            int idx = indices[i];
            heap.offer(nums1[idx]);
            sum += nums1[idx];
            if(heap.size() > k){
                sum -= heap.poll();
            }
            if(heap.size() == k){
                maxScore = Math.max(maxScore, sum * (long)nums2[idx]);
            }
        }
        return maxScore;
    }
}
