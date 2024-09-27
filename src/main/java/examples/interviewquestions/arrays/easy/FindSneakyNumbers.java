package examples.interviewquestions.arrays.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindSneakyNumbers {
    public int[] findSneakyNumbers(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            if (countMap.get(num) == 2) {
                result.add(num);
                if (result.size() == 2) {
                    break;
                }
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        FindSneakyNumbers sol = new FindSneakyNumbers();

        int[] nums1 = {0, 1, 1, 0};
        System.out.println(java.util.Arrays.toString(sol.findSneakyNumbers(nums1)));

        int[] nums2 = {0, 3, 2, 1, 3, 2};
        System.out.println(java.util.Arrays.toString(sol.findSneakyNumbers(nums2)));

        int[] nums3 = {7, 1, 5, 4, 3, 4, 6, 0, 9, 5, 8, 2};
        System.out.println(java.util.Arrays.toString(sol.findSneakyNumbers(nums3)));
    }
}
