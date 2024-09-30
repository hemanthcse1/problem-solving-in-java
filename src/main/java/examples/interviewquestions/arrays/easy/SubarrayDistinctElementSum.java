package examples.interviewquestions.arrays.easy;

import java.util.HashMap;
import java.util.List;

public class SubarrayDistinctElementSum {
    public static int sumOfSquaresOfDistinctCounts(List<Integer> nums) {
        int n = nums.size();
        int sumOfSquares = 0;

        HashMap<Integer, Integer> freqMap = new HashMap<>();

        int start = 0;

        for (int end = 0; end < n; end++) {
            freqMap.put(nums.get(end), freqMap.getOrDefault(nums.get(end), 0) + 1);

            for (int i = start; i <= end; i++) {
                int distinctCount = freqMap.size();
                sumOfSquares += distinctCount * distinctCount;
            }

            freqMap.put(nums.get(start), freqMap.get(nums.get(start)) - 1);
            if (freqMap.get(nums.get(start)) == 0) {
                freqMap.remove(nums.get(start));
            }
            start++;
        }

        return sumOfSquares;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 1};
        System.out.println(sumOfSquaresOfDistinctCounts(nums1));

        int[] nums2 = {1, 1};
        System.out.println(sumOfSquaresOfDistinctCounts(nums2));
    }
}
