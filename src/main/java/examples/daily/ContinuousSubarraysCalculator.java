package examples.daily;

import java.util.Deque;
import java.util.LinkedList;

public class ContinuousSubarraysCalculator {

    public static void main(String[] args) {
        int[] nums1 = {5,4,2,4};
        System.out.println(new ContinuousSubarraysCalculator().countContinuousSubarrays(nums1));

        int[] nums2 = {1,2,3};
        System.out.println(new ContinuousSubarraysCalculator().countContinuousSubarrays(nums2));
    }

    public long countContinuousSubarrays(int[] nums) {
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();
        long count = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            while (!maxDeque.isEmpty() && maxDeque.peekLast() < nums[right]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(nums[right]);

            while (!minDeque.isEmpty() && minDeque.peekLast() > nums[right]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(nums[right]);

            while (!maxDeque.isEmpty() && !minDeque.isEmpty() && maxDeque.peekFirst() - minDeque.peekFirst() > 2) {
                if (maxDeque.peekFirst() == nums[left]) {
                    maxDeque.pollFirst();
                }
                if (minDeque.peekFirst() == nums[left]) {
                    minDeque.pollFirst();
                }
                left++;
            }

            count += (right - left + 1);
        }

        return count;
    }
}
