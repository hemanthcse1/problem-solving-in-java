package examples.hashtables.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaximumNumberOfPairs {
    public int[] numberOfPairs(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        int pairs = 0;
        int leftovers = 0;
        for (int count : frequencyMap.values()) {
            pairs += count / 2;
            leftovers += count % 2;
        }
        return new int[]{pairs, leftovers};
    }

    public static void main(String[] args) {
        MaximumNumberOfPairs solution = new MaximumNumberOfPairs();

        int[] nums = {1, 3, 2, 1, 3, 2, 2};
        int[] result = solution.numberOfPairs(nums);

        System.out.println(Arrays.toString(result));
    }
}
