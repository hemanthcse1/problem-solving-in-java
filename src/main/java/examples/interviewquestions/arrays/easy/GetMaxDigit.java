package examples.interviewquestions.arrays.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GetMaxDigit {
    private int getMaxDigit(int num) {
        int maxDigit = 0;
        while (num > 0) {
            maxDigit = Math.max(maxDigit, num % 10);
            num /= 10;
        }
        return maxDigit;
    }

    public int maxPairSum(int[] nums) {
        HashMap<Integer, List<Integer>> digitMap = new HashMap<>();

        for (int num : nums) {
            int maxDigit = getMaxDigit(num);
            digitMap.putIfAbsent(maxDigit, new ArrayList<>());
            digitMap.get(maxDigit).add(num);
        }

        int maxSum = -1;

        for (List<Integer> group : digitMap.values()) {
            if (group.size() < 2) {
                continue;
            }

            group.sort((a, b) -> b - a);

            int pairSum = group.get(0) + group.get(1);
            maxSum = Math.max(maxSum, pairSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        GetMaxDigit solution = new GetMaxDigit();

        int[] nums1 = {112, 131, 411};
        System.out.println(solution.maxPairSum(nums1));

        int[] nums2 = {2536, 1613, 3366, 162};
        System.out.println(solution.maxPairSum(nums2));

        int[] nums3 = {51, 71, 17, 24, 42};
        System.out.println(solution.maxPairSum(nums3));
    }
}
