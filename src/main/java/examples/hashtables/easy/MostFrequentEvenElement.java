package examples.hashtables.easy;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentEvenElement {
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            if (num % 2 == 0) {
                frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            }
        }

        int mostFrequent = -1;
        int highestFrequency = 0;

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int num = entry.getKey();
            int frequency = entry.getValue();

            if (frequency > highestFrequency || (frequency == highestFrequency && num < mostFrequent)) {
                mostFrequent = num;
                highestFrequency = frequency;
            }
        }

        return mostFrequent;
    }

    public static void main(String[] args) {
        MostFrequentEvenElement solution = new MostFrequentEvenElement();

        int[] nums1 = {0, 1, 2, 2, 4, 4, 1};
        System.out.println("Most Frequent Even Element: " + solution.mostFrequentEven(nums1)); // Output: 2

        int[] nums2 = {4, 4, 4, 9, 2, 4};
        System.out.println("Most Frequent Even Element: " + solution.mostFrequentEven(nums2)); // Output: 4

        int[] nums3 = {1, 3, 5, 7};
        System.out.println("Most Frequent Even Element: " + solution.mostFrequentEven(nums3)); // Output: -1
    }
}
