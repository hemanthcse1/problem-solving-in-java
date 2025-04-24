package examples.daily.april;

import java.util.HashSet;
import java.util.Set;

public class CompleteSubarrayCounter {

    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> uniqueElements = new HashSet<>();
        for (int num : nums) {
            uniqueElements.add(num);
        }
        int totalUnique = uniqueElements.size();
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            Set<Integer> seen = new HashSet<>();
            for (int j = i; j < n; j++) {
                seen.add(nums[j]);
                if (seen.size() == totalUnique) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CompleteSubarrayCounter counter = new CompleteSubarrayCounter();
        int[] nums1 = {1, 3, 1, 2, 2};
        int[] nums2 = {5, 5, 5, 5};
        System.out.println(counter.countCompleteSubarrays(nums1)); //  4
        System.out.println(counter.countCompleteSubarrays(nums2)); // 10
    }
}
