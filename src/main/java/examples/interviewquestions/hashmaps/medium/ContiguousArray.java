package examples.interviewquestions.hashmaps.medium;

import java.util.HashMap;

public class ContiguousArray {

    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> prefixSumIndex = new HashMap<>();
        prefixSumIndex.put(0, -1);

        int maxLength = 0;
        int prefixSum = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += (nums[i] == 1) ? 1 : -1;

            if (prefixSumIndex.containsKey(prefixSum)) {
                maxLength = Math.max(maxLength, i - prefixSumIndex.get(prefixSum));
            } else {
                prefixSumIndex.put(prefixSum, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        ContiguousArray solution = new ContiguousArray();
        System.out.println(solution.findMaxLength(new int[]{0, 1}));
        System.out.println(solution.findMaxLength(new int[]{0, 1, 0}));
    }
}
