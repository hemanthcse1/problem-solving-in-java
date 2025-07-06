package examples.daily.july;

import java.util.HashMap;
import java.util.Map;

public class FindSumPairs {
    private int[] nums1;
    private int[] nums2;
    private Map<Integer, Integer> freqMap;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.freqMap = new HashMap<>();

        for (int num : nums2) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
    }

    public void add(int index, int val) {
        int oldVal = nums2[index];
        int newVal = oldVal + val;

        nums2[index] = newVal;

        freqMap.put(oldVal, freqMap.get(oldVal) - 1);
        if (freqMap.get(oldVal) == 0) {
            freqMap.remove(oldVal);
        }

        freqMap.put(newVal, freqMap.getOrDefault(newVal, 0) + 1);
    }

    public int count(int tot) {
        int count = 0;
        for (int num1 : nums1) {
            int complement = tot - num1;
            count += freqMap.getOrDefault(complement, 0);
        }
        return count;
    }

    public static void main(String[] args) {
        FindSumPairs findSumPairs = new FindSumPairs(
                new int[]{1, 1, 2, 2, 2, 3},
                new int[]{1, 4, 5, 2, 5, 4}
        );

        System.out.println(findSumPairs.count(7)); // 8
        findSumPairs.add(3, 2);                    // nums2[3] += 2 -> 2 -> 4
        System.out.println(findSumPairs.count(8)); // 2
        System.out.println(findSumPairs.count(4)); // 1
        findSumPairs.add(0, 1);                    // nums2[0] += 1 -> 2
        findSumPairs.add(1, 1);                    // nums2[1] += 1 -> 5
        System.out.println(findSumPairs.count(7)); // 11
    }
}
