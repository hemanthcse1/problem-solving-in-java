package examples.interviewquestions.arrays.medium;

import java.util.HashMap;

public class MakeSumDivisibleByP {

    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        long totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        int targetRemainder = (int) (totalSum % p);
        if (targetRemainder == 0) {
            return 0;
        }

        HashMap<Integer, Integer> prefixModMap = new HashMap<>();
        prefixModMap.put(0, -1);

        int currentRemainder = 0, minLength = n;

        for (int i = 0; i < n; i++) {
            currentRemainder = (currentRemainder + nums[i]) % p;

            int neededRemainder = (currentRemainder - targetRemainder + p) % p;

            if (prefixModMap.containsKey(neededRemainder)) {
                minLength = Math.min(minLength, i - prefixModMap.get(neededRemainder));
            }

            prefixModMap.put(currentRemainder, i);
        }

        return minLength == n ? -1 : minLength;
    }

    public static void main(String[] args) {
        MakeSumDivisibleByP solution = new MakeSumDivisibleByP();

        int[] nums1 = {3, 1, 4, 2};
        int p1 = 6;
        System.out.println(solution.minSubarray(nums1, p1));

        int[] nums2 = {6, 3, 5, 2};
        int p2 = 9;
        System.out.println(solution.minSubarray(nums2, p2));

    }
}
