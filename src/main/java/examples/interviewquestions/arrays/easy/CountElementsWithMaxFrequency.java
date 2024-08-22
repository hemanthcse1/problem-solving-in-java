package examples.interviewquestions.arrays.easy;

import java.util.HashMap;
import java.util.Map;

public class CountElementsWithMaxFrequency {
    public int countMaxFrequency(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        int maxFrequency = 0;
        for (int frequency : frequencyMap.values()) {
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
            }
        }
        int totalMaxFrequency = 0;
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                totalMaxFrequency += entry.getValue();
            }
        }

        return totalMaxFrequency;
    }

    public static void main(String[] args) {
        CountElementsWithMaxFrequency solution = new CountElementsWithMaxFrequency();
        int[] nums = {1, 3, 2, 2, 4, 1, 1};
        int result = solution.countMaxFrequency(nums);
        System.out.println("Total frequencies of elements with maximum frequency: " + result);
    }
}
