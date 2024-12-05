package examples.interviewquestions.arrays.medium;

import java.util.HashMap;
import java.util.Map;

public class CheckArrayPairsDivisible {

    public boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> remainderCount = new HashMap<>();

        for (int num : arr) {
            int remainder = ((num % k) + k) % k;
            remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0) + 1);
        }

        for (int r : remainderCount.keySet()) {
            int freq = remainderCount.get(r);
            if (r == 0) {
                if (freq % 2 != 0) return false;
            } else if (r * 2 == k) {
                if (freq % 2 != 0) return false;
            } else {
                int complementFreq = remainderCount.getOrDefault(k - r, 0);
                if (freq != complementFreq) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        CheckArrayPairsDivisible solution = new CheckArrayPairsDivisible();
        int[] arr1 = {1, 2, 3, 4, 5, 10, 6, 7, 8, 9};
        int k1 = 5;
        System.out.println(solution.canArrange(arr1, k1));

        int[] arr2 = {1, 2, 3, 4, 5, 6};
        int k2 = 7;
        System.out.println(solution.canArrange(arr2, k2));

    }
}
