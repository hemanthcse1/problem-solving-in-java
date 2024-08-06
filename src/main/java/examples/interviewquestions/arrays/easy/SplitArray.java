package examples.interviewquestions.arrays.easy;

import java.util.HashMap;
import java.util.Map;

public class SplitArray {
    public static boolean canSplitArray(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        int countOnce = 0;
        int countTwice = 0;
        for (int frequency : frequencyMap.values()) {
            if (frequency > 2) {
                return false;
            } else if (frequency == 2) {
                countTwice++;
            } else if (frequency == 1) {
                countOnce++;
            }
        }
        int n = nums.length / 2;
        if (countTwice > n || (countOnce + countTwice * 2) < nums.length) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 4, 5, 6, 7};
        boolean result = canSplitArray(nums);
        System.out.println("Is it possible to split the array? " + result);
    }
}
