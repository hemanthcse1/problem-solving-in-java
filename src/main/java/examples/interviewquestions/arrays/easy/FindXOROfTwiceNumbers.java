package examples.interviewquestions.arrays.easy;

import java.util.HashMap;

public class FindXOROfTwiceNumbers {
    public int findXOROfTwiceNumbers(int[] nums) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int result = 0;
        for (int num : frequencyMap.keySet()) {
            if (frequencyMap.get(num) == 2) {
                result ^= num;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FindXOROfTwiceNumbers solution = new FindXOROfTwiceNumbers();


        int[] nums1 = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(solution.findXOROfTwiceNumbers(nums1));

        int[] nums2 = {1, 2, 3, 4};
        System.out.println(solution.findXOROfTwiceNumbers(nums2));
    }
}
