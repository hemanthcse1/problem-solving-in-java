package examples.interviewquestions.threepointers;

import java.util.*;

public class FindXSums {
    public int[] xSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] answer = new int[n - k + 1];
        Map<Integer, Integer> frequencyMap;

        for (int i = 0; i <= n - k; i++) {
            frequencyMap = new HashMap<>();

            for (int j = i; j < i + k; j++) {
                frequencyMap.put(nums[j], frequencyMap.getOrDefault(nums[j], 0) + 1);
            }

            List<Map.Entry<Integer, Integer>> sortedEntries = new ArrayList<>(frequencyMap.entrySet());
            sortedEntries.sort((a, b) -> {
                if (!a.getValue().equals(b.getValue())) {
                    return b.getValue().compareTo(a.getValue());
                } else {
                    return b.getKey().compareTo(a.getKey());
                }
            });

            int sum = 0;
            for (int j = 0; j < Math.min(x, sortedEntries.size()); j++) {
                sum += sortedEntries.get(j).getKey() * sortedEntries.get(j).getValue();
            }
            answer[i] = sum;
        }

        return answer;
    }

    public static void main(String[] args) {
        FindXSums solution = new FindXSums();

        int[] nums1 = {1, 1, 2, 2, 3, 4, 2, 3};
        int k1 = 6;
        int x1 = 2;
        System.out.println(Arrays.toString(solution.xSum(nums1, k1, x1)));

        int[] nums2 = {3, 8, 7, 8, 7, 5};
        int k2 = 2;
        int x2 = 2;
        System.out.println(Arrays.toString(solution.xSum(nums2, k2, x2)));
    }
}
