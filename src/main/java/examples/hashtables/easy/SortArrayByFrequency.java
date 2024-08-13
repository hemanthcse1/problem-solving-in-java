package examples.hashtables.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortArrayByFrequency {
    public static int[] frequencySort(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        Integer[] numsArray = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        Arrays.sort(numsArray, (a, b) -> {
            int freqA = frequencyMap.get(a);
            int freqB = frequencyMap.get(b);
            if (freqA != freqB) {
                return Integer.compare(freqA, freqB);
            } else {
                return Integer.compare(b, a);
            }
        });

        return Arrays.stream(numsArray).mapToInt(Integer::intValue).toArray();
    }
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 3};
        int[] result = frequencySort(nums);
        System.out.println(Arrays.toString(result));
    }
}
